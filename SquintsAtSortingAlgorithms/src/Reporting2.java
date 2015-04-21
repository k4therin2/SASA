
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
	
    public static void main(String[] args) {}
    
    public class ReadFile {
        private final String file;
        private final int[] freqArray; //array of frequencies
        private int[][] freqValArray; //array of frequencies and corressponding characters
        private int charCount;
        private int totalChars;
        private int postBitCount;
        
        /**
         * Constructor 
         * @param file filename to be read "--.txt"
         */
        public ReadFile(String file) {
            totalChars = 0;
            charCount = 0;
            postBitCount = 0;
            this.freqArray = new int[1112064]; //allocate an array for frequencies in ASCII utf-8
            this.file = file;
        }
        
        /**
         * Opens the file, reading frequencies into the freqArray into the index that corresponds with it's character.
         * @throws IOException
         */
        public void OpenFile() throws IOException {
            
            //find the file size, and allocate an array
            long fileSize =  Files.size(new File(file).toPath());
            long arraySize = fileSize ; 

            int[] charArray = new int[(int)arraySize];
            
            FileReader fr = new FileReader(file);
            BufferedReader textReader = new BufferedReader(fr);
        
            int index = 0;
            int nextChar = textReader.read();
     


        }

}
