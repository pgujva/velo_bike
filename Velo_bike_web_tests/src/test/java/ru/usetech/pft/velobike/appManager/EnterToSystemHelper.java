package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterToSystemHelper {
    private WebDriver wd;
    private WebDriverWait wait;

    public EnterToSystemHelper(WebDriver wd, WebDriverWait wait){
        this.wd = wd;
        this.wait = wait;
    }

    public void goToSideMenu() {
        wd.findElement(By.cssSelector("a.side-opener")).click();

    }
}
