package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.NumberStrategy;
import racingcar.domain.strategy.ZeroToNineRandom;

@DisplayName("자동차 도메인 테스트")
public class CarTest {
    private ZeroToNineRandom zeroToNineRandom;

    @BeforeEach
    void setUp() {
        zeroToNineRandom = new ZeroToNineRandom();
    }

    @RepeatedTest(100)
    void randomNumber_isLessThan_10() {
        int randomNumber = zeroToNineRandom.nextInt();
        Assertions.assertThat(randomNumber).isLessThan(10);
    }

    @Test
    void isMove() {
        NumberStrategy numberStrategy = new NumberStrategy(5);
        Car car = new Car();
        car.move(numberStrategy);
        Assertions.assertThat(car.getMoveCount()).isEqualTo(1);
    }
}