package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class Car {
    private int moveCount = 0;

    public void move(MoveStrategy randomStrategy) {
        if (randomStrategy.isMovable()) {
            moveCount = moveCount + 1;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }
}