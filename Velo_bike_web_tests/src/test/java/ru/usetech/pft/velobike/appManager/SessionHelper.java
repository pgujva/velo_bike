package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper {
  private ChromeDriver wd;
  public SessionHelper(ChromeDriver wd) {
    this.wd = wd;
  }

  public void login(String userLog, String pin) {
    wd.findElement(By.xpath("//a[contains(text(),'Войти')]")).click();
    wd.findElement(By.id("id_login")).click();
    wd.findElement(By.id("id_login")).clear();
    wd.findElement(By.id("id_login")).sendKeys(userLog);
    wd.findElement(By.id("id_pin")).click();
    wd.findElement(By.id("id_pin")).clear();
    wd.findElement(By.id("id_pin")).sendKeys(pin);
    wd.findElement(By.cssSelector("input.btn-red.h_mb32[value=Войти]")).click();
  }
}
