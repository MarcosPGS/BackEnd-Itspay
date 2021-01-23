package com.play.check.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ClienteTest {

	@Test
	void test() {
		Cliente cliente = new Cliente();
		LocalDate data;
		cliente.setDataAtualizacao(LocalDate.now());
		cliente.setDataCadastro(LocalDate.now());
		cliente.setId(1l);
		cliente.setNome("FULANO");
		cliente.setPassword("12345678");
		cliente.setUsername("fulano01");
		
		cliente.getDataAtualizacao();
		cliente.getDataCadastro();
		cliente.getId();
		cliente.getNome();
		cliente.getPassword();
		cliente.getUsername();
		cliente.getClass();
		
		assertEquals(LocalDate.now(), cliente.getDataAtualizacao());
		assertEquals(LocalDate.now(), cliente.getDataCadastro());
		assertEquals("FULANO", cliente.getNome());
		assertEquals("12345678", cliente.getPassword());
		assertEquals("fulano01", cliente.getUsername());
		
		
	}

}
