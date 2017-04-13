package com.fkujikis.playground.linkedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	private LinkedList<String> list;
	
	@Before
	public void initList(){
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
	}
	
	@Test
	public void testAddRemove() {
		assertEquals(4, list.getSize());
		assertArrayEquals(new Object[]{"A","B","C","D"}, list.toForwardArray());
		assertArrayEquals(new Object[]{"D","C","B","A"}, list.toReverseArray());
		
		list.remove("C");
		assertEquals(3, list.getSize());
		assertArrayEquals(new Object[]{"A","B","D"}, list.toForwardArray());
		assertArrayEquals(new Object[]{"D","B","A"}, list.toReverseArray());
		
		list.clear();
		assertEquals(0, list.getSize());
		assertArrayEquals(new Object[]{}, list.toForwardArray());
	}
	
	@Test
	public void testInsertAfter(){
		
		list.insertAfter("C", "C1");
		assertEquals(5, list.getSize());
		
		assertArrayEquals(new Object[]{"A","B","C","C1","D"}, list.toForwardArray());
		assertArrayEquals(new Object[]{"D","C1","C","B","A"}, list.toReverseArray());		
		
		
	}

}
