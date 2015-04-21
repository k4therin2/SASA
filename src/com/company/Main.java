package com.company;

public class Main {

    public static void main(String[] args) {
	    int[] increasing = {0, 1, 2, 3, 4, 5, 5, 6, 6, 7};
        int[] decreasing = {9, 8, 8, 6, 5, 4, 4, 3, 2, 1};
        int[] random = {3, 7, 5, 8, 0, 7, 8, 3, 2, 6};
        int[] result;

        result = Sorting.heapSort(increasing);
        System.out.println("Increasing: "+ increasing);
        System.out.println("Heapsort result, increasing: " + result);

        result = Sorting.heapSort(decreasing);
        System.out.println("Decreasing: "+ decreasing);
        System.out.println("Heapsort result, decreasing: " + result);

        result = Sorting.heapSort(random);
        System.out.println("Random: "+ random);
        System.out.println("Heapsort result, random: " + result);

    }
}
