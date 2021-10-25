/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassBdd;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lor.cdi02
 */
@Entity
@Table(name = "ecf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecf.findAll", query = "SELECT e FROM Ecf e"),
    @NamedQuery(name = "Ecf.findByEcfId", query = "SELECT e FROM Ecf e WHERE e.ecfId = :ecfId"),
    @NamedQuery(name = "Ecf.findByEcfName", query = "SELECT e FROM Ecf e WHERE e.ecfName = :ecfName"),
    @NamedQuery(name = "Ecf.findByEcfDate", query = "SELECT e FROM Ecf e WHERE e.ecfDate = :ecfDate")})
public class Ecf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ecf_id")
    private Integer ecfId;
    @Column(name = "ecf_name")
    private String ecfName;
    @Column(name = "ecf_date")
    @Temporal(TemporalType.DATE)
    private Date ecfDate;
    @OneToMany(mappedBy = "ecfId")
    private Collection<Note> noteCollection;

    public Ecf() {
    }

    public Ecf(Integer ecfId) {
        this.ecfId = ecfId;
    }

    public Integer getEcfId() {
        return ecfId;
    }

    public void setEcfId(Integer ecfId) {
        this.ecfId = ecfId;
    }

    public String getEcfName() {
        return ecfName;
    }

    public void setEcfName(String ecfName) {
        this.ecfName = ecfName;
    }

    public Date getEcfDate() {
        return ecfDate;
    }

    public void setEcfDate(Date ecfDate) {
        this.ecfDate = ecfDate;
    }

    @XmlTransient
    public Collection<Note> getNoteCollection() {
        return noteCollection;
    }

    public void setNoteCollection(Collection<Note> noteCollection) {
        this.noteCollection = noteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ecfId != null ? ecfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecf)) {
            return false;
        }
        Ecf other = (Ecf) object;
        if ((this.ecfId == null && other.ecfId != null) || (this.ecfId != null && !this.ecfId.equals(other.ecfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClassBdd.Ecf[ ecfId=" + ecfId + " ]";
    }
    
}
