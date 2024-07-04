package com.happy.happymachine.service;

import java.util.List;

import com.happy.happymachine.dto.EquipamentoDTO;
import com.happy.happymachine.model.Equipamento;

public interface EquipamentoService {
	public void addEquip(EquipamentoDTO equipamentoDTO);
	public void uptEquip(EquipamentoDTO euqipamentoDTO, Integer id);
	public void delEquip(Integer id);
	public Equipamento getEquip(Integer id);
	public List<Equipamento> getAllEquip();
}