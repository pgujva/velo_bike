package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MainPageHelper {
  private ChromeDriver wd;
  private WebDriverWait wait;

  public MainPageHelper(ChromeDriver wd, WebDriverWait wait) {
    this.wd = wd;
    this.wait = wait;
  }

  public void goToParkingsPage() {
    WebElement a =  wd.findElement(By.cssSelector("a.address-search__view"));
    wait.until(visibilityOf(a));
    a.click();
  }
}
