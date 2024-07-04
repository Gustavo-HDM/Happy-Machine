package com.happy.happymachine.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.happymachine.dto.UsuarioResponseDTO;
import com.happy.happymachine.model.Usuario;
import com.happy.happymachine.repository.UsuarioRepository;
import com.happy.happymachine.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public void addUsuario(UsuarioResponseDTO usuarioDTO) {
		Usuario usuario = new Usuario(usuarioDTO);
		usuario.setId(gerarIdAleatorio());
		repository.save(usuario);
	}

	@Override
	public void uptUsuario(UsuarioResponseDTO usuarioDTO, Integer id) {
		Optional<Usuario> oldUsuario = repository.findById(id);
		if (oldUsuario.isPresent()) {
			Usuario usuario = new Usuario(usuarioDTO);
			usuario.setId(id);
			repository.save(usuario);
		}
	}

	@Override
	public void delUsuario(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Usuario getUsuario(Integer id) {
		Optional<Usuario> usuario = repository.findById(id);
		return usuario.orElse(null);
	}

	@Override
	public List<Usuario> getAllUsuario() {
		Iterable<Usuario> usuariosRep = repository.findAll();
		List<Usuario> usuarios = new ArrayList<>();
		usuariosRep.forEach(usuarios::add);
		return usuarios;
	}
	
	public Integer gerarIdAleatorio() {
		Random random = new Random();
		int randomId;
		do {
			randomId = 100000 + random.nextInt(900000);
		} while (repository.existsById(randomId));
		return randomId;
	}
}
