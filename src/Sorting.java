

/**
 * Created by Katherine on 4/20/2015.
 */
public class Sorting {


    private static int[] arr;
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
        int[] no = {0};
        return no;
    }

    static int[] mergeSort(int [] arr){
        int[] no = {0};
        return no;
    }
}
