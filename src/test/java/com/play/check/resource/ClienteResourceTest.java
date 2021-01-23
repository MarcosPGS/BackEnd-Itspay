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
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.play.check.model.Cliente;
//import com.play.check.service.ClienteService;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = ClienteResource.class)
//class ClienteResourceTest {
//
//	 @Autowired
//	    private MockMvc mockMvc;
//	 
//	 @Autowired
//	 private ObjectMapper objectMapper;
//	 
//	 @MockBean
//	 private ClienteService service;
//	 
//	 @Autowired
//		private ClienteResource clienteResource;
//	 
//	 @Before
//		public void setUp() {
//			this.mockMvc = MockMvcBuilders.standaloneSetup(clienteResource).build();
//		}
//	 
//	 
//	@Test
//	void testListarCliente() throws Exception {
//		Cliente cliente = new Cliente();
//		LocalDate data;
//		cliente.setDataAtualizacao(LocalDate.now());
//		cliente.setDataCadastro(LocalDate.now());
//		cliente.setId(1l);
//		cliente.setNome("FULANO");
//		cliente.setPassword("12345678");
//		cliente.setUsername("fulano01");
//		
//		List<Cliente> listaClientes = new ArrayList<>();
//		listaClientes.add(cliente);
//		
//		Mockito.when(service.listarTodosCliente()).thenReturn(listaClientes);
//		
//		String url = "/v1/api/clientes";
//		
//		MvcResult mvc = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
//		
//		String atualJsonResponse = mvc.getResponse().getContentAsString();
//		
//		String expectativaJsonresponse = objectMapper.writeValueAsString(listaClientes);
//		
//		assertThat(atualJsonResponse).isEqualToIgnoringWhitespace(expectativaJsonresponse);
//		
//	}
//
//	@Test
//	void testSalvarCliente() throws Exception {
//		Cliente cliente = new Cliente();
//		LocalDate data;
//		cliente.setDataAtualizacao(LocalDate.now());
//		cliente.setDataCadastro(LocalDate.now());
//		cliente.setId(1l);
//		cliente.setNome("FULANO");
//		cliente.setPassword("12345678");
//		cliente.setUsername("fulano01");
//		
//		Cliente cliente2 = new Cliente();
//		cliente2.setDataAtualizacao(LocalDate.now());
//		cliente2.setDataCadastro(LocalDate.now());
//		cliente2.setId(1l);
//		cliente2.setNome("FULANO");
//		cliente2.setPassword("12345678");
//		cliente2.setUsername("fulano01");
//		
//		Mockito.when(service.salvar(cliente)).thenReturn(cliente2);
//		
//		String url = "/v1/api/clientes";
//		
//		MvcResult mvc = (MvcResult) mockMvc.perform(post(url).contentType("application/json")
//				.content(objectMapper.writeValueAsString(cliente2))).andExpect(status().is2xxSuccessful()).andReturn();
//		
//	}
//
//}
