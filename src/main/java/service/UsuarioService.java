package service;

import java.util.List;

import dto.UsuarioDTO;
import model.Usuario;

public interface UsuarioService {
	public void addUsuario(UsuarioDTO usuarioDTO);
	public void uptUsuario(UsuarioDTO usuarioDTO, Integer id);
	public void delUsuario(Integer id);
	public Usuario getUsuario(Integer id);
	public List<Usuario> getAllUsuario();
}