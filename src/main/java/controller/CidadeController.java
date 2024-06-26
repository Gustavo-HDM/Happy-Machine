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

import dto.CidadeDTO;
import jakarta.transaction.Transactional;
import model.Cidade;
import service.CidadeService;

@RestController
@RequestMapping("/cidade")
@CrossOrigin(origins = "*")
public class CidadeController {

	@Autowired
	private CidadeService service;

	@PostMapping
	public ResponseEntity<Cidade> addCidade(@RequestBody CidadeDTO cidade) {
		service.addCidade(cidade);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{sigla}")
	public ResponseEntity<Cidade> getCidade(@PathVariable String sigla) {
		Cidade cidade = service.getCidade(sigla);
		return ResponseEntity.ok(cidade);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Cidade>> getAllCidade() {
		List<Cidade> cidades = service.getAllCidade();
		return ResponseEntity.ok(cidades);
	}
	
	@DeleteMapping("/{sigla}")
	public ResponseEntity<Cidade> delCidade(@PathVariable String sigla) {
		service.delCidade(sigla);
		return ResponseEntity.ok().build();
	}
	
	@Transactional
	@PutMapping("/{sigla}")
	public ResponseEntity<Cidade> uptCidade(@RequestBody CidadeDTO cidade, @PathVariable String sigla) {
		service.uptCidade(cidade, sigla);
		return ResponseEntity.ok().build();
	}
}