package com.happy.happymachine.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.happymachine.dto.EquipamentoDTO;
import com.happy.happymachine.model.Equipamento;
import com.happy.happymachine.repository.EquipamentoRepository;
import com.happy.happymachine.service.EquipamentoService;

@Service
public class EquipamentoServiceImpl implements EquipamentoService{

	@Autowired
	private EquipamentoRepository repository;
	
	@Override
	public void addEquip(EquipamentoDTO equipamentoDTO) {
		Equipamento equipamento = new Equipamento(equipamentoDTO);
		repository.save(equipamento);
	}

	@Override
	public void uptEquip(EquipamentoDTO equipamentoDTO, Integer id) {
		Optional<Equipamento> oldEquipamento = repository.findById(id);
		if(oldEquipamento.isPresent()) {
			Equipamento equipamento = new Equipamento(equipamentoDTO);
			equipamento.setId(id);
			repository.save(equipamento);
		}
	}

	@Override
	public void delEquip(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Equipamento getEquip(Integer id) {
		Optional<Equipamento> equipamento = repository.findById(id);
		return equipamento.orElse(null);
	}

	@Override
	public List<Equipamento> getAllEquip() {
		Iterable<Equipamento> equipamentosRep = repository.findAll();
		List<Equipamento> equipamentos = new ArrayList<>();
		equipamentosRep.forEach(equipamentos::add);
		return equipamentos;
	}
}