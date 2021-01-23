package com.play.check.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class RequisicaoCPFDTOTest {

	@Test
	void test() {
		RequisicaoCPFDTO dto = new RequisicaoCPFDTO();
		dto.setCpf("03145678901");
		dto.setIdCliente(1l);
		assertEquals("03145678901", dto.getCpf());
	}

}
