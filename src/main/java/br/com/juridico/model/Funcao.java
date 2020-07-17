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
@Table(name = "funcao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcao.findAll", query = "SELECT f FROM Funcao f"),
    @NamedQuery(name = "Funcao.findByFuncaoNum", query = "SELECT f FROM Funcao f WHERE f.funcaoNum = :funcaoNum"),
    @NamedQuery(name = "Funcao.findByNmFuncao", query = "SELECT f FROM Funcao f WHERE f.nmFuncao = :nmFuncao"),
    @NamedQuery(name = "Funcao.findByUsAlt", query = "SELECT f FROM Funcao f WHERE f.usAlt = :usAlt"),
    @NamedQuery(name = "Funcao.findByDtAlt", query = "SELECT f FROM Funcao f WHERE f.dtAlt = :dtAlt")})
public class Funcao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "funcao_num")
    private Integer funcaoNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nm_funcao")
    private String nmFuncao;
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
    @OneToMany(mappedBy = "funcaoNum", fetch = FetchType.LAZY)
    private List<Pessoa> pessoaList;

    public Funcao() {
    }

    public Funcao(Integer funcaoNum) {
        this.funcaoNum = funcaoNum;
    }

    public Funcao(Integer funcaoNum, String nmFuncao, String usAlt, Date dtAlt) {
        this.funcaoNum = funcaoNum;
        this.nmFuncao = nmFuncao;
        this.usAlt = usAlt;
        this.dtAlt = dtAlt;
    }

    public Integer getFuncaoNum() {
        return funcaoNum;
    }

    public void setFuncaoNum(Integer funcaoNum) {
        this.funcaoNum = funcaoNum;
    }

    public String getNmFuncao() {
        return nmFuncao;
    }

    public void setNmFuncao(String nmFuncao) {
        this.nmFuncao = nmFuncao;
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
    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcaoNum != null ? funcaoNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcao)) {
            return false;
        }
        Funcao other = (Funcao) object;
        if ((this.funcaoNum == null && other.funcaoNum != null) || (this.funcaoNum != null && !this.funcaoNum.equals(other.funcaoNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.juridico.model.Funcao[ funcaoNum=" + funcaoNum + " ]";
    }
    
}
