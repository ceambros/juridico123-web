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
@Table(name = "tipo_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoItem.findAll", query = "SELECT t FROM TipoItem t"),
    @NamedQuery(name = "TipoItem.findByTpitemNum", query = "SELECT t FROM TipoItem t WHERE t.tpitemNum = :tpitemNum"),
    @NamedQuery(name = "TipoItem.findByNmTpitem", query = "SELECT t FROM TipoItem t WHERE t.nmTpitem = :nmTpitem"),
    @NamedQuery(name = "TipoItem.findByUsAlt", query = "SELECT t FROM TipoItem t WHERE t.usAlt = :usAlt"),
    @NamedQuery(name = "TipoItem.findByDtAlt", query = "SELECT t FROM TipoItem t WHERE t.dtAlt = :dtAlt")})
public class TipoItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tpitem_num")
    private Integer tpitemNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nm_tpitem")
    private String nmTpitem;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tpitemNum", fetch = FetchType.LAZY)
    private List<Item> itemList;

    public TipoItem() {
    }

    public TipoItem(Integer tpitemNum) {
        this.tpitemNum = tpitemNum;
    }

    public TipoItem(Integer tpitemNum, String nmTpitem, String usAlt, Date dtAlt) {
        this.tpitemNum = tpitemNum;
        this.nmTpitem = nmTpitem;
        this.usAlt = usAlt;
        this.dtAlt = dtAlt;
    }

    public Integer getTpitemNum() {
        return tpitemNum;
    }

    public void setTpitemNum(Integer tpitemNum) {
        this.tpitemNum = tpitemNum;
    }

    public String getNmTpitem() {
        return nmTpitem;
    }

    public void setNmTpitem(String nmTpitem) {
        this.nmTpitem = nmTpitem;
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
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpitemNum != null ? tpitemNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoItem)) {
            return false;
        }
        TipoItem other = (TipoItem) object;
        if ((this.tpitemNum == null && other.tpitemNum != null) || (this.tpitemNum != null && !this.tpitemNum.equals(other.tpitemNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.juridico.model.TipoItem[ tpitemNum=" + tpitemNum + " ]";
    }
    
}
