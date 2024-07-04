package com.happy.happymachine.service;

import java.util.List;

import com.happy.happymachine.dto.CidadeDTO;
import com.happy.happymachine.model.Cidade;

public interface CidadeService {
	public void addCidade(CidadeDTO cidadeDTO);
	public void uptCidade(CidadeDTO cidadeDTO, String sigla);
	public void delCidade(String sigla);
	public Cidade getCidade(String sigla);
	public List<Cidade> getAllCidade();
}