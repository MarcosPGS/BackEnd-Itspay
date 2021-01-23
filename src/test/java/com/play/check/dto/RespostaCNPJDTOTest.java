package com.play.check.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class RespostaCNPJDTOTest {

	@Test
	void test() {
		RespostaCNPJDTO dto = new RespostaCNPJDTO();
		dto.setCnpj("39213861000193");
		dto.setMensagem("CNPJ válido.");
		dto.getCnpj();
		dto.getMensagem();
		assertEquals("39213861000193", dto.getCnpj());
		assertEquals("CNPJ válido.", dto.getMensagem());
	}

}
