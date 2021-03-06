//package com.play.check.resource;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.play.check.dto.RequisicaoCNPJDTO;
//import com.play.check.dto.RequisicaoCPFDTO;
//import com.play.check.dto.RespostaCNPJDTO;
//import com.play.check.dto.RespostaCPFDTO;
//import com.play.check.dto.RespostaDadosDTO;
//import com.play.check.model.Cliente;
//import com.play.check.model.DadoRequisicao;
//import com.play.check.service.DadosRequisicaoService;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = DadoRequisicaoResource.class)
//class DadoRequisicaoResourceTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Autowired
//	private ObjectMapper objectMapper;
//
//	@MockBean
//	private DadosRequisicaoService service;
//
//	@Autowired
//	private DadoRequisicaoResource dadoRequisicaoResource;
//
//	@Before
//	public void setUp() {
//		this.mockMvc = MockMvcBuilders.standaloneSetup(dadoRequisicaoResource).build();		
//	}
//
//	@Test
//	void testListarTodos() throws Exception {
//		Cliente cliente = new Cliente();
//		cliente.setDataAtualizacao(LocalDate.now());
//		cliente.setDataCadastro(LocalDate.now());
//		cliente.setId(1l);
//		cliente.setNome("FULANO");
//		cliente.setPassword("12345678");
//		cliente.setUsername("fulano01");
//		DadoRequisicao dado = new DadoRequisicao();
//		dado.setCliente(cliente);
//		dado.setDataRequisicao(LocalDate.now());
//		dado.setId(1l);
//		
//		List<DadoRequisicao> listaDadoRequisicao = new ArrayList<>();
//		listaDadoRequisicao.add(dado);
//		
//		Mockito.when(service.litarTodosDados()).thenReturn(listaDadoRequisicao);
//		
//		String url = "/v1/api/dados";
//		
//		MvcResult mvc = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
//		
//		String atualJsonResponse = mvc.getResponse().getContentAsString();
//		
//		String expectativaJsonresponse = objectMapper.writeValueAsString(listaDadoRequisicao);
//		
//		assertThat(atualJsonResponse).isEqualToIgnoringWhitespace(expectativaJsonresponse);
//	}
//
//	@Test
//	void testListarPorData() throws Exception {
//		int mes = 1;
//		String nome = "marcos";
//		
//		RespostaDadosDTO dtoResposta = new RespostaDadosDTO();
//		dtoResposta.setDataRequisicao(LocalDate.now());
//		dtoResposta.setIdCliente(1l);
//		dtoResposta.setIdDados(1l);
//		dtoResposta.setNomeCliente("Fulano");
//		
//		List<RespostaDadosDTO> listaResposta = new ArrayList<>();
//		listaResposta.add(dtoResposta);
//		
//		
//		Mockito.when(service.buscarPorData(mes, nome)).thenReturn(listaResposta);
//		
//		String url = "/v1/api/dados/pesquisar";
//		
//		mockMvc.perform(get(url)).andExpect(status().is4xxClientError()).andReturn();
//	}
//
//	@Test
//	void testValidarCPF() throws JsonProcessingException, Exception {
//		RequisicaoCPFDTO dto = new RequisicaoCPFDTO();
//		dto.setCpf("03149028131");
//		dto.setIdCliente(1l);
//		
//		RespostaCPFDTO resposta = new RespostaCPFDTO();
//		resposta.setCpf("03149028131");
//		resposta.setMensagem("ok..");
//		
//			Mockito.when(service.validarCPF(dto)).thenReturn(resposta);
//		
//		String url = "/v1/api/dados/cpf";
//		
//		MvcResult mvc = (MvcResult) mockMvc.perform(post(url).contentType("application/json")
//				.content(objectMapper.writeValueAsString(resposta))).andExpect(status().is2xxSuccessful()).andReturn();
//	}
//	
//	@Test
//	void testValidarCNPJ() throws JsonProcessingException, Exception {
//		RequisicaoCNPJDTO dto = new RequisicaoCNPJDTO();
//		dto.setCnpj("01253698547801");
//		dto.setIdCliente(1l);
//		
//		RespostaCNPJDTO resposta = new RespostaCNPJDTO();
//		resposta.setCnpj("01253698547801");
//		resposta.setMensagem("ok....");
//		
//			Mockito.when(service.validarCNPJ(dto)).thenReturn(resposta);
//		
//		String url = "/v1/api/dados/cnpj";
//		
//		MvcResult mvc = (MvcResult) mockMvc.perform(post(url).contentType("application/json")
//				.content(objectMapper.writeValueAsString(resposta))).andExpect(status().is2xxSuccessful()).andReturn();
//	}
//
//}
