package Patterns.Behavioural.StrategyPattern;

public class MergeSortingStrategy implements SortingStrategy{

    @Override
    public void sort(int[] array) {
        System.out.println("Using Merge Sorting strategy");
    }
}
