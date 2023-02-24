package com.java.springdata;

import com.java.springdata.entities.Cargo;
import com.java.springdata.service.CrudCargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	private final CrudCargoService cargoService;
	public SpringDataApplication(CrudCargoService cargoService) {
		this.cargoService = cargoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}


	//executa após a aplicacao startar (CommandLineRunner)
	@Override
	public void run(String... args) throws Exception {
		var scanner = new Scanner(System.in);
		cargoService.inicial(scanner);
	}
}
