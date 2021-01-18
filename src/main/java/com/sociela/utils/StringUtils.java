package com.sociela.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sociela.domain.Usuario;

public class StringUtils {
	
	/*Caminho do arquivo exportado pelo DB
	/Foi necessário substituir no txt os espaços em branco por NULL*/
	private static final Path PATH = Path.of("C:\\Dev\\sociela\\src\\main\\resources\\static\\regsoc.csv");	
	private static List<Usuario> usuarios = new ArrayList<>();
	
	/*Este método retornará uma lista de usuários a partir de um arquivo.
	 * Basicamente vamos ler linha a linha um arquivo, fazer o split pelo caractere ';' e
	 * adicionar cada campo separado num array de Strings que chamei de u.
	 * Após isso, iteramos sobre o arquivo verificando se há uma próxima linha e, caso haja,
	 * armazendo-a na variável line. Quando der null não tem mais nada a ler.
	 * 
	 * O passo seguinte é instanciar um usuário, no caso, user, passando os dados que estão no
	 * array u. O construtor de Usuario recebe o id, nome, email e cpf, sendo que essa lista está sem o cpf
	 * por isso coloquei null. Como se pode observar, cada elemento do array representa um atributo do Usuario e assim
	 * pudemos utilizá-los para fazer essa instancia.
	 * Por fim, na lista usuarios, adicionamos esse user e retornamos a lista;*/
	public static List<Usuario> lerArquivo() {
		
		//Instancia um BufferedReader passando como caminho para o arquivo a contante PATH
		try (BufferedReader reader = Files.newBufferedReader(PATH)) {
			
			//Uma String para guardar uma linha do arquivo
			String line;
			Usuario user = null;

			//Enquanto o retorno da tentativa de de leitura de uma próxima linha for diferente de null
			while ((line = reader.readLine()) != null) {
				String[] u = line.split(";");
				
				user = new Usuario(null, u[0], u[1], limpaString(u[5]));
				user.getTelefones().addAll(Arrays.asList(limpaString(u[2]), limpaString(u[3]), limpaString(u[4])));
				usuarios.add(user);
			}
			System.out.println(usuarios.get(0));
			return usuarios;
		} catch (IOException e) {
			e.getMessage();
			return null;
		}
	}
	
	public static String limpaString(String s) {
		String text = s; 
		text = text.replaceAll("\\D", "");
		
	return text;
	}
}
