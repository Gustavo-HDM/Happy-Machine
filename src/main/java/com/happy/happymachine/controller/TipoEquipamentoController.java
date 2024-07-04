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

import com.happy.happymachine.dto.TipoEquipamentoDTO;
import com.happy.happymachine.model.TipoEquipamento;
import com.happy.happymachine.service.TipoEquipamentoService;

@RestController
@RequestMapping("/tipoequipamento")
@CrossOrigin(origins = "*")
public class TipoEquipamentoController {

	@Autowired
	private TipoEquipamentoService service;
	
	@PostMapping
	public ResponseEntity<TipoEquipamento> addTipoEquip(@RequestBody TipoEquipamentoDTO tipoEquipamentoDTO) {
		service.addTipoEquip(tipoEquipamentoDTO);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoEquipamento> getTipoEquip(@RequestParam Integer id) {
		TipoEquipamento tipoEquipamento = service.getTipoEquip(id);
		return ResponseEntity.ok(tipoEquipamento);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<TipoEquipamento>> getAllTipoEquip() {
		List<TipoEquipamento> tipoEquipamentos = service.getAllTipoEquip();
		return ResponseEntity.ok(tipoEquipamentos);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<TipoEquipamento> delTipoEquip(@RequestParam Integer id) {
		service.delTipoEquip(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TipoEquipamento> uptTipoEquip(@RequestBody TipoEquipamentoDTO tipoEquipamentoDTO, @RequestParam Integer id) {
		service.uptTipoEquip(tipoEquipamentoDTO, id);
		return ResponseEntity.ok().build();
	}
}