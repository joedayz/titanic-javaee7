package com.titanic.ventapasajes.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.titanic.ventapasajes.modelo.Grupo;
import com.titanic.ventapasajes.modelo.Usuario;
import com.titanic.ventapasajes.repositorio.UsuarioRepositorio;
import com.titanic.ventapasajes.util.cdi.CDIServiceLocator;

public class AppUserDetailsService implements UserDetailsService{

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UsuarioRepositorio usuarioRepositorio = CDIServiceLocator.getBean(UsuarioRepositorio.class);
		Usuario usuario = usuarioRepositorio.buscarUsuarioporEmail(email);
		UsuarioSistema user = null;
		if(usuario!=null){
			user = new UsuarioSistema(usuario, getGrupos(usuario));
		}
		
		return user;
	}

	private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario) {

		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		
		for(Grupo grupo : usuario.getGrupos()){
			authorities.add(new SimpleGrantedAuthority(grupo.getNombreGrupo().toUpperCase()));
		}
		
		return authorities;
	}

}
