
import java.util.*;

public class LinkStack<E> implements StackInterface<E> {

	public SNode<E> topNode;
	public int nodeSize;

	public LinkStack() {

		topNode = null;
		nodeSize = 0;
	}
	
	/**
	 * removes the top element of the linkstack list
	 * 
	 * precondition: the list is not empty
	 * 
	 * 
	 * 
	 */

	@Override
	public E pop() {

		if (isEmpty())

			throw new EmptyStackException();

		E removal = topNode.data;

		topNode = topNode.node;

		nodeSize--;

		return removal;
	}

	
	/**
	 * returns the head value of the linkstack list
	 * 
	 * precondition: linklikst is not null
	 * 
	 */
	@Override
	public E top() {

		if (isEmpty())

			throw new EmptyStackException();

		return topNode.data;
	}

	
	/**
	 * returns the size of the linklist
	 * 
	 * precondition: linkedlist is not null
	 * 
	 */
	@Override
	public int size() {

		if (isEmpty())

			throw new EmptyStackException();

		return nodeSize;
	}

	
	/**
	 * returns whether or not the linkedlist is empty
	 * 
	 */
	@Override
	public boolean isEmpty() {

		return topNode == null;
	}
	
	/**
	 * adds a new element to the linked list
	 * 
	 * @param: e (generic class element)
	 * 
	 * no return values or precondition
	 * 
	*/
	@Override
	public void push(E e) {

		SNode<E> newNode = new SNode<E>();

		newNode.setData(e);

		newNode.node = topNode;

		topNode = newNode;

		nodeSize++;

	}

}
