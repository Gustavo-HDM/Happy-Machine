package com.happy.happymachine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.happy.happymachine.dto.EquipamentoDTO;
import com.happy.happymachine.model.Equipamento;
import com.happy.happymachine.service.EquipamentoService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/equipamento")
@CrossOrigin(origins = "*")
public class EquipamentoController {

	@Autowired
	private EquipamentoService service;
	
	@PostMapping
	public ResponseEntity<Equipamento> addEquip(@RequestBody EquipamentoDTO equipamentoDTO) {
		service.addEquip(equipamentoDTO);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Equipamento> getEquip(@RequestParam Integer id) {
		Equipamento equipamento = service.getEquip(id);
		return ResponseEntity.ok(equipamento);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Equipamento>> getAllEquip() {
		List<Equipamento> equipamentos = service.getAllEquip();
		return ResponseEntity.ok(equipamentos);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Equipamento>	delEquip(@RequestParam Integer id) {
		service.delEquip(id);
		return ResponseEntity.ok().build();
	}
	
	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<Equipamento>	uptEquip(@RequestBody EquipamentoDTO equipamentoDTO, @RequestParam Integer id) {
		service.uptEquip(equipamentoDTO, id);
		return ResponseEntity.ok().build();
	}
}
