package Summation;

public abstract class Summator implements ISummator{
    protected volatile int currentSum;
    protected volatile boolean canRead;

    public Summator() {
        currentSum = 0;
        canRead = true;
    }

    @Override
    public void SumFromFiles(String[] filesPaths) {

        for (String path : filesPaths) {
            //System.out.print(path);
            if(canRead) {
                FileAnalyzer reader = new FileAnalyzer(this, path);
                reader.start();
            }
        }
    }

    @Override
    public void BlockReading() {
        canRead = false;
    }

}
