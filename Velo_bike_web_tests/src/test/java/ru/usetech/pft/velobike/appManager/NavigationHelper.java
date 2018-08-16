package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationHelper {
  private ChromeDriver wd;
  private WebDriverWait wait;

  public NavigationHelper(ChromeDriver wd, WebDriverWait wait) {
    this.wd=wd;
    this.wait = wait;
  }

  public void goToPersonalAccountPage() {
    wd.findElement(By.cssSelector("div.logged-user__photo")).click();
  }

  public void goToModifyAccountPage() {

  }

  public void goToRegPageFromMenu() {
    wd.findElement(By.cssSelector("a.side-opener")).click();
  }
}
