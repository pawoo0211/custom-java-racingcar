package learning;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스 학습 테스트")
public class StringTest {
    private final Slice slice = new Slice();
    @Test
    void splitCommaTest() {
        String given = "1,2";
        Assertions.assertThat(slice.sliceByComma(given))
                .containsExactly("1","2");
    }

    @Test
    void splitNonCommaTest() {
        String given = "1";
        Assertions.assertThat(slice.sliceByComma(given))
                .containsExactly("1");
    }

    class Slice {
        public String[] sliceByComma(String input) {
            return input.split(",");
        }
    }
}