package com.play.check.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class RespostaCPFDTOTest {

	@Test
	void test() {
		RespostaCPFDTO dto = new RespostaCPFDTO();
		dto.setCpf("04136587901");
		dto.setMensagem("CPF válido.");
		dto.getCpf();
		dto.getMensagem();
		assertEquals("04136587901", dto.getCpf());
		assertEquals("CPF válido.", dto.getMensagem());
	}

}
