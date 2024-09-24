package Home_work_08.TaskO1;

public class StringTasks {

    public boolean areEqual(String str1, String str2, boolean caseSensitive) {
        if (caseSensitive) {
            return str1.equals(str2);
        } else {
            return str1.equalsIgnoreCase(str2);
        }
    }

    public String getSubstring(String str, int start, int end) {
        return str.substring(start, end);
    }


    public int indexOfSubstring(String str, String subStr) {
        return str.indexOf(subStr);
    }

    public String replaceSubstring(String str, String target, String replacement) {
        return str.replace(target, replacement);
    }

    public boolean containsDigits(String str) {
        return str.matches(".*\\d.*");
    }

    public String trimSpaces(String str) {
        return str.trim();
    }

    public String[] splitString(String str, String delimiter) {
        return str.split(delimiter);
    }

    public static void main(String[] args) {
        StringTasks st = new StringTasks();
        System.out.println(st.areEqual("Hello", "hello", false));  // True
        System.out.println(st.getSubstring("HelloWorld", 0, 5));  // Hello
        System.out.println(st.indexOfSubstring("HelloWorld", "World"));  // 5
        System.out.println(st.replaceSubstring("I like apples", "apples", "oranges"));  // I like oranges
        System.out.println(st.containsDigits("abc123"));  // True
        System.out.println(st.trimSpaces("   Hello World   "));  // "Hello World"
        String[] result = st.splitString("apple,orange,banana", ",");
        for (String word : result) {
            System.out.println(word);
        }
    }
}
