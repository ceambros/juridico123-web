/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juridico.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
@Entity
@Table(name = "comarca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comarca.findAll", query = "SELECT c FROM Comarca c"),
    @NamedQuery(name = "Comarca.findByComarcaNum", query = "SELECT c FROM Comarca c WHERE c.comarcaNum = :comarcaNum"),
    @NamedQuery(name = "Comarca.findByNmComarca", query = "SELECT c FROM Comarca c WHERE c.nmComarca = :nmComarca"),
    @NamedQuery(name = "Comarca.findByUsAlt", query = "SELECT c FROM Comarca c WHERE c.usAlt = :usAlt"),
    @NamedQuery(name = "Comarca.findByDtAlt", query = "SELECT c FROM Comarca c WHERE c.dtAlt = :dtAlt")})
public class Comarca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "comarca_num")
    private Integer comarcaNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nm_comarca")
    private String nmComarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "us_alt")
    private String usAlt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_alt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comarcaNum", fetch = FetchType.LAZY)
    private List<Processo> processoList;

    public Comarca() {
    }

    public Comarca(Integer comarcaNum) {
        this.comarcaNum = comarcaNum;
    }

    public Comarca(Integer comarcaNum, String nmComarca, String usAlt, Date dtAlt) {
        this.comarcaNum = comarcaNum;
        this.nmComarca = nmComarca;
        this.usAlt = usAlt;
        this.dtAlt = dtAlt;
    }

    public Integer getComarcaNum() {
        return comarcaNum;
    }

    public void setComarcaNum(Integer comarcaNum) {
        this.comarcaNum = comarcaNum;
    }

    public String getNmComarca() {
        return nmComarca;
    }

    public void setNmComarca(String nmComarca) {
        this.nmComarca = nmComarca;
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

    @XmlTransient
    public List<Processo> getProcessoList() {
        return processoList;
    }

    public void setProcessoList(List<Processo> processoList) {
        this.processoList = processoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comarcaNum != null ? comarcaNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comarca)) {
            return false;
        }
        Comarca other = (Comarca) object;
        if ((this.comarcaNum == null && other.comarcaNum != null) || (this.comarcaNum != null && !this.comarcaNum.equals(other.comarcaNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.juridico.model.Comarca[ comarcaNum=" + comarcaNum + " ]";
    }
    
}
