package ru.usetech.pft.velobike.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UserNavigationTests extends Testbase {

  @Test
  public void testsUserNavigation() throws Exception {

    app.getNavigationHelper().goToPersonalAccountPage();
    boolean a = app.getHelperBase().isThereARightPage(By.tagName("h1"), "Личный кабинет",
            By.cssSelector("span.lk-intro__welcome-name"), "Тест!",
            "https://velobike.ru/account/");
    Assert.assertEquals(a, true);

    //app.getNavigationHelper().getMenuList();

  }

}
