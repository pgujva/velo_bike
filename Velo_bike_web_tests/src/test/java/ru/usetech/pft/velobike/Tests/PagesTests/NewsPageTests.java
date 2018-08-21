package ru.usetech.pft.velobike.Tests.PagesTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Tests.Testbase;

public class NewsPageTests extends Testbase {

    @BeforeClass
    public void ensurePreconditions() {

        app.getSessionHelper().loginInSideMenu("4001776", "3875");
        app.getNavigationHelper().goToPersonalAccountPage();
    }
    @Test
    public void TestNewsPage() {
      app.getNavigationHelper().goToSideMenu();
      app.getNavigationHelper().goNewsPage();
      app
}
}