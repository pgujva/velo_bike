package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;

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
}
