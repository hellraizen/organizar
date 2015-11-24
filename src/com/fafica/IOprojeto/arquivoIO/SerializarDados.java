package com.fafica.IOprojeto.arquivoIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializarDados {
	
	public String path;
	public String nomeArquivo;
	public Object obj;
	
	public SerializarDados() {
	
	}
	
	public void gravarDadosSemArquivo(String path , String nomeAquivo,Object obj){
		try{
			FileOutputStream output = new FileOutputStream(path+nomeAquivo);
			ObjectOutputStream objoutput = new ObjectOutputStream(output);
			objoutput.writeObject(obj);
			objoutput.close();
			
		}catch( Exception e){
			System.err.println(e);
		}
	}
	public Object restauraDadosSemArquivo(String path, String nomeArquivo) throws IOException, ClassNotFoundException{
		FileInputStream input = new FileInputStream(path+nomeArquivo);
		ObjectInputStream objInput= new ObjectInputStream(input);
		obj = (Object) objInput.readObject();
		
		return obj;
	}
}

	
