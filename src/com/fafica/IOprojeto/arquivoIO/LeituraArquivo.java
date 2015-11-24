package com.fafica.IOprojeto.arquivoIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;



public class LeituraArquivo {

	Path path = Paths
			.get("C:/Users/Alternativo8/git/organizar/src/com/fafica/IOprojeto/txt/cidades.txt");
	Charset utf8 = StandardCharsets.UTF_8;

	public String[] leitura( ) throws IOException {
		
	
		ArrayList<String> arrayLocal = new ArrayList<String>();
		
		
		try (BufferedReader ler = Files.newBufferedReader(path, utf8))  {
			String linha = null;
			while ((linha = ler.readLine())!= null ) {
			
				System.out.println("cheguei aqui");

			String dado = linha;
			
			 arrayLocal.add(dado);
			}
		}
		
		String[] dados = new String[arrayLocal.size()];
		int index=-1;
		for (String string : arrayLocal) {
			dados[++index]=string;
		}
		
		return dados;
	}

}
