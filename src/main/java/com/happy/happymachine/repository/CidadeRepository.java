package com.happy.happymachine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.happy.happymachine.model.Cidade;

@Repository
public interface CidadeRepository extends CrudRepository<Cidade, String>{}