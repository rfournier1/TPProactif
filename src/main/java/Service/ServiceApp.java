/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author clementguittat
 */

import DAO.ClientDAO;
import DAO.EmployeDAO;
import DAO.InterventionDAO;
import DAO.JpaUtil;
import java.util.List;
import modele.Client;
import modele.Employe;
import modele.Intervention;

public class ServiceApp {
    public ServiceApp(){
    
    }
    
    ClientDAO clientDAO = new ClientDAO();
    EmployeDAO employeDAO = new EmployeDAO();
    InterventionDAO intervDAO = new InterventionDAO();
    
    public Client creationClient (Client c){
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        Client cl = clientDAO.creerClient(c);
        try{
            JpaUtil.validerTransaction();
        }catch(Exception e){
            cl = null;
            JpaUtil.annulerTransaction();
        }
        JpaUtil.fermerEntityManager();
        return cl;
    }
    
    public void creationEmployes (Employe[]tabEmp){
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        employeDAO.creerEmployes(tabEmp);
        try{
            JpaUtil.validerTransaction();
        }catch(Exception e){
            JpaUtil.annulerTransaction();
        }
        JpaUtil.fermerEntityManager();
    }
    
    public Intervention creationIntervention(Intervention i){
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        Intervention in = intervDAO.creerIntervention(i);
        try{
            JpaUtil.validerTransaction();
        }catch(Exception e){
            in = null;
            JpaUtil.annulerTransaction();
        }
        JpaUtil.fermerEntityManager();
        return in;
    } 
    
    public Client clientLogin(String username, int mdp){
        JpaUtil.creerEntityManager();
        Client c;
        if (username.contains("@proactif.fr")){
            c = null;
        }
        else {
            c = clientDAO.verifLogin(username, mdp);
        }
        JpaUtil.fermerEntityManager();
        return c;
    }
    
    public Employe employeLogin(String username, int mdp){
        JpaUtil.creerEntityManager();
        Employe e;
        if (username.contains("@proactif.fr")){
            e = employeDAO.verifLogin(username, mdp);        
        }
        else {
            e = null;
        }
        JpaUtil.fermerEntityManager();
        return e;
    }
    
    public List<Intervention> recupToutesIntervClient (Client c){
        List<Intervention> liste;
        JpaUtil.creerEntityManager();
        liste = intervDAO.getAllIntervClient(c);
        JpaUtil.fermerEntityManager(); 
        return liste;
    }
    
    public List<Intervention> recup5DerniereInterv (Client c){
        List<Intervention> liste;
        JpaUtil.creerEntityManager();
        liste = intervDAO.get5LastIntervClient(c);
        JpaUtil.fermerEntityManager(); 
        return liste;
    }
    
    public Intervention recupIntervEnCours (Employe emp){
        JpaUtil.creerEntityManager();
        Intervention in = intervDAO.getIntervInProgress(emp);
        JpaUtil.fermerEntityManager();
        return in;
    }
    
    public List<Intervention> recupToutesIntervEmploye (Employe emp){
        List<Intervention> liste;
        JpaUtil.creerEntityManager();
        liste = intervDAO.getAllIntervEmploye(emp);
        JpaUtil.fermerEntityManager(); 
        return liste;
    } 
    
    public List<Intervention> recupToutesIntervToday(){
        List<Intervention> liste;
        JpaUtil.creerEntityManager();
        liste = intervDAO.getAllIntervToday();
        JpaUtil.fermerEntityManager(); 
        return liste;
    } 
    
    public Intervention fermerInterv (Employe emp, String comm){
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        Intervention in = intervDAO.closeInterv(emp, comm);
        try{
            JpaUtil.validerTransaction();
        }catch(Exception e){
            in = null;
            JpaUtil.annulerTransaction();
        }
        JpaUtil.fermerEntityManager();
        return in;
    }
}
