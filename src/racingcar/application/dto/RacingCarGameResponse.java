package racingcar.application.dto;

import racingcar.domain.car.entity.MoveCounts;

public class RacingCarGameResponse {
    private String carName;
    private MoveCounts moveCounts;

    public RacingCarGameResponse(String carName, MoveCounts moveCounts) {
        this.carName = carName;
        this.moveCounts = moveCounts;
    }
}