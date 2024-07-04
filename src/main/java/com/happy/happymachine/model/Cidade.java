package com.happy.happymachine.model;

import com.happy.happymachine.dto.CidadeDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cidade")
public class Cidade {

	//ID NÃO TERÁ UM VALOR GERADO,
	//ELE SERÁ DEFINIDO DURANTE O CADASTRO
	
	@Id
	@Column(name = "sigla", columnDefinition = "varchar(3)")
	private String sigla;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "uf")
	private String uf;
	
	public Cidade() {}
	
	public Cidade(CidadeDTO cidade) {
		this.sigla = cidade.sigla();
		this.nome = cidade.nome();
		this.uf = cidade.uf();
	}
}