package test;

public class test {
    public static void main(String[] s) {
        try {
            nestedTry();
        } catch(Exception ex) {
            System.out.print("AAA");
        }
    }

static void nestedTry() {
    try {
        int i = Integer.parseInt("abc");
    } catch(NullPointerException ex) {
        System.out.print("BBB");
    }
}
