package Summation;

/**
 * Created by Andrew on 26-Jan-18.
 */
public class PositiveSummator extends Summator {

    public PositiveSummator() {
        super();
    }


    @Override
    public synchronized void AddToSum(int addition) {
        if(canRead && addition>0 && addition%2==0) {
            currentSum += addition;
            OutputHandler.PrintToConsole(currentSum);
        }
    }
}
