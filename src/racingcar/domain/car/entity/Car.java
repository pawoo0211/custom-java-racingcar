package racingcar.domain.car.entity;

import racingcar.domain.strategy.MoveStrategy;


public class Car {
    private MoveCounts moveCounts;

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

    public int getTotalMoveCountAtTurn(int turn) {
        return moveCounts.getTotalMoveCountByTurn(turn);
    }
}