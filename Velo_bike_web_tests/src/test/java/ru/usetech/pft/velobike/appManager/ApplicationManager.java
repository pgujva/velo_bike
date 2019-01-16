package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class ApplicationManager {

WebDriver wd;

  private NavigationHelper navigationHelper;
  private SessionHelper sessionHelper;
  private EnterToSystemHelper enterToSystemHelper;
  private HelperBase helperBase;
  private SideMenuHelper sideMenuHelper;
  private NewsPageHelper newsPageHelper;
  private PricePageHelper pricePageHelper;
  private ElectroVoloBikeHelper electroVoloBikeHelper;
  private MapHelper mapHelper;
  private MainPageHelper mainPageHelper;
  private WebDriverWait wait;

  public void init() {
    String browser = BrowserType.CHROME;
    if(browser == BrowserType.CHROME) {
      wd = new ChromeDriver();
    } else if (browser == BrowserType.FIREFOX) {
      wd= new FirefoxDriver();
    } else  if (browser == BrowserType.IE) {
      wd= new InternetExplorerDriver();
    }

    wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    wait = new WebDriverWait(wd, 20);
    wd.manage().window().fullscreen();
    wd.get("https://velobike.ru/");
    helperBase = new HelperBase(wd, wait);
    navigationHelper = new NavigationHelper(wd, wait);
    sessionHelper = new SessionHelper(wd, wait);
    enterToSystemHelper = new EnterToSystemHelper(wd, wait);
    sideMenuHelper = new SideMenuHelper(wd, wait);
    newsPageHelper = new NewsPageHelper(wd, wait);
    pricePageHelper = new PricePageHelper(wd, wait);
    electroVoloBikeHelper = new ElectroVoloBikeHelper(wd, wait);
    mainPageHelper = new MainPageHelper(wd,wait);
    mapHelper = new MapHelper(wd,wait);
    //sessionHelper.loginInSideMenu("4001776", "3875");
  }

  public void stop() {
 wd.quit();
  }

  public HttpSession newSession() {
    return new HttpSession(this);
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

  public SideMenuHelper getSideMenuHelper() {
    return sideMenuHelper;
  }

  public NewsPageHelper getNewsPageHelper() {
    return newsPageHelper;
  }

  public PricePageHelper getPricePageHelper() {
    return pricePageHelper;
  }

  public ElectroVoloBikeHelper getElectroVoloBikeHelper() {
    return electroVoloBikeHelper;
  }

  public MapHelper getMapHelper () {
    return mapHelper;
  }

  public MainPageHelper getMainPageHelper () {
    return mainPageHelper;
  }



  public byte[] takeScreenshot() {
    return ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
  }

 /*public File takeScreenshot() throws IOException {
    String nameFile = "ff";
    //Image img = new ImageIcon("G:\\img.png").getImage();
   String PATHSCREENSHOT="C:\\images\\im";

String path = PATHSCREENSHOT + String.format("%s_%s.png", nameFile, System.currentTimeMillis());

    File screenShot_tmp = null;
    File screenShot = new File(path);
     screenShot_tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
     FileUtils.copyFile(screenShot_tmp, screenShot);
     return screenShot;
 }
*/



}

