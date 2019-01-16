package ru.usetech.pft.velobike.Tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import ru.usetech.pft.velobike.appManager.ApplicationManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
@Listeners(MyTestListener.class)
public class testAllure extends Testbase{
  //protected final ApplicationManager app = new ApplicationManager();
  ChromeDriver wd;
  WebDriverWait wait;

  @BeforeMethod
  public void setUp() throws Exception {
   // context.setAttribute("app",app);
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void Tesff() {
    wd.get("https://velobike.ru/");
    WebElement element = wd.findElement(By.tagName("h2"));
    String a=element.getText();
    System.out.println(a);
    Assert.assertEquals(a,"333");


  }

  public File takeScreenshot() throws IOException {
    String nameFile = "ff";
    //Image img = new ImageIcon("G:\\img.png").getImage();
    String PATHSCREENSHOT = "C:\\images\\im";

    String path = PATHSCREENSHOT + String.format("%s_%s.png", nameFile, System.currentTimeMillis());

    File screenShot_tmp = null;
    File screenShot = new File(path);
    screenShot_tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(screenShot_tmp, screenShot);
    return screenShot;
  }
  @AfterMethod
  public void tearDown() {
    wd.quit();
  }
}
