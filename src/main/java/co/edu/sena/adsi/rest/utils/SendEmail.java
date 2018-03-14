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
           /*sb.append("<table border=0 cellpadding=0 cellspacing=0 width=100; style=''>");
           sb.append("<tr><td style='padding: 10px 0 30px 0';>");  
           sb.append("<table align=center border=0 cellpadding=0 cellspacing=0 width=600 style='border: 1px solid #cccc; border-collapse: collapse;'>"); 
           sb.append("<tr><td align=center bgcolor=#70bbd9 style='padding: 40px 0 30px 0; color: #153643; font-size: 28px; font-weight: bold; font-family: Arial, sans-serif;'>");  
           sb.append("<img src='http://img.fenixzone.net/i/nAMhD4W.png' alt=Desarrollo SGEDI width=300 height=230 style='display: block;'/>"); 
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
           sb.append("<div style='text-align: center;>");
           sb.append("<img src='http://img.fenixzone.net/i/nAMhD4W.png' alt=Desarrollo SGEDI>");
           sb.append("<div style='margin-bottom: 43px;'>");
           sb.append("<h1 style='color: #2a6496; font-weight: bold; font: oblique bold 120% cursive; font-size: 70px'>Desarrollo SGEDI</h1>");
           sb.append("<strong style='color: black; font-size: 25px'>Tus Documentos En Las Mejores Manos </strong>");
           sb.append("</div>");
           sb.append("<div style='background-image: url(http://img.fenixzone.net/i/yvEbA4D.jpeg);'>");
           sb.append("<h3 style='color: white; font: oblique bold 120% cursive; font-size: 25px;'>Informacíón de tu cuenta: </h3>");
           sb.append("<p style='color: white; font-weight: bold;'>Nombres: </p>");
           sb.append(users.getName());
           sb.append("<p style='color: white; font-weight: bold;'>Apellidos: </p>");
           sb.append(users.getLastName());
           sb.append("<p style='color: white; font-weight: bold;'>Email: xxxxxxxx</p>");
           sb.append(users.getEmail());
           sb.append("</div>");
           sb.append("<div style='text-align: center;'>");
           sb.append("<h4 style='color: black; text-align: center;'>¡Hola. Te damos una grata bienvenida Desarrollo SGEDI, con nostros tus documentos se encotraran seguros gracias a que nuestra prioridad es darle la total confianza con tus documentos. </h4> \n" +
"  ¡Recuerda, si tus documentos quieres cuidar, la gestión Documental con SGEDI debes usar!</h4>");
           sb.append("</div>");
           sb.append("</div>");
           email.setHtmlMsg(sb.toString());

            email.addTo(users.getEmail());
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
