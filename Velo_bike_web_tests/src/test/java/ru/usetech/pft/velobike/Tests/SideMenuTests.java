package ru.usetech.pft.velobike.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;

public class SideMenuTests extends Testbase {

    @Test()
    public void TestsSideMenu() {
        app.getSessionHelper().loginInSideMenu("4001776", "3875");
        app.getNavigationHelper().goToPersonalAccountPage();
        app.getNavigationHelper().goToSideMenu();

        List<WebElement> menuElements = app.getSideMenuHelper().getMenuList();
        List<String> menuNames = app.getSideMenuHelper().getMenuNames();


    }
}






