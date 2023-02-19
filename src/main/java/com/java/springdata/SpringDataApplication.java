package com.java.springdata;

import com.java.springdata.entities.Cargo;
import com.java.springdata.repository.CargoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CargoRepository cargoRepository;

	public SpringDataApplication(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}


	//executa após a aplicacao startar (CommandLineRunner)
	@Override
	public void run(String... args) throws Exception {
		Cargo cargo = new Cargo();
		cargo.setDescricao("Desenvolvedor de Software");
		cargoRepository.save(cargo);
		System.out.println("Cargo: " + cargo.getDescricao() + "salvo com sucesso!");
	}
}
