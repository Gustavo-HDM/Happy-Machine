package com.happy.happymachine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.happy.happymachine.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{}