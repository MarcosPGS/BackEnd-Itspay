package com.play.check.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.play.check.model.Cliente;
import com.play.check.service.ClienteService;



@RestController
@RequestMapping(value = "v1/api/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarCliente(){
		List<Cliente> clientes = service.listarTodosCliente();
		if (clientes == null) {
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.ok(clientes);
	}
	
	@PostMapping
	public ResponseEntity<Object> salvarCliente( @RequestBody Cliente cliente){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(cliente));
			
		}
//		catch (RegraException e) {
//			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
