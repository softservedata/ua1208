package Task1;

public class SplitAString {
    public static String[] splitString(String str, String delimiter) {
        return str.split(delimiter);
    }

    public static void main(String[] args) {
        // Test splitting a string
        String[] result = splitString("apple,orange,banana", ",");
        for (String s : result) {
            System.out.println(s);
        }
        // Output:
        // apple
        // orange
        // banana
    }
}
