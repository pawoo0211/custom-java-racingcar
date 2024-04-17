package racingcar.presentation.view;

import racingcar.application.dto.RacingCarGameRequest;
import racingcar.application.dto.RacingCarGameResponse;
import racingcar.presentation.RacingCarGameController;

import java.util.Scanner;

public class RacingCarGameView {

    public static void main(String[] args) {
        RacingCarGameController controller = new RacingCarGameController();

        RacingCarGameRequest request = inputCarsNumberAndTryCount();
        RacingCarGameResponse response = controller.gameStart(request);
    }

    private static RacingCarGameRequest inputCarsNumberAndTryCount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carsNumber = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        return new RacingCarGameRequest(carsNumber, tryCount);
    }
}