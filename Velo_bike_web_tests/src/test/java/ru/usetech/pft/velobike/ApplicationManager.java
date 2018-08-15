package ru.usetech.pft.velobike;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  ChromeDriver wd;

  public void init() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.manage().window().fullscreen();
    wd.get("https://velobike.ru/");
    login("4001776", "3875");
  }

  private void login(String userLog, String pin) {
    wd.findElement(By.xpath("//a[contains(text(),'Войти')]")).click();
    wd.findElement(By.id("id_login")).click();
    wd.findElement(By.id("id_login")).clear();
    wd.findElement(By.id("id_login")).sendKeys(userLog);
    wd.findElement(By.id("id_pin")).click();
    wd.findElement(By.id("id_pin")).clear();
    wd.findElement(By.id("id_pin")).sendKeys(pin);
    wd.findElement(By.cssSelector("input.btn-red.h_mb32[value=Войти]")).click();
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
  public void goToPersonalAccount() {
    wd.findElement(By.cssSelector("div.logged-user__photo")).click();
  }
}
