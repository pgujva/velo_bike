package ru.usetech.pft.velobike.Tests.SideMenuNavigationTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Tests.Testbase;

import java.util.List;

public class GoToSideMenuTest extends Testbase {

    @Test
    public void TestGoToSideMenu() {
        app.getSessionHelper().loginInSideMenu("4001776", "3875");
        app.getNavigationHelper().goToPersonalAccountPage();
        app.getNavigationHelper().goToSideMenu();
        List<String> menuNamesFromPage = app.getSideMenuHelper().getMenuNamesFromPage();
        List<String> menuLinksFromPage = app.getSideMenuHelper().getMenuLinksFromPage();
        List<String> staticMenuLinks = app.getSideMenuHelper().getStaticMenuLinks();
        List<String> staticMenuNames = app.getSideMenuHelper().getStaticMenuNames();
        Assert.assertEquals(staticMenuLinks, menuLinksFromPage);
        Assert.assertEquals(staticMenuNames, menuNamesFromPage);

    }
}
