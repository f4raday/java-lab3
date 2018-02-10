package Summation;

import Loaders.SummationLoader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SummatorInvokationHandler implements InvocationHandler {
    private String CLASS_PATH;

    public SummatorInvokationHandler(String CLASS_PATH) {
        this.CLASS_PATH = CLASS_PATH;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object worker;
        SummationLoader summationLoader = new SummationLoader();

        worker = summationLoader
                .loadClass(CLASS_PATH)
                .newInstance();

        return method.invoke(worker, args);
    }
}