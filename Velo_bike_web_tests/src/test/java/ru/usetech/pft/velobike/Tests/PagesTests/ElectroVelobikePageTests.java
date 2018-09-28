package ru.usetech.pft.velobike.Tests.PagesTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Model.StationsData;
import ru.usetech.pft.velobike.Tests.Testbase;
import ru.usetech.pft.velobike.appManager.HttpSession;


import java.io.IOException;

public class ElectroVelobikePageTests extends Testbase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().goToPersonalAccountPage();
    app.getNavigationHelper().goToSideMenu();
    app.getNavigationHelper().goElectroVelobikePage();
  }


  @Test
  public void Test1() {
    //проверка перехода по ссылке «стоимость доступа»
    app.getNavigationHelper().goToPriceFromgoElectroVelobikePage();
    String pricesUrl = app.getHelperBase().getCurrentPageURL();
    Assert.assertEquals(pricesUrl, "https://velobike.ru/prices/");

  }

  @Test
  public void Test2() {
    //проверка перехода по ссылке «вопросы и ответы»
    app.getNavigationHelper().goToQaPageFromgoElectroVelobikePage();
    String qaUrl = app.getHelperBase().getCurrentPageURL();
    Assert.assertEquals(qaUrl, "https://velobike.ru/qa/#electro");
    //проверка наличие элемента "Электропрокат"
    Assert.assertEquals(app.getHelperBase().isElementPresent(By.id("electro")), true);
  }

  @Test
  public void Test3() throws IOException, InterruptedException {
    //отправляем http запрос и из ответа создаем объект типа station
    HttpSession session = app.newSession();
    String respons = session.resp("https://electro.velobike.ru/ajax/parkings/?_=1535358830923");
    StationsData expectedStation = app.getMapHelper().CreateStationDataFromResponse(respons);
    String stationNumber = "241";
    app.getMapHelper().initSearchOnElectroPage(stationNumber);
    app.getMapHelper().clickOnStationIconInElectro();
    //создаем объект типа station на странице
    StationsData actualStation = app.getMapHelper().CreateStationData(stationNumber);
    Assert.assertEquals(actualStation, expectedStation);

  }


}
