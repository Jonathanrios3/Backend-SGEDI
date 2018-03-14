/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.sessions;

import co.edu.sena.adsi.jpa.entities.Documents;
import co.edu.sena.adsi.jpa.entities.Folders;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Johan
 */
@Stateless
public class FoldersFacade extends AbstractFacade<Folders> {

    @PersistenceContext(unitName = "co.edu.sena_BAKEND_SGEDI_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FoldersFacade() {
        super(Folders.class);
    }
    
    public List<Folders> getMyFolders(Integer idUsuario){
        StoredProcedureQuery procedure = em.createStoredProcedureQuery("traerMisCarpetas", Folders.class);
        procedure.registerStoredProcedureParameter("idUsuario", Integer.class, ParameterMode.IN);
        procedure.setParameter("idUsuario", idUsuario);
        procedure.execute();
        List<Folders> myFolders = (List<Folders>) procedure.getResultList();
        return myFolders;
        
    }
    
    public List<Folders> getMySharedFolders(Integer idUsuario){
        StoredProcedureQuery procedure = em.createStoredProcedureQuery("traerMisCarpetasCompartidos", Folders.class);
        procedure.registerStoredProcedureParameter("idUsuario", Integer.class, ParameterMode.IN);
        procedure.setParameter("idUsuario", idUsuario);
        procedure.execute();
        List<Folders> misCarpetasCompartidos = (List<Folders>) procedure.getResultList();
        return misCarpetasCompartidos;
    }
    
    public Boolean compartirCarpeta(Integer idUsuarioPropietario, Integer idUsuario, Integer idCarpeta){
        Query function = em.createNativeQuery("select compartirCarpeta(?,?,?)");
        function.setParameter(1,idUsuarioPropietario);
        function.setParameter(2,idUsuario);
        function.setParameter(3,idCarpeta);
        Boolean status = (Boolean) function.getSingleResult();
        return status;
    }
}
