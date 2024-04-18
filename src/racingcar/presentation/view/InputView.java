package racingcar.presentation.view;

import racingcar.application.dto.request.RacingCarGameRequest;
import racingcar.presentation.controller.RacingCarGameController;


import java.util.Scanner;

public class InputView {

    public static void main(String[] args) {
        RacingCarGameController controller = new RacingCarGameController();

        RacingCarGameRequest request = inputCarsNumberAndTryCount();
        controller.gameStart(request);
    }

    private static RacingCarGameRequest inputCarsNumberAndTryCount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carsName = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        return new RacingCarGameRequest(carsName, tryCount);
    }
}