package com.springboot.nelioalves.services;

import com.springboot.nelioalves.entities.PurchaseEntity;

import org.springframework.mail.SimpleMailMessage;

public interface EmailsService {

  void sendPurchaseConfirmationEmail(PurchaseEntity object);

  void sendEmail(SimpleMailMessage message);
}
