package ru.usetech.pft.velobike.Tests.PagesTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Model.NewsPageData;
import ru.usetech.pft.velobike.Tests.Testbase;

import java.util.List;

public class NewsPageTests extends Testbase {

    @BeforeClass
    public void ensurePreconditions() {

        app.getSessionHelper().loginInSideMenu("4001776", "3875");
        app.getNavigationHelper().goToPersonalAccountPage();
        app.getNavigationHelper().goToSideMenu();
    }

    @Test
    public void TestIsNewsOnPage() {
        //проверка, что новости есть на странице
        app.getNavigationHelper().goNewsPage();
        boolean news = app.getHelperBase().isElementPresent(By.className("news-list__item"));

        Assert.assertEquals(true, news, "нет новостей на странице");
    }

    @Test
    public void TestNewsObject() {
        //проверка, ссылка открывает искомую новость на просморт
        int index = 0;
        NewsPageData actualNews = app.getNewsPageHelper().actualNewsObject(index);

        app.getNewsPageHelper().goToOneNewsPage(index);

        NewsPageData expectedNews = app.getNewsPageHelper().expectedNewsObject(index);

        Assert.assertEquals(actualNews, expectedNews, "на просмотр открыта не верная новость");

    }
}


