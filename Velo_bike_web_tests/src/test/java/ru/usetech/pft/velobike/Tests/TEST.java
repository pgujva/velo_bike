package ru.usetech.pft.velobike.Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Model.NewsPageData;

import java.util.ArrayList;
import java.util.List;

public class TEST extends Testbase {

    @BeforeClass
    public void ensurePreconditions() {

        app.getSessionHelper().loginInSideMenu("4001776", "3875");
        app.getNavigationHelper().goToPersonalAccountPage();
    }


        @Test
        public void TestGoToHowToUseRentalPage() {
            app.getNavigationHelper().goToSideMenu();
            app.getNavigationHelper().goNewsPage();
            int index = 0;
            NewsPageData actualNews = app.getNewsPageHelper().actualNewsObject();

            app.getNewsPageHelper().goToOneNewsPage(index);

            NewsPageData expectedNews =app.getNewsPageHelper().expectedNewsObject();
            Assert.assertEquals(actualNews,expectedNews);

        }
    }











