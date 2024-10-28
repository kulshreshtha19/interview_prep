package Patterns.Behavioural.StrategyPattern;

public class StrategyContext {

    private SortingStrategy sortingStrategy;

    StrategyContext(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void  setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sort(int[] array) {
        this.sortingStrategy.sort(array);
    }
}
