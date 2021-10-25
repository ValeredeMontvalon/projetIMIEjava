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
import ImiesException.AddFormerParamsException;
import ImiesException.AddSiteParamsException;
import ImiesException.SearchIdSchoolWithNameException;
import ImiesException.SelectCityNameException;
import ImiesException.SelectDateBeginException;
import ImiesException.SelectDateEndException;
import ImiesException.SelectFormationException;
import ImiesException.SelectPromoException;
import ImiesException.SelectSchoolNameException;
import Views.View;
import Views.ViewMain;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lor.cdi02
 */
public class Model {

    private ViewMain view;

    public Model() {
    }

    public void addView(ViewMain view) {
        this.view = view;
    }

    public void addSite(School site) {
        try {
            boolean cityContainsInt = false;
            boolean SchoolNameEmpty = false;
            boolean CityNameEmpty = false;
            String cityName = site.getSchoolCity();
            for (char c : cityName.toCharArray()) {
                if (Character.isDigit(c)) {
                    cityContainsInt = true;
                }
            }
            if (site.getSchoolName().equals("")) {
                SchoolNameEmpty = true;
            }
            if (site.getSchoolCity().equals("")) {
                CityNameEmpty = true;
            }
            if (!cityContainsInt && !SchoolNameEmpty && CityNameEmpty) {
                this.view.AddSiteMessage(new AddSiteParamsException("Nom de ville vide!"));
            }
            if (!cityContainsInt && SchoolNameEmpty && !CityNameEmpty) {
                this.view.AddSiteMessage(new AddSiteParamsException("Nom du site vide!"));
            }
            if (cityContainsInt && !SchoolNameEmpty && !CityNameEmpty) {
                this.view.AddSiteMessage(new AddSiteParamsException("Nom de ville invalide car contien des entiers!"));
            }
            if (!cityContainsInt && SchoolNameEmpty && CityNameEmpty) {
                this.view.AddSiteMessage(new AddSiteParamsException("Nom de ville et de site vides!"));
            }
            if (cityContainsInt && SchoolNameEmpty && !CityNameEmpty) {
                this.view.AddSiteMessage(new AddSiteParamsException("Nom de ville invalide et nom d'école vide!"));
            }
            if (!cityContainsInt && !SchoolNameEmpty && !CityNameEmpty) {
                DaoHibernateImiesProject.getInstance().addBdd(site);
                this.view.AddSiteMessage("Site correctement ajouter");
            }
        } catch (AddException e) {
            this.view.AddSiteMessage(e);
        }
    }

    public void addFormer(Former f) {
        boolean formerFirstNameEmpty = false;
        boolean formerLastNameEmpty = false;
        boolean formerLoginEmpty = false;
        boolean formerLessonEmpty = false;
        boolean formerPasswordEmpty = false;
        boolean firstNameContainInt = false;
        boolean lastNameContainInt = false;
        boolean lessonContainInt = false;
        try {
            //Vérification si il y a des entiers dans le nom, prénom, matière.
            for (char c : f.getFormerFirstName().toCharArray()) {
                if (Character.isDigit(c)) {
                    firstNameContainInt = true;
                }
            }
            for (char c : f.getFormerLastName().toCharArray()) {
                if (Character.isDigit(c)) {
                    lastNameContainInt = true;
                }
            }
            for (char c : f.getFormerLesson().toCharArray()) {
                if (Character.isDigit(c)) {
                    lessonContainInt = true;
                }
            }
            //Vérification si tous les champs sont remplis.
            if (f.getFormerFirstName().isEmpty()) {
                formerFirstNameEmpty = true;
            }
            if (f.getFormerLastName().isEmpty()) {
                formerLastNameEmpty = true;
            }
            if (f.getFormerLogin().isEmpty()) {
                formerLoginEmpty = true;
            }
            if (f.getFormerLesson().isEmpty()) {
                formerLessonEmpty = true;
            }
            if (f.getFormerPassword().isEmpty()) {
                formerPasswordEmpty = true;
            }
            if (firstNameContainInt && !lastNameContainInt && !lessonContainInt) {
                this.view.AddFormerMessage(new AddFormerParamsException("Vous avez mis un entier dans votre prénom !"));
            }
            if (!firstNameContainInt && lastNameContainInt && !lessonContainInt) {
                this.view.AddFormerMessage(new AddFormerParamsException("Vous avez mis un entier dans votre nom !"));
            }
            if (!firstNameContainInt && !lastNameContainInt && lessonContainInt) {
                this.view.AddFormerMessage(new AddFormerParamsException("Vous avez mis un entier dans votre matière !"));
            }
            if (formerFirstNameEmpty || formerLastNameEmpty || formerLessonEmpty || formerLoginEmpty || formerPasswordEmpty) {
                this.view.AddFormerMessage(new AddFormerParamsException("Vous n'avez pas remplis tous les champs  !"));
            }
            if (!lessonContainInt && !formerFirstNameEmpty && !formerLastNameEmpty && !formerLessonEmpty && !formerLoginEmpty && !formerPasswordEmpty && !firstNameContainInt && !lastNameContainInt) {
                DaoHibernateImiesProject.getInstance().addBdd(f);
                this.view.AddSiteMessage("Formateur correctement ajouter");

            }
        } catch (AddException e) {
            this.view.AddFormerMessage(e);
        }
    }

    public void ListerLesPromo(Promotion promo) {
        try {
            List<Promotion> listPromo = DaoHibernateImiesProject.getInstance().selectPromo(promo);
            this.view.chargeListePromotion(listPromo);
        } catch (SelectPromoException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    public void ListerLesFormations(Formation forma) {
        try {
            List<Formation> listForma = DaoHibernateImiesProject.getInstance().selectFormation(forma);
            this.view.ChargeListFormation(listForma);
        } catch (SelectFormationException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void ListerLesVilles() {
        try {
            List<String> listCity = DaoHibernateImiesProject.getInstance().selectCity();
            this.view.ChargeListCity(listCity);
        } catch (SelectCityNameException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ListBeginDate() {
        try {
            List<Date> listDateBegin = DaoHibernateImiesProject.getInstance().selectDateBegin();
            this.view.LoadDateBegin(listDateBegin);
        } catch (SelectDateBeginException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ListSchool(){
        try {
            List<String> listSchool = DaoHibernateImiesProject.getInstance().selectSchoolName();
            this.view.LoadSchoolName(listSchool);
        }catch (SelectSchoolNameException ex){
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       public void ListEndDate() {
        try {
            List<Date> listDateEnd = DaoHibernateImiesProject.getInstance().selectDateEnd();
            this.view.LoadDateEnd(listDateEnd);
        } catch (SelectDateEndException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       public Promotion SearchIdSchoolWithName(String dateBegin, String dateFin, String ecoleNom, String formationNom){

        Promotion p = new Promotion();
        //Transformation des string date du debut et date de fin de la promotion en date.
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Date DateDeb;
        Date DateFin;
        try {
            DateDeb = (Date) sdf.parse(dateBegin);
            DateFin = (Date) sdf.parse(dateFin);
            p.setPromotionDateBegin(DateDeb);
            p.setPromotionDateEnd(DateFin);
        } catch (ParseException ex) {
            Logger.getLogger(ViewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Recherche de l'id de l'école avec son nom
        
        
        //Recherche de l'id de la formation avec son nom
           
           return p;
       }

}
