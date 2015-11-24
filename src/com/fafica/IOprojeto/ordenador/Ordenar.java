package com.fafica.IOprojeto.ordenador;

public class Ordenar {

	public String[] ordenar(String[] array){
		
		String aux;
		
		for(int i = 0 ; i < array.length ; i++){
			for(int j = 0 ; j < array.length; j ++){
				if (array[i].compareTo(array[j])<0){
					aux= array[j];
					array[j]= array[i];
					array[i]= aux;
				}
			}
		}
		
		return array;
		
	}
}
