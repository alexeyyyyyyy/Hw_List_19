package telran.list.tests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import telran.list.interfaces.Ilist;
import telran.list.model.MyLinkedList;


class ListTest {
	 private MyLinkedList<Integer> list;

	 @BeforeEach
	    public void setUp() {
	        list = new MyLinkedList<>();
	    }
	
	@Test
	void test() {
		Ilist<Integer> list = new MyLinkedList<Integer>();
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(3);
		list.add(7);
		list.add(null);
		list.add(9);
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		System.out.println(list.get(2));
		System.out.println(list.get(5));
		System.out.println(list.add(1, 144));
		System.out.println(list.get(1));
		list.clear();
		System.out.println(list.size());
		list.add(2);
		System.out.println(list.size());
		list.remove(0);
		System.out.println(list.size());
		
		
		
		 
		
//		System.out.println(list.indexOf(3));
//		System.out.println(list.lastIndexOf(3));
//		System.out.println(list.indexOf(null));
//		System.out.println(list.contains(11));
//		System.out.println(list.isEmpty());
//		System.out.println(list.remove(2));
//		System.out.println(list.size());
//		System.out.println(list.set(0, 11));
//		System.out.println(list.size());
//		System.out.println(list.get(0));
	}
	 @Test
	    public void testEmptyListByIterator() {
	        Iterator<Integer> iterator = list.iterator();
	        assertFalse(iterator.hasNext(), "Empty!");
	    }
	
	 @Test
	    public void testIteratorWithOneElement() {
	        list.add(0, 1);
	        Iterator<Integer> iterator = list.iterator();
	        assertTrue(iterator.hasNext(), "Iterator have elements");
	        assertEquals(1, iterator.next());
	        assertFalse(iterator.hasNext(), "Error, no elements in List");
	    }


}
