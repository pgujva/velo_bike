package ru.usetech.pft.velobike;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTests extends Testbase {

  @Test
  public void firstTests() throws Exception {
    wd.findElement(By.cssSelector("div.logged-user__photo")).click();

    boolean a = wd.findElement(By.tagName("h1")).getText().equals("Личный кабинет");
    boolean b = wd.findElement(By.cssSelector("span.lk-intro__welcome-name")).getText().equals("Тест!");
    System.out.println(wd.findElement(By.tagName("h1")).getText());
    System.out.println(wd.findElement(By.cssSelector("span.lk-intro__welcome-name")).getText());
    Assert.assertEquals(a,true);
    Assert.assertEquals(b,true);
     //       \\.equals("Личный кабинет");

   // wd.findElement(By.tagName("span")).getText().equals("Tect1");
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
}
