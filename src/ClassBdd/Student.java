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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentId", query = "SELECT s FROM Student s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "Student.findByStudentFirstName", query = "SELECT s FROM Student s WHERE s.studentFirstName = :studentFirstName"),
    @NamedQuery(name = "Student.findByStudentLastName", query = "SELECT s FROM Student s WHERE s.studentLastName = :studentLastName"),
    @NamedQuery(name = "Student.findByStudentMail", query = "SELECT s FROM Student s WHERE s.studentMail = :studentMail"),
    @NamedQuery(name = "Student.findByStudentAge", query = "SELECT s FROM Student s WHERE s.studentAge = :studentAge"),
    @NamedQuery(name = "Student.findByStudentRetard", query = "SELECT s FROM Student s WHERE s.studentRetard = :studentRetard"),
    @NamedQuery(name = "Student.findByStudentCommentary", query = "SELECT s FROM Student s WHERE s.studentCommentary = :studentCommentary"),
    @NamedQuery(name = "Student.findByStudentOldPromotion", query = "SELECT s FROM Student s WHERE s.studentOldPromotion = :studentOldPromotion"),
    @NamedQuery(name = "Student.findByStudentTelephonNumber", query = "SELECT s FROM Student s WHERE s.studentTelephonNumber = :studentTelephonNumber")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "student_first_name")
    private String studentFirstName;
    @Column(name = "student_last_name")
    private String studentLastName;
    @Column(name = "student_mail")
    private String studentMail;
    @Column(name = "student_age")
    private Integer studentAge;
    @Column(name = "student_retard")
    private Integer studentRetard;
    @Column(name = "student_commentary")
    private String studentCommentary;
    @Column(name = "student_old_promotion")
    private String studentOldPromotion;
    @Column(name = "student_telephon_number")
    private Integer studentTelephonNumber;
    @OneToMany(mappedBy = "studentId")
    private Collection<Note> noteCollection;
    @JoinColumn(name = "former_id", referencedColumnName = "former_id")
    @ManyToOne
    private Former formerId;
    @JoinColumn(name = "promotion_id", referencedColumnName = "promotion_id")
    @ManyToOne
    private Promotion promotionId;

    public Student() {
    }

    public Student(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentMail() {
        return studentMail;
    }

    public void setStudentMail(String studentMail) {
        this.studentMail = studentMail;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public Integer getStudentRetard() {
        return studentRetard;
    }

    public void setStudentRetard(Integer studentRetard) {
        this.studentRetard = studentRetard;
    }

    public String getStudentCommentary() {
        return studentCommentary;
    }

    public void setStudentCommentary(String studentCommentary) {
        this.studentCommentary = studentCommentary;
    }

    public String getStudentOldPromotion() {
        return studentOldPromotion;
    }

    public void setStudentOldPromotion(String studentOldPromotion) {
        this.studentOldPromotion = studentOldPromotion;
    }

    public Integer getStudentTelephonNumber() {
        return studentTelephonNumber;
    }

    public void setStudentTelephonNumber(Integer studentTelephonNumber) {
        this.studentTelephonNumber = studentTelephonNumber;
    }

    @XmlTransient
    public Collection<Note> getNoteCollection() {
        return noteCollection;
    }

    public void setNoteCollection(Collection<Note> noteCollection) {
        this.noteCollection = noteCollection;
    }

    public Former getFormerId() {
        return formerId;
    }

    public void setFormerId(Former formerId) {
        this.formerId = formerId;
    }

    public Promotion getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Promotion promotionId) {
        this.promotionId = promotionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClassBdd.Student[ studentId=" + studentId + " ]";
    }
    
}
