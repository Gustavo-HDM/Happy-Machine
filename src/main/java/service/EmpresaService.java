package service;

import java.util.List;

import dto.EmpresaDTO;
import model.Empresa;

public interface EmpresaService {
	public void addEmpresa(EmpresaDTO empresaDTO);
	public void uptEmpresa(EmpresaDTO empresaDTO, Integer id);
	public void delEmpresa(Integer id);
	public Empresa getEmpresa(Integer id);
	public List<Empresa> getAllEmpresa();
}