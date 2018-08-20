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
        int d = menuList.size();
        System.out.println(d);
        System.out.println(menuList.get(0).getAttribute("href"));

    }
}



