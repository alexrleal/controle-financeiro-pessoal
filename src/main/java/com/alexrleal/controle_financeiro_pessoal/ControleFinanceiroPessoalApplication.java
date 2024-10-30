package com.alexrleal.controle_financeiro_pessoal;

import com.alexrleal.controle_financeiro_pessoal.dto.FaturaDTO;
import com.alexrleal.controle_financeiro_pessoal.entity.Fatura;
import com.alexrleal.controle_financeiro_pessoal.repository.FaturaRepository;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;
import java.time.LocalDate;
import java.util.List;


@SpringBootApplication
public class ControleFinanceiroPessoalApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ControleFinanceiroPessoalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
