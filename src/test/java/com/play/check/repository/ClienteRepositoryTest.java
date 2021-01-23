package com.play.check.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.play.check.model.Cliente;
@ExtendWith(SpringExtension.class)
@DataJpaTest
class ClienteRepositoryTest {

	@Autowired
    private ClienteRepository repository;
	@Test
	void testFindByUsername() {
		
		String username = "marcos";
		
		Optional<Cliente> dados = repository.findByUsername(username);
		assertNotNull(dados);
		
	}

}
