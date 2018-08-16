package ru.usetech.pft.velobike.Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TEST extends Testbase {

    @Test()
    public void testTest() {
        app.getSessionHelper().loginInHeder("4001776", "3875");
        app.getNavigationHelper().goToSideMenu();
        List<WebElement> menuElements = app.getNavigationHelper().getMenuList();
        for (WebElement element : menuElements) {
            String name = element.getText().toLowerCase();
            element.click();
            String name2 = app.getHelperBase().getPageName().toLowerCase();

            Assert.assertEquals(name,name2);
        }
    }
}
