package br.com.juridico.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nm_login")
    private String nmLogin;
    @Basic(optional = false)
    @Column(name = "ds_senha")
    private String dsSenha;
    @Basic(optional = false)
    @Column(name = "cd_sit")
    private Character cdSit;
    @Basic(optional = false)
    @Column(name = "cd_tipo")
    private Character cdTipo;
    @Column(name = "ds_frase_senha")
    private String dsFraseSenha;
    @Basic(optional = false)
    @Column(name = "pessoa_num")
    private int pessoaNum;
    @Basic(optional = false)
    @Column(name = "us_alt")
    private String usAlt;
    @Basic(optional = false)
    @Column(name = "dt_alt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlt;
    @JoinColumn(name = "perfil_num", referencedColumnName = "perfil_num")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PerfilAcesso perfilAcesso;

    public Usuario() {
    }

    public Usuario(String nmLogin) {
        this.nmLogin = nmLogin;
    }

    public Usuario(String nmLogin, String dsSenha, Character cdSit, Character cdTipo, int pessoaNum, String usAlt, Date dtAlt) {
        this.nmLogin = nmLogin;
        this.dsSenha = dsSenha;
        this.cdSit = cdSit;
        this.cdTipo = cdTipo;
        this.pessoaNum = pessoaNum;
        this.usAlt = usAlt;
        this.dtAlt = dtAlt;
    }

    public String getNmLogin() {
        return nmLogin;
    }

    public void setNmLogin(String nmLogin) {
        this.nmLogin = nmLogin;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public Character getCdSit() {
        return cdSit;
    }

    public void setCdSit(Character cdSit) {
        this.cdSit = cdSit;
    }

    public Character getCdTipo() {
        return cdTipo;
    }

    public void setCdTipo(Character cdTipo) {
        this.cdTipo = cdTipo;
    }

    public String getDsFraseSenha() {
        return dsFraseSenha;
    }

    public void setDsFraseSenha(String dsFraseSenha) {
        this.dsFraseSenha = dsFraseSenha;
    }

    public int getPessoaNum() {
        return pessoaNum;
    }

    public void setPessoaNum(int pessoaNum) {
        this.pessoaNum = pessoaNum;
    }

    public String getUsAlt() {
        return usAlt;
    }

    public void setUsAlt(String usAlt) {
        this.usAlt = usAlt;
    }

    public Date getDtAlt() {
        return dtAlt;
    }

    public void setDtAlt(Date dtAlt) {
        this.dtAlt = dtAlt;
    }

    public PerfilAcesso getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nmLogin != null ? nmLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.nmLogin == null && other.nmLogin != null) || (this.nmLogin != null && !this.nmLogin.equals(other.nmLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.petinc.importacaojpa.Usuario[ nmLogin=" + nmLogin + " ]";
    }

}
