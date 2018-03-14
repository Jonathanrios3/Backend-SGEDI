package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Documents;
import co.edu.sena.adsi.jpa.entities.Users;
import co.edu.sena.adsi.jpa.entities.UsersHasFolders;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-14T09:13:47")
@StaticMetamodel(Folders.class)
public class Folders_ { 

    public static volatile SingularAttribute<Folders, Date> date;
    public static volatile ListAttribute<Folders, UsersHasFolders> usersHasFoldersList;
    public static volatile SingularAttribute<Folders, String> name;
    public static volatile SingularAttribute<Folders, Users> usersId;
    public static volatile SingularAttribute<Folders, Integer> id;
    public static volatile ListAttribute<Folders, Documents> documentsList;

}