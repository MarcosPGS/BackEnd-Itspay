package com.play.check.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.play.check.model.DadoRequisicao;
@ExtendWith(SpringExtension.class)
@DataJpaTest
class DadoRequisicaoRepositoryTest {

	@Autowired
    private DadoRequisicaoRepository repository;
	@Test
	void testFindAllDataRequisica() {
		String nome = "marcos";
		int mes = 1;
		
		List<DadoRequisicao> dados = repository.findAllDataRequisica(mes, nome);
		assertNotNull(dados);
	}

}
