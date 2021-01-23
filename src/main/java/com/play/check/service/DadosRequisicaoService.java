package com.play.check.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.play.check.dto.RequisicaoCNPJDTO;
import com.play.check.dto.RequisicaoCPFDTO;
import com.play.check.dto.RespostaCNPJDTO;
import com.play.check.dto.RespostaCPFDTO;
import com.play.check.dto.RespostaDadosDTO;
import com.play.check.exceptions.RegraException;
import com.play.check.model.Cliente;
import com.play.check.model.DadoRequisicao;
import com.play.check.repository.DadoRequisicaoRepository;
import com.play.check.util.ValidarCPF_CNPJ;



@Service
public class DadosRequisicaoService {

	@Autowired
	private DadoRequisicaoRepository repository;
	
	@Autowired
	private ClienteService clienteService;
	
	public List<DadoRequisicao> litarTodosDados(){
		return repository.findAll();
	}
	
	public List<RespostaDadosDTO> buscarPorData(int mes, String nome){
		List<RespostaDadosDTO> dados = new ArrayList<RespostaDadosDTO>();
		RespostaDadosDTO dado = new RespostaDadosDTO();
		List<DadoRequisicao>  listaDadoRequisicao= repository.findAllDataRequisica(mes, nome);
		
		for (DadoRequisicao item : listaDadoRequisicao) {
			dado.setIdDados(item.getId());
			dado.setDataRequisicao(item.getDataRequisicao());
			dado.setIdCliente(item.getCliente().getId());
			dado.setNomeCliente(item.getCliente().getNome());
			dados.add(dado);
			
		}
		
		return dados;
	}
	
	public RespostaCPFDTO validarCPF(RequisicaoCPFDTO dado) throws RegraException {
		DadoRequisicao requisicao =new DadoRequisicao();
		RespostaCPFDTO respostaCPFDTO = new RespostaCPFDTO();
		
		Optional<Cliente> clienteOptional = clienteService.bucarPorID(dado.getIdCliente());
		if (!clienteOptional.isPresent()) {
			throw new RegraException("Cliente não encontrado!");
		}
		
		
		
		requisicao.setCliente(clienteOptional.get());
		
		if (ValidarCPF_CNPJ.isValidCpf(dado.getCpf()) == false ) {
			respostaCPFDTO.setMensagem("CPF inválido.");
			respostaCPFDTO.setCpf(dado.getCpf());
		}
		
		if (ValidarCPF_CNPJ.isValidCpf(dado.getCpf()) == true ) {
			respostaCPFDTO.setMensagem("CPF válido.");
			respostaCPFDTO.setCpf(dado.getCpf());
		}
		
		DadoRequisicao dadoSalvo = repository.save(requisicao);
		
		return respostaCPFDTO;
		
	}
	
	public RespostaCNPJDTO validarCNPJ(RequisicaoCNPJDTO dado) throws RegraException {
		DadoRequisicao requisicao =new DadoRequisicao();
		RespostaCNPJDTO respostaCNPJDTO= new RespostaCNPJDTO();
		
		Optional<Cliente> clienteOptional = clienteService.bucarPorID(dado.getIdCliente());
		if (!clienteOptional.isPresent()) {
			throw new RegraException("Cliente não encontrado!");
		}
		
		
		
		requisicao.setCliente(clienteOptional.get());
		
		if (ValidarCPF_CNPJ.isValidCnpj(dado.getCnpj()) == false ) {
			respostaCNPJDTO.setMensagem("CNPJ inválido.");
			respostaCNPJDTO.setCnpj(dado.getCnpj());
		}
		
		if (ValidarCPF_CNPJ.isValidCnpj(dado.getCnpj()) == true ) {
			respostaCNPJDTO.setMensagem("CNPJ válido.");
			respostaCNPJDTO.setCnpj(dado.getCnpj());
		}
		
		DadoRequisicao dadoSalvo = repository.save(requisicao);
		
		return respostaCNPJDTO;
		
	}
}
