/**
 * 
 */

/**
 * @author benja
 *
 */




public interface QueueInterface<E> {
	
	public void enqueue(E e);
	public E dequeue();
	public int size();
	public boolean isEmpty();
	public E front();

}
