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
@Table(name = "jurisdicao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jurisdicao.findAll", query = "SELECT j FROM Jurisdicao j"),
    @NamedQuery(name = "Jurisdicao.findByJurisdicaoNum", query = "SELECT j FROM Jurisdicao j WHERE j.jurisdicaoNum = :jurisdicaoNum"),
    @NamedQuery(name = "Jurisdicao.findByNmJurisdicao", query = "SELECT j FROM Jurisdicao j WHERE j.nmJurisdicao = :nmJurisdicao"),
    @NamedQuery(name = "Jurisdicao.findByUsAlt", query = "SELECT j FROM Jurisdicao j WHERE j.usAlt = :usAlt"),
    @NamedQuery(name = "Jurisdicao.findByDtAlt", query = "SELECT j FROM Jurisdicao j WHERE j.dtAlt = :dtAlt")})
public class Jurisdicao implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jurisdicaoNum", fetch = FetchType.LAZY)
    private List<Processo> processoList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "jurisdicao_num")
    private Integer jurisdicaoNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nm_jurisdicao")
    private String nmJurisdicao;
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

    public Jurisdicao() {
    }

    public Jurisdicao(Integer jurisdicaoNum) {
        this.jurisdicaoNum = jurisdicaoNum;
    }

    public Jurisdicao(Integer jurisdicaoNum, String nmJurisdicao, String usAlt, Date dtAlt) {
        this.jurisdicaoNum = jurisdicaoNum;
        this.nmJurisdicao = nmJurisdicao;
        this.usAlt = usAlt;
        this.dtAlt = dtAlt;
    }

    public Integer getJurisdicaoNum() {
        return jurisdicaoNum;
    }

    public void setJurisdicaoNum(Integer jurisdicaoNum) {
        this.jurisdicaoNum = jurisdicaoNum;
    }

    public String getNmJurisdicao() {
        return nmJurisdicao;
    }

    public void setNmJurisdicao(String nmJurisdicao) {
        this.nmJurisdicao = nmJurisdicao;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jurisdicaoNum != null ? jurisdicaoNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jurisdicao)) {
            return false;
        }
        Jurisdicao other = (Jurisdicao) object;
        if ((this.jurisdicaoNum == null && other.jurisdicaoNum != null) || (this.jurisdicaoNum != null && !this.jurisdicaoNum.equals(other.jurisdicaoNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.juridico.model.Jurisdicao[ jurisdicaoNum=" + jurisdicaoNum + " ]";
    }

    @XmlTransient
    public List<Processo> getProcessoList() {
        return processoList;
    }

    public void setProcessoList(List<Processo> processoList) {
        this.processoList = processoList;
    }
    
}
