package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.usetech.pft.velobike.Model.PricePageData;

import java.util.ArrayList;
import java.util.List;

public class PricePageHelper {
    private ChromeDriver wd;
    private WebDriverWait wait;

    public PricePageHelper(ChromeDriver wd, WebDriverWait wait) {
        this.wd = wd;
        this.wait = wait;
    }

    public List<PricePageData> getPriceList() {
        List<PricePageData> prices = new ArrayList<PricePageData>();
        List<WebElement> webprices = wd.findElements(By.className("price-content__column"));
        for(WebElement webpri: webprices) {
        String title =  webpri.findElement(By.tagName("h4")).getText();
        String text = webpri.findElement(By.tagName("p")).getText();
        String price = webpri.findElement(By.className("price-table__price")).getText();
            System.out.println(title);
            System.out.println(text);
            System.out.println(price);
        }
        return null;
    }
}
