package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Integer>{}