package racingcar.application.dto;

public class RacingCarGameRequest {
    private int carsNumber;
    private int tryCount;

    public RacingCarGameRequest(int carsNumber, int tryCount) {
        this.carsNumber = carsNumber;
        this.tryCount = tryCount;
    }

    public int getCarsNumber() {
        return carsNumber;
    }

    public int getTryCount() {
        return tryCount;
    }
}