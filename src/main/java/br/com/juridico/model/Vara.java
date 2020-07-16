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
@Table(name = "vara")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vara.findAll", query = "SELECT v FROM Vara v"),
    @NamedQuery(name = "Vara.findByVaraNum", query = "SELECT v FROM Vara v WHERE v.varaNum = :varaNum"),
    @NamedQuery(name = "Vara.findByNmVara", query = "SELECT v FROM Vara v WHERE v.nmVara = :nmVara"),
    @NamedQuery(name = "Vara.findByUsAlt", query = "SELECT v FROM Vara v WHERE v.usAlt = :usAlt"),
    @NamedQuery(name = "Vara.findByDtAlt", query = "SELECT v FROM Vara v WHERE v.dtAlt = :dtAlt")})
public class Vara implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "vara_num")
    private Integer varaNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nm_vara")
    private String nmVara;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "varaNum", fetch = FetchType.LAZY)
    private List<Processo> processoList;

    public Vara() {
    }

    public Vara(Integer varaNum) {
        this.varaNum = varaNum;
    }

    public Vara(Integer varaNum, String nmVara, String usAlt, Date dtAlt) {
        this.varaNum = varaNum;
        this.nmVara = nmVara;
        this.usAlt = usAlt;
        this.dtAlt = dtAlt;
    }

    public Integer getVaraNum() {
        return varaNum;
    }

    public void setVaraNum(Integer varaNum) {
        this.varaNum = varaNum;
    }

    public String getNmVara() {
        return nmVara;
    }

    public void setNmVara(String nmVara) {
        this.nmVara = nmVara;
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
        hash += (varaNum != null ? varaNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vara)) {
            return false;
        }
        Vara other = (Vara) object;
        if ((this.varaNum == null && other.varaNum != null) || (this.varaNum != null && !this.varaNum.equals(other.varaNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.juridico.model.Vara[ varaNum=" + varaNum + " ]";
    }
    
}
