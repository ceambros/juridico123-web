/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juridico.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Eduardo Ambrosio
 */
@Entity
@Table(name = "pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByPessoaNum", query = "SELECT p FROM Pessoa p WHERE p.pessoaNum = :pessoaNum"),
    @NamedQuery(name = "Pessoa.findByNmPessoa", query = "SELECT p FROM Pessoa p WHERE p.nmPessoa = :nmPessoa"),
    @NamedQuery(name = "Pessoa.findByNmAbrev", query = "SELECT p FROM Pessoa p WHERE p.nmAbrev = :nmAbrev"),
    @NamedQuery(name = "Pessoa.findByCdTipoFj", query = "SELECT p FROM Pessoa p WHERE p.cdTipoFj = :cdTipoFj"),
    @NamedQuery(name = "Pessoa.findByCdSit", query = "SELECT p FROM Pessoa p WHERE p.cdSit = :cdSit"),
    @NamedQuery(name = "Pessoa.findByCdSexo", query = "SELECT p FROM Pessoa p WHERE p.cdSexo = :cdSexo"),
    @NamedQuery(name = "Pessoa.findByDtCadastro", query = "SELECT p FROM Pessoa p WHERE p.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "Pessoa.findByDtNascimento", query = "SELECT p FROM Pessoa p WHERE p.dtNascimento = :dtNascimento"),
    @NamedQuery(name = "Pessoa.findByCpfCnpjNum", query = "SELECT p FROM Pessoa p WHERE p.cpfCnpjNum = :cpfCnpjNum"),
    @NamedQuery(name = "Pessoa.findByRgIeNum", query = "SELECT p FROM Pessoa p WHERE p.rgIeNum = :rgIeNum"),
    @NamedQuery(name = "Pessoa.findByOabNum", query = "SELECT p FROM Pessoa p WHERE p.oabNum = :oabNum")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pessoa_num")
    private Integer pessoaNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nm_pessoa")
    private String nmPessoa;
    @Size(max = 30)
    @Column(name = "nm_abrev")
    private String nmAbrev;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cd_tipo_fj")
    private Character cdTipoFj;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cd_sit")
    private Character cdSit;
    @Column(name = "cd_sexo")
    private Character cdSexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;
    @Column(name = "dt_nascimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtNascimento;
    @Size(max = 20)
    @Column(name = "cpf_cnpj_num")
    private String cpfCnpjNum;
    @Size(max = 20)
    @Column(name = "rg_ie_num")
    private String rgIeNum;
    @Size(max = 20)
    @Column(name = "oab_num")
    private String oabNum;
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
    @JoinColumn(name = "funcao_num", referencedColumnName = "funcao_num")
    @ManyToOne(fetch = FetchType.LAZY)
    private Funcao funcaoNum;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoa1", fetch = FetchType.LAZY)
    private Pessoa pessoa;
    @JoinColumn(name = "pessoa_num", referencedColumnName = "pessoa_num", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Pessoa pessoa1;
    @JoinColumn(name = "tppessoa_num", referencedColumnName = "tppessoa_num")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoPessoa tppessoaNum;

    public Pessoa() {
    }

    public Pessoa(Integer pessoaNum) {
        this.pessoaNum = pessoaNum;
    }

    public Pessoa(Integer pessoaNum, String nmPessoa, Character cdTipoFj, Character cdSit, Date dtCadastro, String usAlt, Date dtAlt) {
        this.pessoaNum = pessoaNum;
        this.nmPessoa = nmPessoa;
        this.cdTipoFj = cdTipoFj;
        this.cdSit = cdSit;
        this.dtCadastro = dtCadastro;
        this.usAlt = usAlt;
        this.dtAlt = dtAlt;
    }

    public Integer getPessoaNum() {
        return pessoaNum;
    }

    public void setPessoaNum(Integer pessoaNum) {
        this.pessoaNum = pessoaNum;
    }

    public String getNmPessoa() {
        return nmPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }

    public String getNmAbrev() {
        return nmAbrev;
    }

    public void setNmAbrev(String nmAbrev) {
        this.nmAbrev = nmAbrev;
    }

    public Character getCdTipoFj() {
        return cdTipoFj;
    }

    public void setCdTipoFj(Character cdTipoFj) {
        this.cdTipoFj = cdTipoFj;
    }

    public Character getCdSit() {
        return cdSit;
    }

    public void setCdSit(Character cdSit) {
        this.cdSit = cdSit;
    }

    public Character getCdSexo() {
        return cdSexo;
    }

    public void setCdSexo(Character cdSexo) {
        this.cdSexo = cdSexo;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getCpfCnpjNum() {
        return cpfCnpjNum;
    }

    public void setCpfCnpjNum(String cpfCnpjNum) {
        this.cpfCnpjNum = cpfCnpjNum;
    }

    public String getRgIeNum() {
        return rgIeNum;
    }

    public void setRgIeNum(String rgIeNum) {
        this.rgIeNum = rgIeNum;
    }

    public String getOabNum() {
        return oabNum;
    }

    public void setOabNum(String oabNum) {
        this.oabNum = oabNum;
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

    public Funcao getFuncaoNum() {
        return funcaoNum;
    }

    public void setFuncaoNum(Funcao funcaoNum) {
        this.funcaoNum = funcaoNum;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getPessoa1() {
        return pessoa1;
    }

    public void setPessoa1(Pessoa pessoa1) {
        this.pessoa1 = pessoa1;
    }

    public TipoPessoa getTppessoaNum() {
        return tppessoaNum;
    }

    public void setTppessoaNum(TipoPessoa tppessoaNum) {
        this.tppessoaNum = tppessoaNum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessoaNum != null ? pessoaNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.pessoaNum == null && other.pessoaNum != null) || (this.pessoaNum != null && !this.pessoaNum.equals(other.pessoaNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.juridico.model.Pessoa[ pessoaNum=" + pessoaNum + " ]";
    }
    
}
