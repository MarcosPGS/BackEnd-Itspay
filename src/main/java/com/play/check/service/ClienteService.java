package com.play.check.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.play.check.model.Cliente;
import com.play.check.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> listarTodosCliente(){
		return repository.findAll();
	}
	
	public Optional<Cliente> bucarPorID(long id){
		return repository.findById(id);
	}
	
	public Cliente salvar(Cliente c) {
//		BCryptPasswordEncoder gerador = new BCryptPasswordEncoder();
		Cliente cliente = new Cliente();
		
	cliente.setNome(c.getNome().toUpperCase());
	cliente.setUsername(c.getUsername());
//	cliente.setPassword(gerador.encode(c.getPassword()));
	cliente.setPassword(c.getPassword());
	
	Cliente clienteSalvo = repository.save(cliente);
	
	return clienteSalvo;
	
	}
}
