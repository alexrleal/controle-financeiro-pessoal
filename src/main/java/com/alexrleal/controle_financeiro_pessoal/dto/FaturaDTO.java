package com.alexrleal.controle_financeiro_pessoal.dto;

import com.alexrleal.controle_financeiro_pessoal.entity.Fatura;

import java.time.LocalDate;

public class FaturaDTO {
    private Long id;
    private String descricao;
    private String conta;
    private Double valor;
    private LocalDate data;

    public FaturaDTO(Fatura entity) {
        id = entity.getId();
        descricao = entity.getDescricao();
        conta = entity.getConta();
        valor = entity.getValor();
        data = entity.getData();
    }

    public FaturaDTO(Long id, String descricao, String conta, Double valor, LocalDate data) {
        this.id = id;
        this.descricao = descricao;
        this.conta = conta;
        this.valor = valor;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getConta() {
        return conta;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }
}
