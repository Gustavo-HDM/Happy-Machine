package service;

import java.util.List;

import dto.CidadeDTO;
import model.Cidade;

public interface CidadeService {
	public void addCidade(CidadeDTO cidadeDTO);
	public void uptCidade(CidadeDTO cidadeDTO, String sigla);
	public void delCidade(String sigla);
	public Cidade getCidade(String sigla);
	public List<Cidade> getAllCidade();
}