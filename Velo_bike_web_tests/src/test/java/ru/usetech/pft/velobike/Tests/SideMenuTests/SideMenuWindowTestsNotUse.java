package ru.usetech.pft.velobike.Tests.SideMenuTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Tests.Testbase;

import java.util.List;

public class SideMenuWindowTestsNotUse extends Testbase {

    @BeforeClass(enabled = false)
    public void ensurePreconditions() {

        app.getSessionHelper().loginInSideMenu("4001776", "3875");
        app.getNavigationHelper().goToPersonalAccountPage();
    }

    @Test(enabled = false)
    public void TestGoToSideMenu() {
        app.getNavigationHelper().goToSideMenu();
        List<String> menuNamesFromPage = app.getSideMenuHelper().getMenuNamesFromPage();
        List<String> menuLinksFromPage = app.getSideMenuHelper().getMenuLinksFromPage();
        List<String> staticMenuLinks = app.getSideMenuHelper().getStaticMenuLinks();
        List<String> staticMenuNames = app.getSideMenuHelper().getStaticMenuNames();
        Assert.assertEquals(staticMenuLinks, menuLinksFromPage,"неверные ссылки в боковом меню");
        Assert.assertEquals(staticMenuNames, menuNamesFromPage,"Неверный названия в боковом меню");

    }
}
