package modele;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cguittat
 */
import com.google.maps.model.LatLng;
import java.util.Date;
import javax.persistence.*;
import util.GeoTest;


@Entity
public class Employe {
    
    @Id
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private char civilite;
        
    private String nom;
    
    private String prenom;
    
    @Column(nullable=false)
    private int[][] horaire;    
            
    private boolean dispo; 
   
    @Column(nullable=false)
    private String domicile;
    
    @Column(unique=true, nullable=false) 
    private String mail;
    
    private LatLng GPS;

    public Employe(char civ, String name, String pre, int[][] hor,String domi, String email)
    {
        this.civilite = civ;
        this.nom = name;
        this.prenom = pre;
        this.horaire = hor;
        this.domicile = domi;
        this.mail = email;
        dispo = true;
    }   

    public Employe() {
    }
    
    public void setDispo(boolean b){
        this.dispo = b;
    }
    
    public boolean disponi(int heure){
        boolean b = false;
        for (int i=0; i<this.horaire.length;i++){
            if (heure >= this.horaire[i][0] && heure <= this.horaire[i][1]){
                b = true;
                break;
            }
        }
        return b;
    }
    
    public void setCoord(){
        this.GPS = GeoTest.getLatLng(this.domicile);
    }
    
    public LatLng getGPS(){
        return this.GPS;
    }
    
    public String toString(){
        return "L'employé s'appelle " + this.prenom + " "
            + this.nom + " id est:"+this.id+" habite au: "+ this.domicile+ " ses horaires sont: " +AfficheHoraire(this.horaire)+" il est "+this.dispo+" disponible et ses coordonnées GPS sont :"+this.GPS;
    }
    public String AfficheHoraire(int[][] tab){
        String chaine = "";
        for(int i = 0;i<tab.length;i++)
        {
            chaine = chaine+ "de ";
            for (int j=0; j<tab[i].length; j++){
                chaine = chaine + tab[i][j] +" à ";
            }
            chaine = chaine+ " et ";
        }
        return chaine;
    }
}
