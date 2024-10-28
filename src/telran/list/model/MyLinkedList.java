package telran.list.model;

import java.util.Iterator;

import telran.list.interfaces.Ilist;

public class MyLinkedList<E> implements Ilist<E> {
	private Node<E> first;
	private Node<E> last;
	private int size;

	@Override
	public Iterator<E> iterator() {
		  return new Iterator<E>() {
	            private Node<E> current = first;

	            @Override
	            public boolean hasNext() {
	                return current != null;
	            }

	            @Override
	            public E next() {
	                E data = current.data;
	                current = current.next;
	                return data;
	            }
	        };
	}

	@Override
	public void clear() {
		first = null;
        last = null;
        size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean add(int index, E element) {
		if (index == size) {
			Node<E> newNode = new Node<E>(element, null, last);
			if (last != null) {
				last.next = newNode;
			} else {
				first = newNode;
			}
			last = newNode;
		} else {
			Node<E> node = getNodeByIndex(index);
			Node<E> newNode = new Node<E>(element, node, node.prev);
			node.prev = newNode;
			if (index != 0) {
				newNode.prev.next = newNode;
			} else {
				first = newNode;
			}
		}
		size++;
		return false;
	}


	@Override
	public E get(int index) {
		return getNodeByIndex(index).data;
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index);
		}
	}

	private Node<E> getNodeByIndex(int index) {
		checkIndex(index);
		Node<E> node;
		if (index < size / 2) {
			node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
		} else {
			node = last;
			for (int i = size - 1; i > index; i--) {
				node = node.prev;
			}
		}
		return node;
	}


	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E remove(int index) {
		checkIndex(index);
		Node<E> nodeRemove = getNodeByIndex(index);
		if(nodeRemove.prev != null) {
			nodeRemove.prev.next = nodeRemove.next;
		}else {
			first = nodeRemove.next;
		}
		if(nodeRemove.next != null) {
			nodeRemove.next.prev = nodeRemove.prev;
		}else {
			last = nodeRemove.prev;
		}
		size--;
		return nodeRemove.data;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

}
