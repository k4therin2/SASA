import java.util.Random;


/** 
 * A testing class that generates increasing, decreasing and random arrays of sizes 1,000, 10,000, 100,000, and 1,000,000, and then 
 * tests the performance of Sorting.java sorting methods on these arrays, printing results to the console.
 * 
 * @author Katherine Cass
 *
 */

public class Reporting1 {

    public static void main(String[] args) {
    	
    	System.out.println("In nanoseconds, for arrays of size 1000: ");
    	//1000
    	int[] inc = generateIncreasing(1000);
    	int[] dec = generateDecreasing(1000);
    	int[] ran = generateRandom(1000);
    	
    	//sorts
    	System.out.println("Increasing: \n"+ testSorts(inc));
    	System.out.println("Decreasing: \n"+ testSorts(dec));
    	System.out.println("Random: \n"+ testSorts(ran));

    	
    System.out.println("\nIn nanoseconds, for arrays of size 10000: ");
    	//10000
    	inc = generateIncreasing(10000);
    	dec = generateDecreasing(10000);
    	ran = generateRandom(10000);
    	
    	//sorts
    	System.out.println("Increasing: \n"+ testSorts(inc));
    	System.out.println("Decreasing: \n"+ testSorts(dec));
    	System.out.println("Random: \n"+ testSorts(ran));
   
    System.out.println("\nIn nanoseconds, for arrays of size 100000: ");
    	//100000
    	inc = generateIncreasing(100000);
    	dec = generateDecreasing(100000);
    	ran = generateRandom(100000);
    	
    	//sorts
    	System.out.println("Increasing: \n"+ testSorts(inc));
    	System.out.println("Decreasing: \n"+ testSorts(dec));
    	System.out.println("Random: \n"+ testSorts(ran));
    	
    System.out.println("\nIn nanoseconds, for arrays of size 1000000: ");
    	//1000000
    	inc = generateIncreasing(1000000);
    	dec = generateDecreasing(1000000);
    	ran = generateRandom(1000000);
    	
    	//sorts
    	System.out.println("Increasing: \n"+ testSorts(inc));
    	System.out.println("Decreasing: \n"+ testSorts(dec));
    	System.out.println("Random: \n"+ testSorts(ran));

    	
    }

    
	/**
	 * Method that repeatedly tests input array on Heapsort, Quicksort and 
	 * Mergesort and returns average statistics on elapsed time for each.
	 * 
	 * @param arr input array
	 * @return result (mean and variance of different algorithms)
	 */
	private static String testSorts(int[] arr) {
		int[] initial = arr.clone();
		double start;
		double[] heapTime = new double[10];
		double[] quickTime = new double[10];
		double[] mergeTime = new double[10];
		
		for (int i=0; i < 10; i++){  //runs 10 times
	        arr = initial.clone();
			start = System.nanoTime();
	        Sorting.heapSort(arr);
	        heapTime[i] = System.nanoTime()-start;
	       
	        arr = initial.clone();
			start = System.nanoTime();
			Sorting.quickSort(arr);  
	        quickTime[i] = System.nanoTime()-start;
	        
	        arr = initial.clone();
			start = System.nanoTime();
			Sorting.mergeSort(arr); 
	        mergeTime[i] = System.nanoTime()-start;
		}
		
	      double heapMean= meanVal(heapTime) ;
	      double quickMean= meanVal(quickTime);
	      double mergeMean= meanVal(mergeTime);
	      
	      String result = "Means   | HeapSort: " +heapMean + " QuickSort: " + quickMean + " MergeSort: " + mergeMean + "\n" + 
	      "Variance| HeapSort: "+ varianceVal(heapTime, heapMean)+ " QuickSort: " + varianceVal(quickTime, quickMean)+
	      " MergeSort: " +varianceVal(mergeTime, mergeMean);
	      
	      return result;
		
	}
	
	/**
	 * Finds mean value of input array
	 * 
	 * @param arrayOfSamples input array
	 * @return mean value
	 */
	private static double meanVal(double[] arrayOfSamples){
		double total = 0;
		    for (double i :arrayOfSamples){
		    	total += i;
		    }
	   return total/arrayOfSamples.length;
	}
	
	/**
	 * Returns variance of an input array
	 * 
	 * @param arrayOfSamples input array
	 * @param mean mean of input array
	 * @return variance
	 */
	private static double varianceVal(double[] arrayOfSamples, double mean){
	        double v = 0;
	        for(double i :arrayOfSamples)
	            v += Math.pow((mean-i), 2);
	        return v / arrayOfSamples.length;
	}


	/**
	 * Generates a decreasing array of size n
	 * 
	 * @param n number of elements
	 * @return generated array
	 */
	private static int[] generateDecreasing(int n) {
		int[] arr = new int[n];
		
		for (int i = n-1; i <= 0; i--)
			arr[i] = i;
			
		return arr;
	}

	/**
	 * Generates an increasing array of size n
	 * 
	 * @param n number of elements
	 * @return generated array
	 */
	private static int[] generateIncreasing(int n) {
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++)
			arr[i] = i;
			
		return arr;
	}
	
	/**
	 * Generates a random array of size n, ranging in numbers from 0-n.
	 * @param n number of values
	 * @return generated array
	 */
	private static int[] generateRandom(int n) {
		int[] arr = new int[n];
		Random r = new Random();
		
		for (int i = 0; i < n; i++)
			arr[i] = r.nextInt(n);
					
		return arr;
	}

}
