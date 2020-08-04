package br.com.juridico.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import br.com.juridico.dao.UsuarioDao;
import br.com.juridico.modelo.Usuario;

@Controller
public class LoginBean extends BaseMB implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario = new Usuario();

    @Inject
    UsuarioDao dao;

    public Usuario getUsuario() {
        usuario.setNmLogin("admin");
        usuario.setDsSenha("admin");
        return usuario;
    }

    public String efetuaLogin() {
        System.out.println("fazendo login do usuario "
                + this.usuario.getNmLogin());

        FacesContext context = FacesContext.getCurrentInstance();

        boolean existe = dao.existe(this.usuario);
        if (existe) {
            context.getExternalContext().getSessionMap()
                    .put("usuarioLogado", this.usuario);
            return "livro?faces-redirect=true";
        }

        context.getExternalContext().getFlash().setKeepMessages(true);
        context.addMessage(null, new FacesMessage("Usu�rio n�o encontrado"));

        return "login?faces-redirect=true";
    }

    public String deslogar() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("usuarioLogado");
        return "login?faces-redirect=true";
    }
}
