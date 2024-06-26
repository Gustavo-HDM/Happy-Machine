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

import dto.UsuarioDTO;
import jakarta.transaction.Transactional;
import model.Usuario;
import service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping
	public ResponseEntity<Usuario> addUsuario(@RequestBody UsuarioDTO usuario) {
		service.addUsuario(usuario);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id) {
		Usuario usuario = service.getUsuario(id);
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping ("/all")
	public ResponseEntity<List<Usuario>> getAllUsuario() {
		List<Usuario> usuarios = service.getAllUsuario();
		return ResponseEntity.ok(usuarios);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Usuario> delUsuario(@PathVariable Integer id) {
		service.delUsuario(id);
		return ResponseEntity.ok().build();
	}
	
	@Transactional
	@PutMapping ("/{id}")
	public ResponseEntity<Usuario> uptUsuario(@RequestBody UsuarioDTO usuario, @PathVariable Integer id) {
		service.uptUsuario(usuario, id);
		return ResponseEntity.ok().build();
	}
}
