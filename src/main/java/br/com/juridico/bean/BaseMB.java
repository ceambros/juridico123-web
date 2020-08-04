package br.com.juridico.bean;

import br.com.juridico.modelo.Usuario;
import br.com.juridico.util.ValidationUtil;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.primefaces.component.inputtext.InputText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public abstract class BaseMB implements Serializable {

    protected static final String VISUALIZOU_AGENDA_DIALOG = "visualizouAgendaDialog";

    private static final Logger LOG = LoggerFactory.getLogger(BaseMB.class);

    /*
    private ResourceBundle dicionario = getFacesContext().getApplication()
            .getResourceBundle(getFacesContext(), "dicionario");
     */
    private String focusCampo = "";

    protected static final String SESSION_USER = "uc";

    protected static final String SESSION_MENUS = "menus";

    protected static final String SESSION_USUARIO = "usuario";

    protected static final String TIMEZONE_ID = "America/Sao_Paulo";

    protected static final String STR_SELECIONE = "Selecione";

    protected static final String DASHBOARD_URL = "/pages/common/dashboard.xhtml";

    protected static final String ALTERAR_SENHA_URL = "/pages/seguranca/seg010.xhtml";

    protected static final String LICENCA_URL = "/pages/seguranca/licenca.xhtml";

    protected static final String RELATORIO_URL = "../../relatorio?reportName=";

    protected static final String ROLE_CLIENTE = "ROLE_CLIENTE";

    protected static final String MSG_INSTALACAO_FALHOU = "verificacao_falhou";

    protected static final String MSG_VALIDADE_EXPIRADA = "validade_expirada";

    protected static final String NENHUM_REGISTRO_SELECIONADO = "br.com.ezproc.nenhum.registro.selecionado";

    protected static final String OPERACAO_REALIZADA_SUCESSO = "br.com.ezproc.operacao.realizada.sucesso";

    protected static final String DEFAULT_EXCEPTION_MSG = "br.com.ezproc.message.facade.default";

    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public ExternalContext getExternalContext() {
        return getFacesContext().getExternalContext();
    }

    public HttpSession getSession() {
        return (HttpSession) getExternalContext().getSession(true);
    }

    public HttpServletRequest getRequest() {
        return (HttpServletRequest) getExternalContext().getRequest();
    }

    public HttpServletResponse getResponse() {
        return (HttpServletResponse) getExternalContext().getResponse();
    }

    public String getDominio(HttpServletRequest request) {
        return request.getRequestURL().toString()
                .replace(request.getRequestURI(), "");
    }

    public UIComponent searchById(UIComponent comp, String id) {
        if (comp == null) {
            comp = getFacesContext().getViewRoot();
        }

        String compId = comp.getId();

        if (id.equalsIgnoreCase(compId)) {
            return comp;
        }

        Iterator<UIComponent> it = comp.getFacetsAndChildren();

        while (it.hasNext()) {
            UIComponent aux = searchById(it.next(), id);

            if (aux != null) {
                return aux;
            }
        }

        return null;
    }

    public void addMensagemSucesso(String msg) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
                traduzir(msg), null);
        getFacesContext().addMessage(traduzir(msg), mensagem);
    }

    public void addMensagemErro(String msg) {

        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                traduzir(msg), null);
        getFacesContext().addMessage(traduzir(msg), mensagem);
    }

    public String traduzir(String msg) {
        return msg;
//        try {
//            return getDicionario().getString(msg);
//        } catch (Exception ex) {
//            return msg + " {properties não encontrado}";
//        }
    }

    public UserContext getUserContext() {
        if (!ValidationUtil.isNull(getRequest().getSession())) {
            return (UserContext) getRequest().getSession().getAttribute(SESSION_USER);
        }

        return null;
    }

    public Usuario getUsuarioConectado() {
        if (!ValidationUtil.isNull(getRequest().getSession())) {
            return (Usuario) getRequest().getSession().getAttribute("usuarioLogado");
        }

        return null;
    }

//    private Boolean hasAccess(Menu menu) {
//        if (!ValidationUtil.isNull(getRequest().getSession())) {
//            @SuppressWarnings("unchecked")
//            List<Menu> menus = (List<Menu>) getRequest().getSession().getAttribute(SESSION_MENUS);
//
//            if (!ValidationUtil.isNullOrEmpty(menus)) {
//                return menus.contains(menu);
//            }
//
//        }
//
//        return false;
//    }
//    private Boolean registraLogAcesso(Menu menu) {
//        LogAcessoResponse response
//                = getLogAcessoFacade().insert(
//                        new LogAcessoRequest(getUserContext(), new LogAcesso(null, new Date(), new Usuario(
//                                getUserContext().getLogin()), menu)));
//        if (!response.isOperationSuccess()) {
//            InterfaceUtil
//                    .printLogDebugEnabled(LOG, "Erro ao registrar log de acesso: " + response.getMessageInfoList());
//            return false;
//        }
//
//        return true;
//    }
//    public Boolean initMain(Menu menu) {
//        if (!hasAccess(menu)) {
//            InterfaceUtil.printLogDebugEnabled(LOG, "Usuário " + getUserContext().getLogin()
//                    + " sem acesso a tela [" + menu.getArea() + "/" + menu.getAplicacao()
//                    + "/" + menu.getNome() + "]. Redirecionando para dashboard.");
//
//            try {
//                getResponse().sendRedirect(getRequest().getContextPath() + DASHBOARD_URL);
//            } catch (IOException ex) {
//                return false;
//            }
//        }
//
//        return registraLogAcesso(menu);
//    }
//    protected Boolean hasCaract(Caracteristica caract, Usuario usuario) {
//        if (!ValidationUtil.isNullOrEmpty(usuario.getCaracteristicas())) {
//            return usuario.getCaracteristicas().contains(caract);
//        }
//
//        InterfaceUtil.printLogDebugEnabled(LOG, "Usuário " + getUserContext().getLogin()
//                + " não tem a caracteristica [" + caract.getNome() + "].");
//
//        return false;
//    }
    public Map<String, String> getRequestParameterMap() {
        return getExternalContext()
                .getRequestParameterMap();
    }

    public Locale getLocale() {
        return getFacesContext().getViewRoot().getLocale();
    }

    public String getTimeZoneId() {
        return TIMEZONE_ID;
    }

    public void setValorCampo(String nomeCampo, Object objValor) {
        InputText campo = (InputText) searchById(null, nomeCampo);
        if (campo != null) {
            campo.setValue(objValor);
        }
    }

    public void resetValorCampo(String nomeCampo) {
        InputText campo = (InputText) searchById(null, nomeCampo);
        if (campo != null) {
            campo.resetValue();
        }
    }

    public String getFocusCampo() {
        return focusCampo;
    }

    public void setFocusCampo(String focusCampo) {
        this.focusCampo = focusCampo;
    }

    public String getStyleClassByRecordStatus(String valor) {
        if (valor.equalsIgnoreCase("I")) {
            return "recordStatusInsert";
        } else if (valor.equalsIgnoreCase("D")) {
            return "recordStatusDelete";
        } else if (valor.equalsIgnoreCase("U")) {
            return "recordStatusUpdate";
        }

        return null;
    }

}
