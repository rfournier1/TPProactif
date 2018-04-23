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
public class Client {
    
    @Id
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private char civilite;
    
    private String nom;
    
    private String prenom;
    
    @Temporal(TemporalType.DATE)
    private Date DateNaissance;
    
    @Column(nullable=false)
    private String Adresse; 
   
    private String numTel;
    
    @Column(unique=true, nullable=false) 
    private String mail;
    
    private LatLng GPS;
    
    public Client(char civ, String name, String pre,Date d,String ad, String num, String email)
    {
        this.civilite = civ;
        this.nom = name;
        this.prenom = pre;
        this.Adresse = ad;
        this.DateNaissance = d;
        this.numTel = num;
        this.mail = email;
    }    

    public Client() {
    }
    
    public String getName(){
        return this.prenom;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setCoord(){
        this.GPS = GeoTest.getLatLng(this.Adresse);
    }
    
    public LatLng getGPS(){
        return this.GPS;
    }
    
    public String toString(){
        return "Le client s'appelle " + this.prenom + " "
                + " " + this.nom + ", son id est "+ this.id +", habite au: "+ this.Adresse+ " son numéro est le " +this.numTel+ 
                " et son mail est : "+ this.mail+ " ses coordonnées GPS :"+ this.GPS;
    }
}