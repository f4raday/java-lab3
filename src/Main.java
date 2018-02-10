//import Summation.NegativeSummator;
//import Summation.PositiveSummator;

import Summation.ISummator;
import Summation.SummatorInvokationHandler;

import java.lang.reflect.Proxy;

/**
 * Created by Andrew on 26-Jan-18.
 */
public class Main {
    public static void main(String[] args) {
        //new PositiveSummator().SumFromFiles(args);
        //new NegativeSummator().SumFromFiles(args);


        ISummator summator = (ISummator) Proxy.newProxyInstance(
                ISummator.class.getClassLoader(),
                new Class[]{ISummator.class},
                new SummatorInvokationHandler("Summation.PositiveSummator"));

        summator.SumFromFiles(args);
    }
}
