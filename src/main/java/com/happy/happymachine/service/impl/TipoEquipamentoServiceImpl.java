package com.happy.happymachine.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.happymachine.dto.TipoEquipamentoDTO;
import com.happy.happymachine.model.TipoEquipamento;
import com.happy.happymachine.repository.TipoEquipamentoRepository;
import com.happy.happymachine.service.TipoEquipamentoService;

@Service
public class TipoEquipamentoServiceImpl implements TipoEquipamentoService{

	@Autowired
	private TipoEquipamentoRepository repository;
	
	@Override
	public void addTipoEquip(TipoEquipamentoDTO tipoEquipamentoDTO) {
		TipoEquipamento tipoEquipamento = new TipoEquipamento(tipoEquipamentoDTO);
		repository.save(tipoEquipamento);
	}

	@Override
	public void uptTipoEquip(TipoEquipamentoDTO tipoEquipamentoDTO, Integer id) {
		Optional<TipoEquipamento> OldTipoEquipamento = repository.findById(id);
		if (OldTipoEquipamento.isPresent()) {
			TipoEquipamento tipoEquipamento = new TipoEquipamento(tipoEquipamentoDTO);
			tipoEquipamento.setId(id);
			repository.save(tipoEquipamento);
		}
	}
	
	@Override
	public void delTipoEquip(Integer id) {
		repository.deleteById(id);
	}


	@Override
	public TipoEquipamento getTipoEquip(Integer id) {
		Optional<TipoEquipamento> tipoEquipamento = repository.findById(id);
		return tipoEquipamento.orElse(null);
	}

	@Override
	public List<TipoEquipamento> getAllTipoEquip() {
		Iterable<TipoEquipamento> tipoEquipamentosRep = repository.findAll();
		List<TipoEquipamento> tipoEquipamentos = new ArrayList<>();
		tipoEquipamentosRep.forEach(tipoEquipamentos::add);
		return tipoEquipamentos;
	}

}
