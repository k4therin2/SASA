import java.util.Random;


/**
 * Reporting1 should generate the 3 types of arrays specified in the Research section. 1,000, 10,000, 100,000, 1,000,000.
 *  Then for each array:
 * 
Run each of the sorting methods on the arrays as many times as specified above

Record the execution time of these methods

Print out the results in a form suitable for inclusion into your report and/or writes out the results into a 
file if you need to post-process your results (e.g., by Excel to produce graphs for your report).  
If you do not need this output file for your report, you do not have to write it.
 * 
 * @author Katherine
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

    
	private static String testSorts(int[] arr) {
		double start;
		double[] heapTime = new double[10];
		double[] quickTime = new double[10];
		double[] mergeTime = new double[10];
		
		for (int i=0; i < 10; i++){
			start = System.nanoTime();
	        Sorting.heapSort(arr);
	        heapTime[i] = System.nanoTime()-start;
	       
	        
			start = System.nanoTime();
			Sorting.quickSort(arr);  
	        quickTime[i] = System.nanoTime()-start;
	        
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
	private static double meanVal(double[] arrayOfSamples){
		double total = 0;
		    for (double i :arrayOfSamples){
		    	total += i;
		    }
	   return total/arrayOfSamples.length;
	}
	
	private static double varianceVal(double[] arrayOfSamples, double mean){
	        double v = 0;
	        for(double i :arrayOfSamples)
	            v += Math.pow((mean-i), 2);
	        return v / arrayOfSamples.length;
	}


	private static int[] generateDecreasing(int n) {
		int[] arr = new int[n];
		
		for (int i = n-1; i <= 0; i--)
			arr[i] = i;
			
		return arr;
	}

	private static int[] generateIncreasing(int n) {
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++)
			arr[i] = i;
			
		return arr;
	}
	
	private static int[] generateRandom(int n) {
		int[] arr = new int[n];
		Random r = new Random();
		
		for (int i = 0; i < n; i++)
			arr[i] = r.nextInt(n);
					
		return arr;
	}

}
