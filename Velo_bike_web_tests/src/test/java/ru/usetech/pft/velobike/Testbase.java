package ru.usetech.pft.velobike;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Testbase {
  ChromeDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
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

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }
}
