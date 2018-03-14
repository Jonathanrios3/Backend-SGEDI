/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Category;
import co.edu.sena.adsi.jpa.entities.Documents;
import co.edu.sena.adsi.jpa.entities.Folders;
import co.edu.sena.adsi.jpa.entities.Users;
import co.edu.sena.adsi.jpa.sessions.DocumentsFacade;
import co.edu.sena.adsi.jpa.sessions.UsersFacade;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;


/**
 *
 * @author adsi1261718
 */
@Path("upload")
@Produces(MediaType.APPLICATION_JSON)
public class UploadRESTFile {
        //Se debe cambiar por la URL donde se quiera guardar la imagen
    private static final String UPLOAD_FOLDER = "/home/adsi1261718/Vídeos/NUEVO/z$$$z/FRONTEND SGEDI/client/assets/fotos-usuarios/";
    private static final String UPLOAD_FOLDER_DOCUMENTS = "/home/adsi1261718/Vídeos/NUEVO/z$$$z/FRONTEND SGEDI/client/assets/documentos/";

    @EJB
    private UsersFacade usersEJB;
    
    @EJB
    private DocumentsFacade documentsEJB;

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream in,
            @FormDataParam("file") FormDataContentDisposition info,
            @FormDataParam("idUser") Integer idUser) throws IOException {
        
        System.out.println("ID "+idUser);
        File upload = new File(UPLOAD_FOLDER.concat(info.getFileName()));
        
        try {
            if (upload.exists()) {
                String message = "file: " + upload.getName() + " already exists";
                return Response.status(Response.Status.CONFLICT).entity(message).build();
            } else {
                
                Files.copy(in, upload.toPath());
                Users user = usersEJB.find(idUser);
                user.setUlrImg(upload.getName());
                usersEJB.edit(user); 
                return Response.status(Response.Status.OK).build();
            }
        } catch (IOException e) {
            System.out.println("ERROR "+ e);
            return Response.status(Response.Status.CONFLICT).entity(e).build();
        }

    }

    @POST
    @Path("documents")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFileUsuario(
            @FormDataParam("file") InputStream in,
            @FormDataParam("file") FormDataContentDisposition info,
            @FormDataParam("idCategory") Integer idCategory,
            @FormDataParam("idUser") Integer idUser,
            @FormDataParam("description") String description,
            @FormDataParam("fileString") String fileString,
            @FormDataParam("folio") Integer folio,
            @FormDataParam("format") String format,
            @FormDataParam("name") String name,
            @FormDataParam("weight") double weight,
            @FormDataParam("idFolder") Integer idFolder) throws IOException {

        File upload = new File(UPLOAD_FOLDER_DOCUMENTS.concat(info.getFileName()));
        try {
            if (upload.exists()) {
                String message = "file: " + upload.getName() + " already exists";
                return Response.status(Response.Status.CONFLICT).entity(message).build();
            } else {
                Files.copy(in, upload.toPath());
                Documents documento = new Documents();
                documento.setIdCategory(new Category(idCategory));
                documento.setIdUsers(new Users(idUser));
                if(idFolder != null){
                    documento.setFoldersId(new Folders(idFolder));
                }
                documento.setDescription(description);
                documento.setFile(fileString);
                documento.setFolio(folio);
                documento.setFormat(format);
                documento.setName(name);
                documento.setWeight(weight);
                documento.setDate(new Date());
                documentsEJB.create(documento);
                //System.out.println("1. date "+ documento.getName());
                return Response.status(Response.Status.OK).entity(documento).build();
            }
        } catch (IOException e) {
            return Response.status(Response.Status.CONFLICT).entity(e).build();
        }

    }
}
