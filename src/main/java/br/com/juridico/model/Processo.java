/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juridico.model;

import br.com.juridico.enums.ProcessoSituacaoEnum;
import br.com.juridico.enums.ProcessoTipoClienteEnum;
import br.com.juridico.enums.SimNaoEnum;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
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
@Table(name = "processo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Processo.findAll", query = "SELECT p FROM Processo p"),
    @NamedQuery(name = "Processo.findByProcessoNum", query = "SELECT p FROM Processo p WHERE p.processoNum = :processoNum"),
    @NamedQuery(name = "Processo.findByCodBarras", query = "SELECT p FROM Processo p WHERE p.codBarras = :codBarras"),
    @NamedQuery(name = "Processo.findByNumProcesso", query = "SELECT p FROM Processo p WHERE p.numProcesso = :numProcesso")
})
@NamedNativeQuery(name = "fcGetProcessos", callable = true, query = "{? = call fc_get_processos}", resultClass = Processo.class)

@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
            name = "Processo.insert",
            procedureName = "processo_insert",
            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_num")}
    )})
public class Processo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "processo_num")
    private Integer processoNum;

    @Size(max = 50)
    @Column(name = "cod_barras")
    private String codBarras;

    @Size(max = 50)
    @Column(name = "num_processo")
    private String numProcesso;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "ds_processo")
    private String dsProcesso;

    @Size(max = 50)
    @Column(name = "toi_num")
    private String toiNum;

    @Size(max = 50)
    @Column(name = "instalacao_num")
    private String instalacaoNum;

    @Size(max = 50)
    @Column(name = "pn_num")
    private String pnNum;

    @Size(max = 50)
    @Column(name = "trib_just_num")
    private String tribJustNum;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cd_tipo_cliente")
    @Enumerated(EnumType.STRING)
    private ProcessoTipoClienteEnum cdTipoCliente;

    @Basic(optional = false)
    @NotNull
    @Column(name = "sg_liminar")
    @Enumerated(EnumType.STRING)
    private SimNaoEnum sgLiminar;

    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_abertura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAbertura;

    @Column(name = "dt_encerramento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtEncerramento;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cd_sit")
    @Enumerated(EnumType.STRING)
    private ProcessoSituacaoEnum cdSit;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vl_causa")
    private Double vlCausa;

    @Column(name = "vl_debito")
    private Double vlDebito;

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

    @JoinColumn(name = "acao_num", referencedColumnName = "acao_num")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Acao acaoNum;

    @JoinColumn(name = "comarca_num", referencedColumnName = "comarca_num")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Comarca comarcaNum;

    @JoinColumn(name = "fase_item_num", referencedColumnName = "item_num")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item faseItemNum;

    @JoinColumn(name = "jurisdicao_num", referencedColumnName = "jurisdicao_num")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Jurisdicao jurisdicaoNum;

    @JoinColumn(name = "natureza_num", referencedColumnName = "natureza_num")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Natureza naturezaNum;

    @OneToMany(mappedBy = "paiProcessoNum", fetch = FetchType.LAZY)
    private List<Processo> processoList;

    @JoinColumn(name = "pai_processo_num", referencedColumnName = "processo_num")
    @ManyToOne(fetch = FetchType.LAZY)
    private Processo paiProcessoNum;

    @JoinColumn(name = "vara_num", referencedColumnName = "vara_num")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vara varaNum;

    public Processo() {
    }

    public Processo(Integer processoNum) {
        this.processoNum = processoNum;
    }

    public Processo(Integer processoNum, String dsProcesso, ProcessoTipoClienteEnum cdTipoCliente, SimNaoEnum sgLiminar, Date dtCadastro, Date dtAbertura, ProcessoSituacaoEnum cdSit, String usAlt, Date dtAlt) {
        this.processoNum = processoNum;
        this.dsProcesso = dsProcesso;
        this.cdTipoCliente = cdTipoCliente;
        this.sgLiminar = sgLiminar;
        this.dtCadastro = dtCadastro;
        this.dtAbertura = dtAbertura;
        this.cdSit = cdSit;
        this.usAlt = usAlt;
        this.dtAlt = dtAlt;
    }

    public Integer getProcessoNum() {
        return processoNum;
    }

    public void setProcessoNum(Integer processoNum) {
        this.processoNum = processoNum;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getNumProcesso() {
        return numProcesso;
    }

    public void setNumProcesso(String numProcesso) {
        this.numProcesso = numProcesso;
    }

    public String getDsProcesso() {
        return dsProcesso;
    }

    public void setDsProcesso(String dsProcesso) {
        this.dsProcesso = dsProcesso;
    }

    public String getToiNum() {
        return toiNum;
    }

    public void setToiNum(String toiNum) {
        this.toiNum = toiNum;
    }

    public String getInstalacaoNum() {
        return instalacaoNum;
    }

    public void setInstalacaoNum(String instalacaoNum) {
        this.instalacaoNum = instalacaoNum;
    }

    public String getPnNum() {
        return pnNum;
    }

    public void setPnNum(String pnNum) {
        this.pnNum = pnNum;
    }

    public String getTribJustNum() {
        return tribJustNum;
    }

    public void setTribJustNum(String tribJustNum) {
        this.tribJustNum = tribJustNum;
    }

    public ProcessoTipoClienteEnum getCdTipoCliente() {
        return cdTipoCliente;
    }

    public void setCdTipoCliente(ProcessoTipoClienteEnum cdTipoCliente) {
        this.cdTipoCliente = cdTipoCliente;
    }

    public SimNaoEnum getSgLiminar() {
        return sgLiminar;
    }

    public void setSgLiminar(SimNaoEnum sgLiminar) {
        this.sgLiminar = sgLiminar;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Date getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(Date dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    public Date getDtEncerramento() {
        return dtEncerramento;
    }

    public void setDtEncerramento(Date dtEncerramento) {
        this.dtEncerramento = dtEncerramento;
    }

    public ProcessoSituacaoEnum getCdSit() {
        return cdSit;
    }

    public void setCdSit(ProcessoSituacaoEnum cdSit) {
        this.cdSit = cdSit;
    }

    public Double getVlCausa() {
        return vlCausa;
    }

    public void setVlCausa(Double vlCausa) {
        this.vlCausa = vlCausa;
    }

    public Double getVlDebito() {
        return vlDebito;
    }

    public void setVlDebito(Double vlDebito) {
        this.vlDebito = vlDebito;
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

    public Acao getAcaoNum() {
        return acaoNum;
    }

    public void setAcaoNum(Acao acaoNum) {
        this.acaoNum = acaoNum;
    }

    public Comarca getComarcaNum() {
        return comarcaNum;
    }

    public void setComarcaNum(Comarca comarcaNum) {
        this.comarcaNum = comarcaNum;
    }

    public Item getFaseItemNum() {
        return faseItemNum;
    }

    public void setFaseItemNum(Item faseItemNum) {
        this.faseItemNum = faseItemNum;
    }

    public Jurisdicao getJurisdicaoNum() {
        return jurisdicaoNum;
    }

    public void setJurisdicaoNum(Jurisdicao jurisdicaoNum) {
        this.jurisdicaoNum = jurisdicaoNum;
    }

    public Natureza getNaturezaNum() {
        return naturezaNum;
    }

    public void setNaturezaNum(Natureza naturezaNum) {
        this.naturezaNum = naturezaNum;
    }

    @XmlTransient
    public List<Processo> getProcessoList() {
        return processoList;
    }

    public void setProcessoList(List<Processo> processoList) {
        this.processoList = processoList;
    }

    public Processo getPaiProcessoNum() {
        return paiProcessoNum;
    }

    public void setPaiProcessoNum(Processo paiProcessoNum) {
        this.paiProcessoNum = paiProcessoNum;
    }

    public Vara getVaraNum() {
        return varaNum;
    }

    public void setVaraNum(Vara varaNum) {
        this.varaNum = varaNum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (processoNum != null ? processoNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Processo)) {
            return false;
        }
        Processo other = (Processo) object;
        if ((this.processoNum == null && other.processoNum != null) || (this.processoNum != null && !this.processoNum.equals(other.processoNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.juridico.model.Processo[ processoNum=" + processoNum + " ]";
    }

}
