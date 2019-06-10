
//CS278
//Lab 1
//Book.java
//Author: Benjamin Nutter
//1-29-19

import java.util.*;

public class BookTable {

	private Book[] keys;
	private Book[] data;
	private boolean[] used;
	private int num;
	private int size;

	public BookTable(int newSize) {

		keys = new Book[newSize];
		data = new Book[newSize];

		used = new boolean[newSize];

		num = 0;

		size = newSize;

		for (int i = 0; i < used.length; i++) {

			data[i] = null;
			used[i] = false;

		}

	}

	private int hash(Book key) {

		return key.getISBN() % data.length;

	}

	private int findIndex(Book e) {

		int idx = hash(e);

		int counter = 0;

		while (counter < data.length && used[idx] == true) {

			if (e == data[idx])
				return idx;

			idx++;
			counter++;

		}

		return -1;

	}

	public void ensureCapacity(int _size) {

		if (size < _size) {

			BookTable temp = new BookTable(size);

			for (int x = 0; x < size; x++)

				temp.put(keys[x]);

			data = temp.data;
			keys = temp.keys;
			used = temp.used;
			size = _size;

		}

	}

	public void put(Book e) {

		int idx = hash(e);

		if (num > data.length) {

			BookTable temp = new BookTable((num + 1) * 2);

			for (int x = 0; x < data.length; x++)

				temp.put(data[x]);

			keys = temp.keys;
			data = temp.data;
			used = temp.used;
			num = temp.num;

		}

		while (data[idx] != null) {

			idx++;
		}

		data[idx] = e;

		num++;
	}

	public int search(int ISBN) {

		int idx = ISBN % data.length;
		if (data[idx] != null)
			return idx;

		while (true) {

			if (data[idx] == null)

				return -1;

			if (data[idx].getISBN() == ISBN)

				return idx;

			idx++;
		}
	}

	public boolean remove(int ISBN) {

		if (search(ISBN) == -1)

			return false;

		int idx = search(ISBN);

		used[idx] = true;
		data[idx] = null;
		num--;
		return true;

	}

	public static void main(String[] args) {

		BookTable testThing = new BookTable(5);

		Book crap = new Book();

		Book crapper = new Book();

		Book crappier = new Book();

		Book crappest = new Book();

		Book crappiest = new Book();

		Book craptastic = new Book();

		crap.setISBN(1);

		crapper.setISBN(2);

		crappier.setISBN(3);

		crappest.setISBN(4);

		crappiest.setISBN(5);

		testThing.put(crap);

		testThing.put(crapper);

		testThing.put(crappier);

		testThing.put(crappest);

		System.out.println(testThing.search(1));

		System.out.println(testThing.search(2));

		System.out.println(testThing.search(3));

		System.out.println(testThing.search(5));

		System.out.println(testThing.remove(3));

		System.out.println(testThing.search(3));

	}
}
