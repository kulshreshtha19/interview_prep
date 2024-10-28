package Patterns.Behavioural.StrategyPattern;

public class BubbleSortingStrategy implements SortingStrategy{


    @Override
    public void sort(int[] array) {
        System.out.println("Using Bubble Sorting strategy");
    }
}
