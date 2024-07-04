package com.happy.happymachine.service;

import java.util.List;

import com.happy.happymachine.dto.UsuarioResponseDTO;
import com.happy.happymachine.model.Usuario;

public interface UsuarioService {
	public void addUsuario(UsuarioResponseDTO usuarioDTO);
	public void uptUsuario(UsuarioResponseDTO usuarioDTO, Integer id);
	public void delUsuario(Integer id);
	public Usuario getUsuario(Integer id);
	public List<Usuario> getAllUsuario();
}