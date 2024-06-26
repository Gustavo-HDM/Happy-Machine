package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.UsuarioDTO;
import model.Usuario;
import repository.UsuarioRepository;
import service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public void addUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario(usuarioDTO);
		repository.save(usuario);
	}

	@Override
	public void uptUsuario(UsuarioDTO usuarioDTO, Integer id) {
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

}
