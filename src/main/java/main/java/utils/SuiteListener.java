package main.java.utils;

import test.java.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SuiteListener implements ITestListener, IAnnotationTransformer {
    @Override
    public void onTestStart(ITestResult result) {
// TODO Auto-generated method stub
    }

    @Override
    public void onTestSuccess(ITestResult result) {
// TODO Auto-generated method stub
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String filename = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + result.getMethod().getMethodName();
        File f = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(f, new File(filename + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Failure of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
// TODO Auto-generated method stub
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
// TODO Auto-generated method stub
    }

    @Override
    public void onStart(ITestContext context) {
// TODO Auto-generated method stub
    }

    @Override
    public void onFinish(ITestContext context) {
// TODO Auto-generated method stub
    }
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method){
        iTestAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}


