package com.sociela.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.sociela.domain.Aceite;
import com.sociela.domain.Usuario;
import com.sociela.domain.enums.Orgaos;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotNull(message = "Campo Obrigatório")
	@Max(value = 80, message = "Tamanho m�ximo de 80 Caracteres")
	@Min(value = 10, message = "Tamanho m�ximo de 10 Caracteres")
	private String nome;
	
	@NotNull(message = "Campo Obrigatório")
	@Max(value = 80, message = "Tamanho m�ximo de 80 Caracteres")
	@Min(value = 10, message = "Tamanho m�ximo de 10 Caracteres")
	@Email
	private String email;
	
	@CPF
	private String cpf;
	private String rg;
	private LocalDate dataNascimento;
	private String nomePai;
	private String nomeMae;
	private Orgaos orgao;
	private String telefone1;
	private String telefone2;
	private String telefone3;

	private Aceite aceite;

	
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.cpf = usuario.getCpf();
		this.rg = usuario.getRg();
		this.nomePai = usuario.getNomePai();
		this.nomeMae = usuario.getNomeMae();
		this.orgao = usuario.getOrgao();
		this.aceite = usuario.getAceite();
		this.telefone1 = (String) ((usuario.getTelefones().toArray().length > 0) ? usuario.getTelefones().toArray()[0] : null);
		this.telefone2 = (String) ((usuario.getTelefones().toArray().length > 1) ? usuario.getTelefones().toArray()[1] : null);
		this.telefone3 = (String) ((usuario.getTelefones().toArray().length > 2) ? usuario.getTelefones().toArray()[2] : null);
		//this.telefones = usuario.getTelefones();
	}

	public UsuarioDTO() {
	}
}
