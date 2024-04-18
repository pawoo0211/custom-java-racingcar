package racingcar.application.dto.response;

import racingcar.application.dto.RacingCarGameResponse;

import java.util.List;

public class ResultResponse {
    private List<RacingCarGameResponse> racingCarGameResponses;
    private List<String> winner;

    public ResultResponse(List<RacingCarGameResponse> racingCarGameResponses, List<String> winner) {
        this.racingCarGameResponses = racingCarGameResponses;
        this.winner = winner;
    }
}