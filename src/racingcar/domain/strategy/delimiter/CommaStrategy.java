package racingcar.domain.strategy.delimiter;

public class CommaStrategy implements SplitStrategy{
    private static String SPLIT_SYMBOL = ",";

    @Override
    public String[] split(String input) {
        return input.split(SPLIT_SYMBOL);
    }
}
