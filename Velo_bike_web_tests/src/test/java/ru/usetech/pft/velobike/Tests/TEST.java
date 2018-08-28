package ru.usetech.pft.velobike.Tests;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Model.NewsPageData;
import ru.usetech.pft.velobike.Model.PricePageData;
import ru.usetech.pft.velobike.Model.StationsData;
import ru.usetech.pft.velobike.appManager.HttpSession;

import java.io.IOException;
import java.util.List;

public class TEST extends Testbase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().goToPersonalAccountPage();
        app.getNavigationHelper().goToSideMenu();
        app.getNavigationHelper().goElectroVelobikePage();
    }


    @Test(enabled = false)
    public void TestGoToHowToUseRentalPage() {
        app.getNavigationHelper().goToSideMenu();
        app.getNavigationHelper().goNewsPage();
        int index = 0;
        NewsPageData actualNews = app.getNewsPageHelper().actualNewsObject(index);

        app.getNewsPageHelper().goToOneNewsPage(index);

        NewsPageData expectedNews = app.getNewsPageHelper().expectedNewsObject(index);

        Assert.assertEquals(actualNews, expectedNews);

    }

    @Test(enabled = false)
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
        Assert.assertEquals(pagename, "https://vk.com/");

    }

    @Test(enabled = false)
    public void TestPricePage() {
        app.getNavigationHelper().goToSideMenu();
        app.getNavigationHelper().goPricePage();
        List<PricePageData> actual = app.getPricePageHelper().getPriceList();
        List<PricePageData> expected = app.getPricePageHelper().getStaticPriceList();

        app.getHelperBase().scrollPage();

        List<PricePageData> actualg = app.getPricePageHelper().getPriceList();


        Assert.assertEquals(expected, actualg);
    }


    @Test
    public void TestPricePagde () throws IOException {



    }
}











