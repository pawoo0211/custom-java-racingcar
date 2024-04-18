package racingcar.application.dto.request;

public class RacingCarGameRequest {
    private String carsName;
    private int tryCount;

    public RacingCarGameRequest(String carsName, int tryCount) {
        this.carsName = carsName;
        this.tryCount = tryCount;
    }

    public String getCarsName() {
        return carsName;
    }

    public int getTryCount() {
        return tryCount;
    }
}