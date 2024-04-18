package racingcar.domain.car.vo;

import racingcar.domain.car.entity.MoveCounts;

public class CarInfo {
    private final String carName;
    private final MoveCounts moveCounts;

    public CarInfo(String carName, MoveCounts moveCounts) {
        this.carName = carName;
        this.moveCounts = moveCounts;
    }

    public String getCarName() {
        return carName;
    }

    public MoveCounts getMoveCounts() {
        return moveCounts;
    }

    public boolean isWinnerCar(int highMoveCount) {
        return moveCounts.isHighMoveCount(highMoveCount);
    }

    @Override
    public String toString() {
        return "CarInfo{" +
                "carName='" + carName + '\'' +
                ", moveCounts=" + moveCounts +
                '}';
    }
}