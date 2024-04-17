package racingcar.domain.car.entity;

import racingcar.domain.strategy.NumberStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Cars {
    private List<Car> carList;

    public Cars() {
        carList = new ArrayList<>();
    }

    public void add(Car car) {
        carList.add(car);
    }

    public void addCarsByNumber(int number) {
        IntStream.range(0, number)
                .forEach(i -> carList.add(new Car()));
    }

    public void moveByTryCount(int tryCount) {
        IntStream.range(0, tryCount)
                .forEach(
                        index -> carList.stream()
                                .forEachOrdered(car -> car.move(new NumberStrategy()))
                );
    }

    public List<MoveCounts> getAllMoveCounts() {
        List<MoveCounts> allMoveCounts = new ArrayList<>();
        for (Car car : carList) {
            allMoveCounts.add(
                    car.getMoveCounts()
            );
        }

        return allMoveCounts;
    }
}