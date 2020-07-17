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
@Table(name = "tipo_pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPessoa.findAll", query = "SELECT t FROM TipoPessoa t"),
    @NamedQuery(name = "TipoPessoa.findByTppessoaNum", query = "SELECT t FROM TipoPessoa t WHERE t.tppessoaNum = :tppessoaNum"),
    @NamedQuery(name = "TipoPessoa.findByNmTppessoa", query = "SELECT t FROM TipoPessoa t WHERE t.nmTppessoa = :nmTppessoa"),
    @NamedQuery(name = "TipoPessoa.findByUsAlt", query = "SELECT t FROM TipoPessoa t WHERE t.usAlt = :usAlt"),
    @NamedQuery(name = "TipoPessoa.findByDtAlt", query = "SELECT t FROM TipoPessoa t WHERE t.dtAlt = :dtAlt")})
public class TipoPessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tppessoa_num")
    private Integer tppessoaNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nm_tppessoa")
    private String nmTppessoa;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tppessoaNum", fetch = FetchType.LAZY)
    private List<Pessoa> pessoaList;

    public TipoPessoa() {
    }

    public TipoPessoa(Integer tppessoaNum) {
        this.tppessoaNum = tppessoaNum;
    }

    public TipoPessoa(Integer tppessoaNum, String nmTppessoa, String usAlt, Date dtAlt) {
        this.tppessoaNum = tppessoaNum;
        this.nmTppessoa = nmTppessoa;
        this.usAlt = usAlt;
        this.dtAlt = dtAlt;
    }

    public Integer getTppessoaNum() {
        return tppessoaNum;
    }

    public void setTppessoaNum(Integer tppessoaNum) {
        this.tppessoaNum = tppessoaNum;
    }

    public String getNmTppessoa() {
        return nmTppessoa;
    }

    public void setNmTppessoa(String nmTppessoa) {
        this.nmTppessoa = nmTppessoa;
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
        hash += (tppessoaNum != null ? tppessoaNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPessoa)) {
            return false;
        }
        TipoPessoa other = (TipoPessoa) object;
        if ((this.tppessoaNum == null && other.tppessoaNum != null) || (this.tppessoaNum != null && !this.tppessoaNum.equals(other.tppessoaNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.juridico.model.TipoPessoa[ tppessoaNum=" + tppessoaNum + " ]";
    }
    
}
