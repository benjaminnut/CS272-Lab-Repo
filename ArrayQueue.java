
import java.util.*;

public class ArrayQueue<E> implements QueueInterface<E> {

	public int front;

	public int end;

	public E[] data;

	public int elements;

	/**
	 * 
	 * @param size
	 * 
	 *             constructor with parameter to set the size of the array
	 * 
	 */

	public ArrayQueue(int size) {

		elements = 0;

		data = (E[]) new Object[size];

		front = 0;

		end = data.length - 1;

	}

	/**
	 * 
	 * Adds element to the end of the array
	 * 
	 * @param e generic element to be added to the array
	 * 
	 * @precon array is not null
	 * 
	 */
	public void enqueue(E e) {

		if (elements == data.length)

			ensureCapacity();

		end = (end + 1) % data.length;

		data[end] = e;

		elements++;

	}

	/**
	 * removes and returns the element at the front of the array
	 * 
	 * @return
	 * 
	 * 		the element removed in the function
	 * 
	 * @precon array is not empty
	 * 
	 */
	public E dequeue() {

		if (isEmpty())

			throw new NoSuchElementException();

		E thingy = front();

		data[front] = null;

		front++;

		elements--;

		return thingy;

	}

	/**
	 * 
	 * returns the number of elements in the array
	 * 
	 * @precon array is not empty
	 * 
	 * @return elements
	 * 
	 */

	public int size() {

		if (isEmpty())

			return 0;

		return elements;
	}

	/**
	 * 
	 * checks if the array is empty or not
	 * 
	 * @return true or false
	 * 
	 */

	public boolean isEmpty() {

		return data[front] == null;
	}

	/**
	 * 
	 * returns the front of the array
	 * 
	 * @precon array is not empty
	 * 
	 * @return data[front]
	 * 
	 */

	public E front() {

		if (isEmpty())

			throw new NoSuchElementException();

		return data[front];

	}

	/**
	 * 
	 * doubles the capacity of the array
	 * 
	 * 
	 * 
	 */

	public void ensureCapacity() {

		E[] temp = (E[]) new Object[elements * 2];

		for (int x = front; x <= end; x++)

			temp[x - front] = data[x % elements];

		data = temp;

		front = 0;
		end = data.length - 1;

	}

	public int arrayLength() {

		return data.length;

	}

	public String toString() {

		String arrayString = "Current Array: ";

		for (int x = front; x <= end; x++)

			arrayString += "[" + data[x] + "] ";

		return arrayString;

	}

}
