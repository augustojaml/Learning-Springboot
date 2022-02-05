package com.springboot.nelioalves;

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
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NelioalvesApplication implements CommandLineRunner {

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

	public static void main(String[] args) {
		SpringApplication.run(NelioalvesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// CATEGORIES
		CategoryEntity cat1 = new CategoryEntity(null, "Informática");
		CategoryEntity cat2 = new CategoryEntity(null, "Escritório");

		// PRODUCTS
		ProductEntity p1 = new ProductEntity(null, "Computador", 2000.00);
		ProductEntity p2 = new ProductEntity(null, "Impressora", 800.00);
		ProductEntity p3 = new ProductEntity(null, "Mouse", 80.00);

		// ADD PRODUCT => CATEGORIES
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));

		// ADD CATEGORY => PRODUCT
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));

		// INSERT CATEGORIES
		categoriesRepository.saveAll(Arrays.asList(cat1, cat2));
		// INSERT CATEGORIES
		productsRepository.saveAll(Arrays.asList(p1, p2, p3));

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

		ClientEntity cli1 = new ClientEntity(null, "Maria Sila", "maria@gmail.com", "11111111111",
				TypeClientEnum.NATURALPERSON);

		cli1.getPhones().addAll(Arrays.asList("11110000", "22220000"));

		AddressEntity e1 = new AddressEntity(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		AddressEntity e2 = new AddressEntity(null, "AVenida Matos", "105", "Salva 800", "Centro", "3877701", cli1, c2);

		cli1.getAddresses().addAll(Arrays.asList(e1, e2));

		clientsRepository.saveAll(Arrays.asList(cli1));
		addressesRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		PurchaseEntity ped1 = new PurchaseEntity(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		PurchaseEntity ped2 = new PurchaseEntity(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		PaymentEntity pgto1 = new PaymentCardEntity(null, StatePaymentEnum.LIQUIDATED, ped1, 6);
		ped1.setPayment(pgto1);

		PaymentEntity pgto2 = new PaymentTicketEntity(null, StatePaymentEnum.PENDING, ped2, sdf.parse("30/09/2017 00:00"),
				null);
		ped2.setPayment(pgto2);

		cli1.getPurchases().addAll(Arrays.asList(ped1, ped2));

		purchasesRepository.saveAll(Arrays.asList(ped1, ped2));
		paymentsRepository.saveAll(Arrays.asList(pgto1, pgto1));

		ItemPurchaseEntity ip1 = new ItemPurchaseEntity(ped1, p1, 0.00, 1, 2000.00);
		ItemPurchaseEntity ip2 = new ItemPurchaseEntity(ped1, p3, 0.00, 2, 80.00);
		ItemPurchaseEntity ip3 = new ItemPurchaseEntity(ped2, p2, 100.00, 1, 800.00);

		ped1.getItems().addAll(Arrays.asList(ip1, ip2));
		ped2.getItems().addAll(Arrays.asList(ip3));

		p1.getItems().addAll(Arrays.asList(ip1));
		p2.getItems().addAll(Arrays.asList(ip3));
		p1.getItems().addAll(Arrays.asList(ip2));

		itemPurchaseRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}

}
