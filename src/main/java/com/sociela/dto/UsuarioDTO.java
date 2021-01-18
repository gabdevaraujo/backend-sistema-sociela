package com.sociela.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.sociela.domain.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotNull(message = "Campo Obrigatório")
	@Max(value = 80, message = "Tamanho máximo de 80 Caracteres")
	@Min(value = 10, message = "Tamanho máximo de 10 Caracteres")
	private String nome;
	
	@NotNull(message = "Campo Obrigatório")
	@Max(value = 80, message = "Tamanho máximo de 80 Caracteres")
	@Min(value = 10, message = "Tamanho máximo de 10 Caracteres")
	@Email
	private String email;
	
	//@CPF(message = "CPF inválido")
	private String cpf;
	
	
	private String telefone1;
	private String telefone2;
	private String telefone3;
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.cpf = usuario.getCpf();
		this.telefone1 = (String) ((usuario.getTelefones().toArray().length > 0) ? usuario.getTelefones().toArray()[0] : null);
		this.telefone2 = (String) ((usuario.getTelefones().toArray().length > 1) ? usuario.getTelefones().toArray()[1] : null);
		this.telefone3 = (String) ((usuario.getTelefones().toArray().length > 2) ? usuario.getTelefones().toArray()[2] : null);
		//this.telefones = usuario.getTelefones();
	}
}
