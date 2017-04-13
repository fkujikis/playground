package com.fkujikis.playground.linkedlist;

public class LinkedList<T> {

	private LinkedListItem<T> first = null;
	private LinkedListItem<T> last = null;
	
	public int size = 0;
	
	public void add(T value){
		LinkedListItem<T> item = new LinkedListItem<T>();
		item.setValue(value);
		
		if(first == null){
			first = item;
			last = item;
		} else {
			item.setPrevious(last);
			last.setNext(item);
			last = item;
		}
		
		size++;
	}
	
	public void remove(T value){
		LinkedListItem<T> item = first.getNext();
		while(item != null){
			if(value.equals(item.getValue())){
				break;
			}
			item = item.getNext();
		}
		
		if(item != null){
			LinkedListItem<T> previous = item.getPrevious();
			LinkedListItem<T> next = item.getNext();
			previous.setNext(next);
			if(next != null){
				next.setPrevious(previous);
			}
			size--;
		}
	}
	
	public void clear(){
		first = null;
		last = null;
		size = 0;
	}
	
	public boolean contains(T value){
		return getIndexOf(value) > -1;
	}
	
	public void insertAfter(T value, T valueToInsert){
		LinkedListItem<T> item = first;
		LinkedListItem<T> insertAfter = null;
		while(item != null){
			if(value.equals(item.getValue())){
				insertAfter = item;
				break;
			}
			item = item.getNext();
		}
		
		if(insertAfter != null){
			LinkedListItem<T> toInsert = new LinkedListItem<T>();
			toInsert.setValue(valueToInsert);
			
			toInsert.setNext(insertAfter.getNext());
			toInsert.setPrevious(insertAfter);
			
			// Update previous of new next
			if(insertAfter.getNext() != null){
				insertAfter.getNext().setPrevious(toInsert);
			}
			
			// Update next of new previous
			insertAfter.setNext(toInsert);
			
			size++;
		}
		
	}
	
	public int getIndexOf(T value){
		if(first == null) return -1;
		
		int index = 0;
		
		LinkedListItem<T> item = first.getNext();
		while(item != null){
			if(value.equals(item.getValue())){
				return index;
			}
			item = item.getNext();
			index++;
		}

		return -1;
	}
	
	public int getSize(){
		return size;
	}
	
	public T getFirst(){
		return first == null ? null : first.getValue();
	}
	
	public T getLast(){
		return last == null ? null : last.getValue();
	}
	
	public Object[] toForwardArray(){
		Object[] array = new Object[size];
		LinkedListItem<T> item = first;
		int index = 0;
		
		while(item != null){
			array[index++] = item.getValue();
			item = item.getNext();
		}
		
		return array;
	}
	
	public Object[] toReverseArray(){
		Object[] array = new Object[size];
		LinkedListItem<T> item = last;
		int index = 0;
		
		while(item != null){
			array[index++] = item.getValue();
			item = item.getPrevious();
		}
		
		return array;
	}
	
}
