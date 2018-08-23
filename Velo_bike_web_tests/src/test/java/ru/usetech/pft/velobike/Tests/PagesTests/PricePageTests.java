package ru.usetech.pft.velobike.Tests.PagesTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Model.PricePageData;
import ru.usetech.pft.velobike.Tests.Testbase;

import java.util.List;

public class PricePageTests extends Testbase {

    @BeforeClass
    public void ensurePreconditions() {
        app.getSessionHelper().loginInSideMenu("4001776", "3875");
        app.getNavigationHelper().goToPersonalAccountPage();
        app.getNavigationHelper().goToSideMenu();
    }

    @Test
    public void Test1IsRightPricesOnPage() {
        app.getNavigationHelper().goPricePage();
        //берем элементы с первой половины страницы
        List<PricePageData> actual1 = app.getPricePageHelper().getPriceList();
        List<PricePageData> expected = app.getPricePageHelper().getStaticPriceList();

        app.getHelperBase().scrollPage();
        //добаляем элемент со второй половины страницы
        List<PricePageData> actual2 = app.getPricePageHelper().getPriceList();


        Assert.assertEquals(expected, actual2);
    }
}
