package racingcar.application;

import racingcar.application.dto.RacingCarGameResponse;
import racingcar.application.dto.request.RacingCarGameRequest;
import racingcar.application.dto.response.ResultResponse;
import racingcar.domain.car.entity.Cars;
import racingcar.domain.car.vo.CarInfo;
import racingcar.domain.strategy.delimiter.CommaStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameService {

    public ResultResponse gameStart(RacingCarGameRequest request) {
        Cars cars = new Cars();
        String carsName = request.getCarsName();
        int tryCount = request.getTryCount();

        cars.addCarsByName(carsName, new CommaStrategy());
        cars.moveByTryCount(tryCount);

        return createResultResponse(cars, request.getTryCount());
    }

    private ResultResponse createResultResponse(Cars cars, int tryCount) {
        List<String> winners = findWinners(cars);
        List<RacingCarGameResponse> racingCarGameResponses = new ArrayList<>();
        List<CarInfo> carInfoList = cars.getCarInfoList();

        for (CarInfo carInfo : carInfoList) {
            racingCarGameResponses.add(new RacingCarGameResponse(carInfo.getCarName(), carInfo.getMoveCounts()));
        }

        return new ResultResponse(racingCarGameResponses, winners, tryCount);
    }

    /**
     * ToDo
     * - 도메인 로직으로 변경
     */
    private List<String> findWinners(Cars cars) {
        int highMoveCount = cars.findHighMoveCount();
        List<String> winners = cars.getCarInfoList()
                .stream()
                .filter(carInfo -> carInfo.isWinnerCar(highMoveCount))
                .map(carInfo -> carInfo.getCarName())
                .collect(Collectors.toList());

        return winners;
    }
}