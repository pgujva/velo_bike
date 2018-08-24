package ru.usetech.pft.velobike.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Model.NewsPageData;
import ru.usetech.pft.velobike.Model.PricePageData;

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
    public void TestPricePagde() {
        app.getNavigationHelper().goToSideMenu();
        app.getNavigationHelper().goPricePage();
        //проверка, что выделен первый элемент
        String firstElementChecked = app.getPricePageHelper().isElementChecked();
        Assert.assertEquals(firstElementChecked,"price-content__column price-content__column_active", "при входе на страницу не выбран первый элемент");

        app.getHelperBase().scrollPage();
        //проверка, что выделен пятый элемент
        String fifthElementChecked = app.getPricePageHelper().isElementChecked();
        Assert.assertEquals(fifthElementChecked,"price-content__column price-content__column_active", "при входе на страницу не выбран пятый элемент");
    }
}











