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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "promotion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p"),
    @NamedQuery(name = "Promotion.findByPromotionId", query = "SELECT p FROM Promotion p WHERE p.promotionId = :promotionId"),
    @NamedQuery(name = "Promotion.findByPromotionName", query = "SELECT p FROM Promotion p WHERE p.promotionName = :promotionName"),
    @NamedQuery(name = "Promotion.findByPromotionNumber", query = "SELECT p FROM Promotion p WHERE p.promotionNumber = :promotionNumber"),
    @NamedQuery(name = "Promotion.findByPromotionDateBegin", query = "SELECT p FROM Promotion p WHERE p.promotionDateBegin = :promotionDateBegin"),
    @NamedQuery(name = "Promotion.findByPromotionDateEnd", query = "SELECT p FROM Promotion p WHERE p.promotionDateEnd = :promotionDateEnd")})
public class Promotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "promotion_id")
    private Integer promotionId;
    @Column(name = "promotion_name")
    private String promotionName;
    @Column(name = "promotion_number")
    private String promotionNumber;
    @Column(name = "promotion_date_begin")
    @Temporal(TemporalType.DATE)
    private Date promotionDateBegin;
    @Column(name = "promotion_date_end")
    @Temporal(TemporalType.DATE)
    private Date promotionDateEnd;
    @OneToMany(mappedBy = "promotionId")
    private Collection<Student> studentCollection;
    @JoinColumn(name = "formation_id", referencedColumnName = "formation_id")
    @ManyToOne
    private Formation formationId;
    @JoinColumn(name = "school_id", referencedColumnName = "school_id")
    @ManyToOne
    private School schoolId;

    public Promotion() {
    }

    public Promotion(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getPromotionNumber() {
        return promotionNumber;
    }

    public void setPromotionNumber(String promotionNumber) {
        this.promotionNumber = promotionNumber;
    }

    public Date getPromotionDateBegin() {
        return promotionDateBegin;
    }

    public void setPromotionDateBegin(Date promotionDateBegin) {
        this.promotionDateBegin = promotionDateBegin;
    }

    public Date getPromotionDateEnd() {
        return promotionDateEnd;
    }

    public void setPromotionDateEnd(Date promotionDateEnd) {
        this.promotionDateEnd = promotionDateEnd;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    public Formation getFormationId() {
        return formationId;
    }

    public void setFormationId(Formation formationId) {
        this.formationId = formationId;
    }

    public School getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(School schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promotionId != null ? promotionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.promotionId == null && other.promotionId != null) || (this.promotionId != null && !this.promotionId.equals(other.promotionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return promotionName;
    }
    
}
