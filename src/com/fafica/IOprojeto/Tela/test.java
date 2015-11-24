package com.fafica.IOprojeto.Tela;

import java.io.IOException;

import com.fafica.IOprojeto.arquivoIO.LeituraArquivo;

public class test {

	public static void main(String[] args) {
		LeituraArquivo ler = new LeituraArquivo();
		
		try {
			String [] teste =ler.leitura();
			
			for (String string : teste) {
				System.out.println(string);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
