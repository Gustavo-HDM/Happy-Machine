package service;

import java.util.List;

import dto.EquipamentoDTO;
import model.Equipamento;

public interface EquipamentoService {
	public void addEquipamento(EquipamentoDTO equipamentoDTO);
	public void uptEquipamento(EquipamentoDTO euqipamentoDTO, Integer id);
	public void delEquipamento(Integer id);
	public Equipamento getEquipamento(Integer id);
	public List<Equipamento> getAllEquipamento();
}