package ru.usetech.pft.velobike.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SideMenuTests extends Testbase{

    @Test()
    public void TestsSideMenu () {
        app.getSessionHelper().loginInSideMenu("4001776", "3875");
        app.getNavigationHelper().goToPersonalAccountPage();
        app.getNavigationHelper().goToSideMenu();


        List<WebElement> menuElements = app.getSideMenuHelper().getMenuList();
        for(WebElement element : menuElements) {
            String sideMenuName = element.getAttribute("textContent");
            app.getHelperBase().waitVisibilityOfElement(By.className("nav__link"));
            element.click();
            String pageName = app.getHelperBase().getPageName();
            Assert.assertEquals(sideMenuName, pageName);
             app.getNavigationHelper().goToSideMenu();
        }
    }
}
