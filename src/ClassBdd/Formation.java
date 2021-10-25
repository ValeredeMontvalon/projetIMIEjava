/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassBdd;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lor.cdi02
 */
@Entity
@Table(name = "formation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formation.findAll", query = "SELECT f FROM Formation f"),
    @NamedQuery(name = "Formation.findByFormationId", query = "SELECT f FROM Formation f WHERE f.formationId = :formationId"),
    @NamedQuery(name = "Formation.findByFormationName", query = "SELECT f FROM Formation f WHERE f.formationName = :formationName")})
public class Formation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "formation_id")
    private Integer formationId;
    @Column(name = "formation_name")
    private String formationName;
    @OneToMany(mappedBy = "formationId")
    private Collection<Promotion> promotionCollection;

    public Formation() {
    }

    public Formation(Integer formationId) {
        this.formationId = formationId;
    }

    public Integer getFormationId() {
        return formationId;
    }

    public void setFormationId(Integer formationId) {
        this.formationId = formationId;
    }

    public String getFormationName() {
        return formationName;
    }

    public void setFormationName(String formationName) {
        this.formationName = formationName;
    }

    @XmlTransient
    public Collection<Promotion> getPromotionCollection() {
        return promotionCollection;
    }

    public void setPromotionCollection(Collection<Promotion> promotionCollection) {
        this.promotionCollection = promotionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formationId != null ? formationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formation)) {
            return false;
        }
        Formation other = (Formation) object;
        if ((this.formationId == null && other.formationId != null) || (this.formationId != null && !this.formationId.equals(other.formationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + formationName ;
    }
    
}
