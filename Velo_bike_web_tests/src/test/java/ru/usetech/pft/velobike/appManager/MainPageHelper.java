package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.usetech.pft.velobike.Model.PricePageData;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

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

  public List<PricePageData> getPriceList() {
    List<PricePageData> prices = new ArrayList<PricePageData>();

    List<WebElement> webprices = wd.findElements(By.cssSelector("div.price-table__item"));
    for (WebElement webpri : webprices) {
      String title = webpri.findElement(By.className("price-table__sub-title")).getText();
      String text = webpri.findElement(By.className("price-table__note-text")).getAttribute("innerText");
      String price = webpri.findElement(By.className("price-table__price")).getText();
      String img = webpri.findElement(By.cssSelector("div.price-table__image img")).getAttribute("src");
      WebElement url = webpri.findElement(By.cssSelector("a[href='#']"));
      PricePageData pricePageData = new PricePageData(title, text, price, img, url);
      prices.add(pricePageData);
    }
    return prices;
  }
}
