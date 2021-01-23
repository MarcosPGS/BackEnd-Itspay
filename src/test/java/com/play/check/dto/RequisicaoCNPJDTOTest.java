package com.play.check.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RequisicaoCNPJDTOTest {

	@Test
	void test() {
		RequisicaoCNPJDTO dto = new RequisicaoCNPJDTO();
		dto.setCnpj("95616520000130");
		dto.setIdCliente(1l);
		assertEquals("95616520000130", dto.getCnpj());
	}

}
