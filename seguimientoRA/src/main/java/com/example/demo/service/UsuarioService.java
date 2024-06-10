package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
@Service
public class UsuarioService {


	    @Autowired
	    private JavaMailSender mailSender;

	    public void sendEmail(String to, String subject, String text) {
	        try {
	            MimeMessage mimeMessage = mailSender.createMimeMessage();
	            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");

	            mimeMessage.setText(text);
	            helper.setTo(to);
	            helper.setSubject(subject);
	            mailSender.send(mimeMessage);
	            System.out.println("Correo enviado exitosamente.");
	        } catch (Exception e) {
	            System.err.println("Error al enviar el correo: " + e.getMessage());
	        }
	    }
	}

