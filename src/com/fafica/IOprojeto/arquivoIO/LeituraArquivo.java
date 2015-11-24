package com.fafica.IOprojeto.arquivoIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LeituraArquivo {

	Path path; 
			
	Charset utf8 = StandardCharsets.UTF_8;

	public String[] leitura(String caminho ) throws IOException {
		
		path =  Paths.get(caminho);
		int contador = 0;
		String[] dados ;

		try (BufferedReader ler = Files.newBufferedReader(path, utf8)) {

			String linha1 = null;
			int index = -1;

			while ((ler.readLine()) != null) {

				contador++;

			}
			
			System.out.println(contador);
		dados = new String[contador];
			while ((linha1 = ler.readLine()) != null) {

			 dados[index++] = linha1;

			}
		}
		return dados;
	}

}
