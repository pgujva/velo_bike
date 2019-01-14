package ru.usetech.pft.velobike.Tests.PagesTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Model.NewsPageData;
import ru.usetech.pft.velobike.Tests.Testbase;

public class NewsPageTests extends Testbase {

    @BeforeClass
    public void ensurePreconditions() {
      //  app.getSessionHelper().loginInSideMenu("4001776", "3875");
      //  app.getNavigationHelper().goToPersonalAccountPage();
        app.getNavigationHelper().goToSideMenu();
    }

    @Test
    public void Test1IsNewsOnPage() {
        //проверка, что новости есть на странице
        app.getNavigationHelper().goNewsPage();
        boolean news = app.getHelperBase().isElementPresent(By.className("news-list__item"));

        Assert.assertEquals(true, news, "не новостей на странице");
    }

    @Test
    public void Test2NewsObject() {
        //проверка, ссылка открывает искомую новость на просмотр
        int index = 0;
        NewsPageData actualNews = app.getNewsPageHelper().actualNewsObject(index);

        app.getNewsPageHelper().goToOneNewsPage(index);

        NewsPageData expectedNews = app.getNewsPageHelper().expectedNewsObject(index);

        Assert.assertEquals(actualNews, expectedNews, "на просмотр открыта не верная новость");

    }


    @Test
    public void Test3GoToVKPage() {
        String mainWindow = app.getHelperBase().getCurrentWindowHandle();
        app.getNewsPageHelper().initVKrepost();
        app.getHelperBase().switchToNewWindow();
        String pagename = app.getHelperBase().getVKpageName();
        app.getHelperBase().closeWindow();
        app.getHelperBase().switchWindow(mainWindow);

        Assert.assertEquals(pagename,"https://vk.com/");
    }

    @Test
    public void Test4GoToFacebookPage() {
        String mainWindow = app.getHelperBase().getCurrentWindowHandle();
        app.getNewsPageHelper().initFacebookRepost();
        app.getHelperBase().switchToNewWindow();
        String pagename = app.getHelperBase().getFacebookpageName();
        app.getHelperBase().closeWindow();
        app.getHelperBase().switchWindow(mainWindow);

        Assert.assertEquals(pagename,"Facebook");
    }

}


