package com.fkujikis.playground.linkedlist;

public class LinkedListItem<T> {

	private T value;
	private LinkedListItem<T> next;
	private LinkedListItem<T> previous;
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public LinkedListItem<T> getNext() {
		return next;
	}
	public void setNext(LinkedListItem<T> next) {
		this.next = next;
	}
	public LinkedListItem<T> getPrevious() {
		return previous;
	}
	public void setPrevious(LinkedListItem<T> previous) {
		this.previous = previous;
	}
}
