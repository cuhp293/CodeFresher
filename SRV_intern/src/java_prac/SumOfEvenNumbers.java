package java_prac;

public class SumOfEvenNumbers {
	public static int sumOfEvenNumbers(int n) {
		int sum = 0;
		for (int i = 2; i <= n; i += 2) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		int n = 10;
		int sum = sumOfEvenNumbers(n);
		System.out.println("Sum of even numbers from 1 to " + n + "is: " + sum);
	}

}
