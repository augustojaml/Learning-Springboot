package com.springboot.nelioalves;

import java.util.Arrays;

import com.springboot.nelioalves.entities.CategoryEntity;
import com.springboot.nelioalves.repositories.CategoriesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NelioalvesApplication implements CommandLineRunner {

	@Autowired
	private CategoriesRepository categoriesRepository;

	public static void main(String[] args) {
		SpringApplication.run(NelioalvesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CategoryEntity cat1 = new CategoryEntity(null, "Informática");
		CategoryEntity cat2 = new CategoryEntity(null, "Escritório");

		// INSERT CATEGORIES
		categoriesRepository.saveAll(Arrays.asList(cat1, cat2));

	}

}
