package com.sociela.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sociela.domain.Usuario;
import com.sociela.dto.UsuarioDTO;
import com.sociela.repositories.UsuarioRepository;
import com.sociela.resources.exceptions.UsuarioNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll(){
		List<Usuario> usuarios = repository.findAll();
		return usuarios;
	}
	
	public Usuario findByCpf(String cpf) {
		
		Optional<Usuario> obj = repository.finByCpf(cpf);		
		return obj.orElse(null);
	}
	
	public Usuario fromDto(UsuarioDTO objDTO) {
		Usuario usuario = new Usuario(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), objDTO.getCpf());
		return usuario;
	}

	

}
