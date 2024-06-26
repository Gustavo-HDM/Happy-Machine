package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Equipamento;

@Repository
public interface EquipamentoRepository extends CrudRepository<Equipamento, Integer>{}