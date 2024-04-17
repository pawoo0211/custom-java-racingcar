package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.entity.Car;
import racingcar.domain.car.entity.Cars;
import racingcar.domain.car.entity.MoveCounts;
import racingcar.domain.strategy.NumberStrategy;
import racingcar.domain.strategy.ZeroToNineRandom;

import java.util.List;

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
        Assertions.assertThat(car.getMoveCountAtTurn(1)).isEqualTo(1);
    }

    @Test
    void moveByTryCount() {
        Cars cars = new Cars();
        cars.addCarsByNumber(3);
        cars.moveByTryCount(5);

        List<MoveCounts> allMoveCounts = cars.getAllMoveCounts();

        for (MoveCounts moveCounts : allMoveCounts) {
            System.out.println("car move count : " + moveCounts.getTotalMoveCountByTurn(5));
        }
    }
}