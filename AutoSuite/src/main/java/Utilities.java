import java.util.Random;

public class Utilities {
	//@formatter:off
	// Test if the Sequence of Price are Low to High
	public boolean testLowToHighPrice(Integer[] arr) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] < arr[i + 1]) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	// Test if the Sequence of Price are High to Low
	public boolean testHighToLowPrice(Integer[] arr) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > arr[i + 1]) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	// Test if the Sequence of Names are in Alphabetical Order
	public boolean testAtoZ(String[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].compareTo(arr[i + 1]) < 0) {
				continue;
			} else {
				return false;
			}

		}
		return true;

	}

	// Test if the Sequence of Names are in Reverse Order
	public boolean testZtoA(String[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].compareTo(arr[i + 1]) > 0) {
				continue;
			} else {
				return false;
			}

		}
		return true;

	}

	// Get Random Numbers
	int getRandomNumber() {

		Random r = new Random();
		return r.nextInt((5 - 0) + 1);

	}
}
