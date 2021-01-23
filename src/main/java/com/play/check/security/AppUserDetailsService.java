//package com.play.check.security;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.play.check.model.Cliente;
//import com.play.check.repository.ClienteRepository;
//
//
//
//@Service
//public class AppUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	private ClienteRepository repository;
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		 Optional<Cliente> clienteOptional = repository.findByUsername(username);
//		 Cliente cliente = clienteOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos"));
//		return User.builder().username(cliente.getUsername()).password(cliente.getPassword()).roles("ADMIN").build();
//	}
//	
//	
//
//}
