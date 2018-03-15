package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Cities;
import co.edu.sena.adsi.jpa.entities.Company;
import co.edu.sena.adsi.jpa.entities.Documents;
import co.edu.sena.adsi.jpa.entities.DocumentsType;
import co.edu.sena.adsi.jpa.entities.Folders;
import co.edu.sena.adsi.jpa.entities.Formalities;
import co.edu.sena.adsi.jpa.entities.Rol;
import co.edu.sena.adsi.jpa.entities.UsersHasDocuments;
import co.edu.sena.adsi.jpa.entities.UsersHasFolders;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-15T09:44:54")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> lastName;
    public static volatile ListAttribute<Users, Folders> foldersList;
    public static volatile ListAttribute<Users, UsersHasFolders> usersHasFoldersList;
    public static volatile SingularAttribute<Users, String> address;
    public static volatile SingularAttribute<Users, String> occupation;
    public static volatile SingularAttribute<Users, Company> idCompany;
    public static volatile SingularAttribute<Users, String> ulrImg;
    public static volatile SingularAttribute<Users, String> sex;
    public static volatile SingularAttribute<Users, Boolean> active;
    public static volatile ListAttribute<Users, UsersHasDocuments> usersHasDocumentsList;
    public static volatile SingularAttribute<Users, Integer> telephone;
    public static volatile ListAttribute<Users, Rol> rolList;
    public static volatile ListAttribute<Users, Formalities> formalitiesList;
    public static volatile SingularAttribute<Users, String> numDocument;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile SingularAttribute<Users, Cities> idCities;
    public static volatile SingularAttribute<Users, DocumentsType> idDocumentsType;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile ListAttribute<Users, Documents> documentsList;

}