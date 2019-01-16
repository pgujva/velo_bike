package ru.usetech.pft.velobike.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class testAllure {
  ChromeDriver wd;
  WebDriverWait wait;

  @BeforeMethod
  public void setUp() throws Exception {
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

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }
}
