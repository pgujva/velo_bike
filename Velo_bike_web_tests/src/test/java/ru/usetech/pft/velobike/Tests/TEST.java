package ru.usetech.pft.velobike.Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Model.NewsPageData;

public class TEST extends Testbase {

    @BeforeClass
    public void ensurePreconditions() {

        app.getSessionHelper().loginInSideMenu("4001776", "3875");
        app.getNavigationHelper().goToPersonalAccountPage();
    }


        @Test(enabled = false)
        public void TestGoToHowToUseRentalPage() {
            app.getNavigationHelper().goToSideMenu();
            app.getNavigationHelper().goNewsPage();
            int index = 0;
            NewsPageData actualNews = app.getNewsPageHelper().actualNewsObject(index);

            app.getNewsPageHelper().goToOneNewsPage(index);

            NewsPageData expectedNews =app.getNewsPageHelper().expectedNewsObject(index);

            Assert.assertEquals(actualNews,expectedNews);

        }

    @Test
    public void TestRepost() {
        app.getNavigationHelper().goToSideMenu();
        app.getNavigationHelper().goNewsPage();
        int index = 0;
        app.getNewsPageHelper().goToOneNewsPage(index);

        app.getNewsPageHelper().initVKrepost();
        app.getHelperBase().switchToNewWindow();
        String pagename = app.getHelperBase().getVKpageName();
        String newWindowUrl = app.getHelperBase().getCurrentPageURL();
        System.out.println(pagename);
        Assert.assertEquals(pagename,"https://vk.com/");

    }
    }











