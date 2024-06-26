package dto;

import java.time.LocalDate;

public record EquipamentoDTO(
		String nome,
		String tipoEquip,
		LocalDate dataInic,
		String status) {}