/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabdeal.Utils;

import javax.mail.Authenticator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 *
 * @author SBS
 */
public class JavaMail {
    
    public static void sendMail (String recepient) throws  Exception{
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true"); //enable authentication
        properties.put("mail.smtp.starttls.enable", "true");//enable STARTTLS
        properties.put("mail.smtp.host", "smtp.gmail.com");//SMTP Host
        properties.put("mail.smtp.port", "587");//TLS Port
        
        String myAccountEmail="tabdealcontact@gmail.com";
        String password="Esprit123456789";
     Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail,password); 
            }
         
    });
     Message message = prepareMessage(session,myAccountEmail,recepient);
        Transport.send(message);
        System.out.println("Message send ");
    }

    private static Message prepareMessage(Session session, String myAccountEmail,String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Une nouvelle publication ajoutée ");
            message.setText(" Test Email ");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(JavaMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
        
        
        
         
        

        
         
    }
    
    

