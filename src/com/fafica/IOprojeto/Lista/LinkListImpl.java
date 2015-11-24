package com.fafica.IOprojeto.Lista;

public class LinkListImpl implements LinkListInterface {
private Link first;
	
	public LinkListImpl() {
		first = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void insertLink(Object obj, int id) {
		Link newLink = new Link(obj, id);
		newLink.next = first;
		first = newLink;
	}
	
	public Object find(int id) {
		Link current = first;
		while (current.id != id) {
			if (current.next == null) {
				return null;
			} else {
				current = current.next;
			}
		}
		return current;
	}
	
	public void showList() {
		Link current = first;
		while (current != null) {
			System.out.println("id " + current.id + 
					" , " + current.toString());
			current = current.next;
		}
	}
	
	public Object deleteLink(int id) {
		Link current = first;
		Link previous = first;
		
		while (current.id != id) {
			if (current.next == null) {
				return null;
			} else {
				previous = current;
				current = current.next;
			}
		}
			
		if (current == first) {
			first = first.next;
		} else {
			previous.next = current.next;
		}
		return current;
	}

}
