package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Folders;
import co.edu.sena.adsi.jpa.entities.Users;
import co.edu.sena.adsi.jpa.entities.UsersHasFoldersPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-15T09:44:54")
@StaticMetamodel(UsersHasFolders.class)
public class UsersHasFolders_ { 

    public static volatile SingularAttribute<UsersHasFolders, Date> fecha;
    public static volatile SingularAttribute<UsersHasFolders, Folders> folders;
    public static volatile SingularAttribute<UsersHasFolders, UsersHasFoldersPK> usersHasFoldersPK;
    public static volatile SingularAttribute<UsersHasFolders, Users> users;

}