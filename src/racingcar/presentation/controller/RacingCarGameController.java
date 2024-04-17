package racingcar.presentation.controller;

import racingcar.application.RacingCarGameService;
import racingcar.application.dto.RacingCarGameRequest;
import racingcar.application.dto.RacingCarGameResponse;

public class RacingCarGameController {
    private final RacingCarGameService service;

    public RacingCarGameController() {
        service = new RacingCarGameService();
    }

    public RacingCarGameResponse gameStart(RacingCarGameRequest request) {
        RacingCarGameResponse response = service.gameStart(request);
        return response;
    }
}
