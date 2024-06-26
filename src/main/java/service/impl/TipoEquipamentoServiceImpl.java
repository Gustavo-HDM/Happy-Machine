package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.TipoEquipamentoDTO;
import model.TipoEquipamento;
import repository.TipoEquipamentoRepository;
import service.TipoEquipamentoService;

@Service
public class TipoEquipamentoServiceImpl implements TipoEquipamentoService{

	@Autowired
	private TipoEquipamentoRepository repository;
	
	@Override
	public void addTipoEquipamento(TipoEquipamentoDTO tipoEquipamentoDTO) {
		TipoEquipamento tipoEquipamento = new TipoEquipamento(tipoEquipamentoDTO);
		repository.save(tipoEquipamento);
	}

	@Override
	public void uptTipoEquipamento(TipoEquipamentoDTO tipoEquipamentoDTO, Integer id) {
		Optional<TipoEquipamento> OldTipoEquipamento = repository.findById(id);
		if (OldTipoEquipamento.isPresent()) {
			TipoEquipamento tipoEquipamento = new TipoEquipamento(tipoEquipamentoDTO);
			tipoEquipamento.setId(id);
			repository.save(tipoEquipamento);
		}
	}
	
	@Override
	public void delTipoEquipamento(Integer id) {
		repository.deleteById(id);
	}


	@Override
	public TipoEquipamento getTipoEquipamento(Integer id) {
		Optional<TipoEquipamento> tipoEquipamento = repository.findById(id);
		return tipoEquipamento.orElse(null);
	}

	@Override
	public List<TipoEquipamento> getAllTipoEquipamento() {
		Iterable<TipoEquipamento> tipoEquipamentosRep = repository.findAll();
		List<TipoEquipamento> tipoEquipamentos = new ArrayList<>();
		tipoEquipamentosRep.forEach(tipoEquipamentos::add);
		return tipoEquipamentos;
	}

}
