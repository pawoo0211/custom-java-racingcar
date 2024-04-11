package calculator;

public class ValidatedNumber {
    private int number;

    public ValidatedNumber(String input) {
        if (isNullOrEmpty(input)) {
            number = 0;
        }
        number = Integer.valueOf(input);
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public ValidatedNumber add(ValidatedNumber inputValidatedNumber) {
        int result = this.number + inputValidatedNumber.number;
        return new ValidatedNumber(String.valueOf(result));
    }
}