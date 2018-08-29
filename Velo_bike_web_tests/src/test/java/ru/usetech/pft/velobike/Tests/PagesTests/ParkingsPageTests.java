package ru.usetech.pft.velobike.Tests.PagesTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Model.StationsData;
import ru.usetech.pft.velobike.Tests.Testbase;
import ru.usetech.pft.velobike.appManager.HttpSession;

import java.io.IOException;

public class ParkingsPageTests extends Testbase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().goToPersonalAccountPage();
    app.getNavigationHelper().goMainPage();
  }

  @Test
  public void Test1SearchStationByNumber() throws IOException, InterruptedException {
    //отправляем http запрос и из ответа создаем объект типа station
    HttpSession session = app.newSession();
    String respons = session.resp("https://electro.velobike.ru/ajax/parkings/?_=1535358830923");
    StationsData expectedStation = app.getElectroVoloBikeHelper().CreateStationDataFromResponse(respons);
    String stationNumber = "241";
    app.getElectroVoloBikeHelper().initSearch(stationNumber, By.className("address-search__submit"));
    app.getElectroVoloBikeHelper().clickOnStationIcon(By.xpath("//*[@id=\"map\"]/div/div/div[1]/div[1]/div[1]"));
    //создаем объект типа station на странице
    StationsData actualStation = app.getElectroVoloBikeHelper().CreateStationData(stationNumber);
    Assert.assertEquals(actualStation, expectedStation);
  }

  @Test
  public void Test2SearchStationAddress() throws IOException, InterruptedException {
    //отправляем http запрос и из ответа создаем объект типа station
    HttpSession session = app.newSession();
    String respons = session.resp("https://electro.velobike.ru/ajax/parkings/?_=1535358830923");
    StationsData expectedStation = app.getElectroVoloBikeHelper().CreateStationDataFromResponse(respons);
    String stationNumber = "241";
    app.getElectroVoloBikeHelper().initSearch(stationNumber, By.className("address-search__submit"));
    app.getElectroVoloBikeHelper().clickOnStationIcon(By.xpath("//*[@id=\"map\"]/div/div/div[1]/div[1]/div[1]"));
    //создаем объект типа station на странице
    StationsData actualStation = app.getElectroVoloBikeHelper().CreateStationData(stationNumber);
    Assert.assertEquals(actualStation, expectedStation);
  }
}
