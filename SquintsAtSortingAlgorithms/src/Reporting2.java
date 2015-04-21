import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;


/**
Reporting2 will work by reading input_file into an array, then invoking each of the sorting methods 
on the array three times.  (So you should be sorting the array a total of 9 times.  3 times with each method).
  For the first run of each method, your program will also write out the output file with the name that 
  starts with your case ID and append to it the abbreviation of the method name.  Thus, since my Case ID 
  is mxr136, my program would produce three files: mxr136HS.txt, mxr136QS.txt, and mxr136MS.txt.  
  (Just use string literals to hard-code these names within your program)  Finally, your program must
   print out the results in the form: “HS<caseID> = time; QS<caseID>  = time; MS<caseID> = time;”
    where <caseID> is your Case ID and the time for each algorithm is the median time of the three runs
     using that algorithm.  For instance, my program might produce the output line (do not take these 
     numbers as any indication of what your numbers might look like – I just took these from the thin air;
also indicate the time unite, e.g., “ns” for nanoseconds)

“HSmxr136 = 3682ns; QSmxr136 = 3456ns; MSmxr136 = 4320ns”.

File format: The three files you will be producing must have the same
 format as the input file - one number per line (but of course in the sorted order - from small numbers to large).

 */
public class Reporting2 {
	
    public static void main(String[] args) throws IOException {
    	int[] array = ReadFileArray(args[0]);
    	testSorts(array);
    }
    
	private static void testSorts(int[] arr) throws FileNotFoundException, UnsupportedEncodingException {
		int[] initial = arr.clone();
		double start;
		double end;
		
		for (int i=0; i < 3; i++){
	        arr = initial.clone();
			start = System.nanoTime();
	        Sorting.heapSort(arr);
			end = System.nanoTime()-start;
				if (i==0){
					readToFile("HS", arr);
				    System.out.println("HSkrc53= " +end+"ns");	
				}
				
	        arr = initial.clone();
			start = System.nanoTime();	
			Sorting.quickSort(arr);  
			end = System.nanoTime()-start;
				if (i==0){
					readToFile("QS", arr);
				    System.out.println("QSkrc53= " +end+"ns");	
				}
				
	        arr = initial.clone();
			start = System.nanoTime();	
			Sorting.mergeSort(arr); 
			end = System.nanoTime()-start;
				if (i==0){
					readToFile("MS", arr);
					System.out.println("MSkrc53= " +end+"ns");	
				}
			}
		}

	private static void readToFile(String type, int[] arr) throws FileNotFoundException, UnsupportedEncodingException {
         String fileName = "krc53"+type+".txt";
         PrintWriter writer = new PrintWriter(fileName, "UTF-8");
         writer.println(Arrays.toString(arr));
         writer.close();
	}

        /**
         * Opens the file
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
