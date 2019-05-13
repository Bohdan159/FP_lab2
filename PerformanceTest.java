package secondlab;

import java.util.ArrayList;
import java.util.Random;


public class PerformanceTest {

    private static int[] array = new int[1_000];
    private static ArrayList<Integer> list = new ArrayList<>(1_000);


    public static void main(String[] args) {
        initializeDataHolders();

        Sort mergeSort = new MergeSort();
        Sort quickSort = new QuickSort();
        SortFunc mergeSortFunc = new MergeSortFunc();
        SortFunc quickSortFunc = new QuickSortFunc();

        mergeSort.sort(array);
        quickSort.sort(array);
        SortingResult mergeSortResult = mergeSortFunc.sort(list);
        SortingResult quickSortResult = quickSortFunc.sort(list);

        System.out.println(mergeSort.getClass().getName() + ": " + mergeSort.getSortingTime() + " ms");
        System.out.println(quickSort.getClass().getName() + ": " + quickSort.getSortingTime() + " ms");

        if (mergeSortResult != null) {
            System.out.println(mergeSortFunc.getClass().getName() + ": " + mergeSortResult.getTime() + " ms");
        }

        if (quickSortResult != null) {
            System.out.println(quickSortFunc.getClass().getName() + ": " + quickSortResult.getTime() + " ms");
        }
    }

    private static void initializeDataHolders() {
        Random random = new Random();

        int min = -1000, max = 1000;

        for (int i = 0; i < array.length; i++) {
            int randomNumber = random.nextInt((max - min) + 1) + min;

            array[i] = randomNumber;
            list.add(randomNumber);
        }
    }
}
