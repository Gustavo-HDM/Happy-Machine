package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.EmpresaDTO;
import jakarta.transaction.Transactional;
import model.Empresa;
import service.EmpresaService;

@RestController
@RequestMapping("/empresa")
@CrossOrigin(origins = "*")
public class EmpresaController {

	@Autowired
	private EmpresaService service;
	
	@PostMapping
	public ResponseEntity<Empresa> addEmpresa(@RequestBody EmpresaDTO empresaDTO) {
		service.addEmpresa(empresaDTO);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Empresa> getEmpresa(@PathVariable Integer id) {
		Empresa empresa = service.getEmpresa(id);
		return ResponseEntity.ok(empresa);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Empresa>> getAllEmpresa() {
		List<Empresa> empresas = service.getAllEmpresa();
		return ResponseEntity.ok(empresas);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Empresa> delEmpresa(@PathVariable Integer id) {
		service.delEmpresa(id);
		return ResponseEntity.ok().build();
	}
	
	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<Empresa> uptEmpresa(@RequestBody EmpresaDTO empresaDTO, @PathVariable Integer id) {
		service.uptEmpresa(empresaDTO, id);
		return ResponseEntity.ok().build();
	}
}