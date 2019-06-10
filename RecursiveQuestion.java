
public class RecursiveQuestion {

	public static int Fibonacci(int n) {

		if (n <= 1)

			return n;

		return Fibonacci(n - 1) + Fibonacci(n - 2);

	}

	public static String showCallLevel(int L, int curl) {

		if (L == 0)

			return null;

		String s = "This was written by call number ";

		s += curl + "x";

		showCallLevel(L, curl - 1);

		System.out.println(s);

		return s;

	}

	public static void Hanoi(int n, int s, int d, int t) {

		if (n <= 0)
			return;

		Hanoi(n - 1, s, t, d);

		System.out.println("Move disk " + n + " from post " + s + " to post " + d);

		Hanoi(n - 1, t, d, s);
	}

	public static void binaryPrint(int n) {

		if (n > 0) {

			binaryPrint(n / 2);

			System.out.print(n % 2);

		}

	}

	public static void Pattern(int left, int right) {

		if (left == 0) {

			for (int x = 0; x < right; x++) {

				System.out.print(" ");
			}

			System.out.print("*");
		}

		else {

			Pattern(left - 1, right);

			System.out.println();

			int times = 2;

			for (int x = 1; x < left; x++) {

				times = times * 2;

			}

			for (int x = 0; x < right; x++) {

				System.out.print(" ");
			}
			
			for (int x = 0; x < times; x++) {
				
				System.out.print("*");
			}

			System.out.println();

			Pattern(left - 1, times / 2 + right);
		}

	}

	public static void Permutation(int[] a, int prefix) {

		int length = a.length;

		if (length == prefix) {

			printArray(a);

		}

		else {

			for (int i = 1; i < prefix; i++) {

				swap(a, prefix, i);

				Permutation(a, prefix + 1);

				swap(a, prefix, i);

			}
		}
	}

	public static void swap(int[] a, int x, int y) {

		int z = a[x];

		a[x] = a[y];

		a[y] = z;

	}

	public static void printArray(int[] thing) {

		System.out.println("\n");

		for (int x = 0; x < thing.length; x++)
			System.out.print(thing[x]);

	}

	public static void main(String[] args) {

		int a[] = { 1, 2, 3 };

		System.out.println(Fibonacci(6));

		Hanoi(3, 1, 2, 3);

		binaryPrint(19);
		
		System.out.println();

		Pattern(3, 1);

		Permutation(a, 0);

		//System.out.println(showCallLevel(4, 1));

	}

}
