package ru.usetech.pft.velobike.Tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TEST extends Testbase {

    @Test()
    public void testTest() {
        app.getSessionHelper().loginInSideMenu("4001776", "3875");
        app.getNavigationHelper().goToPersonalAccountPage();
        List<String>pageLinks = new ArrayList<String>();

        for (int i = 0; i <  app.getSideMenuHelper().getStaticMenuLinks().size(); i++) {
            if (app.getHelperBase().isThereAElement() == true) {
                app.getNavigationHelper().goToSideMenu();
                List<WebElement> newMenuElements = app.getSideMenuHelper().getMenuList();
                app.getHelperBase().waitVisibilityOfElement(newMenuElements);
                newMenuElements.get(i).click();

            } else {

                app.getHelperBase().returnBack();
            }

        }


     //   app.getNavigationHelper().goToSideMenu();

      //  List<String> menuLinks = app.getSideMenuHelper().getMenuLinksFromPage();
     //   List<String>pageLinks = new ArrayList<String>();

      // for (int i = 0; i < 12; i++) {
      //      List<WebElement> newMenuElements = app.getSideMenuHelper().getMenuList();
      //      app.getHelperBase().waitVisibilityOfElement(newMenuElements);
      //      newMenuElements.get(i).click();
      //      String handle = app.getNavigationHelper().getCurrentWindowHandle();
      //    app.getHelperBase().isThereAElement() == true)
      //      app.getNavigationHelper().goToSideMenu();
          //      app.getHelperBase().waitVisibilityOfElement(newMenuElements);
             //   menuLinks.add(app.getHelperBase().getPageLink());

        //    } else {
        //        menuLinks.add(app.getHelperBase().getPageLink());
         //       app.getNavigationHelper().switchToFirstWindow(handle);
           // } return;
        }


      //  Assert.assertEquals(app.getSideMenuHelper().getStaticMenuLinks(), pageLinks);

    }






