
public class QueueTest {

	public static void main(String[] args) {

		LinkedQueue<Integer> LinkTest = new LinkedQueue<Integer>();
		ArrayQueue<String> ArrayTest = new ArrayQueue<String>(10);

		System.out.println("LinkedQueue Method tests\n");

		System.out.println("Is the list empty? " + LinkTest.isEmpty());

		LinkTest.enqueue(5);

		LinkTest.enqueue(6);

		LinkTest.enqueue(8);

		LinkTest.enqueue(9);

		System.out.println("Is the list empty? " + LinkTest.isEmpty() + "\nSize of queue " + LinkTest.size()
				+ "\nFront of Queue " + LinkTest.front());

		LinkTest.dequeue();

		System.out.println("Size of list now: " + LinkTest.size() + "\nFront of list now: " + LinkTest.front());

		// Testing ArrayQueue methods

		System.out.println("\nArrayQueue Method tests\n");

		System.out.println("Is this array empty? " + ArrayTest.isEmpty());

		ArrayTest.enqueue("JonnyBoi");

		System.out.println(ArrayTest.arrayLength());

		System.out.println("Is this array empty? " + ArrayTest.isEmpty());
		System.out.println("Size of the array: " + ArrayTest.size());
		System.out.println("Front of the array: " + ArrayTest.front());

		ArrayTest.enqueue("LoWang");

		System.out.println("Size of the array: " + ArrayTest.size());
		System.out.println("Front of the array: " + ArrayTest.front());

		ArrayTest.dequeue();

		System.out.println("Size of the array: " + ArrayTest.size());
		System.out.println("Front of the array: " + ArrayTest.front());

		System.out.println(ArrayTest.arrayLength());
		
		System.out.println(ArrayTest);

		ArrayTest.enqueue("NoMang");
		ArrayTest.enqueue("RoChang");
		ArrayTest.enqueue("BoMang");
		ArrayTest.enqueue("PoTang");
		ArrayTest.enqueue("HoSang");
		ArrayTest.enqueue("DoFang");
		ArrayTest.enqueue("WoLang");
		ArrayTest.enqueue("ChoHang");
		
		System.out.println(ArrayTest);
		
		ArrayTest.enqueue("ToDang");
		
		System.out.println(ArrayTest);
		
		ArrayTest.enqueue("YoKang");
		ArrayTest.enqueue("HoIang");
		
		System.out.println(ArrayTest);

		System.out.println("Size of the array: " + ArrayTest.size());
		System.out.println("Front of the array: " + ArrayTest.front());

		System.out.println(ArrayTest.arrayLength());

	}

}
