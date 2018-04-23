package modele;

import com.google.maps.model.LatLng;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-23T16:35:59")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> Adresse;
    public static volatile SingularAttribute<Client, String> mail;
    public static volatile SingularAttribute<Client, Date> DateNaissance;
    public static volatile SingularAttribute<Client, Integer> id;
    public static volatile SingularAttribute<Client, LatLng> GPS;
    public static volatile SingularAttribute<Client, String> nom;
    public static volatile SingularAttribute<Client, String> prenom;
    public static volatile SingularAttribute<Client, String> numTel;
    public static volatile SingularAttribute<Client, Character> civilite;

}