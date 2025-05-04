import java.util.Scanner;
public class CompareString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name1 = scanner.nextLine(), name2 = scanner.nextLine();
        
        if (name1.equals(name2))
            System.out.println("two people have the same name");
        else
            System.out.println("two people don't have the same name");
	}
}
