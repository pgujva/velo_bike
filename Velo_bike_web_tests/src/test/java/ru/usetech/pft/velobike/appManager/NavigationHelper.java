package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class NavigationHelper {
  private ChromeDriver wd;
  private WebDriverWait wait;

  public NavigationHelper(ChromeDriver wd, WebDriverWait wait) {
    this.wd = wd;
    this.wait = wait;
  }

  public void goToPersonalAccountPage() {
    wd.findElement(By.cssSelector("div.logged-user__photo")).click();
  }

  public void goToModifyAccountPage() {

  }

  public List<WebElement> getMenuList() {
    List<WebElement> menuElements = wd.findElements(By.className("nav__link"));
   return menuElements;
  }

  public void goToSideMenu() {

    wait.until(visibilityOf(wd.findElement(By.cssSelector("a.side-opener")))).click();
    //wd.findElement(By.cssSelector("a.side-opener")).click();

  }
}
