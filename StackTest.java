
public class StackTest {

	public static void main(String[] args) {

		LinkStack<Integer> kunga = new LinkStack<Integer>();
		ArraylistStack<Integer> chunga = new ArraylistStack<Integer>();

		// LinkStack test
		System.out.println(kunga.isEmpty());
		
		kunga.push(5);

		System.out.println(kunga.size());

		System.out.println(kunga.top());

		System.out.println(kunga.size());

		kunga.push(6);

		System.out.println(kunga.top());

		System.out.println(kunga.size());

		kunga.pop();

		System.out.println(kunga.top() + " " + kunga.size() + " " + kunga.isEmpty());

		// ArrayListStack tests

		System.out.println("\nArrayListStack tests");

		System.out.println(chunga.isEmpty());

		chunga.push(5);

		System.out.println(chunga.top());

		System.out.println(chunga.isEmpty());

		chunga.push(6);

		System.out.println(chunga.size());

		chunga.pop();

		System.out.println(chunga.top());

	}

}
