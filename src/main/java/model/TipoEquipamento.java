package model;

import dto.TipoEquipamentoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tipo_equipamento")
public class TipoEquipamento {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "bigint(6)")
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "num_Marcadores")
	private byte numMarc;
	
	@Column(name = "sigla", columnDefinition = "varchar(2)")
	private String sigla;
	
	public TipoEquipamento() {}
	
	public TipoEquipamento(TipoEquipamentoDTO tipoEquipamento) {
		this.nome = tipoEquipamento.nome();
		this.numMarc = tipoEquipamento.numMarc();
		this.sigla = tipoEquipamento.sigla();
	}
}