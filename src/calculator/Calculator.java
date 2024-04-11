package calculator;

public class Calculator {
    private ValidatedNumber number;

    public int calculate(String input) {
        String[] numbers = splitNumber(input);
        ValidatedNumber validatedNumber = new ValidatedNumber(numbers[0]);

        return 0;
    }

    private String[] splitNumber(String input) {
        if (input.contains(",") || input.contains(":")) {
            return Delimiter.splitByCommaOrColon(input);
        }
        return Delimiter.splitByCustomDelimiter(input);
    }
}
