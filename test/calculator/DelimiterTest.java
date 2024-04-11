package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 구분자 테스트")
public class DelimiterTest {

    @Test
    void splitByCommaOrColon() {
        String given = "1,2:3";
        String[] tokens = Delimiter.splitByCommaOrColon(given);
        println(tokens);
    }

    @Test
    void splitByCustomDelimiter() {
        String given = "//;\n1;2;3";
        String[] tokens = Delimiter.splitByCustomDelimiter(given);
        println(tokens);
    }

    private void println(String[] tokens) {
        for (String token : tokens) {
            System.out.println("token : " + token);
        }
    }
}