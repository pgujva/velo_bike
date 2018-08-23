package ru.usetech.pft.velobike.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Model.NewsPageData;
import ru.usetech.pft.velobike.Model.PricePageData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

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

    @Test
    public void TestPricePage() {
        app.getNavigationHelper().goToSideMenu();
        app.getNavigationHelper().goPricePage();

        List<PricePageData> actual = app.getPricePageHelper().getPriceList();
        List<PricePageData> expected = app.getPricePageHelper().getStaticPriceList();
        expected.sort(Comparator.comparing(PricePageData::getPrice));
        int a = actual.size();
        System.out.println("размер первого списка" + a);
      //  app.getHelperBase().change();
        //app.getHelperBase().scrollPage();

        List<PricePageData> actualg = app.getPricePageHelper().getPriceList();

        actualg.sort(Comparator.comparing(PricePageData::getPrice));
        for (int i = 0; i < actualg.size(); i++) {
            System.out.println("первый" + actualg.get(i).getPrice());
            System.out.println("второй" + expected.get(i).getPrice());
        }


        int b = actualg.size();
        System.out.println("размер второго списка" + b);
        System.out.println(actualg.size());

        Assert.assertEquals(expected, actualg);
    }

}











