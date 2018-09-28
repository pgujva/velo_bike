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

    }



    public String getCurrentWindowHandle() {
        String handle = wd.getWindowHandle();
        return handle;
    }

    public void switchToFirstWindow(String handle) {
        wd.switchTo().window(handle);
    }

    public void goHowToUseRentalPage() {

        wait.until(elementToBeClickable(By.cssSelector("a[href='https://velobike.ru/rules/']")));
        wd.findElement(By.cssSelector("a[href='https://velobike.ru/rules/']")).click();
    }

    public void goPricePage() {
        wait.until(elementToBeClickable(By.cssSelector("a[href='/prices/']")));
        wd.findElement(By.cssSelector("a[href='/prices/']")).click();
    }

    public void goStationsMapPage() {
        wait.until(elementToBeClickable(By.cssSelector("a[href='/parkings/']")));
        wd.findElement(By.cssSelector("a[href='/parkings/']")).click();
    }

    public void goContactsPage() {
        wait.until(elementToBeClickable(By.cssSelector("a[href='/contacts/']")));
        wd.findElement(By.cssSelector("a[href='/contacts/']")).click();
    }

    public void goQaPage() {
        wait.until(elementToBeClickable(By.cssSelector("a[href='/qa/']")));
        wd.findElement(By.cssSelector("a[href='/qa/']")).click();
    }

    public void goElectroVelobikePage() {
        wait.until(elementToBeClickable(By.cssSelector("a[href='https://electro.velobike.ru']")));
        wd.findElement(By.cssSelector("a[href='https://electro.velobike.ru']")).click();
    }

    public void goNewsPage() {
        wait.until(elementToBeClickable(By.cssSelector("a[href='/news/']")));
        wd.findElement(By.cssSelector("a[href='/news/']")).click();
    }

    public void goAboutPage() {
        wait.until(elementToBeClickable(By.cssSelector("a[href='/about/']")));
        wd.findElement(By.cssSelector("a[href='/about/']")).click();
    }

    public void goToVKontactePage() {
        wait.until(elementToBeClickable(By.cssSelector("a[href='http://vk.com/velobikeru']")));
        wd.findElement(By.cssSelector("a[href='http://vk.com/velobikeru']")).click();
    }

    public void goToFacebookPage() {
        wait.until(elementToBeClickable(By.cssSelector("a[href='https://www.facebook.com/velobike.ru']")));
        wd.findElement(By.cssSelector("a[href='https://www.facebook.com/velobike.ru']")).click();
    }

    public void goToPreviousPage() {
        wd.navigate().back();
    }

    public void goToInstgramPage() {
        wait.until(elementToBeClickable(By.cssSelector("a[href='https://www.instagram.com/velobike.ru/']")));
        wd.findElement(By.cssSelector("a[href='https://www.instagram.com/velobike.ru/']")).click();
    }

    public void goTelegramPage() {
        wait.until(elementToBeClickable(By.cssSelector("a[href='https://t.me/velobikeru_bot']")));
        wd.findElement(By.cssSelector("a[href='https://t.me/velobikeru_bot']")).click();
    }

    public void goToPriceFromgoElectroVelobikePage() {
        wd.findElement(By.cssSelector("span.price-table__time-note a")).click();
    }

    public void goToQaPageFromgoElectroVelobikePage() {
        wd.findElement(By.cssSelector("a.btn-blue")).click();
    }

    public void goMainPage() {
        wd.findElement(By.cssSelector("a[href='https://velobike.ru']")).click();
    }
}
