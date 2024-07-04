package com.happy.happymachine.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.happymachine.dto.CidadeDTO;
import com.happy.happymachine.model.Cidade;
import com.happy.happymachine.repository.CidadeRepository;
import com.happy.happymachine.service.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService {

	@Autowired
	private CidadeRepository repository;

	@Override
	public void addCidade(CidadeDTO cidadeDTO) {
		Cidade cidade = new Cidade(cidadeDTO);
		repository.save(cidade);
	}

	@Override
	public void uptCidade(CidadeDTO cidadeDTO, String sigla) {
		Optional<Cidade> oldCidade = repository.findById(sigla);
		if (oldCidade.isPresent()) {
			Cidade cidade = new Cidade(cidadeDTO);
			cidade.setSigla(sigla);
			repository.save(cidade);
		}
	}

	@Override
	public void delCidade(String sigla) {
		repository.deleteById(sigla);
	}

	@Override
	public Cidade getCidade(String sigla) {
		Optional<Cidade> cidade = repository.findById(sigla);
		return cidade.orElse(null);
	}

	@Override
	public List<Cidade> getAllCidade() {
		Iterable<Cidade> cidadesRep = repository.findAll();
		List<Cidade> cidades = new ArrayList<>();
		cidadesRep.forEach(cidades::add);
		return cidades;
	}
}
