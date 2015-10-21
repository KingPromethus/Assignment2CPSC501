import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Reversal {
    public static void reverseFile(File input, File output) throws FileNotFoundException{
        String line;
        ArrayList<String> outputList = new ArrayList<>();

        try {
            FileReader fileReader =
                    new FileReader(input);

            FileWriter fileWriter =
                    new FileWriter(output);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

            while ((line = bufferedReader.readLine()) != null) {
                Scanner in = new Scanner(line);
                outputList.add(in.next());
                while(in.hasNext()){
                    outputList.add(in.next() + " ");
                }
                outputList.add(System.getProperty("line.separator"));
            }
            outputList.remove(outputList.size()-1);
            bufferedReader.close();




            for (int i = outputList.size() - 1; i >= 0; i--) {
                bufferedWriter.write(outputList.get(i));
            }

            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + input + "'");
            throw new FileNotFoundException();
        }
    }
}
