

/**
 * Created by Katherine on 4/20/2015.
 */
public class Sorting {

    private static int numItems;
    private static int leftNode;
    private static int rightNode;
    private static int parent;

    //===============================[HEAPSORT]=======================================   
    
    // Build-Heap Function
    public static void buildheap(int[] arr){
    	numItems=arr.length-1;
    	for(int i=numItems/2; i>=0; i--){
    		maxheap(arr,i);
    	}
    }
    
    // Max-Heap Function
    public static void maxheap(int[] arr, int position){
    	leftNode=2*position;
    	rightNode=2*position+1;
    	
    	if(leftNode <= numItems && arr[leftNode] > arr[position]){
    		parent=leftNode;
    	}
    	else{
    		parent=position;
    	}
    	
    	if(rightNode<= numItems && arr[rightNode] > arr[parent]){
    		parent=rightNode;
    	}
    	if(parent!=position){
    		int temp = arr[position];
    	    arr[position] = arr[parent];
    	    arr[parent] = temp;
    		maxheap(arr, parent);
    	}
    }
    
    // Sort Function
    public static int[] heapSort(int[] arr){
    	buildheap(arr);
    	
    	for(int i=numItems;i>0;i--){
    		int temp = arr[0];
    	    arr[0] = arr[i];
    	    arr[i] = temp;
    		numItems=numItems-1;
    		maxheap(arr, 0);
    	}
    	
    	return arr;
    }
    
    //===============================[/HEAPSORT]=======================================   

    //===============================[QUICKSORT]=======================================

    static int[] quickSort(int [] arr){
        numItems = arr.length;
        return myQuickSort(arr, 0, numItems-1);
    }

    static int[] myQuickSort(int[] arr, int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = arr[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (arr[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (arr[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            myQuickSort(arr, low, j);
        if (i < high)
            myQuickSort(arr, i, high);
        
        return arr;
    }

    //===============================[/QUICKSORT]=======================================
    
    //===============================[MERGESORT]=======================================

    public static int[] mergeSort (int[] arr) {
		//if not base case, sort
		if (arr.length > 1) {
			int half =arr.length /2; //find middle point
			int[] a1 = subarray(arr, 0 , half); //establish first subarray
			int [] a2 = subarray (arr, half,arr.length); //establish second subarray
			mergeSort(a1); //sort the first subarray
			mergeSort(a2); //sort the second subarray
			merge(arr, a1, a2); //merge the subarrays
		}

		return arr;
	}

	private static void merge(int [] arr, int[] a1, int[] a2){
		int n1 = a1.length; //size of a1
		int n2 = a2.length; //size of a2
		int i1 = 0; 
		int i2 = 0;

		//while i is less than the length of the entire array
		for (int i = 0; i <arr.length; i++) {
			//if first subarray pointer is equal to the length of a2 OR 
			//first pointer is less than size of a2 but the i1-th element of a1 is less than
			//the i2-th element of a2, set the i-th element of array equal to the i1-th
			//element of a1
			//then increment i1
			if (i2 == n2 || (i1 < n1 && a1[i1] < a2[i2])) {
				arr[i] = a1[i1];
				i1++;
			}
			//otherwise, set the i-th element of array equal to the i2-nd element of a2, and increment i2
			else {
				arr[i] = a2[i2];
				i2++;
			}
		}
	}

	
	private static int [] subarray (int []arr, int p1, int p2) {
		int [] result = new int[p2-p1];

		for (int i = p1; i < p2; i++)
		{
			result[i - p1] =arr[i];
		}
		return result;
	}
	
    //===============================[MERGESORT]=======================================

}

