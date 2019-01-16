package ru.usetech.pft.velobike.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
@Listeners(MyTestListener.class)

public class usetest {
  ChromeDriver wd;
  WebDriverWait wait;
  @BeforeMethod
  public void setUp() throws Exception {
    wd= new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void Tesff() {
    wd.get("https://usetechonline.sharepoint.com/sites/portal_test/Pages/Main.aspx");
    wd.findElement(By.id("i0116")).click();
    wd.findElement(By.id("i0116")).clear();
    wd.findElement(By.id("i0116")).sendKeys("pgujva@usetech.ru");
    wd.findElement(By.id("idSIButton9")).click();
    wait = new WebDriverWait(wd, 30);
    WebElement load = wd.findElement(By.name("passwd"));
   wait.until(stalenessOf(load));
   // wait.until(invisibilityOfElementLocated(By.name("passwd")));
  wd.findElement(By.name("passwd")).click();
    wd.findElement(By.name("passwd")).sendKeys("4444");
    wd.findElement(By.id("idSIButton9")).click();
  }
}
