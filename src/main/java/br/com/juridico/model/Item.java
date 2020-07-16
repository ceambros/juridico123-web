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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByItemNum", query = "SELECT i FROM Item i WHERE i.itemNum = :itemNum"),
    @NamedQuery(name = "Item.findByNmItem", query = "SELECT i FROM Item i WHERE i.nmItem = :nmItem"),
    @NamedQuery(name = "Item.findByCdSit", query = "SELECT i FROM Item i WHERE i.cdSit = :cdSit"),
    @NamedQuery(name = "Item.findByUsAlt", query = "SELECT i FROM Item i WHERE i.usAlt = :usAlt"),
    @NamedQuery(name = "Item.findByDtAlt", query = "SELECT i FROM Item i WHERE i.dtAlt = :dtAlt")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "item_num")
    private Integer itemNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nm_item")
    private String nmItem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "cd_sit")
    private String cdSit;
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
    @JoinColumn(name = "tpitem_num", referencedColumnName = "tpitem_num")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoItem tpitemNum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faseItemNum", fetch = FetchType.LAZY)
    private List<Processo> processoList;

    public Item() {
    }

    public Item(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public Item(Integer itemNum, String nmItem, String cdSit, String usAlt, Date dtAlt) {
        this.itemNum = itemNum;
        this.nmItem = nmItem;
        this.cdSit = cdSit;
        this.usAlt = usAlt;
        this.dtAlt = dtAlt;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public String getNmItem() {
        return nmItem;
    }

    public void setNmItem(String nmItem) {
        this.nmItem = nmItem;
    }

    public String getCdSit() {
        return cdSit;
    }

    public void setCdSit(String cdSit) {
        this.cdSit = cdSit;
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

    public TipoItem getTpitemNum() {
        return tpitemNum;
    }

    public void setTpitemNum(TipoItem tpitemNum) {
        this.tpitemNum = tpitemNum;
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
        hash += (itemNum != null ? itemNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemNum == null && other.itemNum != null) || (this.itemNum != null && !this.itemNum.equals(other.itemNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.juridico.model.Item[ itemNum=" + itemNum + " ]";
    }
    
}
