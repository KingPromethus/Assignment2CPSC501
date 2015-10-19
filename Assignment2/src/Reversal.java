import java.io.*;
import java.util.ArrayList;

public class Reversal {
    public static void reverseFile(File input, File output) throws FileNotFoundException{
        String line;

        ArrayList<String> outputList = new ArrayList<String>();

        try {

            FileReader fileReader =
                    new FileReader(input);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                outputList.add(line);
            }

            bufferedReader.close();

            FileWriter fileWriter =
                    new FileWriter(output);
            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);
            for (int i = 0; i < outputList.size(); i++) {
                bufferedWriter.write(new StringBuilder(outputList.get(i)).reverse().toString());
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
