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
@Table(name = "former")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Former.findAll", query = "SELECT f FROM Former f"),
    @NamedQuery(name = "Former.findByFormerId", query = "SELECT f FROM Former f WHERE f.formerId = :formerId"),
    @NamedQuery(name = "Former.findByFormerFirstName", query = "SELECT f FROM Former f WHERE f.formerFirstName = :formerFirstName"),
    @NamedQuery(name = "Former.findByFormerLastName", query = "SELECT f FROM Former f WHERE f.formerLastName = :formerLastName"),
    @NamedQuery(name = "Former.findByFormerLesson", query = "SELECT f FROM Former f WHERE f.formerLesson = :formerLesson"),
    @NamedQuery(name = "Former.findByFormerLogin", query = "SELECT f FROM Former f WHERE f.formerLogin = :formerLogin"),
    @NamedQuery(name = "Former.findByFormerPassword", query = "SELECT f FROM Former f WHERE f.formerPassword = :formerPassword")})
public class Former implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "former_id")
    private Integer formerId;
    @Column(name = "former_first_name")
    private String formerFirstName;
    @Column(name = "former_last_name")
    private String formerLastName;
    @Column(name = "former_lesson")
    private String formerLesson;
    @Column(name = "former_login")
    private String formerLogin;
    @Column(name = "former_password")
    private String formerPassword;
    @OneToMany(mappedBy = "formerId")
    private Collection<Note> noteCollection;
    @OneToMany(mappedBy = "formerId")
    private Collection<Student> studentCollection;

    public Former() {
    }

    public Former(Integer formerId) {
        this.formerId = formerId;
    }

    public Integer getFormerId() {
        return formerId;
    }

    public void setFormerId(Integer formerId) {
        this.formerId = formerId;
    }

    public String getFormerFirstName() {
        return formerFirstName;
    }

    public void setFormerFirstName(String formerFirstName) {
        this.formerFirstName = formerFirstName;
    }

    public String getFormerLastName() {
        return formerLastName;
    }

    public void setFormerLastName(String formerLastName) {
        this.formerLastName = formerLastName;
    }

    public String getFormerLesson() {
        return formerLesson;
    }

    public void setFormerLesson(String formerLesson) {
        this.formerLesson = formerLesson;
    }

    public String getFormerLogin() {
        return formerLogin;
    }

    public void setFormerLogin(String formerLogin) {
        this.formerLogin = formerLogin;
    }

    public String getFormerPassword() {
        return formerPassword;
    }

    public void setFormerPassword(String formerPassword) {
        this.formerPassword = formerPassword;
    }

    @XmlTransient
    public Collection<Note> getNoteCollection() {
        return noteCollection;
    }

    public void setNoteCollection(Collection<Note> noteCollection) {
        this.noteCollection = noteCollection;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formerId != null ? formerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Former)) {
            return false;
        }
        Former other = (Former) object;
        if ((this.formerId == null && other.formerId != null) || (this.formerId != null && !this.formerId.equals(other.formerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClassBdd.Former[ formerId=" + formerId + " ]";
    }
    
}
