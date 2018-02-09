package Summation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Andrew on 26-Jan-18.
 */
public class FileAnalyzer extends Thread {

    private ISummator summator;
    private String path;
    
    public FileAnalyzer(ISummator summator, String path) {
        this.summator = summator;
        this.path = path;
    }

    public void run(){
        BufferedReader reader = null;
        try  {
            reader = new BufferedReader(new FileReader(path));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                int[] numbers = Parser.Parse(currentLine);
                for (int number : numbers)
                    summator.AddToSum(number);
            }
        } catch (NumberFormatException e) {
            summator.BlockReading();
            System.out.println("Files may only contain numbers, '-' and spaces. Exception for file: " + path);
        } catch (FileNotFoundException e) {
            summator.BlockReading();
            System.out.println("File not found: " + path);
        } catch (IOException e) {
            summator.BlockReading();
            System.out.println("Unknown exception:");
            e.printStackTrace();
        } finally {
            if(reader !=null) try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error when closing:" + path);
                e.printStackTrace();
            }
        }
    }
}
