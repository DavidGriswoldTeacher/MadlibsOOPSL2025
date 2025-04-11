import java.util.Scanner;
import java.io.*;

public class InputOutput {
    
    private Scanner in = new Scanner(System.in);
    private Scanner fileInput;
    private File file;

    private File outFile;
    private PrintStream fileOutput;

    public void openFile(String filename) throws FileNotFoundException {
        file = new File(filename);
        fileInput = new Scanner(file);
    }

    public void openWriteFile(String filename) {
        try {
            outFile = new File(filename);
            fileOutput = new PrintStream(outFile);
        }catch (Exception e) {
            output("Output file was not opened - error " + e.toString());
            outFile = null;
            fileOutput = null;
        }
    }

    public void closeWriteFile() {
        fileOutput.close();
        outFile = null;
        fileOutput = null;
    }

    public void writeToFile(String s) {
        if (fileOutput == null) {
            return;
        }else {
            fileOutput.println(s);
            fileOutput.flush();
        }
    }

    public void closeFile() {
        fileInput.close();
        file = null;
        fileInput = null;
    }

    public boolean fileHasNextLine() {
        if (fileInput == null) {
            return false;
        }else {
            return fileInput.hasNextLine();
        }
    }

    public String getNextLine() {
        if (fileHasNextLine()) {
            return fileInput.nextLine();
        }else {
            return "";
        }
        
    }

    public void output(String s) {
        System.out.println(s);
    }

    public String input() {
        return in.nextLine();
    }

}
