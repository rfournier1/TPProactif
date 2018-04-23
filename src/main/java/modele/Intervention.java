package modele;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import java.io.Serializable;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public abstract class Intervention implements Serializable {
    
    @Id
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    protected  String description;
    
    protected boolean estFini;
    
    protected String commentaire;
    
    @Temporal(TemporalType.TIMESTAMP)
    protected Date debut;
    
    @Temporal(TemporalType.TIMESTAMP)
    protected Date fin;
    
    @ManyToOne
    @JoinColumn(nullable=false)
    protected Client demandePar;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    protected Employe realisePar;
    
    public Intervention() {
        
    }
    
    public Intervention(String desc, Client c) {
        this.description = desc;
        this.demandePar = c;
    }
    
    public Date getTimeInterv(){
        return this.debut;
    }
    public Date getTimeFin(){
        return this.fin;
    }
    public Client getClient(){
        return this.demandePar;
    }
    
    public void setEmploye (Employe e){
        this.realisePar = e; 
    }
    
    public void setFini (boolean b){
        this.estFini = b;
    }
    
    public void setDateDebut(){
        this.debut = new Date();
    }
    
    public void setDateFin (){
        this.fin = new Date();
    }
    
    public void setComm(String comm){
        this.commentaire = comm;
    }
    
    public String toString(){
        return "demandée le " + this.debut + " pour " + this.demandePar.toString() +"dont la description est :" + this.description;
    }
}
