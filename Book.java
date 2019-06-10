//CS278
//Lab 1
//Book.java
//Author: Benjamin Nutter
//1-29-19

public class Book {

	private String title;
	private int AuthorNumber;
	private String[] Authors;
	private int ISBN;

	public Book() { // default constructor

		title = "";
		ISBN = 0;
		AuthorNumber = 0;
		Authors = new String[3];

	}

	public Book(String t) {// book constructor with one parameter

		title = t;
		ISBN = 0;
		AuthorNumber = 0;
		Authors = new String[3];

	}

	public Book(Book b1) { // Copy constructor

		title = b1.title;
		ISBN = b1.ISBN;
		AuthorNumber = b1.AuthorNumber;
		Authors = b1.Authors;

	}

//Accessors

	public String getTitle() {

		return title;

	}

	public int getAuthorNumber() {

		AuthorNumber = Authors.length;

		return AuthorNumber;

	}

	public int getISBN() {

		return ISBN;

	}

//Mutators
	public void setTitle(String t) {

		title = t;

	}

	public void setISBN(int i) {

		ISBN = i;

	}

	public boolean addAuthors(String a) { // addAuthors method to add new names to Authors array

		for (int x = 0; x < Authors.length; x++) {

			if (Authors[x] == null) {

				Authors[x] = a;

				return true;
			}

		}
		return false;
	}

	public boolean equals(Book b1) { // checks if one Book Object equals another

		if (b1.ISBN == ISBN)

			return true;
		else
			return false;

	}

	public static String[] getAllAuthors(Book b1, Book b2) {// Accessor to return all authors in Authors array

		String[] bookAuthors = new String[6];
		int ret = 0;
		for (int x = 0; x < b1.Authors.length; x++) {

			bookAuthors[x] = b1.Authors[x];
			ret = ret + 1;
		} // Adds author from Book1 to the bookAuthors array

		for (int y = 0; y < b2.Authors.length; y++)

			if (b2.Authors[y] != b1.Authors[y])

				bookAuthors[y + ret] = b2.Authors[y]; // Adds Authors from Book2 to array

		return bookAuthors;
	}

	public String toString() {

		String bookInfo = title + ", " + ISBN + ", " + AuthorNumber + ", " + Authors[0] + " " + Authors[1] + " "
				+ Authors[2];

		return bookInfo;// prints full Book info in specified format

	}

	public static void main(String[] args) {

		Book book1 = new Book();

		Book book2 = new Book("Wonga");

		Book book3 = new Book(book2);

		book1.setTitle("Jimbo");
		book1.setISBN(12304323);

		System.out.println("Number of authors for book 1" + book1.getAuthorNumber() + "\n");// testing the
																							// getAuthorNumber method

		book1.addAuthors("Jim");
		book1.addAuthors("Bob");
		book1.addAuthors("Bill");

		book2.addAuthors("John");
		book2.addAuthors("Bob");
		book2.addAuthors("Renfield");// testing the addAuthors method

		System.out.println("Book 1 is the same as Book 2: " + book1.equals(book2) + "\n");

		String[] allAuthors = Book.getAllAuthors(book1, book2);

		System.out.println("These are the names of all the authors for both books:\n");

		for (int x = 0; x < allAuthors.length; x++)
			System.out.println(allAuthors[x]); // add book1 and book2 authors to allAuthors array and
												// prints them using loop

		System.out.println("\nTesting accessor methods and toString method");
		System.out.println(book1.getTitle());
		System.out.println(book1.getISBN() + "\n");

		System.out.println(book1);

		System.out.println(book2);

		System.out.println(book3);
	}

}
