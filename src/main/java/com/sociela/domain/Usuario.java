package com.sociela.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.sociela.domain.enums.Orgaos;

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
	private String rg;
	private LocalDate dataNascimento;
	private String nomePai;
	private String nomeMae;
	private Orgaos orgao;
	
    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones = new HashSet<>();
    
    @OneToOne
	private Aceite aceite;
	
	@ManyToMany
	@JoinTable (name= "USUARIO_SERVICOS",
	joinColumns = @JoinColumn(name = "USUARIO_ID"),
	inverseJoinColumns = @JoinColumn(name = "SERVICO_ID"))
	private List<Servicos> servicos;
	
	public void setTelefones(String telefone) {
		telefones.add(telefone);
	}
	
	@Builder
	public Usuario(Integer id, String nome, String email, String cpf, String rg, LocalDate dataNascimento, String nomePai, String nomeMae, Orgaos orgao, Aceite aceite) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.orgao = orgao;
		this.aceite = aceite;
	}
	
	
}
