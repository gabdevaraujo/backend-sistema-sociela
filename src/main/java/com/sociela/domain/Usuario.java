package com.sociela.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;

	private String nome;
	private String email;
	private String cpf;
	
    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones = new HashSet<>();
    
    @OneToOne
    private Aceite aceite;
	
	public void setTelefones(String telefone) {
		telefones.add(telefone);
	}
	
	@Builder
	public Usuario(Integer id, String nome, String email, String cpf) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}
	
}
