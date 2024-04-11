package calculator;

public class ValidatedNumber {
    private final int number;

    public ValidatedNumber(String input) {
        if (isNullOrEmpty(input)) {
            number = 0;
            return;
        }
        number = Integer.valueOf(input);
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public ValidatedNumber add(ValidatedNumber inputValidatedNumber) {
        int result = this.number + inputValidatedNumber.number;
        return new ValidatedNumber(String.valueOf(result));
    }

    public int getNumber() {
        return number;
    }
}