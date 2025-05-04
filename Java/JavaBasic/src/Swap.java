import java.util.Scanner;
public class Swap {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		// Swap
		int c = a;
        	a = b;
        	b = c;
		
		System.out.println("After swapping: a = " + a + ", b = " + b);
	}
}
