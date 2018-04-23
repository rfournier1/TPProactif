package modele;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modele.Client;
import modele.Employe;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-23T16:35:59")
@StaticMetamodel(Intervention.class)
public abstract class Intervention_ { 

    public static volatile SingularAttribute<Intervention, Date> debut;
    public static volatile SingularAttribute<Intervention, Boolean> estFini;
    public static volatile SingularAttribute<Intervention, Employe> realisePar;
    public static volatile SingularAttribute<Intervention, Client> demandePar;
    public static volatile SingularAttribute<Intervention, String> description;
    public static volatile SingularAttribute<Intervention, Date> fin;
    public static volatile SingularAttribute<Intervention, Integer> id;
    public static volatile SingularAttribute<Intervention, String> commentaire;

}