package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SessionHelper {
    private ChromeDriver wd;
    private WebDriverWait wait;

    public SessionHelper(ChromeDriver wd, WebDriverWait wait) {
        this.wd = wd;
        this.wait = wait;
    }

    public void loginInHeder(String userLog, String pin) {
        wd.findElement(By.xpath("//a[contains(text(),'Войти')]")).click();
        wd.findElement(By.id("id_login")).click();
        wd.findElement(By.id("id_login")).clear();
        wd.findElement(By.id("id_login")).sendKeys(userLog);
        wd.findElement(By.id("id_pin")).click();
        wd.findElement(By.id("id_pin")).clear();
        wd.findElement(By.id("id_pin")).sendKeys(pin);
        wd.findElement(By.cssSelector("input.btn-red.h_mb32[value=Войти]")).click();
    }

    public void loginInSideMenu(String userLog, String pin) {
        wd.findElement(By.cssSelector("a.side-opener")).click();
        wait.until(visibilityOf(wd.findElement(By.cssSelector("a.login-link.fancybox.h_float-left"))));
        wd.findElement(By.cssSelector("a.login-link.fancybox.h_float-left")).click();
        wd.findElement(By.id("id_login")).click();
        wd.findElement(By.id("id_login")).clear();
        wd.findElement(By.id("id_login")).sendKeys(userLog);
        wd.findElement(By.id("id_pin")).click();
        wd.findElement(By.id("id_pin")).clear();
        wd.findElement(By.id("id_pin")).sendKeys(pin);
        wd.findElement(By.cssSelector("input.btn-red.h_mb32[value=Войти]")).click();

    }

    public void logoutFromSystem() {
        wd.findElement(By.cssSelector("a.user-quit.hidden-xs")).click();
    }
}
