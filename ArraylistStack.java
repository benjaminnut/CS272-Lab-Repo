import java.util.*;

public class ArraylistStack<E> implements StackInterface<E> {

	public ArrayList<E> list;

	public ArraylistStack() {

		list = new ArrayList<E>();

	}
	
	/**
	 * 
	 * removes the element at the top of the arraylist
	 * 
	 * precondition: arraylist is not null
	 * 
	 * returns the removed element
	 * 
	 */
	public E pop() {

		if (list.isEmpty())
			
			throw new EmptyStackException();
		
		return list.remove(0);
	}

	/**
	 * adds a new item to the top of the list
	 * 
	 * @param: item (generic class element)
	 * 
	 */
	public void push(E item) {

		list.add(item);

	}

	/**
	 * returns the first item in the arraylist
	 * 
	 * @precondition: list is not null
	 * 
	 * 
	 */
	public E top() {

		if (list.isEmpty())

			throw new EmptyStackException();

		return list.get(0);
	}

	/**
	 * returns the size of the arraylist
	 * 
	 * @precondition: list is not null
	 * 
	 */
	public int size() {

		if (list.isEmpty())

			throw new EmptyStackException();

		return list.size();
	}

	/**
	 * returns whether or not the list is empty
	 * 
	 */
	public boolean isEmpty() {

		return (list.size() == 0);
	}

}
