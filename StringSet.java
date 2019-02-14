import java.util.*;

public class StringSet implements Cloneable {

	private String[] authors;
	private int capacity;

	public StringSet() {

		capacity = 2;

		authors = new String[2];

	}

	public StringSet(int _capacity) {

		capacity = _capacity;

		authors = new String[_capacity];

	}

	public StringSet(StringSet SS2) {

		if (SS2 == null)
			return;
		if (SS2 instanceof StringSet) {

			StringSet SS = (StringSet) SS2;

			capacity = SS.capacity;
			authors = SS.authors;
		} else {

			return;

		}

	}

	public int size() {

		int size = 0;

		for (int x = 0; x < authors.length; x++) {

			if (authors[x] != null)
				size++;

		}

		return size;

	}

	public int capacity() {

		return capacity;

	}

	public void add(String a) {

		int check = 0;

		if (a == null)
			return;

		// checks if capacity is sufficient, runs ensureCapacity if not

		for (int i = 0; i < capacity; i++)

			if (authors[i] != null)

				check++;

		if (check == capacity)

			ensureCapacity(check);

		// adds element to the array if there is an empty spot

		for (int x = 0; x < authors.length; x++) {

			if (authors[x] == null) {

				authors[x] = a;

				break;

			}

		}

	}

	public boolean contains(String a) {

		if (a == null)
			return false;

		// checks if specified element is in the array

		for (int x = 0; x < authors.length; x++)

			if (authors[x] == a)
				return true;

		return false;

	}

	public boolean remove(String a) {

		if (a == null)
			return true;

		// changes element to null if it the parameter exists in the array

		for (int x = 0; x < capacity; x++) {

			if (authors[x] == a) {

				authors[x] = null;

				return true;

			}
		}

		return false;

	}

	public void ensureCapacity(int minCap) {

		String[] moreAuthors;

		if (minCap <= 0)
			return;

		// if Capacity is too small, doubles the capacity, copies the elements
		// of the array to a temporary array, then copies the elements from the
		// temp back to the original with the new capacity
		if (minCap <= capacity) {

			minCap = capacity * 2;

			moreAuthors = Arrays.copyOf(authors, minCap);

			capacity = minCap;

			authors = Arrays.copyOf(moreAuthors, capacity);

		}

		else
			return;

	}

	public void addOrdered(String a) {

		int check = 0;

		if (a == null)
			return;

		String compare;

		// Insertion sort

		for (int i = 1; i < authors.length; i++) {

			int j = 0;
			compare = authors[i];

			for (j = i; j > authors.length; j--) {

				if (compare.compareTo(authors[j - 1]) < 0)

					authors[j] = authors[j - 1];

				else
					break;

				authors[j] = compare;

			}

		}

		// Method to check for sufficient space in array and add
		// a new element as necessary
		for (int k = 0; k < capacity; k++)

			if (authors[k] != null)

				check++;

		if (check == capacity)

			ensureCapacity(check);

		for (int x = 0; x < authors.length; x++) {

			if (authors[x] == null) {

				authors[x] = a;

				break;

			}

		}

	}

	public String toString() {

		String result = "";

		for (int x = 0; x < authors.length; x++)

			if (authors[x] != null)

				result = result + authors[x] + " ";

		return result + " Capacity: " + Integer.toString(capacity);

	}

	public static void main(String[] args) {

		StringSet moreStrings = new StringSet();

		moreStrings.add("Johnny");

		System.out.println(moreStrings.toString());

		moreStrings.add("Terry");

		System.out.println(moreStrings.toString());

		moreStrings.add("Will");

		System.out.println(moreStrings.toString());

		moreStrings.add("Harold");

		System.out.println(moreStrings.toString());

		System.out.println(moreStrings.remove("Terry"));

		moreStrings.addOrdered("Aaron");

		System.out.println(moreStrings.toString());

	}

}
