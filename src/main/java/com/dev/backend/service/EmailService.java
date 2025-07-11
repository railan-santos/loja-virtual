package com.dev.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    //metodo para enviar email
    public String enviarTextoEmail(String destinatario, String titulo, String mensagem) {

        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            //settar remetente, destinarario....
            mailMessage.setFrom(remetente);
            mailMessage.setTo(destinatario);
            mailMessage.setSubject(titulo);
            mailMessage.setText(mensagem);
            mailSender.send(mailMessage);
            return "E-mail enviado com sucesso!";
        } catch (Exception ex) {
            return "Erro ao enviar!!";
        }
    }
}
