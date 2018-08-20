package ru.usetech.pft.velobike.Tests.SideMenuNavigationTests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Tests.Testbase;

import java.util.ArrayList;
import java.util.List;

public class SideMenuTests extends Testbase {


    @Test()
    public void TestsSideMenu() {
        app.getSessionHelper().loginInSideMenu("4001776", "3875");
        app.getNavigationHelper().goToPersonalAccountPage();
        app.getNavigationHelper().goToSideMenu();
        List<String> menuNames = app.getSideMenuHelper().getMenuNamesFromPage();
        List<String> pageNames = new ArrayList<String>();

        for (int i = 0; i < menuNames.size(); i++) {
            List<WebElement> newMenuElements = app.getSideMenuHelper().getMenuList();
            app.getHelperBase().waitVisibilityOfElement(newMenuElements);
            newMenuElements.get(i).click();
            pageNames.add(app.getHelperBase().getPageName());
            app.getNavigationHelper().goToSideMenu();

        }
        menuNames.set(1,"Сколько это стоит");
        menuNames.set(2,"Карта станций\nвелопроката");
        menuNames.set(5,"Велопрокат\nБудущего");
        Assert.assertEquals(menuNames.size(),pageNames.size() );
        Assert.assertEquals(menuNames,pageNames);

    }
}






