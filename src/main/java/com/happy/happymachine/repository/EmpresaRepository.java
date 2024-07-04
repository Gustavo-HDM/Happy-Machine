package com.happy.happymachine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.happy.happymachine.model.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Integer>{}