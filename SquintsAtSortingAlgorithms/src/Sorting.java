

/**
 * Created by Katherine on 4/20/2015.
 */
public class Sorting {

	//variables for heapsort
    private static int numItems;
    private static int leftNode;
    private static int rightNode;
    private static int parent;

    //===============================[HEAPSORT]=======================================   
    
   
    /**
     * Builds a heap out of input array.
     * @param arr input array
     */
    private static void buildheap(int[] arr){
    	numItems=arr.length-1; 
    	
    	for(int i=numItems/2; i > -1; i--){
    		siftDown(arr,i);
    	}
    	
    }
    
    /**
     * Makes necessary adjustments to parent and children so that heap rules are maintained
     * 
     * @param arr input array
     * @param position starting index of current position in heap
     */
    private static void siftDown(int[] arr, int position){
    	leftNode=2*position; //INDEX of left node of current position
    	rightNode=2*position+1; //INDEX of right code of current position
    	
    	//if left index <= total items and the left node is > the parent, set "parent" index as left node index
     	if(leftNode <= numItems && arr[leftNode] > arr[position]){
    		parent=leftNode;
    	}
    	//otherwise, parent will remain same
    	else{
    		parent=position;
    	}
    	//if same situation, but with right node, reset parent accordingly
    	if(rightNode<= numItems && arr[rightNode] > arr[parent]){
    		parent=rightNode;
    	}
    	//and if parent is not equal to the current position, switch around the actual values using calculated indexes
    	if(parent!=position){
    		int temp = arr[position]; 
    	    arr[position] = arr[parent];
    	    arr[parent] = temp; 
    		siftDown(arr, parent); //recursive call for subtree
    	}
    }
    
    /**
     * Performs heapsort on an input array by building a heap and then sifting nodes
     * 
     * @param arr array to be sorted
     * @return sorted array
     */
    public static int[] heapSort(int[] arr){
    	buildheap(arr); 
    	
    	//for each element in heap, from bottom to top, sift down
    	for(int i=numItems; i>0; i--){
    		int temp = arr[0];
    	    arr[0] = arr[i];
    	    arr[i] = temp;
    		numItems=numItems-1;
    		siftDown(arr, 0);
    	}
    	
    	return arr; 
    }
    
    //===============================[/HEAPSORT]=======================================   

    //===============================[QUICKSORT]=======================================

    /**
     * Quicksort sorting algorithm
     * @param arr input array
     * @return sorted array
     */
    public static int[] quickSort(int [] arr){
        numItems = arr.length;
        return myQuickSort(arr, 0, numItems-1);
    }

    /**
     * Sorts an array recursively by splitting into sub-arrays to sort about a pivot
     * 
     * @param arr input array
     * @param start where the sort will start
     * @param end where the sort will end
     * @return sorted array
     */
    private static int[] myQuickSort(int[] arr, int start, int end) {

        int pivot = arr[start + (end-start)/2]; //set pivot as middle element of two subarrays
        int left = start; //left pointer
        int right = end; //right pointer

        // sort input portion of array
        while (left <= right) {
        	
        	//while the left pointer element is less than the pivot value, increment the left pointer because nothing needs to be changed
            while (arr[left] < pivot) {
                left++;
            }
          
            //while the right pointer value is more than the pivot, decrement the right pointer because nothing needs to be changed
            while (arr[right] > pivot) {
                right--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            
            //if, by this point, we have found any left value larger than pivot or right value smaller than pivot,
            //the elements will be switched.
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        
        // recursively call quicksort on left subarray until we have completed sorting left subarray
        if (start < right)
            myQuickSort(arr, start, right);
        //recursively call quicksort on right subarray until we have completed sorting right subarray
        if (left < end)
            myQuickSort(arr, left, end);
        
        return arr;
    }

    //===============================[/QUICKSORT]=======================================
    
    //===============================[MERGESORT]=======================================

    /**
     * @param arr input array
     * @return sorted array
     */
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

