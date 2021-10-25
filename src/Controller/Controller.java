/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ClassBdd.Formation;
import ClassBdd.Former;
import ClassBdd.Promotion;
import ClassBdd.School;
import Model.Model;
import Views.ViewMain;

/**
 *
 * @author lor.cdi02
 */
public class Controller {

    Model model;
    ViewMain view;

    private Controller() {
        this.view = new ViewMain();
        model = new Model();
        this.model.addView(view);
    }

    public static Controller getInstance() {
        return ControllerHolder.INSTANCE;
    }

    private static class ControllerHolder {

        private static final Controller INSTANCE = new Controller();
    }

    public void startScenario(Declencheur d) {
        switch (d.getType()) {
            case Declencheur.AJOUT_SCHOOL:
                this.model.addSite((School) d.getDetails());
                break;
            case Declencheur.CHOIX_PROMOTION:
                this.model.ListerLesPromo((Promotion) d.getDetails());
                break;
            case Declencheur.LOAD_FORMATION:
                this.model.ListerLesFormations((Formation) d.getDetails());
                break;
            case Declencheur.LOAD_CITY_NAME:
                this.model.ListerLesVilles();
                break;
            case Declencheur.LOAD_BEGIN_DATE:
                this.model.ListBeginDate();
                break;
            case Declencheur.LOAD_END_DATE:
                this.model.ListEndDate();
                break;
            case Declencheur.LOAD_SCHOOL:
                this.model.ListSchool();
                break;
            case Declencheur.AJOUT_FORMER:
                this.model.addFormer((Former) d.getDetails());
                break;
            case Declencheur.SEARCH_IDSCHOOL_WITH_NAME:
                this.model.SearchIdSchoolWithName(d.getDateBegin(), d.getDateEnd(), d.getSchoolName(), d.getFormationName());
                break;
            case Declencheur.AFFICHAGE_PROMOTION_CHOISIE:
                this.model.affichagePromoChoisie((Student) d.getDetails());
                break;
            default:
                break;

        }

    }

    public void initView() {
        this.view.init();
    }
}
