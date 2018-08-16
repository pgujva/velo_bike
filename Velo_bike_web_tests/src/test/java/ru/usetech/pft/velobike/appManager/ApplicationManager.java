package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  ChromeDriver wd;
  private  NavigationHelper navigationHelper;
  private SessionHelper sessionHelper;
  private EnterToSystemHelper enterToSystemHelper;
  private HelperBase helperBase;
  private WebDriverWait wait;

  public void init() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait = new WebDriverWait(wd, 10);
   //wd.manage().window().fullscreen();
    wd.get("https://velobike.ru/");
    helperBase = new HelperBase(wd,wait);
    navigationHelper = new NavigationHelper(wd,wait);
    sessionHelper = new SessionHelper(wd,wait);
    enterToSystemHelper = new EnterToSystemHelper(wd,wait);

  }

  public void stop() {
  wd.quit();
  }



  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public EnterToSystemHelper getEnterToSystemHelper() {
    return enterToSystemHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public HelperBase getHelperBase() {
    return helperBase;
  }
}
