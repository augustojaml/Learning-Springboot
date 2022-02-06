package com.springboot.nelioalves.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractEmailService {

  private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

  @Override
  public void sendEmail(SimpleMailMessage message) {
    LOG.info("Simulating email sending");
    LOG.info(message.toString());
    LOG.info("Email sent");
  }

}
