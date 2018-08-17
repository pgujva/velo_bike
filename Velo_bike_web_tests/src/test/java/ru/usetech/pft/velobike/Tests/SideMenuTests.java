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
        List<String> menuNames = app.getSideMenuHelper().getMenuNames();
        List<String> pageNames = new ArrayList<String>();

        for (int i = 0; i < menuNames.size(); i++) {
            List<WebElement> newMenuElements = app.getSideMenuHelper().getMenuList();
            app.getHelperBase().waitVisibilityOfElement(newMenuElements);
            newMenuElements.get(i).click();
            pageNames.add(app.getHelperBase().getPageName());
            app.getNavigationHelper().goToSideMenu();

        }

        Assert.assertEquals(menuNames,pageNames);
    }
}






