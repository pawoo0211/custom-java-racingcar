package racingcar.domain.strategy;

import java.util.Random;

public class ZeroToNineRandom {
    private static Random RANDOM = new Random();
    private static final int LIMIT_NUMBER = 10;

    public static int nextInt() {
        return RANDOM.nextInt(LIMIT_NUMBER);
    }
}