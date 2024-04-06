package learning;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스 학습 테스트")
public class StringTest {
    private final Slice slice = new Slice();

    @Test
    @DisplayName("문자열을 ,를 기준으로 분할한다.")
    void splitByComma() {
        String given = "1,2";
        Assertions.assertThat(slice.sliceByComma(given))
                .containsExactly("1","2");
    }

    @Test
    @DisplayName("하나의 문자만 있을 때 정상 동작이 되는지 확인한다.")
    void splitNonComma() {
        String given = "1";
        Assertions.assertThat(slice.sliceByComma(given))
                .containsExactly("1");
    }

    @Test
    @DisplayName("()를 제거한 후 문자열을 ,를 기준으로 분할한다.")
    void splitInParentheses() {
        String given = "(1,2)";
        Assertions.assertThat(slice.sliceByComma(given))
                .containsExactly("1","2");
    }

    class Slice {
        public String[] sliceByComma(String input) {
            if (input.charAt(0) == '(') {
                input = input.substring(1);
            }

            if (input.charAt(input.length()-1) == ')') {
                input = input.substring(0, input.length()-1);
            }
            return input.split(",");
        }
    }
}