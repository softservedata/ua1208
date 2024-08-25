package Task1;

public class CheckIfAStringContainsDigits {
    public static boolean containsDigits(String str) {
        return str.matches(".*\\d.*");
    }

    public static void main(String[] args) {
        // Test if string contains digits
        System.out.println(containsDigits("Hello123"));  // true
        System.out.println(containsDigits("Hello"));     // false
    }
}
