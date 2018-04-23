/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author cguittat
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;
import modele.Client;
import modele.Employe;
import modele.Intervention;
import util.GeoTest;


public class InterventionDAO {
    public InterventionDAO(){
        
    }
    public Intervention creerIntervention (Intervention in){
        boolean unDispo = false;
        in.setDateDebut();
        Query query = JpaUtil.obtenirEntityManager().createQuery("select e from Employe e where e.dispo =1");
        List<Employe> res = (List<Employe>) query.getResultList();
        double dureeProvisoire = -1;
        Employe empProvisoire = null;
        for (int i =0; i<res.size();i++){
            if (res.get(i).disponi(in.getTimeInterv().getHours())){ 
                //probleme de cle 
                //double dureeCalculee = GeoTest.getTripDurationByBicycleInMinute(in.getClient().getGPS(), res.get(i).getGPS());
                double dureeCalculee = Math.random() *5;//debug
                if (dureeProvisoire < 0 || dureeCalculee< dureeProvisoire){
                    dureeProvisoire = dureeCalculee;
                    empProvisoire = res.get(i);
                    unDispo = true;
                }
            }
        }
        
        if (unDispo){
            in.setEmploye(empProvisoire);
            empProvisoire.setDispo(false);
            JpaUtil.obtenirEntityManager().persist(in);
        }
        else {
            in = null;
        }
        return in;
    }
    
    public List<Intervention> getAllIntervClient (Client c){
        Query query = JpaUtil.obtenirEntityManager().createQuery("Select i from Intervention i where i.demandePar = :cl ORDER BY i.id DESC");
        query.setParameter("cl", c);
        List<Intervention> liste;
        liste = (List<Intervention>) query.getResultList();
        return liste;
    }
    
    public List<Intervention> get5LastIntervClient (Client c){
        Query query = JpaUtil.obtenirEntityManager().createQuery("Select i from Intervention i where i.demandePar = :cl ORDER BY i.id DESC");
        query.setParameter("cl", c);
        List<Intervention> liste;
        liste = (List<Intervention>) query.setMaxResults(5).getResultList();
        return liste;
    }
    
    public Intervention getIntervInProgress (Employe emp){
        Query query = JpaUtil.obtenirEntityManager().createQuery("Select i from Intervention i where i.realisePar = :em and i.estFini =0");
        query.setParameter("em", emp);
        Intervention in;
        try{
            in = (Intervention) query.getSingleResult();
        } catch (Exception e) {
            in = null;
        }
        return in;
    }
    
    public List<Intervention> getAllIntervEmploye (Employe emp){
        Query query = JpaUtil.obtenirEntityManager().createQuery("Select i from Intervention i where i.realisePar = :em ORDER BY i.id DESC");
        query.setParameter("em", emp);
        List<Intervention> liste;
        liste = (List<Intervention>) query.getResultList();
        return liste;
    } 
    
    public List<Intervention> getAllIntervToday (){
        Query query = JpaUtil.obtenirEntityManager().createQuery("Select i from Intervention i where i.estFini=1 Order BY i.fin DESC");
        Date d = new Date();
        List<Intervention> liste;
        liste = (List<Intervention>) query.getResultList();
        for (Iterator<Intervention> iter = liste.listIterator(); iter.hasNext();){
            Intervention in = iter.next();
            boolean verif = in.getTimeFin().getDate() == d.getDate() && in.getTimeFin().getMonth() == d.getMonth() && in.getTimeFin().getYear() == d.getYear();
            if(!verif){
                iter.remove();
            }
        }
        return liste;
    } 
    
    public Intervention closeInterv (Employe emp, String comm){
        Query query = JpaUtil.obtenirEntityManager().createQuery("Select i from Intervention i where i.realisePar = :em and i.estFini =0");
        query.setParameter("em", emp);
        Intervention in;
        try{
            in = (Intervention) query.getSingleResult();
            in.setFini(true);
            in.setDateFin();
            in.setComm(comm);
            emp.setDispo(true);
            JpaUtil.obtenirEntityManager().merge(emp);
        } catch (Exception e) {
            in = null;
        }
        return in;
    }
}
