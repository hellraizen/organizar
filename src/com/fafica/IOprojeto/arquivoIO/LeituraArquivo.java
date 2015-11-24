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

	Path path = Paths
			.get("/home/hellraizen/workspace/com.fafica.IOprojeto/src/com/fafica/IOprojeto/txt/vetores_alunos (1).txt");
	Charset utf8 = StandardCharsets.UTF_8;

	public String[] leitura() throws IOException {
		int contador = 0;
		String[] dados = new String[contador];

		try (BufferedReader ler = Files.newBufferedReader(path, utf8)) {

			String linha1 = null;
			int index = -1;

			while ((ler.readLine()) != null) {

				contador++;

			}
			System.out.println(contador);

			while ((linha1 = ler.readLine()) != null) {

				dados[index++] = linha1;

			}
		}
		return dados;
	}

}
