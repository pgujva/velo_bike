package ru.usetech.pft.velobike.Tests.PagesTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Model.PricePageData;
import ru.usetech.pft.velobike.Tests.Testbase;

import java.util.List;

public class PricePageTests extends Testbase {

    @BeforeClass(enabled = false)
    public void ensurePreconditions() {
       // app.getNavigationHelper().goToPersonalAccountPage();
        app.getNavigationHelper().goToSideMenu();
    }

    @Test(enabled = false)
    public void Test1IsRightPricesOnPage() {
        app.getNavigationHelper().goPricePage();
        //берем элементы с первой половины страницы
        List<PricePageData> actual1 = app.getPricePageHelper().getPriceList();
        List<PricePageData> expected = app.getPricePageHelper().getStaticPriceList();
        app.getHelperBase().scrollPage();
        //добаляем элементы со второй половины страницы
        List<PricePageData> actual2 = app.getPricePageHelper().getPriceList();
        Assert.assertEquals(expected, actual2);

    }

    @Test(enabled = false)
    public void Test2IsElementshecked() {
        app.getNavigationHelper().goToSideMenu();
        app.getNavigationHelper().goPricePage();

        app.getPricePageHelper().getPriceList();
        //проверка, что выделен первый элемент
        String firstElementChecked = app.getPricePageHelper().isElementChecked();
        Assert.assertEquals(firstElementChecked, "price-content__column price-content__column_active", "при входе на страницу не выбран первый элемент");

        app.getHelperBase().scrollPage();
        //проверка, что выделен пятый элемент
        String fifthElementChecked = app.getPricePageHelper().isElementChecked();
        Assert.assertEquals(fifthElementChecked, "price-content__column price-content__column_active", "при входе на страницу не выбран пятый элемент");

    }

    @Test(enabled = false)
    public void Test3IsElementshecked() {
        app.getNavigationHelper().goToSideMenu();
        app.getNavigationHelper().goPricePage();
        String text = app.getHelperBase().findElement(By.cssSelector("span.price-table__time-note.h_mb25"), "innerText");
        List<PricePageData> prices = app.getPricePageHelper().getPriceList();
        prices.get(2).getUrl().click();
        String text2 = app.getHelperBase().findElement(By.cssSelector("span.price-table__time-note.h_mb25"), "innerText");
        Boolean b = text.equals(text2);
        Boolean c = false;

        Assert.assertEquals(b, c);

    }


}
