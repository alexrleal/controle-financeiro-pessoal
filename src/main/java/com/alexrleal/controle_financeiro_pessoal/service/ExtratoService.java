package com.alexrleal.controle_financeiro_pessoal.service;

import com.alexrleal.controle_financeiro_pessoal.dto.ExtratoDTO;
import com.alexrleal.controle_financeiro_pessoal.entity.Extrato;
import com.alexrleal.controle_financeiro_pessoal.repository.ExtratoRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExtratoService {
    @Autowired
    private ExtratoRepository repository;

    @Transactional
    public List<ExtratoDTO> uploadCSVExtrato(MultipartFile file) throws IOException, CsvException {
        CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));
        List<String[]> linhas = reader.readAll();
        List<ExtratoDTO> extratosDTO = new ArrayList<>();

        for (int i = 1; i < linhas.size(); i++) {
            String[] linha = linhas.get(i);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(linha[0], formatter);
            String descricao = linha[3];
            Double valor = Double.parseDouble(linha[1]);

            Extrato extrato = new Extrato(descricao, "NUBANK - Alexandre", valor, data);

            if (extrato != null) {
                repository.save(extrato);
                extratosDTO.add(new ExtratoDTO(extrato));
            }
        }

        return extratosDTO;
    }

}
