import java.util.*;

public class LinkedQueue<E> implements QueueInterface<E> {

	private int elements;
	private SNode front;
	private SNode end;

	/**
	 * generic SNode class
	 */
	private class SNode {

		private SNode node;

		private E data;

	}

	/**
	 * default constructor for LinkedQueue list
	 */
	public LinkedQueue() {

		front = null;
		end = null;
		elements = 0;

	}

	/**
	 * checks if the list is empty or not
	 * 
	 * @return true or false
	 */
	public boolean isEmpty() {

		return front == null;

	}

	/**
	 * 
	 * returns the number of elements in the list
	 * 
	 * @return elements
	 * 
	 * @precon list is not empty
	 * 
	 */

	public int size() {

		if (isEmpty())

			return 0;

		return elements;

	}

	/**
	 * 
	 * returns the front of the list
	 * 
	 * @precon list is not empty
	 * 
	 * @return front.data
	 * 
	 */

	public E front() {

		if (isEmpty())
			throw new NoSuchElementException();

		return front.data;

	}

	/**
	 * 
	 * adds a new element to the end of the list
	 * 
	 * @param e - generic type element
	 * 
	 */
	public void enqueue(E e) {

		SNode newThingy = end;

		end = new SNode();

		end.data = e;

		end.node = null;

		if (isEmpty())
			front = end;

		else

			newThingy.node = end;

		elements++;

	}

	/**
	 * 
	 * removes the element at the front of the list and returns the element removed
	 * 
	 * @precon list is not empty
	 * 
	 * @return oldThingy
	 * @throws Exception 
	 * 
	 */
	public E dequeue() {

		if (isEmpty())

			throw new NoSuchElementException();
		
		if (front == end)
			
			throw new NullPointerException("There's only one element in this list!");

		E oldThingy = front.data;

		front = front.node;

		elements--;

		return oldThingy;
	}
}
