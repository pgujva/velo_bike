package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class NavigationHelper {
    private ChromeDriver wd;
    private WebDriverWait wait;

    public NavigationHelper(ChromeDriver wd, WebDriverWait wait) {
        this.wd = wd;
        this.wait = wait;
    }

    public void goToPersonalAccountPage() {
        wd.findElement(By.cssSelector("div.logged-user__photo")).click();
    }

    public void goToModifyAccountPage() {

    }


    public void goToSideMenu() {

        wait.until(elementToBeClickable(By.className("side-opener")));
        // wait.until(elementSelectionStateToBe(By.className("side-opener"),true));
        wd.findElement(By.cssSelector("a.side-opener")).click();

    }

    public void visibleElement(By locator) {
        wait.until(invisibilityOfElementLocated(locator));
        wait.until(invisibilityOfElementLocated(locator));
    }

    public void goBackToFirstWindow() {
        wd.switchTo().defaultContent();
    }

    public String getCurrentWindowHandle() {
        String handle= wd.getWindowHandle();
        return handle;
    }

    public void switchToFirstWindow(String handle) {
        wd.switchTo().window(handle);
    }
}
