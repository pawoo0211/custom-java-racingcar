package racingcar.domain.strategy.move;

public class NumberStrategy implements MoveStrategy {
    private static final int MOVABLE_LIMIT = 3;
    private int number;

    public NumberStrategy(int number) {
        this.number = number;
    }

    public NumberStrategy() {
        number = ZeroToNineRandom.nextInt();
    }

    @Override
    public boolean isMovable() {
        if (MOVABLE_LIMIT < number) {
            return true;
        }
        return false;
    }
}