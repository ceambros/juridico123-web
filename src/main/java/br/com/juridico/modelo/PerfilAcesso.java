package br.com.juridico.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
@Entity
public class PerfilAcesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "perfil_num")
    private Integer perfilNum;
    @Basic(optional = false)
    @Column(name = "nm_perfil")
    private String nmPerfil;
    @Basic(optional = false)
    @Column(name = "ds_perfil")
    private String dsPerfil;
    @Basic(optional = false)
    @Column(name = "us_alt")
    private String usAlt;
    @Basic(optional = false)
    @Column(name = "dt_alt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfilAcesso", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;

    public PerfilAcesso() {
    }

    public PerfilAcesso(Integer perfilNum) {
        this.perfilNum = perfilNum;
    }

    public PerfilAcesso(Integer perfilNum, String nmPerfil, String dsPerfil, String usAlt, Date dtAlt) {
        this.perfilNum = perfilNum;
        this.nmPerfil = nmPerfil;
        this.dsPerfil = dsPerfil;
        this.usAlt = usAlt;
        this.dtAlt = dtAlt;
    }

    public Integer getPerfilNum() {
        return perfilNum;
    }

    public void setPerfilNum(Integer perfilNum) {
        this.perfilNum = perfilNum;
    }

    public String getNmPerfil() {
        return nmPerfil;
    }

    public void setNmPerfil(String nmPerfil) {
        this.nmPerfil = nmPerfil;
    }

    public String getDsPerfil() {
        return dsPerfil;
    }

    public void setDsPerfil(String dsPerfil) {
        this.dsPerfil = dsPerfil;
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

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilNum != null ? perfilNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilAcesso)) {
            return false;
        }
        PerfilAcesso other = (PerfilAcesso) object;
        if ((this.perfilNum == null && other.perfilNum != null) || (this.perfilNum != null && !this.perfilNum.equals(other.perfilNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.petinc.importacaojpa.PerfilAcesso[ perfilNum=" + perfilNum + " ]";
    }

}
