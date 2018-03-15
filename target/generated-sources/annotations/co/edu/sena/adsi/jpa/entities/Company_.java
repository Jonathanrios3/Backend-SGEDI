package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Cities;
import co.edu.sena.adsi.jpa.entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-15T09:44:54")
@StaticMetamodel(Company.class)
public class Company_ { 

    public static volatile SingularAttribute<Company, Integer> ext;
    public static volatile SingularAttribute<Company, Integer> contacto;
    public static volatile ListAttribute<Company, Users> usersList;
    public static volatile SingularAttribute<Company, String> direccion;
    public static volatile SingularAttribute<Company, String> representanteLegal;
    public static volatile SingularAttribute<Company, Boolean> active;
    public static volatile SingularAttribute<Company, String> urlImg;
    public static volatile SingularAttribute<Company, String> razonSocial;
    public static volatile SingularAttribute<Company, String> password;
    public static volatile SingularAttribute<Company, Integer> nit;
    public static volatile SingularAttribute<Company, String> nombreComercial;
    public static volatile SingularAttribute<Company, Cities> idCities;
    public static volatile SingularAttribute<Company, Integer> id;
    public static volatile SingularAttribute<Company, String> email;

}