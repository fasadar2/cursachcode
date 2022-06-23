package com.example.service;

import jakarta.inject.Singleton;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

@Singleton
public class SendFileService {
    public int SendEmail(String Email) {
        final String from = "createreport@mail.ru";
        final String password = "K1lnk2tJNhQDAa4TfsqX";//K1lnk2tJNhQDAa4TfsqX
        String host = "smtp.mail.ru";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtps.ssl.checkserveridentity", true);
        props.put("mail.smtps.ssl.trust", "*");
        props.put("mail.smtp.ssl.enable", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator(){
                    protected PasswordAuthentication getPassAuth(){
                        return new PasswordAuthentication(from, password);
                    }
                });

        try {
            // Создание объекта MimeMessage по умолчанию
            MimeMessage message = new MimeMessage(session);

            // Установить От: поле заголовка
            message.setFrom(new InternetAddress(from));

            // Установить Кому: поле заголовка
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(Email));

            // Установить тему: поле заголовка
            message.setSubject("Отчет ");

            // Создание части сообщения
            BodyPart messageBodyPart = new MimeBodyPart();

            // Заполнение сообщения
            messageBodyPart.setText("По вашему запросу был сформирован отчет о оборудовании находящемся в сервисе");

            // Создание составного сообщения
            Multipart multipart = new MimeMultipart();

            // Установить часть текстового сообщения
            multipart.addBodyPart(messageBodyPart);

            // Часть вторая вложения
            messageBodyPart = new MimeBodyPart();
            String filename = ".\\ServiceReport.xls";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Отправить полные части сообщения
            message.setContent(multipart );

            // Отправить сообщение
            try{
            Transport.send(message,from,password);}catch(javax.mail.SendFailedException sendFailedException){return 2;}
            System.out.println("Сообщение успешно отправлено....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return 1;
    }
}
