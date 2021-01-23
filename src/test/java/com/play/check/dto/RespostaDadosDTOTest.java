package com.play.check.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class RespostaDadosDTOTest {

	@Test
	void test() {
		RespostaDadosDTO dto = new RespostaDadosDTO();
		LocalDate data;
		dto.setDataRequisicao(LocalDate.now());
		dto.setIdCliente(1l);
		dto.setIdDados(1l);
		dto.setNomeCliente("Fulano");
		
		dto.getDataRequisicao();
		dto.getIdCliente();
		dto.getIdDados();
		dto.getNomeCliente();
		
		assertEquals(LocalDate.now(), dto.getDataRequisicao());
		assertEquals("Fulano",dto.getNomeCliente());
	}
}
