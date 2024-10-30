package com.alexrleal.controle_financeiro_pessoal.service;

import com.alexrleal.controle_financeiro_pessoal.dto.FaturaDTO;
import com.alexrleal.controle_financeiro_pessoal.entity.Fatura;
import com.alexrleal.controle_financeiro_pessoal.repository.FaturaRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FaturaService {
    @Autowired
    private FaturaRepository repository;

    @Transactional
    public List<FaturaDTO> uploadCSVFatura(MultipartFile file) throws IOException, CsvException {
        CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));
        List<String[]> linhas = reader.readAll();
        List<FaturaDTO> faturasDTO = new ArrayList<>();

        for (int i = 1; i < linhas.size(); i++) {
            String[] linha = linhas.get(i);
            LocalDate data = LocalDate.parse(linha[0]);
            String descricao = linha[1];
            Double valor = Double.parseDouble(linha[2]);

            Fatura fatura = new Fatura(descricao, "NUBANK - Alexandre", valor, data);

            if (fatura != null) {
                repository.save(fatura);
                faturasDTO.add(new FaturaDTO(fatura));
            }
        }

        return faturasDTO;
    }
}
