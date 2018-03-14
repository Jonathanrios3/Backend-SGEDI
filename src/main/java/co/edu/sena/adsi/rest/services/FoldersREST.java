/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Documents;
import co.edu.sena.adsi.jpa.entities.Folders;
import co.edu.sena.adsi.jpa.sessions.DocumentsFacade;
import co.edu.sena.adsi.jpa.sessions.FoldersFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
 * @author Johan
 */
@Path("folders")
@Consumes (MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FoldersREST {
    @EJB
    private FoldersFacade foldersEJB;
    
    @EJB
    private DocumentsFacade documentsEJB;
    
    @GET
    @Path("getMyFolders")
    public List<Folders> getMyFolders(@QueryParam("idUsuario") Integer idUsuario){
        return foldersEJB.getMyFolders(idUsuario);
    }
    
    @GET
    @Path("getMySharedFolders")
    public List<Folders> getMySharedFolders(@QueryParam("idUser") Integer idUser){
        return foldersEJB.getMySharedFolders(idUser);
    }
    
    @POST
    public void create(Folders folder){
        foldersEJB.create(folder);
    }
    
    @POST
    @Path("compartirCarpeta")
    public Response compartirCarpeta(@QueryParam("idUsuarioPropietario") Integer idUsuarioPropietario,
                                       @QueryParam("idUsuario") Integer idUsuario,
                                       @QueryParam("idCarpeta") Integer idCarpeta){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try{Boolean status = foldersEJB.compartirCarpeta(idUsuarioPropietario, idUsuario, idCarpeta);
        if(status){
            return Response.status(Response.Status.OK).entity(gson.toJson("La carpeta se compartio correctamente!")).build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("No se pudo compartir!")).build();
        }
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("Error al compartir la carpeta!")).build();
        }
    }
    
    @GET
    public List<Folders> findAll(){
        return foldersEJB.findAll();
    }
    
    @GET
    @Path("{id}")
    public Folders find(@PathParam("id") Integer id){
        return foldersEJB.find(id);
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")Integer id){
        Folders folder = foldersEJB.find(id);
        File fichero = new File("");
        
        Documents document = new Documents();
        List<Documents> documentos = documentsEJB.findDocumentsByFolder(id);
        for (int i = 0; i < documentos.size(); i++) {
            document = documentsEJB.find(documentos.get(i).getId());
            fichero = new File("/home/adsi1261718/Vídeos/NUEVO/z$$$z/FRONTEND SGEDI/client/assets/documentos/"+document.getFile());
            fichero.delete();
            documentsEJB.remove(document);
        }
        foldersEJB.remove(folder);
    }
}



