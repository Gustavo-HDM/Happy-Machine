package service;

import java.util.List;

import dto.TipoEquipamentoDTO;
import model.TipoEquipamento;

public interface TipoEquipamentoService {
	public void addTipoEquipamento(TipoEquipamentoDTO tipoEquipamentoDTO);
	public void delTipoEquipamento(Integer id);
	public void uptTipoEquipamento(TipoEquipamentoDTO tipoEquipamentoDTO, Integer id);
	public TipoEquipamento getTipoEquipamento(Integer id);
	public List<TipoEquipamento> getAllTipoEquipamento();
}