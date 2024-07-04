package com.happy.happymachine.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.happymachine.dto.EmpresaDTO;
import com.happy.happymachine.model.Empresa;
import com.happy.happymachine.repository.EmpresaRepository;
import com.happy.happymachine.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService{

	@Autowired
	private EmpresaRepository repository;
	
	@Override
	public void addEmpresa(EmpresaDTO empresaDTO) {
		Empresa empresa = new Empresa(empresaDTO);
		repository.save(empresa);
	}

	@Override
	public void uptEmpresa(EmpresaDTO empresaDTO, Integer id) {
		Optional<Empresa> oldEmpresa = repository.findById(id);
		if(oldEmpresa.isPresent()) {
			Empresa empresa = new Empresa(empresaDTO);
			empresa.setId(id);
			repository.save(empresa);
		}
	}

	@Override
	public void delEmpresa(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Empresa getEmpresa(Integer id) {
		Optional<Empresa> empresa = repository.findById(id);
		return empresa.orElse(null);
	}

	@Override
	public List<Empresa> getAllEmpresa() {
		Iterable<Empresa> empresasRep = repository.findAll();
		List<Empresa> empresas = new ArrayList<>();
		empresasRep.forEach(empresas::add);
		return empresas;
	}
}