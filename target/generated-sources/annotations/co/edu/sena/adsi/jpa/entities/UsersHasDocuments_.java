package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Documents;
import co.edu.sena.adsi.jpa.entities.Users;
import co.edu.sena.adsi.jpa.entities.UsersHasDocumentsPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-15T09:44:54")
@StaticMetamodel(UsersHasDocuments.class)
public class UsersHasDocuments_ { 

    public static volatile SingularAttribute<UsersHasDocuments, Date> fecha;
    public static volatile SingularAttribute<UsersHasDocuments, UsersHasDocumentsPK> usersHasDocumentsPK;
    public static volatile SingularAttribute<UsersHasDocuments, Documents> documents;
    public static volatile SingularAttribute<UsersHasDocuments, Users> users;

}