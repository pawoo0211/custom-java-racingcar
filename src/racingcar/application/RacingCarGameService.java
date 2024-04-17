package racingcar.application;

import racingcar.application.dto.RacingCarGameRequest;
import racingcar.application.dto.RacingCarGameResponse;
import racingcar.domain.car.entity.Cars;
import racingcar.domain.car.entity.MoveCounts;

import java.util.List;

public class RacingCarGameService {

    public RacingCarGameResponse gameStart(RacingCarGameRequest request) {
        Cars cars = new Cars();
        int carsNumber = request.getCarsNumber();
        int tryCount = request.getTryCount();

        cars.addCarsByNumber(carsNumber);
        cars.moveByTryCount(tryCount);

        List<MoveCounts> allMoveCounts = cars.getAllMoveCounts();
        return new RacingCarGameResponse(tryCount, allMoveCounts);
    }
}