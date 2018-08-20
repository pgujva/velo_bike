package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;

public class SideMenuHelper extends ApplicationManager{
    private ChromeDriver wd;
    private WebDriverWait wait;

    public SideMenuHelper(ChromeDriver wd, WebDriverWait wait) {
        this.wd = wd;
        this.wait = wait;
    }

    public List<WebElement> getMenuList() {
        List<WebElement> menuElements = wd.findElements(By.cssSelector("a.nav__link"));
        return menuElements;
    }

    public List<String> getMenuNamesFromPage() {
        List<WebElement> menuElements = getMenuList();
        List<String> menuNames = new ArrayList<String>();

        for (WebElement name : menuElements) {
            String g = name.getAttribute("textContent");
            menuNames.add(g);

        }
        return menuNames;

    }

    public List<WebElement> getNewMenuList() {
        List<WebElement> menuElements = wd.findElements(By.cssSelector("a.href"));
        return menuElements;
    }


    public List<String> getMenuLinksFromPage() {
        List<WebElement> menuList = wd.findElements(By.cssSelector("div.side-nav__holder a[href*='/']"));
        List<String> menuLinks = new ArrayList<String>();
        for (WebElement element : menuList) {
            String g = element.getAttribute("href");
            menuLinks.add(g);
        }
        return menuLinks;

    }

    public List<String> getStaticMenuLinks() {
        List<String> menuLinks = Arrays.asList(
                "https://velobike.ru/rules/",
                "https://velobike.ru/prices/",
                "https://velobike.ru/parkings/",
                "https://velobike.ru/contacts/",
                "https://velobike.ru/qa/",
                "https://electro.velobike.ru/",
                "https://velobike.ru/news/",
                "https://velobike.ru/about/",
                "http://vk.com/velobikeru",
                "https://www.facebook.com/velobike.ru",
                "https://www.instagram.com/velobike.ru/",
                "https://t.me/velobikeru_bot");

        return menuLinks;
    }
}


