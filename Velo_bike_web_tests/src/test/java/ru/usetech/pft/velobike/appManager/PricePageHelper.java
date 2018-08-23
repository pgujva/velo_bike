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
        for (WebElement webpri : webprices) {
            String title = webpri.findElement(By.tagName("h4")).getText();
            String text = webpri.findElement(By.tagName("p")).getText();
            String price = webpri.findElement(By.className("price-table__price")).getText();
            String img = webpri.findElement(By.tagName("img")).getAttribute("src");
            WebElement url = webpri.findElement(By.tagName("img"));
            PricePageData pricePageData = new PricePageData(title, text, price, img, url);
            prices.add(pricePageData);
            System.out.println(title);
            System.out.println(text);
            System.out.println(price);
            System.out.println(img);
        }
        return prices;
    }

    public List<PricePageData> getStaticPriceList() {
        List<PricePageData> prices = new ArrayList<PricePageData>();
        PricePageData pricePageData1 = new PricePageData("На Сутки",
                "Доступ на 24 часа. Включены все поездки до 30 мин. Стоимость поездок более 30 мин. списывается с банковской карты.",
                "150\u20BD","https://velobike.ru/media/content/ratedescription/icon/46/8e/468ee97b-db6b-47db-9f90-b3f41a37518a.png",null);
        prices.add(0,pricePageData1);

        PricePageData pricePageData2 = new PricePageData("На Месяц",
                "Доступ на 30 дней. Включены все поездки до 30 мин. Стоимость поездок более 30 мин. списывается с банковской карты.",
                "600\u20BD","https://velobike.ru/media/content/ratedescription/icon/d2/9c/d29c50e2-dac9-4305-970e-190c903ab465.png",null);
        prices.add(1,pricePageData2);

        PricePageData pricePageData3 = new PricePageData("На Сезон",
                "Доступ до 31/10/2018. Включены все поездки до 30 мин. Стоимость поездок более 30 мин. списывается с банковской карты.",
                "990\u20BD","https://velobike.ru/media/content/ratedescription/icon/be/2b/be2b119b-432e-4318-8d33-9bfe61055e7c.png",null);
        prices.add(2,pricePageData3);

        PricePageData pricePageData4 = new PricePageData("На Сезон. 45 мин.",
                "Доступ до 31/10/2018. Включены все поездки до 45 мин. Стоимость поездок более 45 мин. Списывается с банковской карты.",
                "1190\u20BD","https://velobike.ru/media/content/ratedescription/icon/c3/b1/c3b18242-c487-4911-9b71-1facefd0229a.png",null);
        prices.add(3,pricePageData4);


        PricePageData pricePageData5 = new PricePageData("На Сутки",
                "",
                "200\u20BD","https://velobike.ru/media/content/ratedescription/icon/46/8e/468ee97b-db6b-47db-9f90-b3f41a37518a.png",null);
        prices.add(4,pricePageData4);

        PricePageData pricePageData6 = new PricePageData("На Сезон",
                null,
                "700\u20BD","https://velobike.ru/media/content/ratedescription/icon/d2/9c/d29c50e2-dac9-4305-970e-190c903ab465.png",null);
        prices.add(5,pricePageData4);

        PricePageData pricePageData7 = new PricePageData("На Сезон",
                null,
                "1390\u20BD","https://velobike.ru/media/content/ratedescription/icon/be/2b/be2b119b-432e-4318-8d33-9bfe61055e7c.png",null);
        prices.add(6,pricePageData4);

        PricePageData pricePageData8 = new PricePageData("На Сезон. 45 мин.",
                null,
                "1490\u20BD","https://velobike.ru/media/content/ratedescription/icon/c3/b1/c3b18242-c487-4911-9b71-1facefd0229a.png",null);
        prices.add(7,pricePageData4);

        return prices;
    }

}

