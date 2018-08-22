package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.usetech.pft.velobike.Model.NewsPageData;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class NewsPageHelper {
    private ChromeDriver wd;
    private WebDriverWait wait;

    public NewsPageHelper(ChromeDriver wd, WebDriverWait wait) {
        this.wd = wd;
        this.wait = wait;
    }

    public List<WebElement> getNewsList() {
        List<WebElement> newsList = wd.findElements(By.cssSelector("a.news-list__title"));
        return newsList;
    }

    public List<String> getNewsLinks() {
        List<WebElement> newsList = getNewsList();
        List<String> newsLinks = new ArrayList<String>();
        for (WebElement news : newsList) {
            String link = news.getAttribute("href");
            newsLinks.add(link);
        }

        return newsLinks;
    }

    public void goToOneNewsPage(int index) {
        List<WebElement> newsList = getNewsList();
        newsList.get(index).click();
    }

    public List<String> getNewsTitles() {
        List<WebElement> newsList = getNewsList();
        List<String> newsTitles = new ArrayList<String>();
        for (WebElement news : newsList) {
            String title = news.getAttribute("textContent");
            newsTitles.add(title);
        }
        return newsTitles;

    }

    public String getCurrentPageNewsTitle() {
       String currentPageTitle = wd.findElement(By.tagName("h3")).getAttribute("textContent");
       return currentPageTitle;

    }

    public NewsPageData actualNewsObject(int index) {
        List<WebElement> Datalist = wd.findElements(By.cssSelector("span.news-list__date"));
        List<WebElement> textList = wd.findElements(By.cssSelector("div.news-list__text-box"));
        List<WebElement> newsList = getNewsList();
        String title= newsList.get(index).getText();
        String date = Datalist.get(index).getText();
        String url = newsList.get(index).getAttribute("href");
        String text = textList.get(index).findElement(By.cssSelector("p.MsoNormal")).getAttribute("textContent");
        NewsPageData newsPageData = new NewsPageData(title,date,text,url);
        return newsPageData;
    }

    public NewsPageData expectedNewsObject (int index) {
        List<WebElement> textList = wd.findElements(By.cssSelector("div.news-content"));
        List<WebElement> Datalist = wd.findElements(By.cssSelector("span.news-list__date"));
        String date = Datalist.get(index).getText();
        String title = wd.findElementByTagName("h3").getText();
        String url = wd.getCurrentUrl();
        String text = textList.get(index).findElement(By.cssSelector("p.MsoNormal")).getAttribute("textContent");
        NewsPageData newsPageData = new NewsPageData(title, date, text, url);
        return newsPageData;
    }

    public void initVKrepost() {
        wait.until(elementToBeClickable(By.cssSelector("li.ya-share2__item.ya-share2__item_service_vkontakte > a.ya-share2__link > span.ya-share2__badge > span.ya-share2__icon")));
        wd.findElement(By.cssSelector("li.ya-share2__item.ya-share2__item_service_vkontakte > a.ya-share2__link > span.ya-share2__badge > span.ya-share2__icon")).click();
    }

    public void initFacebookRepost() {
        wait.until(elementToBeClickable(By.cssSelector("li.ya-share2__item.ya-share2__item_service_facebook > a.ya-share2__link > span.ya-share2__badge > span.ya-share2__icon")));
        wd.findElement(By.cssSelector("li.ya-share2__item.ya-share2__item_service_facebook > a.ya-share2__link > span.ya-share2__badge > span.ya-share2__icon")).click();
    }
}
