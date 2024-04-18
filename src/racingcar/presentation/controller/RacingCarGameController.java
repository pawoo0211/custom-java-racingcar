package racingcar.presentation.controller;

import racingcar.application.RacingCarGameService;
import racingcar.application.dto.request.RacingCarGameRequest;
import racingcar.application.dto.response.ResultResponse;
import racingcar.presentation.view.ResultView;

public class RacingCarGameController {
    private final RacingCarGameService service;
    private final ResultView resultView;

    public RacingCarGameController() {
        service = new RacingCarGameService();
        resultView = new ResultView();
    }

    public void gameStart(RacingCarGameRequest request) {
        ResultResponse response = service.gameStart(request);
        resultView.printGameResult(response);
    }
}
