package base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;

public class CustomListener extends BaseX2 implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Reporter.log("Starting test up", true);

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Reporter.log("SUCCESS! Test has been passed", true);

    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log("FAILED! Test has been failed", true);

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Reporter.log("Test is Skipped", true);

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
