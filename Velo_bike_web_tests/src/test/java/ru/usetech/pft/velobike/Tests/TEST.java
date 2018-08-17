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
        app.getNavigationHelper().goToPersonalAccountPage();
        app.getNavigationHelper().goToSideMenu();
        List<WebElement> menuList = app.getSideMenuHelper().getMenuList();
        app.getHelperBase().waitVisibilityOfElement(menuList);
        menuList.get(0).click();
        app.getHelperBase().waitElementLoad();
        boolean a = app.getHelperBase().isThereARightPage(By.tagName("h1"), "КАК ПОЛЬЗОВАТЬСЯ ПРОКАТОМ",
                By.tagName("h2"),"ВОЗЬМИТЕ ВЕЛОСИПЕД",null);
        Assert.assertEquals(a, true);
       // app.getNavigationHelper().goToSideMenu();

    }
}



