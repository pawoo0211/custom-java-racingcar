package racingcar.application.dto;

import racingcar.domain.car.entity.MoveCounts;

import java.util.List;

public class RacingCarGameResponse {
    private int tryCount;
    private List<MoveCounts> allMoveCounts;

    public RacingCarGameResponse(int tryCount, List<MoveCounts> allMoveCounts) {
        this.tryCount = tryCount;
        this.allMoveCounts = allMoveCounts;
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<MoveCounts> getAllMoveCounts() {
        return allMoveCounts;
    }
}