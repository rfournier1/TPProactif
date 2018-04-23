/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPack;

/**
 *
 * @author cguittat
 */

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import modele.Client;
import modele.Employe;
import modele.Intervention;
import modele.InterventionAnimal;
import modele.InterventionIncident;
import modele.InterventionLivraison;
import DAO.JpaUtil;
import Service.ServiceApp;
import Service.ServiceMail;
import java.util.List;




public class main {
    public static void main(String []args) {
        
        JpaUtil.init();
        ServiceApp serv = new ServiceApp();
        ServiceMail servMail = new ServiceMail();
        
        SimpleDateFormat saf = new SimpleDateFormat("dd/mm/yyyy");
        Date d = null;
        try {
            d = saf.parse("03/05/2018");
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);// ou date du jour
        }
        
        SimpleDateFormat dateInterv = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date debut = null;
        try {
            debut = dateInterv.parse("2018/03/19 18:15:00");
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);// ou date du jour
        }
        
                                        //Création des employés dans la base de données 
        /*
                                        
        serv.creationEmployes(declareEmployes());
        
                                        // Inscription d'un client 
        
        Client c = new Client ('H', "guittat", "Yang", d,"61 Avenue Roger Salengro, Villeurbanne", "06", "Yang@gmail");
        Client cTest = serv.creationClient(c);
        if (cTest != null){
            System.out.println(servMail.sendMailConfirInscrip(cTest));
        }
        else {
            System.out.println(servMail.sendMailRefusIncrip(cTest));
        }
                                        // Connexion d'un client 
        
        Client cl = serv.clientLogin("Yang@gmail", 16);
        System.out.println(cl);
        
                                        // Mot de passé oublié par le client 
                                        
        System.out.println(servMail.sendMailMdpOublie("Yang@gmail"));
        
                                        // Connexion d'un employé 
                                        
        Employe e = serv.employeLogin("Tolisso@proactif.fr", 2910);
        System.out.println(e);
        */
        
                                        // Création d'une intervention par un client 
        
        Client cl = serv.clientLogin("Yang@gmail",16);
        Intervention ia = new InterventionIncident("tout se passe bien", cl, "fuite d'eau");
        Intervention iaCree = serv.creationIntervention(ia);
        if (iaCree != null){
            System.out.println(servMail.notifPourEmploye(iaCree));
        }
        
                                        // Récupérer les 5 dernières interventions d'un client 
        /*
        Client cl = serv.clientLogin("Yang@gmail", 3001);
        List<Intervention>dern = serv.recup5DerniereInterv(cl);
        for (int i=0; i< dern.size();i++){
            System.out.println(dern.get(i));
        }*/
        
                                        // Récupérer toutes les interventions d'un client 
        /*
        Client cl = serv.clientLogin("Yang@gmail", 3001);
        List<Intervention>toutes = serv.recupToutesIntervClient(cl);
        for (int i=0; i< toutes.size();i++){
            System.out.println(toutes.get(i));
        }*/
        
                                        // Récupérer intervention en cours d'un employé
        /*
        Employe e = serv.employeLogin("Matuidi@proactif.fr", 2908);
        System.out.println(serv.recupIntervEnCours(e));
        */
                                        // Récupérer toutes les interventions d'un employé
        /*                                
        Employe e = serv.employeLogin("Matuidi@proactif.fr", 2908);                        
        List<Intervention>toutEmp = serv.recupToutesIntervEmploye(e);
        for (int i=0; i< toutEmp.size();i++){
            System.out.println(toutEmp.get(i));
        }*/
        
                                         // Fermer une intervention
        /*                                 
        Employe e = serv.employeLogin("Matuidi@proactif.fr", 2908);                                           
        Intervention iFerme= serv.fermerInterv(e, "tout s'est bien passé");                       
        System.out.println(iFerme);
        System.out.println(servMail.notifPourClient(iFerme));*/
        
        
        
                                        // Récupérer intervention d'aujourd'hui 
        /*
        List<Intervention>intervToday = serv.recupToutesIntervToday();
        for (int i=0; i< intervToday.size();i++){
            System.out.println(intervToday.get(i));
        }*/
                             
        JpaUtil.destroy();
    }
    
    
    public static Employe[] declareEmployes (){
        Employe [] tabEmp = new Employe[15];
        
        int[][] hor1 = {{10,12},{20,22}};
        int[][] hor2 = {{8,12}};
        int[][] hor3 = {{8,10},{14,16}};
        int[][] hor4 = {{9,10},{11,12},{13,14}};
        int[][] hor5 = {{10,12},{20,22}};
        int[][] hor6 = {{14,20},{21,22}};
        int[][] hor7 = {{10,15},{20,22}};
        int[][] hor8 = {{8,17}};
        int[][] hor9 = {{9,12},{15,17}};
        int[][] hor10 = {{11,12},{15,16},{17,18}};
        int[][] hor11 = {{10,18}};
        int[][] hor12 = {{16,19},{21,22}};
        int[][] hor13 = {{8,12},{16,22}};
        int[][] hor14 = {{10,14},{18,22}};
        int[][] hor15 = {{9,12},{17,19},{20,23}};
        
        Employe e1= new Employe ('M',"Mbappe", "Kylian",hor1, "8 Rue Arago, Villeurbanne", "Mbappe@proactif.fr");
        tabEmp[0]=e1;
        Employe e2= new Employe ('M',"Griezmann", "Antoine",hor2, "5 Rue Léon Fabre, Villeurbanne", "Griezmann@proactif.fr");
        tabEmp[1]=e2;
        Employe e3= new Employe ('M',"Pogba", "Paul",hor3, "12 Rue de la Prevoyance, Villeurbanne", "Pogba@proactif.fr");
        tabEmp[2]=e3;
        Employe e4= new Employe ('M',"Martial", "Anthony",hor4, "4 Rue Phelypeaux, Villeurbanne", "Martial@proactif.fr");
        tabEmp[3]=e4;
        Employe e5= new Employe ('M',"Coman", "Kingsley",hor5, "8 Rue Wilhelmine, Villeurbanne", "Coman@proactif.fr");
        tabEmp[4]=e5;
        Employe e6= new Employe ('M',"Umtiti", "Samuel",hor6, "6 Rue Camille Koechlin, Villeurbanne", "Umtiti@proactif.fr");
        tabEmp[5]=e6;
        Employe e7= new Employe ('M',"Varane", "Raphael",hor7, "9 Impasse Guillet, Villeurbanne", "Varane@proactif.fr");
        tabEmp[6]=e7;
        Employe e8= new Employe ('M',"Matuidi", "Blaise",hor8, "20 Rue Decomberousse, Villeurbanne", "Matuidi@proactif.fr");
        tabEmp[7]=e8;
        Employe e9= new Employe ('M',"Rabiot", "Adrien",hor9, "1 Rue d'Alsace, Villeurbanne", "Rabiot@proactif.fr");
        tabEmp[8]=e9;
        Employe e10= new Employe ('M',"Tolisso", "Corentin",hor10, "4 Rue de la Jeunesse, Villeurbanne", "Tolisso@proactif.fr");
        tabEmp[9]=e10;
        Employe e11= new Employe ('M',"Kante", "Ngolo",hor11, "7 Rue de la Cloche, Villeurbanne", "Kante@proactif.fr");
        tabEmp[10]=e11;
        Employe e12= new Employe ('M',"Koscielny", "Laurent",hor12, "4 Rue Marcel Doret, Villeurbanne", "Koscielny@proactif.fr");
        tabEmp[11]=e12;
        Employe e13= new Employe ('M',"Giroud", "Olivier",hor13, "16 Rue Jules Kumer, Villeurbanne", "Giroud@proactif.fr");
        tabEmp[12]=e13;
        Employe e14= new Employe ('M',"Sidibe", "Djibril",hor14, "4 Rue du Luxembourg, Villeurbanne", "Sidibe@proactif.fr");
        tabEmp[13]=e14;
        Employe e15= new Employe ('M',"Lemar", "Thomas",hor15, "1 Rue Denis Papin, Villeurbanne", "Lemar@proactif.fr");
        tabEmp[14]=e15;
        
        return tabEmp;
    }
} 
