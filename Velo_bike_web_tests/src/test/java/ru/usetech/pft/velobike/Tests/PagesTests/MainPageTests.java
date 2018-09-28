package ru.usetech.pft.velobike.Tests.PagesTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Model.PricePageData;
import ru.usetech.pft.velobike.Model.StationsData;
import ru.usetech.pft.velobike.Tests.Testbase;
import ru.usetech.pft.velobike.appManager.HttpSession;

import java.io.IOException;
import java.util.List;

public class MainPageTests extends Testbase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().goToPersonalAccountPage();
    app.getNavigationHelper().goMainPage();
  }

  @Test(enabled = false)
  public void Test1SearchStationByNumber() throws IOException, InterruptedException {
    //отправляем http запрос и из ответа создаем объект типа station
    HttpSession session = app.newSession();
    String respons = session.resp("https://velobike.ru/ajax/parkings/?_=1537946591952");
    StationsData expectedStation = app.getMapHelper().CreateStationDataFromResponseWithoutElectro(respons);
    String stationNumber = "241";
    app.getMapHelper().initSearchOnMainPage(stationNumber);
    app.getMapHelper().clickOnStationIconOnMainPage();
    //создаем объект типа station на странице
    StationsData actualStation = app.getMapHelper().CreateStationData(stationNumber);
    Assert.assertEquals(actualStation, expectedStation,"неверная станция при поиске по номеру");
  }

  @Test(enabled = false)
  public void Test2SearchStationByAddress() throws IOException, InterruptedException {
    //отправляем http запрос и из ответа создаем объект типа station
    HttpSession session = app.newSession();
    String respons = session.resp("https://velobike.ru/ajax/parkings/?_=1537946591952");
    StationsData expectedStation = app.getMapHelper().CreateStationDataFromResponseWithoutElectro(respons);
    String stationNumber = "241";
    String address = "ст. м. Краснопресненская";
    app.getMapHelper().initSearchOnMainPage(address);
    app.getMapHelper().clickOnStationIconOnMainPage();
    //создаем объект типа station на странице
    StationsData actualStation = app.getMapHelper().CreateStationData(stationNumber);
    Assert.assertEquals(actualStation, expectedStation,"неверная станция при поиске по названию");
  }

  @Test(enabled = false)
  public void Test3GoToParkingsPageTest() {
    app.getMainPageHelper().goToParkingsPage();
    String pageUrl = app.getHelperBase().getCurrentPageURL();
    String pageName = app.getHelperBase().getPageName(By.tagName("h1"));
    Assert.assertEquals(pageUrl, "https://velobike.ru/parkings/", "неверный URL");
    Assert.assertEquals(pageName, "Карта станций\nвелопроката", "неверный заголовок страницы");
  }

  @Test(enabled = true)
  public void Test4HowItCostTest() {
    List<PricePageData> actual = app.getMainPageHelper().getPriceList();
    List<PricePageData> expected = app.getMainPageHelper().getStaticPriceList();
    //app.getHelperBase().scrollPage();
    //app.getHelperBase().moveToElement(actual.get(0).getUrl());
    Assert.assertEquals(actual,expected,"не верный прайс лист");

   // actual.get(0).getUrl().click();
  }
}
