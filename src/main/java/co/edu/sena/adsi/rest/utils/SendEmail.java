/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.utils;


import co.edu.sena.adsi.jpa.entities.EmailApp;
import co.edu.sena.adsi.jpa.entities.Users;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;




/**
 *
 * @author Cliente Pc
 */
public class SendEmail {
      /**
     * Envia email al usuario en el momento del registro
     * @param configEmail
     * @param users
     * @param passwordAsignada 
     */
    public void sendEmailRegistroUsuario(EmailApp configEmail, Users users, String passwordAsignada) {
 try {

            HtmlEmail email = new HtmlEmail();
            email.setHostName(configEmail.getHostnameEmailApp());
            email.setSmtpPort(configEmail.getSmtpPort());
            email.setAuthenticator(new DefaultAuthenticator(configEmail.getEmailApp(), configEmail.getPasswordEmailApp()));
            if (configEmail.getIsAutentication()) {
                email.setAuthentication(configEmail.getEmailApp(), configEmail.getPasswordEmailApp());
            }
            //email.setSSLOnConnect(configEmail.getIsSsl());
            email.setSSL(configEmail.getIsSsl());
           
            email.setFrom(configEmail.getEmailApp());
            email.setCharset("UTF-8");
            email.setSubject("ACTIVACION DE CUENTA DESARROLLO SGEDI.");

            StringBuilder sb = new StringBuilder();
           /* sb.append("<div style='background:#0079bf;'><h1 style='text-align:center;background:cyan;'>Bienvenido(a) a DESARROLLO SGEDI</h1>");
            sb.append("<h3 style='display:inline-block'>Email: </h3>");
            sb.append(users.getEmail());
            sb.append("    <h3 style='display:inline-block'>Password: </h3>");
            sb.append(passwordAsignada);
            sb.append(" <h3 style='display:inline-block'>Número de Identificación: </h3>");
            sb.append(users.getNumdocument());
            sb.append("    <h3 style='display:inline-block'>Nombres: </h3>");
            sb.append(users.getName());
            sb.append("    <h3 style='display:inline-block'>Apellidos: </h3>");
            sb.append(users.getLastName());
            sb.append("<p>Agradecemos su registro.</p>");*/
          /* sb.append("<table border=0 cellpadding=0 cellspacing=0 width=100; style=''>");
           sb.append("<tr><td style='padding: 10px 0 30px 0';>");  
           sb.append("<table align=center border=0 cellpadding=0 cellspacing=0 width=600 style='border: 1px solid #cccc; border-collapse: collapse;'>"); 
           sb.append("<tr><td align=center bgcolor=#70bbd9 style='padding: 40px 0 30px 0; color: #153643; font-size: 28px; font-weight: bold; font-family: Arial, sans-serif;'>");  
           sb.append("<img src='images/logotipo.png' alt=Desarrollo SGEDI width=300 height=230 style='display: block;'/>"); 
           sb.append("</td>");
           sb.append("</tr>");
           sb.append("<tr>");
           sb.append("<td bgcolor=#ffffff style='padding: 40px 30px 40px 30px;'>");
           sb.append("<table border= 0 cellpadding= 0 cellspacing= 0 width=100%>");
           sb.append("<tr>");
           sb.append("<td style='color: #153643; font-family: Arial, sans-serif; font-size: 24px; text-align: center;'>");
           sb.append("<b>BIENVENIDO A DESARROLLO SGEDI</b>");
           sb.append("</tr>");
           sb.append("<tr>");
           sb.append("<td style='padding: 20px 0 30px 0; color: #153643; font-family: Arial, sans-serif; font-size: 16px; line-height: 20px;'>SUS DOCUMENTOS EN LAS MEJORES MANOS </td>");
           sb.append("</tr>");*/
          sb.append("<div class='container'>");
          sb.append("<div class='row'>");
          sb.append("<div col-md-10>");
          sb.append("<div style='text-align: center; background-color: rgba(3, 169, 244, 0.15);'>");
          sb.append("<img src='http://img.fenixzone.net/i/CwNuBcK.png' alt=DESARROLLO SGEDI>");
          sb.append("<h1 style='font:oblique bold 120%; font-size: 40px;'>Desarrollo SGEDI</h1>");
          sb.append("<div style='background-color: rgba(3, 169, 244, 0.15); text-align: center;'>");
          sb.append("<span style='color: initial; font-size: 15px;'><p style='font-weight: bold;'> Hola,</p>" + users.getName() + " " + users.getLastName() + " </span>");
          sb.append("<p style='color: black; font-size: 15px; font-weight: bold;'>LA INFORMACIÓN DE TU CUENTA ES:</p>");
          sb.append("<div style='margin-bottom: 13px;'> <p style='font-weight: bold; color: darkblue; margin: 0;'>Numero de documento:</p>" + users.getNumDocument()+ " </div>");
          sb.append("<div style='margin-bottom: 13px;'> <p style='font-weight: bold; color: darkblue; margin: 0;'>Correo electronico:</p>" + users.getEmail() + " </div>");       
          sb.append("<div> <p style='font-weight: bold; color: darkblue; margin: 0;'>Numero telefonico:</p>" + users.getTelephone() + " </div>");    
          sb.append("</div>");
          sb.append("<h3 style='color:black;'>ESPERAMOS DISFRUTES DE TODOS LOS BENEFICIOS QUE SGEDI TIENE PARA TI!!.</h3>");
          sb.append("<div style='display: flex; font-size: 15px;'>");
          sb.append("<p style='color: black; margin-right: 12px;'>!Tus documentos en las mejores manos¡</p>");
          sb.append("<p style='color: black;  margin-right: 12px;'>!Encuentra una herramienta facil¡</p>");
          sb.append("<p style='color: black'>!Tus documentos un en solo click¡</p>");
          sb.append("<img style='width: 154px; height: 96px;' src='http://img.fenixzone.net/i/konqeIZ.gif'>");
          sb.append("<p style='color: black; margin-left: 12px;'>!Una mano amiga, confible y segura¡</p>");
          sb.append("<p style='color: black; margin-left: 12px;'>!Disfruta del ahorro de tiempo y espacio¡</p>");
          sb.append("<p style='color: black; margin-left: 12px;'>!Garantiza una experecia laboral tranquila¡</p> ");
          sb.append("</div>");
          sb.append("</div>");
          sb.append("</div>");
          sb.append("</div>");
          sb.append("</div>");
           email.setHtmlMsg(sb.toString());

            email.addTo(users.getEmail());
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void sendRecoverPassword(Users users, String passwordAsignada,EmailApp configEmail){
      

       try{
         HtmlEmail email = new HtmlEmail();
            email.setHostName(configEmail.getHostnameEmailApp());
            email.setSmtpPort(configEmail.getSmtpPort());
            email.setAuthenticator(new DefaultAuthenticator(configEmail.getEmailApp(), configEmail.getPasswordEmailApp()));
            if (configEmail.getIsAutentication()) {
                email.setAuthentication(configEmail.getEmailApp(), configEmail.getPasswordEmailApp());
            }
        
            email.setSSL(configEmail.getIsSsl());
            email.setFrom(configEmail.getEmailApp());
            email.setCharset("UTF-8");

        email.setSubject("Recuperacion de password");

       
        
        //Start contenido Email
        
        StringBuilder sb = new StringBuilder();  

        sb.append("<h1>Recuperacion de contraseña</h1>");
        sb.append("Usted solicito una recuperacion de contraseña: ");
        sb.append(users.getName());
        sb.append(" su password provisional asignado es : ");
        sb.append(passwordAsignada);

        //sb.append("Su password es: ");
        //sb.append(pass);


        
        email.setHtmlMsg(sb.toString());
        //End contenido Email
        email.addTo(users.getEmail());
        email.send();
        
       }catch(EmailException e) {

           System.out.println("ERROR "+ e);

           System.out.println("Ha ocurrido un error en el proceso"+ e);

         
       }
        
        

    }
}
