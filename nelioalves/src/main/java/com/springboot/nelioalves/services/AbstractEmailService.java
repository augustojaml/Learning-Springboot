package com.springboot.nelioalves.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.springboot.nelioalves.entities.ClientEntity;
import com.springboot.nelioalves.entities.PurchaseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

public abstract class AbstractEmailService implements EmailsService {

  @Value("${default.sender}")
  private String sender;

  @Autowired
  private TemplateEngine templateEngine;

  @Autowired
  private JavaMailSender javaMailSender;

  @Override
  public void sendPurchaseConfirmationEmail(PurchaseEntity object) {
    SimpleMailMessage message = prepareSimpleMailMessageFromPurchase(object);
    sendEmail(message);
  }

  protected SimpleMailMessage prepareSimpleMailMessageFromPurchase(PurchaseEntity object) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(object.getClient().getEmail());
    message.setFrom(sender);
    message.setSubject("Purchase confirmed. Code: " + object.getId());
    message.setSentDate(new Date(System.currentTimeMillis()));
    message.setText(object.toString());
    return message;
  }

  protected String htmlFromTemplatePurchase(PurchaseEntity object) {
    Context context = new Context();
    context.setVariable("purchase", object);
    return templateEngine.process("email/purchaseConfirmed.html", context);
  }

  @Override
  public void sendOrderConfirmationHtmlEmail(PurchaseEntity object) {
    try {
      MimeMessage message = prepareMimeMessageFromPurchase(object);
      sendHtmlEmail(message);
    } catch (MessagingException e) {
      // System.out.println(e.getMessage());
      sendPurchaseConfirmationEmail(object);
    }
  }

  protected MimeMessage prepareMimeMessageFromPurchase(PurchaseEntity object) throws MessagingException {
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
    mimeMessageHelper.setTo(object.getClient().getEmail());
    mimeMessageHelper.setFrom(sender);
    mimeMessageHelper.setSubject("Purchase confirmed. Code: " + object.getId());
    mimeMessageHelper.setSentDate(new Date(System.currentTimeMillis()));
    mimeMessageHelper.setText(htmlFromTemplatePurchase(object), true);
    return mimeMessage;
  }

  @Override
  public void SendNewPasswordEmail(ClientEntity client, String newPassword) {
    SimpleMailMessage message = prepareNewPasswordEmail(client, newPassword);
    sendEmail(message);
  }

  protected SimpleMailMessage prepareNewPasswordEmail(ClientEntity client, String newPassword) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(client.getEmail());
    message.setFrom(sender);
    message.setSubject("New password request");
    message.setSentDate(new Date(System.currentTimeMillis()));
    message.setText("New Password: " + newPassword);
    return message;
  }

}
