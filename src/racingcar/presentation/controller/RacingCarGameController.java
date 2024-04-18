package racingcar.presentation.controller;

import racingcar.application.RacingCarGameService;
import racingcar.application.dto.RacingCarGameRequest;
import racingcar.application.dto.RacingCarGameResponse;
import racingcar.presentation.view.ResultView;

public class RacingCarGameController {
    private final RacingCarGameService service;
    private final ResultView resultView;

    public RacingCarGameController() {
        service = new RacingCarGameService();
        resultView = new ResultView();
    }

    public void gameStart(RacingCarGameRequest request) {
        RacingCarGameResponse response = service.gameStart(request);

        resultView.printGameResult(response);
    }
}
