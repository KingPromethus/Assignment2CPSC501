import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ReversalTest {
    @Rule public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void testReverseFile() throws Exception {
        try{
            File output = new File("output.txt");
            File file = new File("original.txt");
            PrintWriter write = new PrintWriter(file);
            write.println("This is the first line");
            write.println("This is the second line");
            write.println("This is the third line");
            write.close();

            Reversal.reverseFile(file, output);

            assertTrue("Output file does not exist", output.exists());
            String[] result = new String[]{"line third the is This", "line second the is This", "line first the is This"};

            assertContents(output, result);


        }
        catch (IOException e){
            fail("There should not be an exception");
        }
    }

    @Test
    public void testReverseFile2() throws Exception {
        try{
            File output = new File("output.txt");
            File file = new File("original.txt");
            PrintWriter write = new PrintWriter(file);
            write.println("Lorem ipsum dolor sit amet,");
            write.println("consectetur adipiscing elit.");
            write.close();

            Reversal.reverseFile(file, output);

            assertTrue("Output file does not exist", output.exists());
            String[] result = new String[]{"elit. adipiscing consectetur", "amet, sit dolor ipsum Lorem"};

            assertContents(output, result);


        }
        catch (IOException e){
            fail("There should not be an exception");
        }
    }

    public void assertContents(File file, String[] result) throws FileNotFoundException{
        Scanner scan = new Scanner(file);
        int line = 0;
        for(String expected : result){
            if(scan.hasNextLine()){
                String actual = scan.nextLine();
                assertEquals(String.format("Incorrect result [line %d]", line), expected, actual);
            }
            else{
                fail(String.format("Unexpected end of file [line %d]: expected \"%s\"", line, expected));
            }
            line++;
        }
        assertFalse(String.format("File contains more data than expected [line: %d]",line), scan.hasNext());
        scan.close();
    }


}