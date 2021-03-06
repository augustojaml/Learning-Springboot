package com.springboot.nelioalves.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SMTPEmailService extends AbstractEmailService {

  @Autowired
  private MailSender mailSender;

  @Autowired
  private JavaMailSender javaMailSender;

  private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

  @Override
  public void sendEmail(SimpleMailMessage message) {
    LOG.info("Sending Email...");
    mailSender.send(message);
    LOG.info("Email sent");
  }

  @Override
  public void sendHtmlEmail(MimeMessage message) {
    LOG.info("Sending Email...");
    javaMailSender.send(message);
    LOG.info("Email sent");
  }

}
