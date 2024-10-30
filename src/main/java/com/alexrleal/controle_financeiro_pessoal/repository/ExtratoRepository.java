package com.alexrleal.controle_financeiro_pessoal.repository;

import com.alexrleal.controle_financeiro_pessoal.entity.Extrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtratoRepository extends JpaRepository<Extrato, Integer> {
}
