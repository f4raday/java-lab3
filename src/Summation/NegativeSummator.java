package Summation;

public class NegativeSummator extends Summator {
    public NegativeSummator() {
        super();
    }

    @Override
    public void AddToSum(int addition) {
        if(canRead && addition<0) {
            currentSum += addition;
            OutputHandler.PrintToConsole(currentSum);
        }
    }
}
