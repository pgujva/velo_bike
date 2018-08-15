package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  ChromeDriver wd;
  private  NavigationHelper navigationHelper;
  private SessionHelper sessionHelper;
  public void init() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.manage().window().fullscreen();
    wd.get("https://velobike.ru/");
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("4001776", "3875");
  }



  public void stop() {
    wd.quit();
  }

  public boolean isThereARightPage(By locator, String expText, By locator_2, String expText2, String expURL) {
    if(
    wd.findElement(locator).getText().equals(expText) &&
    wd.findElement(locator_2).getText().equals(expText2) &&
    wd.getCurrentUrl().equals(expURL)) {
      return true;
    } else return false;
  }

  public boolean isThereContact() {
    return isElementPresent(By.name("entry"));
  }

  public boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
