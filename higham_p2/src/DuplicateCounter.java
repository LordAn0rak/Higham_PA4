import java.io.*;
import java.util.*;

public class DuplicateCounter {

    Map<String, Integer> wordCounter = new HashMap<>();

    public void count(String dataFile) {

        FileInputStream inFile = null;
        Scanner inFileStream = null;
        String tempString;
        int tempInt;

        try {

            inFile = new FileInputStream(dataFile);
            inFileStream = new Scanner(inFile);

            while(inFileStream.hasNext()) {

                tempString = inFileStream.next();
                //If I try to add the same string it won't work so it is ok just pushing values straight in
                if(wordCounter.containsKey(tempString)) {


                    wordCounter.replace(tempString, (wordCounter.get(tempString) + 1));
                }
                else {

                    wordCounter.put(tempString, 1);
                }
            }
        }
        catch(IOException e) {

            System.out.println("Oh no! Something went wrong while reading the file:");
            System.out.println(e.toString());

            //If I throw an exception than we failed at something fileIO related then we are closing the program
            System.exit(1);
        }
        //No matter what happens I don't want to leave the file open (If it opened in the first place)_
        finally{

            try{

                //No point in trying to close a file that never opened
                if(inFile != null){

                    inFile.close();
                }
            }
            //If the .close throws an exception I want to catch it
            catch(IOException e){

                System.out.println("Oh no! Something went wrong while closing the input file:");
                System.out.println(e.toString());

                //If I throw an exception than we failed at something fileIO related then we are closing the program
                System.exit(1);
            }
        }
    }

    public void write(String outputFile) {

        FileOutputStream outFile = null;
        PrintWriter outFileStream = null;

        try {

            outFile = new FileOutputStream(outputFile);
            outFileStream = new PrintWriter(outFile);

            for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
                outFileStream.println("Word: " + entry.getKey() + " Count: " + entry.getValue());
            }

            outFileStream.flush();
        }
        catch (IOException e) {

            System.out.println("Oh no! Something went wrong while writing the file:");
            System.out.println(e.toString());

            //If I throw an exception than we failed at something fileIO related then we are closing the program
            System.exit(1);
        }
        finally {

            try {

                //No point in trying to close a file that never opened
                if (outFile != null) {

                    outFile.close();
                }
            }
            //If the .close throws an exception I want to catch it
            catch (IOException e) {

                System.out.println("Oh no! Something went wrong while closing the output file:");
                System.out.println(e.toString());

                //If I throw an exception than we failed at something fileIO related then we are closing the program
                System.exit(1);
            }
        }
    }
}
