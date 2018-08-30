package ru.usetech.pft.velobike.Tests.PagesTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Model.StationsData;
import ru.usetech.pft.velobike.Tests.Testbase;
import ru.usetech.pft.velobike.appManager.HttpSession;

import java.io.IOException;

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
    String respons = session.resp("https://electro.velobike.ru/ajax/parkings/?_=1535358830923");
    StationsData expectedStation = app.getMapHelper().CreateStationDataFromResponse(respons);
    String stationNumber = "241";
    app.getMapHelper().initSearchOnMainPage(stationNumber);
    app.getMapHelper().clickOnStationIconOnMainPage();
    //создаем объект типа station на странице
    StationsData actualStation = app.getMapHelper().CreateStationData(stationNumber);
    Assert.assertEquals(actualStation, expectedStation);
  }

  @Test(enabled = false)
  public void Test2SearchStationByAddress() throws IOException, InterruptedException {
    //отправляем http запрос и из ответа создаем объект типа station
    HttpSession session = app.newSession();
    String respons = session.resp("https://electro.velobike.ru/ajax/parkings/?_=1535358830923");
    StationsData expectedStation = app.getMapHelper().CreateStationDataFromResponse(respons);
    String stationNumber = "241";
    String address = "ст. м. Краснопресненская";
    app.getMapHelper().initSearchOnMainPage(address);
    app.getMapHelper().clickOnStationIconOnMainPage();
    //создаем объект типа station на странице
    StationsData actualStation = app.getMapHelper().CreateStationData(stationNumber);
    Assert.assertEquals(actualStation, expectedStation);
  }

  @Test
  public void Test3GoToParkingsPageTest() {
    app.getMainPageHelper().goToParkingsPage();
    String pageUrl = app.getHelperBase().getCurrentPageURL();
    String pageName = app.getHelperBase().getPageName(By.tagName("h1"));
    Assert.assertEquals(pageUrl, "https://velobike.ru/parkings/", "неверный URL");
    Assert.assertEquals(pageName, "Карта станций\nвелопроката", "неверный заголовок страницы");
  }
}
