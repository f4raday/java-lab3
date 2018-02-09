package Summation;

/**
 * Created by Andrew on 26-Jan-18.
 */
public interface ISummator {
    void SumFromFiles(String[] filesPaths);
    void AddToSum(int addition);
    void BlockReading();
}
