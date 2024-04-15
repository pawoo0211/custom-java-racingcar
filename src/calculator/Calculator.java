package calculator;

import java.util.List;

public class Calculator {

    public int calculateRefactoring(String input) {
        List<ValidatedNumber> validatedNumbers = Delimiter.split(input);
        return sum(validatedNumbers);
    }

    private int sum(List<ValidatedNumber> validatedNumbers) {
        ValidatedNumber result = new ValidatedNumber("");
        for (ValidatedNumber validatedNumber : validatedNumbers) {
            result = result.add(validatedNumber);
        }
        return result.getNumber();
    }
}
