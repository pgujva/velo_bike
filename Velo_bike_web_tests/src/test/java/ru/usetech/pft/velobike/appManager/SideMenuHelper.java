package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class SideMenuHelper extends ApplicationManager {
    private WebDriver wd;
    private WebDriverWait wait;

    public SideMenuHelper(WebDriver wd, WebDriverWait wait) {
        this.wd = wd;
        this.wait = wait;
    }

    public List<WebElement> getMenuList() {
        wait.until(visibilityOfAllElements(wd.findElements(By.cssSelector("a.href"))));
        wd.manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);
        List<WebElement> menuElements = wd.findElements(By.cssSelector("li.nav__link"));
        return menuElements;
    }

    public List<String> getMenuNamesFromPage() {
       // wd.manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);
        List<WebElement> menuElements = wd.findElements(By.cssSelector("nav.nav a[href*='/']"));
        List<String> menuNames = new ArrayList<String>();

        for (WebElement name : menuElements) {
            String g = name.getAttribute("textContent");
            menuNames.add(g);

        }
        return menuNames;

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

    public List<String> getStaticMenuNames() {
        List<String> menuNames = Arrays.asList(
                "Как пользоваться прокатом",
                "Стоимость",
                "Карта станций",
                "Контакты и помощь",
                "Вопросы и ответы",
                "Электропрокат",
                "Новости",
                "О велобайке"
        );
        return menuNames;
    }

    public void changePages(List<String> pageLinks, int i) {
        getNavigationHelper().goToSideMenu();
        List<WebElement> newMenuElements = getSideMenuHelper().getMenuList();
        getHelperBase().waitVisibilityOfElements(newMenuElements);
        newMenuElements.get(i).click();
        pageLinks.add(getHelperBase().getCurrentPageURL());
        getHelperBase().returnBack();
    }
}


