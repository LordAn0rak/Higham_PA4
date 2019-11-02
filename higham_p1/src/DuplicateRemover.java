import java.io.*;
import java.util.*;

public class DuplicateRemover{

    private Set<String> uniqueWords = new HashSet<String>();

    public boolean remove(String dataFile){

        FileInputStream inFile = null;
        Scanner inFileStream = null;
        String tempString;

        //If remove is called we want to overwrite the old unique words for this instance (if they exist).
        //Empty the Set to make room for all new values.
        uniqueWords.clear();

        try{

            inFile = new FileInputStream(dataFile);
            inFileStream = new Scanner(inFile);

            while(inFileStream.hasNext()){

                tempString = inFileStream.next();
                //If I try to add the same string it won't work so it is ok just pushing values straight in
                uniqueWords.add(tempString);
            }
        }
        catch(IOException e){

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

        return true;
    }

    public boolean write(String outputFile){

        FileOutputStream outFile = null;
        PrintWriter outFileStream = null;

        try{

            outFile = new FileOutputStream(outputFile);
            outFileStream = new PrintWriter(outFile);

            uniqueWords.forEach(outFileStream::println);
            outFileStream.flush();
        }
        catch (IOException e){

            System.out.println("Oh no! Something went wrong while writing the file:");
            System.out.println(e.toString());

            //If I throw an exception than we failed at something fileIO related then we are closing the program
            System.exit(1);
        }
        finally{

            try{

                //No point in trying to close a file that never opened
                if (outFile != null){

                    outFile.close();
                }
            }
            //If the .close throws an exception I want to catch it
            catch (IOException e){

                System.out.println("Oh no! Something went wrong while closing the output file:");
                System.out.println(e.toString());

                //If I throw an exception than we failed at something fileIO related then we are closing the program
                System.exit(1);
            }
        }

        return true;
    }
}
