
public class DoublyLinkedListDummy {

	private DIntNode head;
	private DIntNode tail;

	public DIntNode getHead() {

		return head;

	}

	public DIntNode getTail() {

		return tail;

	}

	public void setHead(DIntNode node) {

		head = node;

	}

	public void setTail(DIntNode node) {

		tail = node;

	}

	/**
	 * default constructor for dummy class, sets the head and tail nodes to dummy
	 * nodes and links them togther
	 * 
	 * 
	 */
	public DoublyLinkedListDummy() {

		head = new DIntNode();

		tail = new DIntNode();

		head.setNext(tail);

		tail.setPrev(head);
	}

	/**
	 * adds value to end of list
	 * 
	 * @param element
	 * 
	 * 
	 * 
	 * 
	 */
	public void addEnd(int element) {

		DIntNode newNode = new DIntNode(element, tail, null);

		tail.setNext(newNode);
		tail = newNode;

	}

	/**
	 * 
	 * removes the head value
	 */
	public void removeHead() {

		DIntNode removedHead = head;

		if (removedHead != null) {

			removedHead.getNext().setPrev(null);

			head = removedHead.getNext();

		}

	}

	/**
	 * 
	 * counts the number of times value e occurs in list
	 * 
	 * @param e
	 * @return count
	 * 
	 * 
	 * tiem complexity = O(n)
	 */
	public int countOccurrence(int e) {

		DIntNode cursor;

		int count = 0;

		for (cursor = head; cursor != null; cursor = cursor.getNext()) {

			if (cursor.getData() == e)
				count++;

		}

		return count;

	}

	/**
	 * 
	 * deletes a node from list
	 * 
	 * @param point
	 */
	public void delete(DIntNode point) {

		DIntNode pointPrev = point.getPrev();

		DIntNode pointNext = point.getNext();

		pointNext.setPrev(pointPrev);

		pointPrev.setNext(pointNext);

	}

	/**
	 * 
	 * removes all occurrences of value e in list
	 * 
	 * @param e
	 * @return change
	 * 
	 * time complexity = O(n2)
	 */
	public boolean removeAll(int e) {

		DIntNode dummy = head.getNext();

		boolean change = false;

		if (head == null)

			return false;

		while (dummy != tail && dummy != null) {

			if (dummy.getData() == e) {

				delete(dummy);

				change = true;

			}

			dummy = dummy.getNext();

		}

		return change;

	}

	/**
	 * 
	 * 
	 * adds a node to the list
	 * 
	 * @param node
	 */
	public void add(DIntNode node) {

		if (head == null) {

			if (tail == null)

				head = node;

			tail = head;

		}

		else {

			tail.setNext(node);
			node.setPrev(tail);
			node.setNext(null);
			tail = node;

		}

	}

	/**
	 * returns the size of the list
	 * 
	 * @return size
	 */
	public int size() {

		int count = 0;

		for (DIntNode cursor = head; cursor != null; cursor = cursor.getNext())

			count++;

		return count;

	}

	/**
	 * 
	 * 
	 * creates a sublist of the linked list from beginIdx to endIdx
	 * predondition = beginIdx is not less than zero, and is less than both the list size and endIdx
	 * @param beginIdx
	 * @param endIdx
	 * @return
	 * 
	 * 
	 * time complexity = O(n)
	 */
	public DoublyLinkedListDummy sublist(int beginIdx, int endIdx) {

		if (beginIdx < 0 || beginIdx > size() - 1 || beginIdx > endIdx)

			return null;

		DoublyLinkedListDummy sub = new DoublyLinkedListDummy();
		DIntNode cursor = head;

		int countCursor = 0;

		while (cursor != null) {

			if (countCursor >= beginIdx && countCursor <= endIdx) {

				sub.add(cursor);
			}

			cursor = cursor.getNext();

			countCursor++;

		}

		return sub;

	}

	/**
	 * 
	 * 
	 * overrides toString method to print dummy nodes
	 */
	public String toString() {

		DIntNode currentFromHead = getHead(), currentFromTail = getTail();
		String list = "List: " + currentFromHead.getData(),
				reversedList = "Reversed List: " + currentFromTail.getData();

		currentFromHead = currentFromHead.getNext();
		currentFromTail = currentFromTail.getPrev();

		while (currentFromHead != null) {

			list += "<->" + currentFromHead.getData();
			currentFromHead = currentFromHead.getNext();

		}

		while (currentFromTail != null) {

			reversedList += "<->" + currentFromTail.getData();

			currentFromTail = currentFromTail.getPrev();

		}

		return list + "\n" + reversedList;
	}
}