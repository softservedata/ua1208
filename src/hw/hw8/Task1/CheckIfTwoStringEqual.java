package Task1;

public class CheckIfTwoStringEqual {
// Method for case-sensitive comparison
public static boolean areStringsEqual(String str1, String str2) {
    return str1.equals(str2);
}

// Method for case-insensitive comparison
public static boolean areStringsEqualIgnoreCase(String str1, String str2) {
    return str1.equalsIgnoreCase(str2);
}

public static void main(String[] args) {
    // Test case-sensitive comparison
    System.out.println(areStringsEqual("Hello", "hello")); // false
    System.out.println(areStringsEqual("Hello", "Hello")); // true

    // Test case-insensitive comparison
    System.out.println(areStringsEqualIgnoreCase("Hello", "hello")); // true
}
}
