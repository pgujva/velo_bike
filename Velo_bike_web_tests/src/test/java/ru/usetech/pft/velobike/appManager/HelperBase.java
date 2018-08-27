package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
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
        if (
                wd.findElement(locator).getText().equals(expText) &&
                        wd.findElement(locator_2).getText().equals(expText2) &&
                        wd.getCurrentUrl().equals(expURL)
                ) {
            return true;
        } else return false;
    }

    public boolean isThereAElement() {
        return isElementPresent(By.className("side-opener"));
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public String getPageName(By locator) {
        String pagename = wd.findElement(locator).getText();
        return pagename;
    }

    public void waitVisibilityOfElement(List<WebElement> menuElements) {
        wait.until(visibilityOfAllElements(menuElements));
        wd.manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);

    }

    public void waitElementLoad() {
        wait.until(visibilityOfElementLocated(By.tagName("h1")));
    }

    public String getCurrentPageURL() {
        String pagename = wd.getCurrentUrl();
        return pagename;
    }

    public void returnBack() {
        wd.navigate().back();
    }

    public String getCurrentWindowHandle() {
        String handle = wd.getWindowHandle();
        return handle;
    }

    public void switchWindow(String handle) {
        wd.switchTo().window(handle);
    }

    public String getCurrentWindowHandles() {
        String window = HelperBase.getLastElement(wd.getWindowHandles());

        return window;
    }

    public void switchToNewWindow() {

        String window = HelperBase.getLastElement(wd.getWindowHandles());
      wd.switchTo().window(window );
    }
    public static <T> T getLastElement(final Iterable<T> elements) {
        final Iterator<T> itr = elements.iterator();
        T lastElement = itr.next();

        while(itr.hasNext()) {
            lastElement=itr.next();
        }

        return lastElement;
    }

    public String getVKpageName() {
        String pageName = wd.findElement(By.cssSelector("a.oauth_logo.fl_l")).getAttribute("href");
        return pageName;
    }

    public void closeWindow() {
        wd.close();
    }

    public String getFacebookpageName() {
        String pageName = wd.findElement(By.tagName("h2")).getAttribute("textContent");
        return  pageName;
    }

    public void scrollPage() {
        JavascriptExecutor jsx = (JavascriptExecutor)wd;
        jsx.executeScript("window.scrollBy(0,1300)", "");
    }

    public void change() {
        wd.manage().window().fullscreen();
        wd.manage().window().setSize(new Dimension(1000, 1000));
    }

    public String findElement(By locator, String attribute) {
        String element = wd.findElement(locator).getAttribute(attribute);
         return element;
    }

    public void scrollPage1() {
        JavascriptExecutor jsx = (JavascriptExecutor)wd;
        jsx.executeScript("window.scrollBy(0,2000)", "");
    }
    }
