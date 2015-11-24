package com.fafica.IOprojeto.Lista;

public class Link {
	public Object obj;
	public int id;
	
	public Link next;
	
	public Link (Object obj, int id) {
		this.obj = obj;
		this.id = id;
	}
	
	public String toString() {
		return "" + obj;
	}

}
