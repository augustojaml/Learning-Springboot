package com.springboot.nelioalves.services;

import java.util.Date;

import com.springboot.nelioalves.entities.PurchaseEntity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

public abstract class AbstractEmailService implements EmailsService {

  @Value("${default.sender}")
  private String sender;

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

}
