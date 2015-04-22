import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;


/**  
 *  A test class that reads an array from an input file, and then performs each sorting method on array three times. The program prints
 *  the results of the first run of each algorithm to an output file, and prints to the console the average time of each sort for each algorithm.
 *  
 * @author Katherine Cass
 *
 */
public class Reporting2 {
	
    public static void main(String[] args) throws IOException {
    	int[] array = ReadFileArray(args[0]);
    	testSorts(array);
    }
    
	/**
	 * Tests sorting algorithms on input array.
	 * @param arr input array
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	private static void testSorts(int[] arr) throws FileNotFoundException, UnsupportedEncodingException {
		int[] initial = arr.clone(); //be sure that the array is properly copied
		double start; //start time of timer
		double hsend = 0; //end time of heapsort
		double qsend = 0; //end time of quicksort
		double msend = 0; //endtime of mergesort
		
		//runs 3 times, being careful to clone the arrays and not copy the address
		//on the first iteration, if statements print result to file
		for (int i=0; i < 3; i++){
	        arr = initial.clone();
			start = System.nanoTime();
	        Sorting.heapSort(arr);
			hsend += System.nanoTime()-start;
				if (i==0)
					readToFile("HS", arr); 

	        arr = initial.clone();
			start = System.nanoTime();	
			Sorting.quickSort(arr);  
			qsend += System.nanoTime()-start;
				if (i==0)
					readToFile("QS", arr);	
				
				
	        arr = initial.clone();
			start = System.nanoTime();	
			Sorting.mergeSort(arr); 
			msend = System.nanoTime()-start;
				if (i==0)
					readToFile("MS", arr);
			}
		
		//print result times
		 System.out.println("HSkrc53 = "+hsend/3+"ns; QSkrc53 = "+qsend/3+"ns; MSkrc53 = "+msend/3 + "ns");
		}

	private static void readToFile(String type, int[] arr) throws FileNotFoundException, UnsupportedEncodingException {
         String fileName = "krc53"+type+".txt";
         PrintWriter writer = new PrintWriter(fileName, "UTF-8");
         writer.println(Arrays.toString(arr));
         writer.close();
	}

        /**
         * Opens the file to be read
         * @param f file name
         * @return array read from file
         * @throws IOException
         */
        public static int[] ReadFileArray(String f) throws IOException {
            
            int count = 0; //number of ints in file
            File file = new File(f);
            FileReader fr = new FileReader(file);
            Scanner counter = new Scanner(fr);
            
            //count num of items in file's array
            while (counter.hasNext()){
                count++;
            	counter.nextInt();
            }
            
            //allocate memory for array
            int[] array = new int[count];
            int i = 0;
            fr.close();
            counter.close();
            
            //read values into array
            FileReader fr2 = new FileReader(file);
            Scanner grabber = new Scanner(fr2);
            
	            while (grabber.hasNext()){
	                array[i] = grabber.nextInt();
	                i++;
	               }
	            
            fr2.close();
            grabber.close();
            return array;
        }

}
