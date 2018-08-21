package ru.usetech.pft.velobike.Tests.PagesTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Tests.Testbase;

import java.util.List;

public class NewsPageTests extends Testbase {

    @BeforeClass
    public void ensurePreconditions() {

        app.getSessionHelper().loginInSideMenu("4001776", "3875");
        app.getNavigationHelper().goToPersonalAccountPage();
    }
    @Test
    public void TestNewsPage() {
      app.getNavigationHelper().goToSideMenu();
      app.getNavigationHelper().goNewsPage();
      boolean news = app.getHelperBase().isElementPresent(By.className("news-list__item"));
      Assert.assertEquals(true,news,"нет новостей на странице");

      List<String> newsLinks =  app.getNewsPageHelper().getNewsLinks();
      List<String> newsTitles = app.getNewsPageHelper().getNewsTitles();
      int index = 0;
      String newsLink = newsLinks.get(index);
      String newsTitle = newsTitles.get(index);
      app.getNewsPageHelper().goToOneNewsPage(index);
      String currentNewsUrl = app.getHelperBase().getCurrentPageURL();
      String currentNewsTitle = app.getNewsPageHelper().getCurrentPageNewsTitle();

        Assert.assertEquals(newsLink,currentNewsUrl,"не верная ссылка на новость ");
        Assert.assertEquals(newsTitle,currentNewsTitle,"не верная заголовок новости ");
}
}