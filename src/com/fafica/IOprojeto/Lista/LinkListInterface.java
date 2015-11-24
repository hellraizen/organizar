package com.fafica.IOprojeto.Lista;

public interface LinkListInterface {
	
	public boolean isEmpty();
	
	public void insertLink(Object obj, int id);
	
	public Object deleteLink(int id);
	
	public Object find(int id);
	
	public void showList();

}
