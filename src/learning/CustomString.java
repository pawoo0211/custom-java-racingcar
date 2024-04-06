package learning;

public class CustomString {
    private final char LEFT_PARENTHESES = '(';
    private final char LIGHT_PARENTHESES = ')';

    public String[] sliceByComma(String input) {
        input = deleteParentheses(input);
        return input.split(",");
    }

    private String deleteParentheses(String input) {
        if (input.charAt(0) ==  LEFT_PARENTHESES) {
            input = input.substring(1);
        }
        if (input.charAt(input.length() - 1) == LIGHT_PARENTHESES) {
            input = input.substring(0, input.length()-1);
        }
        return input;
    }

    public char charAt(String input, int index) throws IllegalArgumentException {
        if (input.length() - 1 < index) {
            throw new IllegalArgumentException();
        }
        return input.charAt(index);
    }
}
