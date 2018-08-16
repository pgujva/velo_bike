package ru.usetech.pft.velobike.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TEST extends Testbase {

    @Test()
    public void testTest() {
        app.getSessionHelper().loginInSideMenu("4001776", "3875");
        boolean a = app.getHelperBase().isThereARightPage(By.tagName("h1"), "Личный кабинет",
                By.cssSelector("span.lk-intro__welcome-name"), "Тест!", "https://velobike.ru/account/");
        app.getNavigationHelper().goToSideMenu();
      List<WebElement> menuElements = app.getNavigationHelper().getMenuList();
       for (WebElement element : menuElements) {
           String name = element.getText().toLowerCase();
           app.getNavigationHelper().owait();
           element.click();
           String name2 = app.getHelperBase().getPageName().toLowerCase();

           Assert.assertEquals(name,name2);
       }
    }
}
