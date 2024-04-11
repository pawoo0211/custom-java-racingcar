package calculator;

/**
 * ToDo
 * - 의존성 방향 한 방향으로 리팩터링: Calculator -> Delimiter -> ValidateNumber
 * - 클래스 네이밍 변경: StringAddCalculator
 * - 전체 코드 리팩터링
 */
public class Calculator {
    private ValidatedNumber number;

    public int calculate(String input) {
        if (Delimiter.isCanNotDelimit(input)) {
            return new ValidatedNumber(input).getNumber();
        }
        String[] numbers = splitNumber(input);
        ValidatedNumber validatedNumber = new ValidatedNumber(numbers[0]);
        for (int i = 1; i < numbers.length ; i++) {
            validatedNumber = validatedNumber.add(new ValidatedNumber(numbers[i]));
        }

        return validatedNumber.getNumber();
    }

    private String[] splitNumber(String input) {
        if (input.contains(",") || input.contains(":")) {
            return Delimiter.splitByCommaOrColon(input);
        }
        return Delimiter.splitByCustomDelimiter(input);
    }
}
