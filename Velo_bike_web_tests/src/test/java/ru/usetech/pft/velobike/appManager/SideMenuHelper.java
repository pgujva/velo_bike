package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;

public class SideMenuHelper {
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

    public List<String> getMenuNames() {
        List<WebElement> menuElements = getMenuList();
        List<String> menuNames = new ArrayList<String>();

        for (WebElement name : menuElements) {
            String g = name.getAttribute("textContent");
            menuNames.add(g);

        }
        return menuNames;

    }
}
