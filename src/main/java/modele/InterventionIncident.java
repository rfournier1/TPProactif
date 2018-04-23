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
 * @author clementguittat
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class InterventionIncident extends Intervention {
    private String typeIncident;
    
    public InterventionIncident(){
        
    }
    
    public InterventionIncident(String desc, Client c, String type){
        super(desc, c);
        this.typeIncident = type;
    }
    
    @Override
    public String toString(){
        String str = "L'intervention incident est de type " + this.typeIncident +" "+super.toString();
        return str;
    }
}
