import java.util.Scanner;

public class BasicInput {
    public static void main(String[] args) {
        // Create object keyboard of class Scanner to input data
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Hello " + name);
    }
}
