package ru.usetech.pft.velobike.Tests.PagesTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Tests.Testbase;

public class ParkingsPageTests extends Testbase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().goToPersonalAccountPage();
    app.getNavigationHelper().goToSideMenu();
    app.getNavigationHelper().goStationsMapPage();
  }

  @Test
  public void Test1() {

  }
}
