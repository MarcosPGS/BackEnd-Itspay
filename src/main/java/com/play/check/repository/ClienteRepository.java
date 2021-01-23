package com.play.check.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.play.check.model.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

//	@Query(value = " SELECT u FROM Cliente u WHERE u.username =:username")
//	public Optional<Cliente> findByNome(@Param("username") String username);
	
	Optional<Cliente> findByUsername(String username);
}