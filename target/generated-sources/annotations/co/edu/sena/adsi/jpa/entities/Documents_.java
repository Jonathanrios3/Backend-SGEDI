package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Category;
import co.edu.sena.adsi.jpa.entities.DocumentsHasState;
import co.edu.sena.adsi.jpa.entities.Folders;
import co.edu.sena.adsi.jpa.entities.Users;
import co.edu.sena.adsi.jpa.entities.UsersHasDocuments;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-14T11:18:32")
@StaticMetamodel(Documents.class)
public class Documents_ { 

    public static volatile SingularAttribute<Documents, Date> date;
    public static volatile SingularAttribute<Documents, String> format;
    public static volatile SingularAttribute<Documents, String> description;
    public static volatile SingularAttribute<Documents, Double> weight;
    public static volatile ListAttribute<Documents, UsersHasDocuments> usersHasDocumentsList;
    public static volatile SingularAttribute<Documents, Category> idCategory;
    public static volatile SingularAttribute<Documents, Folders> foldersId;
    public static volatile SingularAttribute<Documents, String> file;
    public static volatile SingularAttribute<Documents, String> name;
    public static volatile SingularAttribute<Documents, Integer> folio;
    public static volatile ListAttribute<Documents, DocumentsHasState> documentsHasStateList;
    public static volatile SingularAttribute<Documents, Integer> id;
    public static volatile SingularAttribute<Documents, Users> idUsers;

}