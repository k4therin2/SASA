import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


/**
Reporting2 will work by reading input_file into an array, then invoking each of the sorting methods 
on the array three times.  (So you should be sorting the array a total of 9 times.  3 times with each method).
  For the first run of each method, your program will also write out the output file with the name that 
  starts with your case ID and append to it the abbreviation of the method name.  Thus, since my Case ID 
  is mxr136, my program would produce three files: mxr136HS.txt, mxr136QS.txt, and mxr136MS.txt.  
  (Just use string literals to hard-code these names within your program)  Finally, your program must
   print out the results in the form: �HS<caseID> = time; QS<caseID>  = time; MS<caseID> = time;�
    where <caseID> is your Case ID and the time for each algorithm is the median time of the three runs
     using that algorithm.  For instance, my program might produce the output line (do not take these 
     numbers as any indication of what your numbers might look like � I just took these from the thin air;
also indicate the time unite, e.g., �ns� for nanoseconds)

�HSmxr136 = 3682ns; QSmxr136 = 3456ns; MSmxr136 = 4320ns�.

File format: The three files you will be producing must have the same
 format as the input file - one number per line (but of course in the sorted order - from small numbers to large).

 */
public class Reporting2 {
	
    public static void main(String[] args) throws IOException {
    	int[] array = ReadFileArray("C\Users\Katherine\IdeaProjects\SquintsAtSortingAlgorithms\SASA\SquintsAtSortingAlgorithms\src\sample");
    	System.out.println(Arrays.toString(array));
    }
    

        
        /**
         * Opens the file
         * @throws IOException
         */
        public static int[] ReadFileArray(String f) throws IOException {
            
            int count = 0; //number of ints in file
            File file = new File(f);
            FileReader fr = new FileReader(file);
            BufferedReader counter = new BufferedReader(fr);
            
            //count num of items in file's array
            int val = counter.read();
            while (val != -1){
             count++;
             val = counter.read();
            }
            
            int[] array = new int[count];
            int i = 0;
            
            //read values into array
            BufferedReader grabber = new BufferedReader(fr);
            val = (int) grabber.read();
	            while (val != -1){
	                array[i] = val;
	                i++;
	                val = (int) grabber.read();
	               }
	            
            fr.close();
            return array;
        }

}
