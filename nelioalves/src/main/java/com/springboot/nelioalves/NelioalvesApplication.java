package com.springboot.nelioalves;

import com.springboot.nelioalves.services.S3Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NelioalvesApplication implements CommandLineRunner {

	@Autowired
	private S3Service s3Service;

	public static void main(String[] args) {
		SpringApplication.run(NelioalvesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		s3Service.uploadFile(
				"/home/augustojaml/Pictures/1993-pcbots-labs-blog-programmers-and-coders-wallpaper-hd-by-pcbots.jpg");
	}

}
