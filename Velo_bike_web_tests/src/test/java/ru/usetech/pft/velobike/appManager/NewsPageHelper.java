package ru.usetech.pft.velobike.appManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPageHelper {
    private ChromeDriver wd;
    private WebDriverWait wait;

    public NewsPageHelper(ChromeDriver wd, WebDriverWait wait) {
        this.wd = wd;
        this.wait = wait;
    }
}
