package Task1;

public class RemoveSpaces {
    public static String trimString(String str) {
        return str.trim();
    }

    public static void main(String[] args) {
        // Test trimming a string
        System.out.println("[" + trimString("   Hello, World!   ") + "]"); // [Hello, World!]
    }
}
