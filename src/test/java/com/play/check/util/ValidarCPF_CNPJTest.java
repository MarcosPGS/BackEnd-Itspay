package com.play.check.util;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class ValidarCPF_CNPJTest {

	@Autowired
	private ValidarCPF_CNPJ validarCPF_CNPJ;
	@Test
	void testIsValidCpf() {
		boolean isFalse = validarCPF_CNPJ.isValidCpf("81807702061");
		boolean isTrue = validarCPF_CNPJ.isValidCpf("81807702065");
		assertEquals(true, isTrue);
		assertEquals(false, isFalse);
	}

	@Test
	void testIsValidCnpj() {
		boolean isFalse = validarCPF_CNPJ.isValidCnpj("29367633000110");
		boolean isTrue = validarCPF_CNPJ.isValidCnpj("29367633000114");
		assertEquals(true, isTrue);
		assertEquals(false, isFalse);
	}

}
