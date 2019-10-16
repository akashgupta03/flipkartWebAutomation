package listener;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer, IInvokedMethodListener {

    @SuppressWarnings("rawtypes")
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);

    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        IRetryAnalyzer retry = result.getMethod().getRetryAnalyzer();
        if (retry == null) {
            return;
        }
        result.getTestContext().getFailedTests().removeResult(result.getMethod());
        result.getTestContext().getSkippedTests().removeResult(result.getMethod());
    }

}



