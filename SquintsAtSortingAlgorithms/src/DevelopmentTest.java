import java.util.Arrays;


/**
 * Test file to test accuracy of algorithms while implimenting. 
 * 
 * @author Katherine Cass
 *
 */
public class DevelopmentTest {

    public static void main(String[] args) {
	    int[] increasing = {0, 1, 2, 3, 4, 5, 5, 6, 6, 7};
        int[] decreasing = {9, 8, 8, 6, 5, 4, 4, 3, 2, 1};
        int[] random = {3, 7, 5, 8, 0, 7, 8, 3, 2, 6};
        int[] result;


        System.out.println("Increasing: "+ Arrays.toString(increasing));
        System.out.println("Decreasing: "+ Arrays.toString(decreasing));
        System.out.println("Random: "+ Arrays.toString(random));
        
        
        result = Sorting.heapSort(increasing);
        System.out.println("Heapsort result, increasing: " + Arrays.toString(result));
        result = Sorting.heapSort(decreasing);
        System.out.println("Heapsort result, decreasing: " + Arrays.toString(result));
        result = Sorting.heapSort(random);
        System.out.println("Heapsort result, random: " + Arrays.toString(result));
        
        main2();
        main3();
        
    }
    
    public static void main2() {
	    int[] increasing = {0, 1, 2, 3, 4, 5, 5, 6, 6, 7};
        int[] decreasing = {9, 8, 8, 6, 5, 4, 4, 3, 2, 1};
        int[] random = {3, 7, 5, 8, 0, 7, 8, 3, 2, 6};
        int[] result;


  //      System.out.println("Increasing: "+ Arrays.toString(increasing));
        result = Sorting.quickSort(increasing);
        System.out.println("Quicksort result, increasing: " + Arrays.toString(result));
  //      System.out.println("Decreasing: "+ Arrays.toString(decreasing));
        result = Sorting.quickSort(decreasing);
        System.out.println("Quicksort result, decreasing: " + Arrays.toString(result));
    //    System.out.println("Random: "+ Arrays.toString(random));
        result = Sorting.quickSort(random);
        System.out.println("Quicksort result, random: " + Arrays.toString(result));
        
    }
    
    public static void main3() {
	    int[] increasing = {0, 1, 2, 3, 4, 5, 5, 6, 6, 7};
        int[] decreasing = {9, 8, 8, 6, 5, 4, 4, 3, 2, 1};
        int[] random = {3, 7, 5, 8, 0, 7, 8, 3, 2, 6};
        int[] result;


  //      System.out.println("Increasing: "+ Arrays.toString(increasing));
        result = Sorting.mergeSort(increasing);
        System.out.println("Mergesort result, increasing: " + Arrays.toString(result));
  //      System.out.println("Decreasing: "+ Arrays.toString(decreasing));
        result = Sorting.mergeSort(decreasing);
        System.out.println("Mergesort result, decreasing: " + Arrays.toString(result));
    //    System.out.println("Random: "+ Arrays.toString(random));
        result = Sorting.mergeSort(random);
        System.out.println("Mergesort result, random: " + Arrays.toString(result));
        
    }
    
}
        
         