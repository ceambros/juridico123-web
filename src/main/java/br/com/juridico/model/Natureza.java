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
@Table(name = "natureza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Natureza.findAll", query = "SELECT n FROM Natureza n"),
    @NamedQuery(name = "Natureza.findByNaturezaNum", query = "SELECT n FROM Natureza n WHERE n.naturezaNum = :naturezaNum"),
    @NamedQuery(name = "Natureza.findByNmNatureza", query = "SELECT n FROM Natureza n WHERE n.nmNatureza = :nmNatureza"),
    @NamedQuery(name = "Natureza.findByUsAlt", query = "SELECT n FROM Natureza n WHERE n.usAlt = :usAlt"),
    @NamedQuery(name = "Natureza.findByDtAlt", query = "SELECT n FROM Natureza n WHERE n.dtAlt = :dtAlt")})
public class Natureza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "natureza_num")
    private Integer naturezaNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nm_natureza")
    private String nmNatureza;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "naturezaNum", fetch = FetchType.LAZY)
    private List<Processo> processoList;

    public Natureza() {
    }

    public Natureza(Integer naturezaNum) {
        this.naturezaNum = naturezaNum;
    }

    public Natureza(Integer naturezaNum, String nmNatureza, String usAlt, Date dtAlt) {
        this.naturezaNum = naturezaNum;
        this.nmNatureza = nmNatureza;
        this.usAlt = usAlt;
        this.dtAlt = dtAlt;
    }

    public Integer getNaturezaNum() {
        return naturezaNum;
    }

    public void setNaturezaNum(Integer naturezaNum) {
        this.naturezaNum = naturezaNum;
    }

    public String getNmNatureza() {
        return nmNatureza;
    }

    public void setNmNatureza(String nmNatureza) {
        this.nmNatureza = nmNatureza;
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
        hash += (naturezaNum != null ? naturezaNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Natureza)) {
            return false;
        }
        Natureza other = (Natureza) object;
        if ((this.naturezaNum == null && other.naturezaNum != null) || (this.naturezaNum != null && !this.naturezaNum.equals(other.naturezaNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.juridico.model.Natureza[ naturezaNum=" + naturezaNum + " ]";
    }
    
}
