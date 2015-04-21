

/**
 * Created by Katherine on 4/20/2015.
 */
public class Sorting {


  //  private static int[] arr;
    private static int numItems;
    private static int leftNode;
    private static int rightNode;
    private static int parent;

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


    

    static int[] mergeSort(int [] arr){
        int[] no = {0};
        return no;
    }
}