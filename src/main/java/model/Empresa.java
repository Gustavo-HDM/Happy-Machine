package model;

import dto.EmpresaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "bigint(6)")
	private Integer id;
	
	@Column(name = "nome_completo")
	private String nomeComp;
	
	@Column(name = "nome_fantasia")
	private String nomeFant;
	
	@Column(name = "cnpj", columnDefinition = "varchar(18)")
	private String cnpj;
	
	@Column(name = "endereco")
	private String endereco;
	
	//TODO POSSIBILIDADE DE ASSOCIAÇÃO
	@Column(name = "cidade")
	private String cidade;
	
	public Empresa() {}
	
	public Empresa(EmpresaDTO empresa) {
		this.nomeComp = empresa.nomeComp();
		this.nomeFant = empresa.nomeFant();
		this.cnpj = empresa.cnpj();
		this.endereco = empresa.endereco();
		this.cidade = empresa.cidade();
	}
}
