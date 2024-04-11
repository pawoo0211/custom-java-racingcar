package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@DisplayName("문자열 덧셈 계산기")
public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void inputNullOrEmpty(String input) {
        Assertions.assertThat(calculator.calculate(input)).isEqualTo(0);
    }

    @Test
    void splitAndSum_숫자_하나() {
        int result = calculator.calculate("1");
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표_구분자() {
        int result = calculator.calculate("1,2");
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = calculator.calculate("1,2:3");
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom_구분자() {
        int result = calculator.calculate("//;\n1;2;3");
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        Assertions.assertThatThrownBy(() -> calculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}