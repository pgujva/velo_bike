package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class HelperBase {
    private ChromeDriver wd;
    private WebDriverWait wait;

    public HelperBase(ChromeDriver wd, WebDriverWait wait) {

        this.wd = wd;
        this.wait = wait;
    }

    public boolean isThereARightPage(By locator, String expText, By locator_2, String expText2, String expURL) {
        if(
                wd.findElement(locator).getText().equals(expText) &&
                        wd.findElement(locator_2).getText().equals(expText2) &&
                        wd.getCurrentUrl().equals(expURL)) {
            return true;
        } else return false;

    }

    public boolean isThereContact() {
        return isElementPresent(By.name("entry"));
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public String getPageName() {
        String pagename = wd.findElement(By.tagName("h1")).getText();
        return pagename;
    }
    public void waitVisibilityOfElement(By locator) {
        wait.until(visibilityOfAllElements();
        wd.manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);

    }
}
