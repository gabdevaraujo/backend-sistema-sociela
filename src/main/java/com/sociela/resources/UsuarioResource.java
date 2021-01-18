package com.sociela.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sociela.domain.Usuario;
import com.sociela.dto.UsuarioDTO;
import com.sociela.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		List<Usuario> usuarios = service.findAll();
        List<UsuarioDTO> usuariosDTO = usuarios.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(usuariosDTO);
    }
	
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<UsuarioDTO> findCpf(@PathVariable String cpf){
		Usuario usuario = service.findByCpf(cpf);
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		if(usuarioDTO != null) {
			return ResponseEntity.ok().body(usuarioDTO);
		}
		else return ResponseEntity.notFound().build();
		
	}
}
