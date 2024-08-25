package Task1;

public class GetSubstringBetweenTwoIndices {
    public static String getSubstringBetweenIndices(String str, int startIndex, int endIndex) {
        if (startIndex >= 0 && endIndex <= str.length() && startIndex < endIndex) {
            return str.substring(startIndex, endIndex);
        }
        return "Invalid indices";
    }

    public static void main(String[] args) {
        // Test substring method
        System.out.println(getSubstringBetweenIndices("Hello, World!", 7, 12)); // World
    }
}
