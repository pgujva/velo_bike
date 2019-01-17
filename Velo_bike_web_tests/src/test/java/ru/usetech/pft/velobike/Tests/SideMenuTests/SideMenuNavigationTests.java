package ru.usetech.pft.velobike.Tests.SideMenuTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import ru.usetech.pft.velobike.Tests.MyTestListener;
import ru.usetech.pft.velobike.Tests.Testbase;
import ru.yandex.qatools.allure.annotations.Attachment;


public class SideMenuNavigationTests extends Testbase {
  @BeforeMethod(alwaysRun = true)
  public void setUp(ITestContext context) throws Exception {
    app.init();
    context.setAttribute("app",app);
  }



  @Test
  public void TestGoToHowToUseRentalPage() {
    app.getSessionHelper().loginInSideMenu("4001776", "3875");
    app.getNavigationHelper().goToPersonalAccountPage();
    app.getNavigationHelper().goToSideMenu();
    app.getNavigationHelper().goHowToUseRentalPage();
    String pageUrl = app.getHelperBase().getCurrentPageURL();
    String pageName = app.getHelperBase().getPageName(By.tagName("h1"));
    Assert.assertEquals(pageUrl, "https://velobike.ru/rules/", "неверный URL");
    Assert.assertEquals(pageName, "Как пользоваться прокато", "неверный заголовок страницы");
  }


  @Test
  public void TestGoToPricePage() {
    app.getNavigationHelper().goToSideMenu();
    app.getNavigationHelper().goPricePage();
    String pageUrl = app.getHelperBase().getCurrentPageURL();
    String pageName = app.getHelperBase().getPageName(By.tagName("h1"));
    Assert.assertEquals(pageUrl, "https://velobike.ru/prices/", "неверный URL");
    Assert.assertEquals(pageName, "Сколько это стои", "неверный заголовок страницы");
  }

  @Test(enabled = false)
  public void TestStationsMapPage() {
    app.getNavigationHelper().goToSideMenu();
    app.getNavigationHelper().goStationsMapPage();
    String pageUrl = app.getHelperBase().getCurrentPageURL();
    String pageName = app.getHelperBase().getPageName(By.tagName("h1"));
    Assert.assertEquals(pageUrl, "https://velobike.ru/parkings/", "неверный URL");
    Assert.assertEquals(pageName, "Карта станций\nвелопроката", "неверный заголовок страницы");
  }

  @Test(enabled = false)
  public void TestContactsPage() {
    app.getNavigationHelper().goToSideMenu();
    app.getNavigationHelper().goContactsPage();
    String pageUrl = app.getHelperBase().getCurrentPageURL();
    String pageName = app.getHelperBase().getPageName(By.tagName("h1"));
    Assert.assertEquals(pageUrl, "https://velobike.ru/contacts/", "неверный URL");
    Assert.assertEquals(pageName, "Контакты и помощь", "неверный заголовок страницы");
  }


  @Test(enabled = false)
  public void TestQaPage() {
    app.getNavigationHelper().goToSideMenu();
    app.getNavigationHelper().goQaPage();
    String pageUrl = app.getHelperBase().getCurrentPageURL();
    String pageName = app.getHelperBase().getPageName(By.tagName("h1"));
    Assert.assertEquals(pageUrl, "https://velobike.ru/qa/", "неверный URL");
    Assert.assertEquals(pageName, "Вопросы и ответы", "неверный заголовок страницы");
  }

  @Test
  public void TestElectroVelobikePage() {
    app.getNavigationHelper().goToSideMenu();
    app.getNavigationHelper().goElectroVelobikePage();
    String pageUrl = app.getHelperBase().getCurrentPageURL();
    String pageName = app.getHelperBase().getPageName(By.tagName("h1"));
    Assert.assertEquals(pageUrl, "https://electro.velobike.ru/", "неверный URL");
    Assert.assertEquals(pageName, "Велопрокат\nБудущего", "неверный заголовок страницы");
  }

  @Test(enabled = false)
  public void TestNewsPage() {
    app.getNavigationHelper().goToSideMenu();
    app.getNavigationHelper().goNewsPage();
    String pageUrl = app.getHelperBase().getCurrentPageURL();
    String pageName = app.getHelperBase().getPageName(By.tagName("h1"));
    Assert.assertEquals(pageUrl, "https://velobike.ru/news/", "неверный URL");
    Assert.assertEquals(pageName, "Новости", "неверный заголовок страницы");
  }


  @Test(enabled = false)
  public void TestAboutPage() {
    app.getNavigationHelper().goToSideMenu();
    app.getNavigationHelper().goAboutPage();
    String pageUrl = app.getHelperBase().getCurrentPageURL();
    String pageName = app.getHelperBase().getPageName(By.tagName("h1"));
    Assert.assertEquals(pageUrl, "https://velobike.ru/about/", "неверный URL");
    Assert.assertEquals(pageName, "О велобайке", "неверный заголовок страницы");
  }


  @Test(enabled = false)
  public void TestVKontactePage() {
    app.getNavigationHelper().goToSideMenu();
    app.getNavigationHelper().goToVKontactePage();
    String pageUrl = app.getHelperBase().getCurrentPageURL();
    Assert.assertEquals(pageUrl, "https://vk.com/velobikeru", "неверный URL");
    app.getNavigationHelper().goToPreviousPage();
  }

  @Test(enabled = false)
  public void TestFacebookPage() {
    app.getNavigationHelper().goToSideMenu();
    app.getNavigationHelper().goToFacebookPage();
    String pageUrl = app.getHelperBase().getCurrentPageURL();
    Assert.assertEquals(pageUrl, "https://www.facebook.com/velobike.ru", "неверный URL");
    app.getNavigationHelper().goToPreviousPage();
  }

  @Test(enabled = false)
  public void TestInstagramPage() {
    app.getNavigationHelper().goToSideMenu();
    app.getNavigationHelper().goToInstgramPage();
    String pageUrl = app.getHelperBase().getCurrentPageURL();
    Assert.assertEquals(pageUrl, "https://www.instagram.com/velobike.ru/", "неверный URL");
    app.getNavigationHelper().goToPreviousPage();
  }

  @Test(enabled = false)
  public void TestTelegramPage() {
    app.getNavigationHelper().goToSideMenu();
    app.getNavigationHelper().goTelegramPage();
    String pageUrl = app.getHelperBase().getCurrentPageURL();
    Assert.assertEquals(pageUrl, "https://t.me/velobikeru_bot", "неверный URL");
    app.getNavigationHelper().goToPreviousPage();
  }
}
