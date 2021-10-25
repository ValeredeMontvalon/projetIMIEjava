/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imiesproject;

import ClassBdd.Ecf;
import Controller.Controller;
import HibernateTools.HibernateUtilTools;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lor.cdi02
 */
public class ImiesProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller c = Controller.getInstance();
        c.initView();
//        Session s = HibernateUtilTools.getSessionFactory().openSession();
//        Transaction t = s.beginTransaction();
//        
//        Ecf e = new Ecf();
//        e.setEcfName("42");
//       
//        s.save(e);
//        t.commit();
//        
//        s.close();
    }
    
}
