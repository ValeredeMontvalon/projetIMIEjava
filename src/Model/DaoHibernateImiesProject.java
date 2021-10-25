/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import ClassBdd.Formation;
import ClassBdd.Former;
import ClassBdd.Promotion;
import ClassBdd.School;
import ClassBdd.Student;
import HibernateTools.HibernateUtilTools;
import ImiesException.AddException;
import ImiesException.DeleteException;
import ImiesException.SelectCityNameException;
import ImiesException.SelectDateBeginException;
import ImiesException.SelectDateEndException;
import ImiesException.SelectFormationException;
import ImiesException.SelectPromoException;
import ImiesException.SelectSchoolNameException;
import ImiesException.UpdateException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author lor.cdi02
 */
public class DaoHibernateImiesProject {

    private DaoHibernateImiesProject() {
    }

    public static DaoHibernateImiesProject getInstance() {
        return DaoHibernateImiesProjectHolder.INSTANCE;
    }

    private static class DaoHibernateImiesProjectHolder {

        private static final DaoHibernateImiesProject INSTANCE = new DaoHibernateImiesProject();
    }

    public void addBdd(Object o) throws AddException {
        try {
            Session s = HibernateUtilTools.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            s.save(o);
            t.commit();
            s.close();
        } catch (Exception e) {
            throw new AddException("Erreur lors de l'ajout");
        }
    }

    public void updateBdd(Object o) throws UpdateException {
        try {
            Session s = HibernateUtilTools.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            s.update(o);
            t.commit();
            s.close();
        } catch (Exception e) {
            throw new UpdateException("Erreur lors de l'update");
        }
    }

    public void deleteBdd(Object o) throws DeleteException {
        try {
            Session s = HibernateUtilTools.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            s.delete(o);
            t.commit();
            s.close();
        } catch (Exception e) {
            throw new DeleteException("Erreur lors de la supression");
        }
    }

    public List<Promotion> selectPromo(Promotion promo) throws SelectPromoException {
        try {
            Session s = HibernateUtilTools.getSessionFactory().openSession();
            Criteria criteria = s.createCriteria(Promotion.class);
            if (promo.getPromotionName() != null) {
                criteria.add(Restrictions.like("promotionName", promo.getPromotionName() + "%"));
            }
            if (promo.getPromotionDateBegin() != null) {
                criteria.add(Restrictions.like("promotionDateBegin", promo.getPromotionDateBegin()));
            }
            if (promo.getPromotionDateEnd() != null) {
                criteria.add(Restrictions.like("promotionDateEnd", promo.getPromotionDateEnd()));
            }
            if (promo.getFormationId() != null) {
                criteria.add(Restrictions.like("formationId", promo.getFormationId()));
            }
            if (promo.getSchoolId() != null) {
                criteria.add(Restrictions.like("schoolId", promo.getSchoolId()));
            }
            List<Promotion> listpromo = criteria.list();
            s.close();
            return listpromo;
        } catch (Exception e) {
            throw new SelectPromoException("Erreur lors de la selection d'une promotion");
        }
    }

    public List<Student> selectStudent(Student s) {
        Session session = HibernateUtilTools.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Student.class);
        if (s.getStudentFirstName() != null) {
            criteria.add(Restrictions.like("studentFirstName", s.getStudentFirstName() + "%"));
        }
        if (s.getStudentLastName() != null) {
            criteria.add(Restrictions.like("studentLastName", s.getStudentLastName() + "%"));
        }
        if (s.getFormerId() != null) {
            criteria.add(Restrictions.like("formerId", s.getFormerId()));
        }
        List<Student> listStudent = criteria.list();
        session.close();
        return listStudent;
        }catch(Exception e){
            throw new SelectStudentException("Erreur lors de la selection d'un étudiant\n "+e.getMessage());
        }
    }

    public List<School> selectSchool(School s) {
        Session session = HibernateUtilTools.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(School.class);
        if (s.getSchoolName() != null) {
            criteria.add(Restrictions.like("schoolName", s.getSchoolName() + "%"));
        }
        if (s.getSchoolCity() != null) {
            criteria.add(Restrictions.like("schoolCity", s.getSchoolCity()));
        }
        List<School> listSchool = criteria.list();
        session.close();
        return listSchool;
    }

    public List<Formation> selectFormation(Formation f) throws SelectFormationException {
        try {
            Session session = HibernateUtilTools.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Formation.class);
            if (f.getFormationName() != null) {
                criteria.add(Restrictions.like("formationName", f.getFormationName() + "%"));
            }
            if (f.getFormationId() != null) {
                criteria.add(Restrictions.like("formationId", f.getFormationId()));
            }
            List<Formation> listFormation = criteria.list();
            session.close();
            return listFormation;
        } catch (Exception e) {
            throw new SelectFormationException("Erreur lors de la selection d'une promotion");
        }
    }
    
    public List<String> selectSchoolName() throws SelectSchoolNameException{
        try{
            Session session = HibernateUtilTools.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(School.class);
            criteria.setProjection(Projections.distinct(Projections.property("schoolName")));
            List<String> listSchoolName = criteria.list();
            session.close();
            return listSchoolName;
        }catch (Exception e){
            throw new SelectSchoolNameException("Erreur lors de la selection de l'école");
        }
    }
    public List<String> selectCity() throws SelectCityNameException {
        try {
            Session session = HibernateUtilTools.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(School.class);
            criteria.setProjection(Projections.distinct(Projections.property("schoolCity")));
            List<String> listSchool = criteria.list();

            session.close();
            return listSchool;
        } catch (Exception e) {
            throw new SelectCityNameException("Erreur lors de la selection d'une ville");
        }
    }

    public List<Date> selectDateBegin() throws SelectDateBeginException {
        try {
            Session session = HibernateUtilTools.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Promotion.class);
            criteria.setProjection(Projections.distinct(Projections.property("promotionDateBegin")));
            List<Date> listDate = criteria.list();

            session.close();
            return listDate;
        } catch (Exception e) {
            throw new SelectDateBeginException("Erreur lors de la selection d'une date de début");
        }
    }

    public List<Date> selectDateEnd() throws SelectDateEndException {
        try {
            Session session = HibernateUtilTools.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Promotion.class);
            criteria.setProjection(Projections.distinct(Projections.property("promotionDateEnd")));
            List<Date> listDate = criteria.list();

            session.close();
            return listDate;
        } catch (Exception e) {
            throw new SelectDateEndException("Erreur lors de la selection d'une date de fin" );
        }
    }

}
