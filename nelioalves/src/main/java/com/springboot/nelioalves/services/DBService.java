package com.springboot.nelioalves.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.springboot.nelioalves.entities.AddressEntity;
import com.springboot.nelioalves.entities.CategoryEntity;
import com.springboot.nelioalves.entities.CityEntity;
import com.springboot.nelioalves.entities.ClientEntity;
import com.springboot.nelioalves.entities.ItemPurchaseEntity;
import com.springboot.nelioalves.entities.PaymentCardEntity;
import com.springboot.nelioalves.entities.PaymentEntity;
import com.springboot.nelioalves.entities.PaymentTicketEntity;
import com.springboot.nelioalves.entities.ProductEntity;
import com.springboot.nelioalves.entities.PurchaseEntity;
import com.springboot.nelioalves.entities.StateEntity;
import com.springboot.nelioalves.entities.enums.ProfileEnum;
import com.springboot.nelioalves.entities.enums.StatePaymentEnum;
import com.springboot.nelioalves.entities.enums.TypeClientEnum;
import com.springboot.nelioalves.repositories.AddressesRepository;
import com.springboot.nelioalves.repositories.CategoriesRepository;
import com.springboot.nelioalves.repositories.CitiesRepository;
import com.springboot.nelioalves.repositories.ClientsRepository;
import com.springboot.nelioalves.repositories.ItemPurchaseRepository;
import com.springboot.nelioalves.repositories.PaymentsRepository;
import com.springboot.nelioalves.repositories.ProductsRepository;
import com.springboot.nelioalves.repositories.PurchasesRepository;
import com.springboot.nelioalves.repositories.StatesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DBService {

  @Autowired
  private CategoriesRepository categoriesRepository;

  @Autowired
  private ProductsRepository productsRepository;

  @Autowired
  private StatesRepository statesRepository;

  @Autowired
  private CitiesRepository citiesRepository;

  @Autowired
  private AddressesRepository addressesRepository;

  @Autowired
  private ClientsRepository clientsRepository;

  @Autowired
  private PurchasesRepository purchasesRepository;

  @Autowired
  private PaymentsRepository paymentsRepository;

  @Autowired
  private ItemPurchaseRepository itemPurchaseRepository;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public void instantiateDatabase() throws ParseException {
    // CATEGORIES
    CategoryEntity cat1 = new CategoryEntity(null, "Informática");
    CategoryEntity cat2 = new CategoryEntity(null, "Escritório");
    CategoryEntity cat3 = new CategoryEntity(null, "Cama mesa e banho");
    CategoryEntity cat4 = new CategoryEntity(null, "Eletrônicos");
    CategoryEntity cat5 = new CategoryEntity(null, "Jardinagem");
    CategoryEntity cat6 = new CategoryEntity(null, "Decoração");
    CategoryEntity cat7 = new CategoryEntity(null, "Perfumaria");

    // PRODUCTS
    ProductEntity p1 = new ProductEntity(null, "Computador", 2000.00);
    ProductEntity p2 = new ProductEntity(null, "Impressora", 800.00);
    ProductEntity p3 = new ProductEntity(null, "Mouse", 80.00);
    ProductEntity p4 = new ProductEntity(null, "Mesa de escritório", 300.00);
    ProductEntity p5 = new ProductEntity(null, "Toalha", 50.00);
    ProductEntity p6 = new ProductEntity(null, "Colcha", 200.00);
    ProductEntity p7 = new ProductEntity(null, "TV true color", 1200.00);
    ProductEntity p8 = new ProductEntity(null, "Roçadeira", 800.00);
    ProductEntity p9 = new ProductEntity(null, "Abajur", 100.00);
    ProductEntity p10 = new ProductEntity(null, "Pendente", 180.00);
    ProductEntity p11 = new ProductEntity(null, "Shampoo", 90.00);
    ProductEntity p12 = new ProductEntity(null, "Produto 12", 10.00);
    ProductEntity p13 = new ProductEntity(null, "Produto 13", 10.00);
    ProductEntity p14 = new ProductEntity(null, "Produto 14", 10.00);
    ProductEntity p15 = new ProductEntity(null, "Produto 15", 10.00);
    ProductEntity p16 = new ProductEntity(null, "Produto 16", 10.00);
    ProductEntity p17 = new ProductEntity(null, "Produto 17", 10.00);
    ProductEntity p18 = new ProductEntity(null, "Produto 18", 10.00);
    ProductEntity p19 = new ProductEntity(null, "Produto 19", 10.00);
    ProductEntity p20 = new ProductEntity(null, "Produto 20", 10.00);
    ProductEntity p21 = new ProductEntity(null, "Produto 21", 10.00);
    ProductEntity p22 = new ProductEntity(null, "Produto 22", 10.00);
    ProductEntity p23 = new ProductEntity(null, "Produto 23", 10.00);
    ProductEntity p24 = new ProductEntity(null, "Produto 24", 10.00);
    ProductEntity p25 = new ProductEntity(null, "Produto 25", 10.00);
    ProductEntity p26 = new ProductEntity(null, "Produto 26", 10.00);
    ProductEntity p27 = new ProductEntity(null, "Produto 27", 10.00);
    ProductEntity p28 = new ProductEntity(null, "Produto 28", 10.00);
    ProductEntity p29 = new ProductEntity(null, "Produto 29", 10.00);
    ProductEntity p30 = new ProductEntity(null, "Produto 30", 10.00);
    ProductEntity p31 = new ProductEntity(null, "Produto 31", 10.00);
    ProductEntity p32 = new ProductEntity(null, "Produto 32", 10.00);
    ProductEntity p33 = new ProductEntity(null, "Produto 33", 10.00);
    ProductEntity p34 = new ProductEntity(null, "Produto 34", 10.00);
    ProductEntity p35 = new ProductEntity(null, "Produto 35", 10.00);
    ProductEntity p36 = new ProductEntity(null, "Produto 36", 10.00);
    ProductEntity p37 = new ProductEntity(null, "Produto 37", 10.00);
    ProductEntity p38 = new ProductEntity(null, "Produto 38", 10.00);
    ProductEntity p39 = new ProductEntity(null, "Produto 39", 10.00);
    ProductEntity p40 = new ProductEntity(null, "Produto 40", 10.00);
    ProductEntity p41 = new ProductEntity(null, "Produto 41", 10.00);
    ProductEntity p42 = new ProductEntity(null, "Produto 42", 10.00);
    ProductEntity p43 = new ProductEntity(null, "Produto 43", 10.00);
    ProductEntity p44 = new ProductEntity(null, "Produto 44", 10.00);
    ProductEntity p45 = new ProductEntity(null, "Produto 45", 10.00);
    ProductEntity p46 = new ProductEntity(null, "Produto 46", 10.00);
    ProductEntity p47 = new ProductEntity(null, "Produto 47", 10.00);
    ProductEntity p48 = new ProductEntity(null, "Produto 48", 10.00);
    ProductEntity p49 = new ProductEntity(null, "Produto 49", 10.00);
    ProductEntity p50 = new ProductEntity(null, "Produto 50", 10.00);

    // ADD PRODUCT => CATEGORIES
    cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
    cat2.getProducts().addAll(Arrays.asList(p2, p4));
    cat3.getProducts().addAll(Arrays.asList(p5, p6));
    cat4.getProducts().addAll(Arrays.asList(p1, p2, p3, p7));
    cat5.getProducts().addAll(Arrays.asList(p8));
    cat6.getProducts().addAll(Arrays.asList(p9, p10));
    cat7.getProducts().addAll(Arrays.asList(p11));

    cat1.getProducts().addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
        p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
        p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));

    // ADD CATEGORY => PRODUCT
    p1.getCategories().addAll(Arrays.asList(cat1, cat4));
    p2.getCategories().addAll(Arrays.asList(cat1, cat2, cat4));
    p3.getCategories().addAll(Arrays.asList(cat1, cat4));
    p4.getCategories().addAll(Arrays.asList(cat2));
    p5.getCategories().addAll(Arrays.asList(cat3));
    p6.getCategories().addAll(Arrays.asList(cat3));
    p7.getCategories().addAll(Arrays.asList(cat4));
    p8.getCategories().addAll(Arrays.asList(cat5));
    p9.getCategories().addAll(Arrays.asList(cat6));
    p10.getCategories().addAll(Arrays.asList(cat6));
    p11.getCategories().addAll(Arrays.asList(cat7));

    p12.getCategories().add(cat1);
    p13.getCategories().add(cat1);
    p14.getCategories().add(cat1);
    p15.getCategories().add(cat1);
    p16.getCategories().add(cat1);
    p17.getCategories().add(cat1);
    p18.getCategories().add(cat1);
    p19.getCategories().add(cat1);
    p20.getCategories().add(cat1);
    p21.getCategories().add(cat1);
    p22.getCategories().add(cat1);
    p23.getCategories().add(cat1);
    p24.getCategories().add(cat1);
    p25.getCategories().add(cat1);
    p26.getCategories().add(cat1);
    p27.getCategories().add(cat1);
    p28.getCategories().add(cat1);
    p29.getCategories().add(cat1);
    p30.getCategories().add(cat1);
    p31.getCategories().add(cat1);
    p32.getCategories().add(cat1);
    p33.getCategories().add(cat1);
    p34.getCategories().add(cat1);
    p35.getCategories().add(cat1);
    p36.getCategories().add(cat1);
    p37.getCategories().add(cat1);
    p38.getCategories().add(cat1);
    p39.getCategories().add(cat1);
    p40.getCategories().add(cat1);
    p41.getCategories().add(cat1);
    p42.getCategories().add(cat1);
    p43.getCategories().add(cat1);
    p44.getCategories().add(cat1);
    p45.getCategories().add(cat1);
    p46.getCategories().add(cat1);
    p47.getCategories().add(cat1);
    p48.getCategories().add(cat1);
    p49.getCategories().add(cat1);
    p50.getCategories().add(cat1);

    // INSERT CATEGORIES
    categoriesRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
    // INSERT CATEGORIES
    productsRepository.saveAll(Arrays.asList(p1, p2, p3, p3, p4, p5, p6, p7, p8, p9, p10, p11));

    productsRepository.saveAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
        p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
        p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));

    // INSERT STATE
    StateEntity est1 = new StateEntity(null, "Minas Gerais");
    StateEntity est2 = new StateEntity(null, "São Paulo");

    // INSERT CITY
    CityEntity c1 = new CityEntity(null, "Uberlândia", est1);
    CityEntity c2 = new CityEntity(null, "São Paulo", est2);
    CityEntity c3 = new CityEntity(null, "Campinas", est2);

    // ADD CITY => STATE
    est1.getCities().addAll(Arrays.asList(c1));
    est2.getCities().addAll(Arrays.asList(c2, c3));

    // INSERT CATEGORIES
    statesRepository.saveAll(Arrays.asList(est1, est2));
    // INSERT CATEGORIES
    citiesRepository.saveAll(Arrays.asList(c1, c2, c3));

    // CLIENTS
    ClientEntity cli1 = new ClientEntity(null, "Maria Sila", "brawziin@gmail.com", "50147663075",
        TypeClientEnum.NATURALPERSON, bCryptPasswordEncoder.encode("123"));

    ClientEntity cli2 = new ClientEntity(null, "Ana Monteiro", "augusto.emmanuel@gmail.com", "04045537023",
        TypeClientEnum.NATURALPERSON, bCryptPasswordEncoder.encode("123"));
    cli2.addProfile(ProfileEnum.ADMIN);

    // ADD PHONE CLIENT
    cli1.getPhones().addAll(Arrays.asList("11110000", "22220000"));
    cli2.getPhones().addAll(Arrays.asList("33330000", "44440000"));

    // ADDRESS
    AddressEntity e1 = new AddressEntity(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
    AddressEntity e2 = new AddressEntity(null, "AVenida Matos", "105", "Salva 800", "Centro", "3877701", cli1, c2);
    AddressEntity e3 = new AddressEntity(null, "Avenida Pau Brasil", "77", null, "Centro", "17061977", cli2,
        c2);

    // ADD ADDRESS CLIENT
    cli1.getAddresses().addAll(Arrays.asList(e1, e2));
    cli2.getAddresses().addAll(Arrays.asList(e3));

    // SAVE CLIENT
    clientsRepository.saveAll(Arrays.asList(cli1, cli2));

    // SAVE ADDRESS
    addressesRepository.saveAll(Arrays.asList(e1, e2, e3));

    // FORMAT DATE
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    // PURCHASE
    PurchaseEntity ped1 = new PurchaseEntity(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
    PurchaseEntity ped2 = new PurchaseEntity(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

    // PAYMENT CARD
    PaymentEntity pgto1 = new PaymentCardEntity(null, StatePaymentEnum.LIQUIDATED, ped1, 6);
    ped1.setPayment(pgto1);

    // PAYMENT TICKET
    PaymentEntity pgto2 = new PaymentTicketEntity(null, StatePaymentEnum.PENDING, ped2, sdf.parse("30/09/2017 00:00"),
        null);

    // ADD PAYMENT PURCHASE
    ped2.setPayment(pgto2);

    // ADD ALL PURCHASE
    cli1.getPurchases().addAll(Arrays.asList(ped1, ped2));

    // SAVE PURCHASE
    purchasesRepository.saveAll(Arrays.asList(ped1, ped2));

    // SAVE PAYMENTS
    paymentsRepository.saveAll(Arrays.asList(pgto1, pgto1));

    // ITEM PURCHASE
    ItemPurchaseEntity ip1 = new ItemPurchaseEntity(ped1, p1, 0.00, 1, 2000.00);
    ItemPurchaseEntity ip2 = new ItemPurchaseEntity(ped1, p3, 0.00, 2, 80.00);
    ItemPurchaseEntity ip3 = new ItemPurchaseEntity(ped2, p2, 100.00, 1, 800.00);

    // ADD ITEM PURCHASE TO PURCHASE
    ped1.getItems().addAll(Arrays.asList(ip1, ip2));
    ped2.getItems().addAll(Arrays.asList(ip3));

    // ADD PRODUCT PURCHASE
    p1.getItems().addAll(Arrays.asList(ip1));
    p2.getItems().addAll(Arrays.asList(ip3));
    p1.getItems().addAll(Arrays.asList(ip2));

    // SAVE ITEM PURCHASE
    itemPurchaseRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
  }
}
