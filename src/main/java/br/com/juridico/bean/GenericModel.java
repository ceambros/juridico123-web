package br.com.juridico.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings("serial")
public class GenericModel implements java.io.Serializable {

    private String usuarioCadastro;

    private String usuarioAlteracao;

    /**
     * The data cadastro.
     */
    private Date dataCadastro;

    /**
     * The data alteracao.
     */
    private Date dataAlteracao;

    public GenericModel() {

    }

    public String getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public void setUsuarioCadastro(String usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

    public String getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

    public void setUsuarioAlteracao(String usuarioAlteracao) {
        this.usuarioAlteracao = usuarioAlteracao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    @Override
    public String toString() {
        return "GenericModel [getUsuarioCadastro()=" + getUsuarioCadastro()
                + ", getUsuarioAlteracao()=" + getUsuarioAlteracao()
                + ", getDataCadastro()=" + getDataCadastro()
                + ", getDataAlteracao()=" + getDataAlteracao() + ", toString()="
                + super.toString() + "]";
    }

}
