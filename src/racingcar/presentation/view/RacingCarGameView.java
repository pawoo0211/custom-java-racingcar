package racingcar.presentation.view;

import racingcar.application.dto.RacingCarGameRequest;
import racingcar.application.dto.RacingCarGameResponse;
import racingcar.domain.car.entity.MoveCounts;
import racingcar.presentation.controller.RacingCarGameController;

import java.util.List;
import java.util.Scanner;

public class RacingCarGameView {

    public static void main(String[] args) {
        RacingCarGameController controller = new RacingCarGameController();

        RacingCarGameRequest request = inputCarsNumberAndTryCount();
        RacingCarGameResponse response = controller.gameStart(request);

        printGameResult(response);
    }

    private static RacingCarGameRequest inputCarsNumberAndTryCount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carsNumber = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        return new RacingCarGameRequest(carsNumber, tryCount);
    }

    private static void printGameResult(RacingCarGameResponse response) {
        System.out.println("실행 결과");

        List<MoveCounts> allMoveCounts = response.getAllMoveCounts();
        int tryCount = response.getTryCount();

        for (int turn = 1; turn <= tryCount; turn++) {
            System.out.println("Turn : " + turn);
            printMoveAtTurn(allMoveCounts, turn);
            System.out.println("");
        }
    }

    private static void printMoveAtTurn(List<MoveCounts> allMoveCounts, int turn) {
        final String moveSymbol = "-";

        for (MoveCounts moveCounts : allMoveCounts) {
            int moveCount = moveCounts.getTotalMoveCountByTurn(turn);
            System.out.println(moveSymbol.repeat(moveCount));
        }
    }
}