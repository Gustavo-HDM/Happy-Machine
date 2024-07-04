package com.happy.happymachine.model;

import java.time.LocalDate;

import com.happy.happymachine.dto.UsuarioResponseDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {

	@Id
//	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "bigint(6)")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "funcao")
	private String funcao;

	@Column(name = "cpf", columnDefinition = "varchar(14)")
	private String cpf;

	// TODO POSSIBILIDADE DE ASSOCIAÇÃO
	@Column(name = "supervisor")
	private String superv;

	@Column(name = "data_inicio")
	private LocalDate dataInic;

	@Column(name = "data_rescisao")
	private LocalDate dataResc;

	@Column(name = "status")
	private String status;

	@Column(name = "nome_red", columnDefinition = "char(15)")
	private String nomeRed;

	@Column(name = "senha", columnDefinition = "char(6)")
	private String senha;

	public Usuario() {
	}

	public Usuario(UsuarioResponseDTO usuarioDTO) {
		this.nome = usuarioDTO.nome();
		this.funcao = usuarioDTO.funcao();
		this.cpf = usuarioDTO.cpf();
		this.superv = usuarioDTO.superv();
		this.dataInic = usuarioDTO.dataInic();
		this.dataResc = usuarioDTO.dataResc();
		this.status = usuarioDTO.status();
		this.nomeRed = usuarioDTO.nomeRed();
		this.senha = usuarioDTO.senha();
	}
}