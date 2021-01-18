package com.sociela;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sociela.domain.Usuario;
import com.sociela.repositories.UsuarioRepository;
import com.sociela.utils.StringUtils;

@SpringBootApplication
public class SocielaApplication implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(SocielaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//System.out.println("Principal: " + StringUtils.lerArquivo());
		// Instancia os Usuarios de teste e salva no repositório
		/*Usuario u1 = new Usuario(null, "CEZAR AUGUSTO DE OLIVEIRA DIAS", "cezardias2012@hotmail.com", "12300396785");
		u1.getTelefones().addAll(Arrays.asList("7182676517", "7132703147", "7132703163"));
		System.out.println(u1);*/
		
		usuarioRepository.saveAll(StringUtils.lerArquivo());
		
		StringUtils.limpaString("asdsadsadsadsad");
		
	}

}
