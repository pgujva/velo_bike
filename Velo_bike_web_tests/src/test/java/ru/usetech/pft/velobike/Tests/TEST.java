package ru.usetech.pft.velobike.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static jdk.nashorn.internal.objects.NativeString.trim;

public class TEST extends Testbase {

    @Test()
    public void testTest() {
        app.getSessionHelper().loginInSideMenu("4001776", "3875");
        boolean a = app.getHelperBase().isThereARightPage(By.tagName("h1"), "Личный кабинет",
                By.cssSelector("span.lk-intro__welcome-name"), "Тест!", "https://velobike.ru/account/");
          app.getNavigationHelper().goToSideMenu();
         // List<WebElement> menuElements = app.getSideMenuHelper().getMenuList();
        //  String name= menuElements.get(0).getAttribute("textContent");
         // app.getNavigationHelper().waitVisibilityOfElement(By.className("nav__link"));
        //  menuElements.get(0).click();
       //   String name2 = app.getHelperBase().getPageName();
     //   Assert.assertEquals(name,name2);
       //  app.getNavigationHelper().goToSideMenu();
      // for (WebElement element : menuElements) {
        //   String name = element.getText().toLowerCase();
         //  app.getNavigationHelper().owait(By.className("nav__link"));
        //   element.click();
          // app.getNavigationHelper().owait(By.linkText("Контакты и помощь"));
        //   String name2 = app.getHelperBase().getPageName().toLowerCase();
        //   Assert.assertEquals(name,name2);
        //   app.getNavigationHelper().visibleElement(By.className("side-opener"));
         //  app.getNavigationHelper().goToSideMenu();
       }
    }

