package Task1;

public class CheckIfSubstringExists {
    public static int getIndexOfSubstring(String str, String subStr) {
        return str.indexOf(subStr);
    }

    public static void main(String[] args) {
        // Test the index of a substring
        System.out.println(getIndexOfSubstring("Hello, World!", "World")); // 7
        System.out.println(getIndexOfSubstring("Hello, World!", "Java"));  // -1 (not found)
    }
}
