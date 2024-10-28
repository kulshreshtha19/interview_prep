package Patterns.Behavioural.StrategyPattern;

public class StrategyMain {

    public static void main(String[] args) {
        StrategyContext strategyContext = new StrategyContext(new BubbleSortingStrategy());
        strategyContext.sort(new int[]{1,2,3,4,5});

        strategyContext.setSortingStrategy(new MergeSortingStrategy());
        strategyContext.sort(new int[]{1,2,3,4,5});
    }
}
