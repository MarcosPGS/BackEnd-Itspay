//package com.play.check.service;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.play.check.model.Cliente;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//class ClienteServiceTest {
//	
//	@Autowired
//    private MockMvc mockMvc;
// 
// @Autowired
// private ObjectMapper objectMapper;
// 
// @MockBean
// private ClienteService service;
// 
// @Before
//	public void setUp() {
//		this.mockMvc = MockMvcBuilders.standaloneSetup(service).build();
//	}
//
//	@Test
//	void testListarTodosCliente() {
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
////		listaClientes = service.listarTodosCliente();
//		 assertNotNull(listaClientes);
//		
//	}
//
//	@Test
//	void testBucarPorID() {
//		Long id = 1l;
//		Optional<Cliente> cliente = Optional.empty();
//		
//		service.bucarPorID(id);
//		
//		Mockito.when(service.bucarPorID(id)).thenReturn(cliente);
//	}
//
//	@Test
//	void testSalvar() {
//		Cliente cliente = new Cliente();
//		LocalDate data;
//		cliente.setDataAtualizacao(LocalDate.now());
//		cliente.setDataCadastro(LocalDate.now());
//		cliente.setId(1l);
//		cliente.setNome("FULANO");
//		cliente.setPassword("12345678");
//		cliente.setUsername("fulano01");
//		
//		Mockito.when(service.salvar(cliente)).thenReturn(cliente);
//	}
//
//}
