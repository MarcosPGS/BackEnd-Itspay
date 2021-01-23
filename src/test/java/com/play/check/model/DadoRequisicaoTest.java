package com.play.check.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class DadoRequisicaoTest {

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
		
		DadoRequisicao dado = new DadoRequisicao();
		dado.setCliente(cliente);
		dado.setDataRequisicao(LocalDate.now());
		dado.setId(1l);
		
		dado.getClass();
		
		dado.getCliente();
		dado.getDataRequisicao();
		dado.getId();
		
		assertEquals(cliente, dado.getCliente());
		assertEquals(LocalDate.now(), dado.getDataRequisicao());
	}

}
