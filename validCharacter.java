package calculator;

public class validChar {
    public static boolean containsInvalidCharacters(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch) && "+-*/()^".indexOf(ch) == -1) {
                return true;
            }
        }
        return false;
    }
    public static boolean hasConsecutiveOperators(String str) {
        for (int i = 1; i < str.length(); i++) {
            if ("+-*/^".indexOf(str.charAt(i)) != -1 && "+-*/^".indexOf(str.charAt(i - 1)) != -1) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String str = "+9+2/+3";
        System.out.println(hasConsecutiveOperators(str));
    }
}
