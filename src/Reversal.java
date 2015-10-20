import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Reversal {
    public static void reverseFile(File input, File output) throws FileNotFoundException{
        String line;
        ArrayList<String> lineList = new ArrayList<>();
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
                while(in.hasNext()){
                    outputList.add(in.next() + " ");
                }
                outputList.add(System.getProperty("line.separator"));
            }


            bufferedReader.close();




            for (int i = outputList.size() - 1; i >= 0; i--) {
                bufferedWriter.write(new StringBuilder(outputList.get(i)).toString());
            }

            bufferedWriter.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            input + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + input + "'");
        }
    }

    public static void main(String[] args){
        File input = new File("C:\\Users\\mb_ch\\Documents\\Test.txt");
        File output = new File("C:\\Users\\mb_ch\\Documents\\Output.txt");
        try {
            reverseFile(input, output);
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}
