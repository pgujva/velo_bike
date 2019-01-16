package ru.usetech.pft.velobike.Tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.usetech.pft.velobike.appManager.ApplicationManager;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

public class MyTestListener implements ITestListener {
  @Override
  public void onTestStart(ITestResult result) {

  }

  @Override
  public void onTestSuccess(ITestResult result) {

  }

  @Override
  public void onTestFailure(ITestResult result) {
    ApplicationManager app = (ApplicationManager) result.getTestContext().getAttribute("app");
    try {
      saveScreenshot(app.takeScreenshot());
    } catch (IOException e) {
      e.printStackTrace();
    }


  }

  @Attachment(value = "Page screenshot", type = "image/png")

  public File saveScreenshot(File screenShot) {
    return screenShot;
  }


  @Override
  public void onTestSkipped(ITestResult result) {

  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

  }

  @Override
  public void onStart(ITestContext context) {

  }

  @Override
  public void onFinish(ITestContext context) {

  }
}
