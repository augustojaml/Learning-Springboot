package com.springboot.nelioalves;

import java.util.Arrays;

import com.springboot.nelioalves.entities.CategoryEntity;
import com.springboot.nelioalves.entities.ProductsEntity;
import com.springboot.nelioalves.repositories.CategoriesRepository;
import com.springboot.nelioalves.repositories.ProductsRepository;

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

	public static void main(String[] args) {
		SpringApplication.run(NelioalvesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// CATEGORIES
		CategoryEntity cat1 = new CategoryEntity(null, "Informática");
		CategoryEntity cat2 = new CategoryEntity(null, "Escritório");

		// PRODUCTS
		ProductsEntity p1 = new ProductsEntity(null, "Computador", 2000.00);
		ProductsEntity p2 = new ProductsEntity(null, "Impressora", 800.00);
		ProductsEntity p3 = new ProductsEntity(null, "Mouse", 80.00);

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

	}

}
