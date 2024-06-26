package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.EquipamentoDTO;
import model.Equipamento;
import repository.EquipamentoRepository;
import service.EquipamentoService;

@Service
public class EquipamentoServiceImpl implements EquipamentoService{

	@Autowired
	private EquipamentoRepository repository;
	
	@Override
	public void addEquipamento(EquipamentoDTO equipamentoDTO) {
		Equipamento equipamento = new Equipamento(equipamentoDTO);
		repository.save(equipamento);
	}

	@Override
	public void uptEquipamento(EquipamentoDTO equipamentoDTO, Integer id) {
		Optional<Equipamento> oldEquipamento = repository.findById(id);
		if(oldEquipamento.isPresent()) {
			Equipamento equipamento = new Equipamento(equipamentoDTO);
			equipamento.setId(id);
			repository.save(equipamento);
		}
	}

	@Override
	public void delEquipamento(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Equipamento getEquipamento(Integer id) {
		Optional<Equipamento> equipamento = repository.findById(id);
		return equipamento.orElse(null);
	}

	@Override
	public List<Equipamento> getAllEquipamento() {
		Iterable<Equipamento> equipamentosRep = repository.findAll();
		List<Equipamento> equipamentos = new ArrayList<>();
		equipamentosRep.forEach(equipamentos::add);
		return equipamentos;
	}
}