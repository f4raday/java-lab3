package Summation;

/**
 * Created by Andrew on 26-Jan-18.
 */
public class Parser {
    public static int[] Parse(String line) throws NumberFormatException {
        String[] words = line.split(" ");
        int[] numbers = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            numbers[i] = Integer.parseInt(words[i]);
        }

        return numbers;
    }
}
