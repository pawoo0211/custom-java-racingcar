package racingcar.domain.car.entity;

import racingcar.domain.car.vo.CarInfo;
import racingcar.domain.strategy.move.MoveStrategy;


public class Car {
    private String name;
    private MoveCounts moveCounts;

    public Car(String name) {
        this();
        this.name = name;
    }

    public Car() {
        moveCounts = new MoveCounts();
    }

    public void move(MoveStrategy randomStrategy) {
        if (randomStrategy.isMovable()) {
            moveCounts.addMoveCount();
        }
        if (!randomStrategy.isMovable()) {
            moveCounts.stopCount();
        }
    }

    public final MoveCounts getMoveCounts() {
        return moveCounts;
    }

    public int getMoveCountAtTurn(int turn) {
        if (moveCounts.isMovedStatusByTurn(turn)) {
            return 1;
        }
        return 0;
    }

    public int getTotalMoveCount() {
        return moveCounts.getTotalMoveCount();
    }

    public final CarInfo getCarInfo() {
        return new CarInfo(name, moveCounts);
    }
}