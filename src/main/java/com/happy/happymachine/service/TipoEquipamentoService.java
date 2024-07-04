package com.happy.happymachine.service;

import java.util.List;

import com.happy.happymachine.dto.TipoEquipamentoDTO;
import com.happy.happymachine.model.TipoEquipamento;

public interface TipoEquipamentoService {
	public void addTipoEquip(TipoEquipamentoDTO tipoEquipamentoDTO);
	public void delTipoEquip(Integer id);
	public void uptTipoEquip(TipoEquipamentoDTO tipoEquipamentoDTO, Integer id);
	public TipoEquipamento getTipoEquip(Integer id);
	public List<TipoEquipamento> getAllTipoEquip();
}