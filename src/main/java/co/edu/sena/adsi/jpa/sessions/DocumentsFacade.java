/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.sessions;

import co.edu.sena.adsi.jpa.entities.Documents;
import co.edu.sena.adsi.jpa.entities.Documents_;
import co.edu.sena.adsi.jpa.entities.Folders;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
    
    public Boolean compartirDocumento(Integer idUsuarioPropietario, Integer idUsuario, Integer idDocumento){
        Query function = em.createNativeQuery("select compartirDocumento(?,?,?)");
        function.setParameter(1,idUsuarioPropietario);
        function.setParameter(2,idUsuario);
        function.setParameter(3,idDocumento);
        Boolean status = (Boolean) function.getSingleResult();
        return status;
    }
    
    public List<Documents> findDocumentsByFolder(Integer idFolder) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Documents> cq = cb.createQuery(Documents.class);
        Root<Documents> documents = cq.from(Documents.class);

        Predicate data = cb.conjunction();

        if (idFolder != null) {
            data = cb.and(data, cb.equal(documents.get(Documents_.foldersId), new Folders(idFolder)));
        }

        cq.where(data);
        cq.orderBy(cb.asc(documents.get(Documents_.id)));
        TypedQuery<Documents> tq = em.createQuery(cq);

        try {
            return tq.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
