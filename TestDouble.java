
public class TestDouble {

	public static void main(String[] args) {

		DoublyLinkedListDummy testDummy = new DoublyLinkedListDummy();

		testDummy.addEnd(6);
		testDummy.addEnd(10);

		testDummy.addEnd(4);
		testDummy.addEnd(4);
		testDummy.addEnd(4);
		testDummy.addEnd(15);

		String testString = testDummy.toString();

		System.out.println(testString);

		testDummy.removeHead();

		System.out.println(testDummy);

		testString = testDummy.toString();

		System.out.println(testString);

		System.out.println(testDummy.countOccurrence(4));

		System.out.println(testDummy.countOccurrence(15));

		System.out.println(testDummy.countOccurrence(1));

		testDummy.removeAll(4);

		testString = testDummy.toString();

		System.out.println(testString);

		System.out.println(testDummy.sublist(0,4));

	}

}
