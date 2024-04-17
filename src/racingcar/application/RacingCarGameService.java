package racingcar.application;

import racingcar.application.dto.RacingCarGameRequest;
import racingcar.application.dto.RacingCarGameResponse;
import racingcar.domain.car.entity.Cars;

public class RacingCarGameService {

    public RacingCarGameResponse gameStart(RacingCarGameRequest request) {
        Cars cars = new Cars();
        cars.addCarsByNumber(request.getCarsNumber());
        cars.moveByTryCount(request.getTryCount());

        return null;
    }
}