package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper {
  private ChromeDriver wd;

  public NavigationHelper(ChromeDriver wd) {
    this.wd=wd;
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
