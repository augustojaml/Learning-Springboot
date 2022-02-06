package com.springboot.nelioalves.services;

import java.util.Date;
import java.util.Optional;

import com.springboot.nelioalves.entities.ItemPurchaseEntity;
import com.springboot.nelioalves.entities.PaymentTicketEntity;
import com.springboot.nelioalves.entities.PurchaseEntity;
import com.springboot.nelioalves.entities.enums.StatePaymentEnum;
import com.springboot.nelioalves.exceptions.ServiceObjectNotFoundException;
import com.springboot.nelioalves.repositories.ItemPurchaseRepository;
import com.springboot.nelioalves.repositories.PaymentsRepository;
import com.springboot.nelioalves.repositories.PurchasesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchasesService {

  @Autowired
  private PurchasesRepository repository;

  @Autowired
  private ClientsService clientsService;

  @Autowired
  private TicketsService ticketsService;

  @Autowired
  private PaymentsRepository paymentsRepository;

  @Autowired
  private ProductsService productsService;

  @Autowired
  private ItemPurchaseRepository itemPurchaseRepository;

  @Autowired
  private EmailsService emailsService;

  public PurchaseEntity findById(Integer id) {
    Optional<PurchaseEntity> object = repository.findById(id);
    return object.orElseThrow(
        () -> new ServiceObjectNotFoundException(
            "Object with identifier " + id + " | Class: " + PurchaseEntity.class.getName()));
  }

  public PurchaseEntity insert(PurchaseEntity object) {
    object.setId(null);
    object.setInstant(new Date());
    object.getPayment().setState(StatePaymentEnum.PENDING);
    object.getPayment().setPurchase(object);
    object.setClient(clientsService.findById(object.getClient().getId()));

    if (object.getPayment() instanceof PaymentTicketEntity) {
      PaymentTicketEntity payment = (PaymentTicketEntity) object.getPayment();
      ticketsService.paymentsWithTicket(payment, object.getInstant());
    }
    object = repository.save(object);
    paymentsRepository.save(object.getPayment());

    for (ItemPurchaseEntity item : object.getItems()) {
      item.setDiscount(0.0);
      item.setProduct(productsService.findById(item.getProduct().getId()));
      item.setPrice(item.getProduct().getPrice());
      item.setPurchase(object);
    }

    itemPurchaseRepository.saveAll(object.getItems());
    emailsService.sendOrderConfirmationHtmlEmail(object);
    return object;
  }
}
