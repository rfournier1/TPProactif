package modele;

import com.google.maps.model.LatLng;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-23T16:35:59")
@StaticMetamodel(Employe.class)
public class Employe_ { 

    public static volatile SingularAttribute<Employe, int[][]> horaire;
    public static volatile SingularAttribute<Employe, String> mail;
    public static volatile SingularAttribute<Employe, String> domicile;
    public static volatile SingularAttribute<Employe, Integer> id;
    public static volatile SingularAttribute<Employe, LatLng> GPS;
    public static volatile SingularAttribute<Employe, String> nom;
    public static volatile SingularAttribute<Employe, String> prenom;
    public static volatile SingularAttribute<Employe, Character> civilite;
    public static volatile SingularAttribute<Employe, Boolean> dispo;

}