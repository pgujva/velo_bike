package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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
}
