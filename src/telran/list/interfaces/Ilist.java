package telran.list.interfaces;


public interface Ilist<E> extends Iterable<E> {
	// interface Collection
	default boolean add(E element) {
		return add(size(), element);
	}


	void clear();


	default boolean contains(Object o) {
		return indexOf(o) >= 0;
	};


	default boolean isEmpty() {
		return size() == 0;
	}


	default boolean remove(Object o) {
		int index = indexOf(o);
		if (index < 0) {
			return false;
		}
		remove(index);
		return true;
	}


	int size();


	// interface List
	boolean add(int index, E element);


	E get(int index);


	int indexOf(Object o);


	int lastIndexOf(Object o);


	E remove(int index);


	E set(int index, E element);
}

