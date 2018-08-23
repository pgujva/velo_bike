package ru.usetech.pft.velobike.Tests.PagesTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Tests.Testbase;

public class PricePageTests extends Testbase {

    @BeforeClass
    public void ensurePreconditions() {
        app.getSessionHelper().loginInSideMenu("4001776", "3875");
        app.getNavigationHelper().goToPersonalAccountPage();
        app.getNavigationHelper().goToSideMenu();
    }

    @Test
    public void Test1() {
        app.getNavigationHelper().goPricePage();

    }
}
