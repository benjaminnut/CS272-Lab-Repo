public class Fractal {

	public static void main(String[] args) {

		figure(3,1);

	}

	public static void figure(int level, int pad) {

		if (level == 0) {

			for (int i = 0; i < pad; i++) {

				System.out.print(" ");

			}

			System.out.print("*");
		} 
		
		else {

			figure(level - 1, pad);

			System.out.println();

			int times = 2;

			for (int i = 1; i < level; i++) {

				times = times * 2;

			}

			for (int i = 0; i < pad; i++) {

				System.out.print(" ");
			}

			for (int i = 0; i < times; i++) {

				System.out.print("*");

			}

			System.out.println();

			figure(level - 1, times / 2 + pad);
		}
	}
}