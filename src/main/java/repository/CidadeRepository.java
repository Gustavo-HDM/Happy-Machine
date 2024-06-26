package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Cidade;

@Repository
public interface CidadeRepository extends CrudRepository<Cidade, String>{}