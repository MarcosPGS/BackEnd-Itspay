package com.play.check.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.play.check.dto.RequisicaoCNPJDTO;
import com.play.check.dto.RequisicaoCPFDTO;
import com.play.check.dto.RespostaDadosDTO;
import com.play.check.model.DadoRequisicao;
import com.play.check.service.DadosRequisicaoService;



@RestController
@RequestMapping(value = "v1/api/dados")
public class DadoRequisicaoResource {
	
	@Autowired
	private DadosRequisicaoService service;
	
	@GetMapping
	public ResponseEntity<List<DadoRequisicao>> listarTodos(){
		List<DadoRequisicao> dados = service.litarTodosDados();
		if (dados == null) {
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.ok(dados);
	}
	
	@GetMapping("/pesquisar")
	public ResponseEntity<Object> listarPorData(@RequestParam (value = "nome", required = false) String nome,
			@RequestParam (value = "mes", required = false) Integer mes){
		try {
			List<RespostaDadosDTO> dados = service.buscarPorData(mes, nome);
			return ResponseEntity.ok(dados);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping("/cpf")
	public ResponseEntity<Object> validarCPF( @RequestBody RequisicaoCPFDTO dado){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.validarCPF(dado));
			
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PostMapping("/cnpj")
	public ResponseEntity<Object> validarCNPJ( @RequestBody RequisicaoCNPJDTO dado){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.validarCNPJ(dado));
			
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
