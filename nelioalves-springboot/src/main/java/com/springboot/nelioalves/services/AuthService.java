package com.springboot.nelioalves.services;

import java.util.Random;

import com.springboot.nelioalves.entities.ClientEntity;
import com.springboot.nelioalves.exceptions.ServiceObjectNotFoundException;
import com.springboot.nelioalves.repositories.ClientsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Autowired
  private ClientsRepository clientsRepository;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private EmailsService emailsService;

  private Random random = new Random();

  public void sendNewPassword(String email) {
    ClientEntity client = clientsRepository.findByEmail(email);
    if (client == null) {
      throw new ServiceObjectNotFoundException("Email not found");
    }

    String newPass = newPassword();
    client.setPassword(bCryptPasswordEncoder.encode(newPass));
    clientsRepository.save(client);
    emailsService.SendNewPasswordEmail(client, newPass);
  }

  private String newPassword() {
    char[] charNewPass = new char[10];
    for (int i = 0; i < 10; i++) {
      charNewPass[i] = randomChar();
    }
    return new String(charNewPass);
  }

  private char randomChar() {
    int digit = random.nextInt(3);
    if (digit == 0) { // NUMBER
      return (char) (random.nextInt(10) + 48);
    } else if (digit == 1) { // UP CASE
      return (char) (random.nextInt(26) + 65);
    } else { // LOW CASE
      return (char) (random.nextInt(26) + 97);
    }
  }
}
