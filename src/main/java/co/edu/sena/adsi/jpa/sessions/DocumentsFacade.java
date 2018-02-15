/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.sessions;

import co.edu.sena.adsi.jpa.entities.Documents;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author adsi1261718
 */
@Stateless
public class DocumentsFacade extends AbstractFacade<Documents> {

    @PersistenceContext(unitName = "co.edu.sena_BAKEND_SGEDI_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocumentsFacade() {
        super(Documents.class);
    }
    
    public List<Documents> traerMisDocumentos(Integer idUsuario){
        StoredProcedureQuery procedure = em.createStoredProcedureQuery("traerMisDocumentos", Documents.class);
        procedure.registerStoredProcedureParameter("idUsuario", Integer.class, ParameterMode.IN);
        procedure.setParameter("idUsuario", idUsuario);
        procedure.execute();
        List<Documents> misDocumentos = (List<Documents>) procedure.getResultList();
        return misDocumentos;
    }
    
    public List<Documents> traerMisDocumentosCompartidos(Integer idUsuario){
        StoredProcedureQuery procedure = em.createStoredProcedureQuery("traerMisDocumentosCompartidos", Documents.class);
        procedure.registerStoredProcedureParameter("idUsuario", Integer.class, ParameterMode.IN);
        procedure.setParameter("idUsuario", idUsuario);
        procedure.execute();
        List<Documents> misDocumentosCompartidos = (List<Documents>) procedure.getResultList();
        return misDocumentosCompartidos;
    }
    
    public Boolean compartirDocumento(Integer propieatario, Integer usuario, Integer documento){
        Query function = em.createNativeQuery("select compartirDocumento(?,?,?)");
        function.setParameter(1,propieatario);
        function.setParameter(2,usuario);
        function.setParameter(3,documento);
        Boolean status = (Boolean) function.getSingleResult();
        return status;
    }
    
}
