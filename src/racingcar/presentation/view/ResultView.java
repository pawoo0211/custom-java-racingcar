package racingcar.presentation.view;

import racingcar.application.dto.RacingCarGameResponse;
import racingcar.application.dto.response.ResultResponse;
import racingcar.domain.car.entity.MoveCounts;

import java.util.List;

public class ResultView {

    public void printGameResult(ResultResponse response) {
        int tryCount = response.getTryCount();
        List<RacingCarGameResponse> racingCarGameResponses = response.getRacingCarGameResponses();

        System.out.println("실행 결과");

        for (int turn = 1; turn <= tryCount; turn++) {
            System.out.println("Turn : " + turn);
            printMoveAtTurn(racingCarGameResponses, turn);
            System.out.println("");
        }

        System.out.println(response.getWinner()+ "가 최종 우승 했습니다.");
    }

    private void printMoveAtTurn(List<RacingCarGameResponse> racingCarGameResponses, int turn) {
        final String moveSymbol = "-";

        for (RacingCarGameResponse racingCarGameResponse : racingCarGameResponses) {
            MoveCounts moveCounts = racingCarGameResponse.getMoveCounts();
            int moveCount = moveCounts.getTotalMoveCountByTurn(turn);
            System.out.print(racingCarGameResponse.getCarName() + " : ");
            System.out.println(moveSymbol.repeat(moveCount));
        }
    }
}