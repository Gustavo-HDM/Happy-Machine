package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.TipoEquipamento;

@Repository
public interface TipoEquipamentoRepository extends CrudRepository<TipoEquipamento, Integer>{}