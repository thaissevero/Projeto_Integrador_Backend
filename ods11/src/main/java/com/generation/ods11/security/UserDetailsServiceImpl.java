//Feito por @marirebecca

package com.generation.ods11.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.generation.ods11.model.Usuario;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {

		Optional<Usuario> usuario = repository.findByUsuario(username);
		usuario.orElseThrow(() -> new UsernameNotFoundException(username + " Não encontrado!"));
		
		return usuario.map(UserDetailsImpl::new).get();
	}
}
