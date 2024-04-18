package racingcar.domain.car.entity;

import java.util.ArrayList;
import java.util.List;

public class MoveCounts {
    List<Integer> moveCounts;

    public MoveCounts() {
        moveCounts = new ArrayList<>();
    }

    public void addMoveCount() {
        moveCounts.add(1);
    }

    public void stopCount() {
        moveCounts.add(0);
    }

    public boolean isMovedStatusByTurn(int turn) {
        int turnIndex = turn - 1;
        if (moveCounts.get(turnIndex).equals(1)) {
            return true;
        }
        return false;
    }

    public boolean isHighMoveCount(int highMoveCount) {
        if (getTotalMoveCount() < highMoveCount) {
            return false;
        }
        return true;
    }

    public int getTotalMoveCountByTurn(int turn) {
        int totalMoveCount = 0;
        int turnIndex = turn - 1;

        for (int index = 0; index < turnIndex; index++) {
            totalMoveCount = totalMoveCount + moveCounts.get(index);
        }

        return totalMoveCount;
    }

    public int getTotalMoveCount() {
        int totalMoveCount = 0;

        for (int index = 0; index < moveCounts.size(); index++) {
            totalMoveCount = totalMoveCount + moveCounts.get(index);
        }

        return totalMoveCount;
    }
}