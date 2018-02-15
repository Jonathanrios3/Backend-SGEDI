/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Documents;
import co.edu.sena.adsi.jpa.sessions.DocumentsFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author adsi1261718
 */
@Path("documents")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DocumentsREST {
     @EJB
    private DocumentsFacade documentsEJB;
    
    @GET
    public List<Documents> findAll(){
        return documentsEJB.findAll();
    }
    @GET
    @Path("{id}")
    public Documents findBye(
    @PathParam("nombre")String nombre){
        return documentsEJB.find(nombre);
    }
    @POST
    public void create(Documents documents){
        documentsEJB.create(documents);
    }
    
    @GET
    @Path("traerMisDocumentos")
    public List<Documents> traerMisDocumentos(@QueryParam("idUsuario") Integer idUsuario){
        return documentsEJB.traerMisDocumentos(idUsuario);
    }
    
    @GET
    @Path("traerMisDocumentosCompartidos")
    public List<Documents> traerMisDocumentosCompartidos(@QueryParam("idUsuario") Integer idUsuario){
        return documentsEJB.traerMisDocumentosCompartidos(idUsuario);
    }
    
    @POST
    @Path("compartirDocumento")
    public Response compartirDocumento(@QueryParam("propieatario") Integer propieatario,
                                       @QueryParam("usuario") Integer usuario,
                                       @QueryParam("documento") Integer documento){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try{Boolean status = documentsEJB.compartirDocumento(propieatario, usuario, documento);
        if(status){
            return Response.status(Response.Status.OK).entity(gson.toJson("El documento se compartio correctamente!")).build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("No se pudo compartir!")).build();
        }
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("Error al compartir el documento!")).build();
        }
    }
}
