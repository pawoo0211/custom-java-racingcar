package racingcar.application.dto.response;

import racingcar.application.dto.RacingCarGameResponse;

import java.util.List;

public class ResultResponse {
    private List<RacingCarGameResponse> racingCarGameResponses;
    private List<String> winner;
    private int tryCount;

    public ResultResponse(List<RacingCarGameResponse> racingCarGameResponses, List<String> winner, int tryCount) {
        this(racingCarGameResponses, winner);
        this.tryCount = tryCount;
    }

    public ResultResponse(List<RacingCarGameResponse> racingCarGameResponses, List<String> winner) {
        this.racingCarGameResponses = racingCarGameResponses;
        this.winner = winner;
    }

    public List<RacingCarGameResponse> getRacingCarGameResponses() {
        return racingCarGameResponses;
    }

    public List<String> getWinner() {
        return winner;
    }

    public int getTryCount() {
        return tryCount;
    }
}