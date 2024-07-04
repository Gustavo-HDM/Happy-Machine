package com.happy.happymachine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.happy.happymachine.model.Equipamento;

@Repository
public interface EquipamentoRepository extends CrudRepository<Equipamento, Integer>{}