package Task1;

public class ReplaceAllOccurrences {
    public static String replaceSubstring(String str, String oldSubStr, String newSubStr) {
        return str.replace(oldSubStr, newSubStr);
    }

    public static void main(String[] args) {
        // Test replacing substrings
        System.out.println(replaceSubstring("I like Java", "Java", "Python")); // I like Python
    }
}
