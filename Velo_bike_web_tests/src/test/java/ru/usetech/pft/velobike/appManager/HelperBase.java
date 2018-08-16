package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    private ChromeDriver wd;
    private WebDriverWait wait;

    public HelperBase(ChromeDriver wd, WebDriverWait wait) {

        this.wd = wd;
        this.wait = wait;
    }

    public boolean isThereARightPage(By locator, String expText, By locator_2, String expText2, String expURL) {
        String a = wd.findElement(By.xpath("//a[contains(text(),'Войти')]")).getText();
        String b = wd.findElement(By.xpath("//a[contains(text(),'Регистрация')]")).getText();
        String c = wd.getCurrentUrl();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
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
}
