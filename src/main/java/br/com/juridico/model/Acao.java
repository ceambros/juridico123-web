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
@Table(name = "acao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acao.findAll", query = "SELECT a FROM Acao a"),
    @NamedQuery(name = "Acao.findByAcaoNum", query = "SELECT a FROM Acao a WHERE a.acaoNum = :acaoNum"),
    @NamedQuery(name = "Acao.findByNmAcao", query = "SELECT a FROM Acao a WHERE a.nmAcao = :nmAcao"),
    @NamedQuery(name = "Acao.findByUsAlt", query = "SELECT a FROM Acao a WHERE a.usAlt = :usAlt"),
    @NamedQuery(name = "Acao.findByDtAlt", query = "SELECT a FROM Acao a WHERE a.dtAlt = :dtAlt")})
public class Acao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "acao_num")
    private Integer acaoNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nm_acao")
    private String nmAcao;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acaoNum", fetch = FetchType.LAZY)
    private List<Processo> processoList;

    public Acao() {
    }

    public Acao(Integer acaoNum) {
        this.acaoNum = acaoNum;
    }

    public Acao(Integer acaoNum, String nmAcao, String usAlt, Date dtAlt) {
        this.acaoNum = acaoNum;
        this.nmAcao = nmAcao;
        this.usAlt = usAlt;
        this.dtAlt = dtAlt;
    }

    public Integer getAcaoNum() {
        return acaoNum;
    }

    public void setAcaoNum(Integer acaoNum) {
        this.acaoNum = acaoNum;
    }

    public String getNmAcao() {
        return nmAcao;
    }

    public void setNmAcao(String nmAcao) {
        this.nmAcao = nmAcao;
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
        hash += (acaoNum != null ? acaoNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acao)) {
            return false;
        }
        Acao other = (Acao) object;
        if ((this.acaoNum == null && other.acaoNum != null) || (this.acaoNum != null && !this.acaoNum.equals(other.acaoNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.juridico.model.Acao[ acaoNum=" + acaoNum + " ]";
    }

}
