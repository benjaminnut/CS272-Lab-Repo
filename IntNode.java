
public class IntNode {

	private int data;
	private IntNode link;

	// default constructor
	public IntNode() {

		data = 0;
		link = null;

	}

	// constructor with arguments
	public IntNode(int d, IntNode n) {

		data = d;

		link = n;

	}

	public int getValue() {

		return data;

	}

	public IntNode getLink() {

		return link;

	}

	public void setValue(int v) {

		data = v;

	}

	public void setLink(IntNode l) {

		link = l;

	}

	/*
	 * returns the length of the given list
	 * 
	 * @param head
	 * 
	 * node for the beginning of list
	 * 
	 * @return
	 * 
	 * length - actual length of the list
	 * 
	 */
	public static int listLength(IntNode head) {

		IntNode point;

		int length = 0;

		for (point = head; point != null; point = point.link)

			length++;

		return length;

	}

	/*
	 * searches for the given value 'data' in the list starting at node 'head'
	 * 
	 * @param head, data
	 * 
	 * head- node at the beginning of linked list data- value to be searched in the
	 * list
	 * 
	 * @ return
	 * 
	 * true or false whether or not data is found in list
	 * 
	 */
	public static boolean searcher(IntNode head, int data) {

		if (head == null)

			return false;

		IntNode pointer;

		for (pointer = head; pointer != null; pointer = pointer.link)

			if (data == pointer.data)

				return true;

		return false;

	}

	/*
	 * adds value after the given node position
	 * 
	 * @param newPoint data to be added to the list
	 */
	public void addNodeAfter(int newpoint) {

		link = new IntNode(newpoint, link);

	}

	/*
	 * removes node after the given position in the linked list
	 * 
	 * @postcondition the item after the given node is removed
	 * 
	 */
	public void removeNodeAfter() {

		link = link.link;

	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * overrides String method to print linkedList in given format
	 * 
	 * @return result- formatted string value
	 * 
	 */
	public String toString() {

		String result = "";

		for (IntNode cursor = this; cursor != null; cursor = cursor.link) {

			if (result == "") {
				result = Integer.toString(cursor.getValue());
			} else
				result += " -> " + cursor.getValue();
		}

		return result;

	}

}
