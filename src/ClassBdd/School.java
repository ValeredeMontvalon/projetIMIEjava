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
@Table(name = "school")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "School.findAll", query = "SELECT s FROM School s"),
    @NamedQuery(name = "School.findBySchoolId", query = "SELECT s FROM School s WHERE s.schoolId = :schoolId"),
    @NamedQuery(name = "School.findBySchoolName", query = "SELECT s FROM School s WHERE s.schoolName = :schoolName"),
    @NamedQuery(name = "School.findBySchoolCity", query = "SELECT s FROM School s WHERE s.schoolCity = :schoolCity")})
public class School implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "school_id")
    private Integer schoolId;
    @Column(name = "school_name")
    private String schoolName;
    @Column(name = "school_city")
    private String schoolCity;
    @OneToMany(mappedBy = "schoolId")
    private Collection<Promotion> promotionCollection;

    public School() {
    }

    public School(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolCity() {
        return schoolCity;
    }

    public void setSchoolCity(String schoolCity) {
        this.schoolCity = schoolCity;
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
        hash += (schoolId != null ? schoolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof School)) {
            return false;
        }
        School other = (School) object;
        if ((this.schoolId == null && other.schoolId != null) || (this.schoolId != null && !this.schoolId.equals(other.schoolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClassBdd.School[ schoolId=" + schoolId + " ]";
    }
    
}
