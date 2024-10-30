package com.alexrleal.controle_financeiro_pessoal.controller;

import com.alexrleal.controle_financeiro_pessoal.dto.ExtratoDTO;
import com.alexrleal.controle_financeiro_pessoal.service.ExtratoService;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/extrato")
public class ExtratoController {
    @Autowired
    private ExtratoService service;

    @PostMapping(value = "/upload-csv")
    public ResponseEntity<List<ExtratoDTO>> uploadExtrato(@RequestParam("file") MultipartFile file) {
        try {
            List<ExtratoDTO> extratosDTO = service.uploadCSVExtrato(file);
            return ResponseEntity.ok(extratosDTO);
        } catch (IOException | CsvException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
