package com.java.springdata.service;

import com.java.springdata.entities.Cargo;
import com.java.springdata.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Scanner;

@Service
public class CrudCargoService {
    private final CargoRepository cargoRepository;
    private Boolean system = true;
    public CrudCargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void inicial(Scanner scanner){
        while (system) {
            System.out.println("Qual ação você quer executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Criar Novo Cargo");
            System.out.println("2 - Atualizar Cargo");
            System.out.println("3 - Visualizar Cargos");
            System.out.println("4 - Deletar Cargo");

            int action = scanner.nextInt();
            switch (action) {
                case 0: {system = false; break;}
                case 1: {salvar(scanner); break;}
                case 2: {atualizarPorDescricao(scanner); break;}
                case 3: {visualizar(); break;}
                case 4: {deletar(scanner); break;}
                default: {
                    System.out.println(String.format("Opção %s não encontrada!", action));
                    system = false;
                }
            }
        }
    }
    public void atualizarPorDescricao(Scanner scanner){
        System.out.println("Descrição do cargo que quer atualizar:");
        var descOld = scanner.next();
        var desc = cargoRepository.findByDescricao(descOld);
        System.out.println("Valor desc: " + desc);
        if(desc.size() > 0){
            System.out.println("Descrição do cargo novo:");
            var descricao = scanner.next();
            var descUpdate = desc.get(0);
            descUpdate.setDescricao(descricao);
            cargoRepository.save(descUpdate);
        }
    }

    private void salvar(Scanner scanner){
        System.out.println("Descrição do cargo:");
        var descricao = scanner.next();
        var cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        System.out.println(String.format("Cargo: %s criado com sucesso.", cargo.getDescricao()));
    }

    private void visualizar(){
        Iterable<Cargo> cargos = cargoRepository.findAll();
        cargos.forEach(cargo -> System.out.println(cargo));
    }

    private void deletar(Scanner scanner){
        System.out.println("Id:");
        int id = scanner.nextInt();
        cargoRepository.deleteById(id);
        System.out.println("Deletado com sucesso!");
    }
}
