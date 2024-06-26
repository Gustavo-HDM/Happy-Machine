package model;

import java.time.LocalDate;

import dto.UsuarioDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "bigint(6)")
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "funcao")
	private String funcao;
	
	@Column(name = "cpf", columnDefinition = "varchar(14)")
	private String cpf;
	
	//TODO POSSIBILIDADE DE ASSOCIAÇÃO
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
	
	public Usuario() {}
	
	public Usuario(UsuarioDTO usuario) {
		this.nome = usuario.nome();
		this.funcao = usuario.funcao();
		this.cpf = usuario.cpf();
		this.superv = usuario.superv();
		this.dataInic = usuario.dataInic();
		this.dataResc = usuario.dataResc();
		this.status = usuario.status();
		this.nomeRed = usuario.nomeRed();
		this.senha = usuario.senha();
	}
}