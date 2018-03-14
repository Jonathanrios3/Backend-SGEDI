/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.EmailApp;
import co.edu.sena.adsi.jpa.entities.Rol;
import co.edu.sena.adsi.jpa.entities.Users;
import co.edu.sena.adsi.jpa.sessions.EmailAppFacade;
import co.edu.sena.adsi.jpa.sessions.UsersFacade;
import co.edu.sena.adsi.rest.auth.DigestUtil;
import co.edu.sena.adsi.rest.utils.SendEmail;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsersREST {
    @EJB
    private UsersFacade usersEJB;
    @EJB
    private EmailAppFacade emailEJB;

    /**
     * Obtiene todos los usuarioes
     *
     * @param idUsers
     * @param sex
     * @param active
     * @param numDocument
     * @param email
     * @param cities
     * @param idCities
     * @param idDepartament
     * @param idDocumentsType
     * @return lista de usuarios
     */

    @GET
    //@RolesAllowed({"ADMIN"})

    public List<Users> findAll(@QueryParam("idUsers") Integer idUsers,
            @QueryParam("sex") String sex,
            @QueryParam("active") Boolean active,
            @QueryParam("numDocument") String numDocument,
            @QueryParam("email") String email,
            @QueryParam("idCities") String cities,
            @QueryParam("idDepartament") Integer idDepartament,
            @QueryParam("idDocumentsType") Integer idDocumentsType) {
        return usersEJB.findUsers(idUsers, sex, active, numDocument,
                email, cities, idDepartament, idDocumentsType);
    }

    /**
     * Obtiene todos los usuarios con rol empleado
     *
     * @return lista de empleados
     */
    @GET
    @Path("empleados")
    public List<Users> findAllUsersByRol() {
        return usersEJB.findAllUsersByRol("EMPL");
    }
    
    /***
     * 
     * Obtiene todos los usuarios con rol administrador
     * @return Lista de administradores
      */
    
    @GET
    @Path("administradores")
    public List<Users> finAllUsersByrol(){
        return usersEJB.findAllUsersByRol("ADMIN");
    }
    @GET
    @Path("{id}")
    public Users findBye(
            @PathParam("id") Integer name) {
        return usersEJB.find(name);
    }
    
    /**
     * CREA users
     * @param users
     * @return 
      */

    @POST
    public Response create(Users users) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        String pass = users.getPassword();

        try {
            if (usersEJB.findUsersByEmail(users.getEmail()) == null) {
                if (usersEJB.findUsersByNumDocument(users.getNumDocument()) == null) {

                    users.setPassword(DigestUtil.cifrarPassword(users.getPassword()));
                    System.out.println("CIUDAD"+ users.getIdCities());
                    if(users.getSex().equals("M"))
                        users.setUlrImg("male-default.jpg");
                    else
                        users.setUlrImg("female-default.jpg");
                    usersEJB.create(users);
                    try {

                        //Uso configuración de email para Registro
                        EmailApp emailApp = emailEJB.findConfigEmail("REGISTRO");
                        if (emailApp == null) {
                            emailApp = emailEJB.findConfigEmail("GENERAL");
                        }
                        //Envio de email
                        SendEmail enviarEmailUser = new SendEmail();
                        enviarEmailUser.sendEmailRegistroUsuario(emailApp, users, pass);

                        return Response.status(Response.Status.CREATED).entity(gson.toJson("El usuario se creó correctamente!")).build();
                    } catch (Exception e) {
                        System.out.println("ERROR ENVIO DE EMAIL: " + e);
                        return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("No fue posible el envio del email")).build();
                    }
                } else {
                    return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("El número de documento ya se encuentra registrado!.")).build();
                }
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("El email ya se encuentra registrado!.")).build();
            }
        } catch (Exception e) {
            Logger.getLogger(UsersREST.class.getName()).log(Level.SEVERE, null, e);
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("Error al guardar el usuario!.")).build();
        }

    }
    /**
     * Crea ADMIN
     * @param users
     * @return 
      */
    @POST
    @Path("administradores")
    public Response createAdmin(Users users) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            if (usersEJB.findUsersByEmail(users.getEmail()) == null) {
                if (usersEJB.findUsersByNumDocument(users.getNumDocument()) == null) {
                    
                    users.setPassword(DigestUtil.cifrarPassword(users.getPassword()));
                    users.setRolList(new ArrayList<Rol>());
                    users.getRolList().add(new Rol("ADMIN"));
                    usersEJB.create(users);
                    return Response.status(Response.Status.CREATED).entity(gson.toJson("El administrador se registro correctamente!")).build();

                
                } else {
                    return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("El número de documento ya se encuentra registrado!.")).build();
                }
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("El email ya se encuentra registrado!.")).build();
            }
        } catch (Exception e) {
            Logger.getLogger(UsersREST.class.getName()).log(Level.SEVERE, null, e);
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("Error al crear el administrador!.")).build();
        }
    }
    /**
     * Crea Empleados
     * @param users
     * @return 
      */
    @POST
    @Path("empleados")
    public Response createEmpleado(Users users) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            if (usersEJB.findUsersByEmail(users.getEmail()) == null) {
                if (usersEJB.findUsersByNumDocument(users.getNumDocument()) == null) {
                    
                    users.setPassword(DigestUtil.cifrarPassword(users.getPassword()));
                    users.setRolList(new ArrayList<Rol>());
                    users.getRolList().add(new Rol("EMPL"));
                    usersEJB.create(users);
                    return Response.status(Response.Status.CREATED).entity(gson.toJson("El empleado se registro correctamente!")).build();

                
                } else {
                    return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("El número de documento ya se encuentra registrado!.")).build();
                }
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("El email ya se encuentra registrado!.")).build();
            }
        } catch (Exception e) {
            Logger.getLogger(UsersREST.class.getName()).log(Level.SEVERE, null, e);
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("Error al registrar el empleado!.")).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response edit(@PathParam("id") Integer id, Users users) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            usersEJB.edit(users);
            return Response.status(Response.Status.CREATED)
                    .entity(gson.toJson("El usuario se Actualizo correctamente"))
                    .build();
        } catch (Exception e) {
            System.out.println("Err" + e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error al Actualizar el usuario"))
                    .build();
        }
        
    }
    
    @PUT
    @Path("changePassword")
    public Response changePassword(@QueryParam("old") String old,
                                   @QueryParam("new") String newPass,
                                   @QueryParam("id") Integer id){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Users users = usersEJB.find(id);
        try{
            if(users.getPassword().equals(DigestUtil.cifrarPassword(old))){
                users.setPassword(DigestUtil.cifrarPassword(newPass));
                usersEJB.edit(users);
                return Response.status(Response.Status.OK).entity(gson.toJson("La contraseña fue cambiada correctamente!")).build();
            }else{
                return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("La password no es correcta!")).build();
            }
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("Error al intentar cambiar la contraseña!")).build();
        }
    }
    @POST
    @Path("recuperarContrasena")
    public Response recuperarContrasena(@QueryParam("email") String email){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Users usuario = usersEJB.findUsersByEmail(email);
        if(usuario == null){
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("El usuario no esta registrado")).build();
        }else{
            int randUno = (int) (Math.random() * 1000000);
            int randDos = (int) (Math.random() * 1000000);
            usuario.setPassword(DigestUtil.cifrarPassword(String.valueOf(randUno) + String.valueOf(randDos)));
            usersEJB.edit(usuario);
            
               EmailApp emailApp = emailEJB.findConfigEmail("REGISTRO");
                        if (emailApp == null) {
                            emailApp = emailEJB.findConfigEmail("GENERAL");
                        }
            SendEmail enviarEmail = new SendEmail();   
            enviarEmail.sendRecoverPassword(usuario, String.valueOf(randUno) + String.valueOf(randDos),emailApp);
            return Response.status(Response.Status.OK).entity(gson.toJson("La nueva contraseña ha sido enviada al correo!")).build();
        }
    }

}
