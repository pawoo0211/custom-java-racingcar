package racingcar.presentation.view;

import racingcar.application.dto.RacingCarGameResponse;
import racingcar.domain.car.entity.MoveCounts;

import java.util.List;

public class ResultView {

    public void printGameResult(RacingCarGameResponse response) {
        System.out.println("실행 결과");

        List<MoveCounts> allMoveCounts = response.getAllMoveCounts();
        int tryCount = response.getTryCount();

        for (int turn = 1; turn <= tryCount; turn++) {
            System.out.println("Turn : " + turn);
            printMoveAtTurn(allMoveCounts, turn);
            System.out.println("");
        }
    }

    private void printMoveAtTurn(List<MoveCounts> allMoveCounts, int turn) {
        final String moveSymbol = "-";

        for (MoveCounts moveCounts : allMoveCounts) {
            int moveCount = moveCounts.getTotalMoveCountByTurn(turn);
            System.out.println(moveSymbol.repeat(moveCount));
        }
    }
}