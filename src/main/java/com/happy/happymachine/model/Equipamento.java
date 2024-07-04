package com.happy.happymachine.model;

import java.time.LocalDate;

import com.happy.happymachine.dto.EquipamentoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "equipamento")
public class Equipamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "bigint(4)")
	private Integer id;
	
	//O NOME SERÁ A JUNÇÃO ENTRE A SIGLA DO TIPO DE EQUIPAMENTO E O ID (AA6969)
	
	@Column(name = "nome", columnDefinition = "varchar(6)")
	private String nome;
	
	@Column(name = "tipo_equip", columnDefinition = "varchar(2)")
	private String tipoEquip;
	
	@Column(name = "data_inicio")
	private LocalDate dataInic;
	
	@Column(name = "status", columnDefinition = "varchar(7)")
	private String status;
	
	public Equipamento() {}
	
	public Equipamento(EquipamentoDTO equipamento) {
		this.nome = equipamento.nome();
		this.tipoEquip = equipamento.tipoEquip();
		this.dataInic = equipamento.dataInic();
		this.status = equipamento.status();
	}
}