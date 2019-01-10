package ru.usetech.pft.velobike.Tests.SideMenuTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Tests.Testbase;

public class GoToPersonalAccountByPhotoTest extends Testbase {

  @Test
  public void TestGoToPersonalAccountByPhoto() throws Exception {
    app.getSessionHelper().loginInSideMenu("4001776","3875");
   // app.getNavigationHelper().goToPersonalAccountPage();
   // boolean a = app.getHelperBase().isThereARightPage(By.tagName("h1"), "Личный кабинет",
      //      By.cssSelector("span.lk-intro__welcome-name"), "Тест!",
 //           "https://velobike.ru/account/");
   // app.getNavigationHelper().goToSideMenu();

  //  Assert.assertEquals(a, true);

    //app.getNavigationHelper().getMenuList();

  }

}
