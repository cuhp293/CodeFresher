import java.util.Scanner;
public class MaxNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 3 numbers: ");
		int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
		
        System.out.println("Max Number: " + ((a>=b && a>=c) ? a : (b>=c ? b : c)));
	}
}