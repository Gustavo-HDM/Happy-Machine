package com.happy.happymachine.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.happy.happymachine.dto.UsuarioResponseDTO;
import com.happy.happymachine.model.Usuario;
import com.happy.happymachine.service.UsuarioService;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping ("/add")
	public String adicionarUsuario(
            @RequestParam("nome") String nome,
            @RequestParam("funcao") String funcao,
            @RequestParam("cpf") String cpf,
            @RequestParam("superv") String superv,
            @RequestParam(value = "dataInic", required = false) LocalDate dataInic,
            @RequestParam(value = "dataResc", required = false) LocalDate dataResc,
            @RequestParam("status") String status,
            @RequestParam("nomeRed") String nomeRed,
            @RequestParam("senha") String senha,
            RedirectAttributes redirectAttributes) {
		
		UsuarioResponseDTO usuario = new UsuarioResponseDTO(nome, funcao, cpf, superv, dataInic, dataResc, status, nomeRed, senha);
        service.addUsuario(usuario);
        redirectAttributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso!");
        return "redirect:/usuario/all";
	}
//	public ResponseEntity<Usuario> addUsuario(@RequestBody UsuarioResponseDTO usuario) {
//		service.addUsuario(usuario);
//		return ResponseEntity.ok().build();
//	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id) {
		Usuario usuario = service.getUsuario(id);
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping ("/all")
	public String getAllUsuario(Model model) {
		model.addAttribute("usuarios", service.getAllUsuario());
		return "Usuarios";
	}
//	public ResponseEntity<List<Usuario>> getAllUsuario() {
//		List<Usuario> usuarios = service.getAllUsuario();
//		return ResponseEntity.ok(usuarios);
//	}
	
	@DeleteMapping ("/{id}") 
	public ResponseEntity<Usuario> delUsuario(@PathVariable Integer id) {
		service.delUsuario(id);
		return ResponseEntity.ok().build();
	}
	
	@Transactional
	@PutMapping ("/{id}")
	public ResponseEntity<Usuario> uptUsuario(@RequestBody UsuarioResponseDTO usuario, @PathVariable Integer id) {
		service.uptUsuario(usuario, id);
		return ResponseEntity.ok().build();
	}
}
