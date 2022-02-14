package com.springboot.nelioalves.config;

import java.text.ParseException;

import com.springboot.nelioalves.services.DBService;
import com.springboot.nelioalves.services.EmailsService;
import com.springboot.nelioalves.services.MockEmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

  @Autowired
  DBService dbService;

  @Bean
  public boolean instantiateDatabase() throws ParseException {
    dbService.instantiateDatabase();
    return true;
  }

  @Bean
  public EmailsService emailsService() {
    return new MockEmailService();
  }

}
