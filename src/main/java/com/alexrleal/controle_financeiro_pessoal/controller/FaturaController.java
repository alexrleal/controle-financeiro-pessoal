package com.alexrleal.controle_financeiro_pessoal.controller;

import com.alexrleal.controle_financeiro_pessoal.dto.FaturaDTO;
import com.alexrleal.controle_financeiro_pessoal.service.FaturaService;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/fatura")
public class FaturaController {
    @Autowired
    private FaturaService service;

    @PostMapping(value = "/upload-csv")
    public ResponseEntity<List<FaturaDTO>> uploadFatura(@RequestParam("file") MultipartFile file) {
        try {
            List<FaturaDTO> faturasDTO = service.uploadCSVFatura(file);
            return ResponseEntity.ok(faturasDTO);
        } catch (IOException | CsvException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
