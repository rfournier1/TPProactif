/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
/**
 *
 * @author DellUser
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class InterventionLivraison extends Intervention {
    private String entreprise;
    private String objet;
    
    public InterventionLivraison(){
        
    }
    
    public InterventionLivraison(String desc, Client c, String obj, String entr){
            super(desc, c);
            this.objet = obj;
            this.entreprise =  entr;
    }
    
    @Override
    public String toString(){
        String str = "L'intervention livraison est un objet " + this.objet +" livré par : "+ this.entreprise + " " +super.toString();
        return str;
    }
}