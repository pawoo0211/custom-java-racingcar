package learning;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스 학습 테스트")
public class StringTest {
    private final CustomString customString = new CustomString();

    @Test
    @DisplayName("문자열을 ,를 기준으로 분할한다.")
    void splitByComma() {
        String given = "1,2";
        Assertions.assertThat(customString.sliceByComma(given))
                .containsExactly("1","2");
    }

    @Test
    @DisplayName("하나의 문자만 있을 때 정상 동작이 되는지 확인한다.")
    void splitNonComma() {
        String given = "1";
        Assertions.assertThat(customString.sliceByComma(given))
                .containsExactly("1");
    }

    @Test
    @DisplayName("()를 제거한 후 문자열을 ,를 기준으로 분할한다.")
    void splitInParentheses() {
        String given = "(1,2)";
        Assertions.assertThat(customString.sliceByComma(given))
                .containsExactly("1","2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져온다.")
    void charAt() throws IllegalArgumentException {
        String given = "abc";
        Assertions.assertThat(customString.charAt(given, 1))
                .isEqualTo('b');
    }

    @Test
    @DisplayName("문자열의 길이보다 긴 index가 입력 되면 예외가 발생한다.")
    void charAt_indexOut() {
        String given = "abc";
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> customString.charAt(given, 5));
    }
}