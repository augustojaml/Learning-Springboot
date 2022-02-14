package com.springboot.nelioalves.services;

import javax.mail.internet.MimeMessage;

import com.springboot.nelioalves.entities.ClientEntity;
import com.springboot.nelioalves.entities.PurchaseEntity;

import org.springframework.mail.SimpleMailMessage;

public interface EmailsService {

  void sendPurchaseConfirmationEmail(PurchaseEntity object);

  void sendEmail(SimpleMailMessage message);

  void sendOrderConfirmationHtmlEmail(PurchaseEntity object);

  void sendHtmlEmail(MimeMessage message);

  void SendNewPasswordEmail(ClientEntity clientEntity, String newPassword);
}
