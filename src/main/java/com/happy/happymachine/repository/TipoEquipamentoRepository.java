package com.happy.happymachine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.happy.happymachine.model.TipoEquipamento;

@Repository
public interface TipoEquipamentoRepository extends CrudRepository<TipoEquipamento, Integer>{}