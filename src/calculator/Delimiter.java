package calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

public class Delimiter {
    private static String COMMA = ",";
    private static String COLON = ":";
    private static String COMMA_OR_COLON = COMMA + "|" + COLON;
    private static Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    public static List<ValidatedNumber> split(String input) {
        List<ValidatedNumber> validatedNumbers = new ArrayList<>();
        if (isCanNotDelimit(input)) {
            validatedNumbers.add(new ValidatedNumber(input));
            return validatedNumbers;
        }
        if (input.contains(",") || input.contains(":")) {
            String[] numbers = Delimiter.splitByCommaOrColon(input);
            for (String number : numbers) {
                validatedNumbers.add(new ValidatedNumber(number));
            }
            return validatedNumbers;
        }
        String[] numbers = Delimiter.splitByCustomDelimiter(input);
        for (String number : numbers) {
            validatedNumbers.add(new ValidatedNumber(number));
        }
        return validatedNumbers;
    }




    public static String[] splitByCommaOrColon(String input) {
        return input.split(COMMA_OR_COLON);
    }

    public static String[] splitByCustomDelimiter(String input) {
        String[] tokens = {};
        Matcher matcher = PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            tokens = matcher.group(2).split(customDelimiter);
            return tokens;
        }
        return tokens;
    }

    public static boolean isCanNotDelimit(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        if (input.length() == 1) {
            return true;
        }
        return false;
    }
}