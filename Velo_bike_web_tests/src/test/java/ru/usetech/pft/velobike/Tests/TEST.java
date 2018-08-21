package ru.usetech.pft.velobike.Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TEST extends Testbase {

    @Test()
    public void testTest() {
        app.getSessionHelper().loginInSideMenu("4001776", "3875");
        app.getNavigationHelper().goToPersonalAccountPage();
        List<String> pageLinks = new ArrayList<String>();
        for (int i = 0; i < app.getSideMenuHelper().getStaticMenuLinks().size(); i++) {
            app.getNavigationHelper().goToSideMenu();
            List<WebElement> newMenuElements = app.getSideMenuHelper().getMenuList();
            app.getHelperBase().waitVisibilityOfElement(newMenuElements);
            newMenuElements.get(i).click();
            pageLinks.add(app.getHelperBase().getPageLink());
            app.getHelperBase().returnBack();
        }
        Assert.assertEquals(app.getSideMenuHelper().getStaticMenuLinks(), pageLinks);

    }

}










