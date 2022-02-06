package com.springboot.nelioalves.services;

import java.util.Calendar;
import java.util.Date;

import com.springboot.nelioalves.entities.PaymentTicketEntity;

import org.springframework.stereotype.Service;

@Service
public class TicketsService {

  public void paymentsWithTicket(PaymentTicketEntity payment, Date instantOfPurchase) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(instantOfPurchase);
    calendar.add(Calendar.DAY_OF_MONTH, 7);
    payment.setExpireDate(calendar.getTime());
  }
}
