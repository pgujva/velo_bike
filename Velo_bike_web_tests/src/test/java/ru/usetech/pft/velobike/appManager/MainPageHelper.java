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
    WebElement a = wd.findElement(By.cssSelector("a.address-search__view"));
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

  public List<PricePageData> getStaticPriceList() {
    List<PricePageData> prices = new ArrayList<PricePageData>();

    PricePageData pricePageData0 = new PricePageData("Сутки",
            "Включает поездки\nдо 30 минут",
            "150 \u20BD", "https://velobike.ru/media/content/ratedescription/icon/46/8e/468ee97b-db6b-47db-9f90-b3f41a37518a.png", null);
    prices.add(0, pricePageData0);

    PricePageData pricePageData1 = new PricePageData("Weekend",
            "Включает поездки\nдо 60 минут",
            "350 \u20BD", "https://velobike.ru/media/content/ratedescription/icon/4f/d8/4fd85064-21c9-414f-9778-b4238d78f3dd.png", null);
    prices.add(1, pricePageData1);

    PricePageData pricePageData2 = new PricePageData("Месяц",
            "Включает поездки\nдо 30 минут",
            "600 \u20BD", "https://velobike.ru/media/content/ratedescription/icon/d2/9c/d29c50e2-dac9-4305-970e-190c903ab465.png", null);
    prices.add(2, pricePageData2);

    PricePageData pricePageData3 = new PricePageData("Сезон",
            "Включает поездки\nдо 30 минут",
            "990 \u20BD", "https://velobike.ru/media/content/ratedescription/icon/be/2b/be2b119b-432e-4318-8d33-9bfe61055e7c.png", null);
    prices.add(3, pricePageData3);

    PricePageData pricePageData4 = new PricePageData("Сезон. 45 мин.",
            "Включает поездки\nдо 45 минут",
            "1190 \u20BD", "https://velobike.ru/media/content/ratedescription/icon/c3/b1/c3b18242-c487-4911-9b71-1facefd0229a.png", null);
    prices.add(4, pricePageData4);


    return prices;
  }
}
