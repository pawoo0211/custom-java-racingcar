package racingcar.domain.car.entity;

import racingcar.domain.car.vo.CarInfo;
import racingcar.domain.strategy.delimiter.SplitStrategy;
import racingcar.domain.strategy.move.NumberStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Cars {
    private List<Car> carList;

    public Cars() {
        carList = new ArrayList<>();
    }

    public void addCarsByNumber(int number) {
        IntStream.range(0, number)
                .forEach(i -> carList.add(new Car()));
    }

    public int addCarsByName(String carsName, SplitStrategy splitStrategy) {
        String[] splintedCarsName = splitStrategy.split(carsName);
        Arrays.stream(splintedCarsName)
                .forEach(carName -> carList.add(new Car(carName)));

        return carList.size();
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

        return Collections.unmodifiableList(allMoveCounts);
    }

    public List<CarInfo> getCarInfoList() {
        List<CarInfo> carInfoList = new ArrayList<>();
        for (Car car : carList) {
            carInfoList.add(car.getCarInfo());
        }

        return Collections.unmodifiableList(carInfoList);
    }

    public int findHighMoveCount() {
        int winnerMoveCount = carList.stream()
                .mapToInt(car -> car.getTotalMoveCount())
                .max()
                .orElse(0);

        return winnerMoveCount;
    }
}