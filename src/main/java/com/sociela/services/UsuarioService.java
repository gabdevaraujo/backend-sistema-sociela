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
		Usuario usuario = new Usuario(null, objDTO.getNome(), objDTO.getEmail(), objDTO.getCpf(), objDTO.getRg(), objDTO.getDataNascimento(), objDTO.getNomePai(), objDTO.getNomeMae(), objDTO.getOrgao(), objDTO.getAceite());
		return usuario;
	}

	public UsuarioDTO toUsuarioDto(Usuario obj) {
		UsuarioDTO dto = new UsuarioDTO(obj);
		return dto;
	}

	public UsuarioDTO save(UsuarioDTO usuarioDTO) {		
		Usuario usuario = fromDto(usuarioDTO);
		return toUsuarioDto(repository.save(usuario));
	}

	

}
