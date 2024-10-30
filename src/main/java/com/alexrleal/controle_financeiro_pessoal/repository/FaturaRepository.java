package com.alexrleal.controle_financeiro_pessoal.repository;

import com.alexrleal.controle_financeiro_pessoal.entity.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaturaRepository extends JpaRepository <Fatura, Long> {
}
