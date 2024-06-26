package dto;

import java.time.LocalDate;

public record UsuarioDTO(
		String nome,
		String funcao,
		String cpf,
		String superv,
		LocalDate dataInic,
		LocalDate dataResc,
		String status,
		String nomeRed,
		String senha) {}