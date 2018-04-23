/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author clementguittat
 */

import javax.persistence.*;
import modele.Employe;

public class EmployeDAO {
    public EmployeDAO(){
        
    }
    
    public void creerEmployes(Employe[]etab){
        for (int i=0; i< etab.length; i++){
            etab[i].setCoord();
            JpaUtil.obtenirEntityManager().persist(etab[i]);
        }
    }
    
    public Employe verifLogin (String user, int mdp){
        Query query = JpaUtil.obtenirEntityManager().createQuery("select e from Employe e where e.mail = :usr and e.id = :m");
        query.setParameter("usr", user);
        query.setParameter("m", mdp);
        Employe em;
        try {
            em = (Employe) query.getSingleResult();
        } catch (Exception e) {
            em = null;
        }
        return em;
    }
}
