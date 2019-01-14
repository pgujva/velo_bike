package ru.usetech.pft.velobike.appManager;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.usetech.pft.velobike.Model.StationsData;

public class MapHelper {

  private WebDriver wd;
  private WebDriverWait wait;

  public MapHelper(WebDriver wd, WebDriverWait wait) {
    this.wd = wd;
    this.wait = wait;
  }

  public StationsData CreateStationDataFromResponse(String respons) {
    JsonParser jsonParser = new JsonParser();
    JsonObject jsonObject = (JsonObject) jsonParser.parse(respons);
    JsonArray lang = (JsonArray) jsonObject.get("Items");
    JsonObject innerObj = (JsonObject) lang.get(234);

    int id = innerObj.get("Id").getAsInt();
    int freeElectricPlaces = innerObj.get("FreeElectricPlaces").getAsInt();
    int totalElectricPlaces = innerObj.get("TotalElectricPlaces").getAsInt();
    int freeOrdinaryPlaces = totalElectricPlaces - freeElectricPlaces;
    String address = innerObj.get("Address").getAsString();
    StationsData station = new StationsData(id, freeElectricPlaces, freeOrdinaryPlaces, address);
    return station;
  }

  public StationsData CreateStationDataFromResponseWithoutElectro(String respons) {
    JsonParser jsonParser = new JsonParser();
    JsonObject jsonObject = (JsonObject) jsonParser.parse(respons);
    JsonArray lang = (JsonArray) jsonObject.get("Items");
    JsonObject innerObj = (JsonObject) lang.get(234);

    int id = innerObj.get("Id").getAsInt();
    int freeElectricPlaces = innerObj.get("FreeOrdinaryPlaces").getAsInt();
    int totalElectricPlaces = innerObj.get("TotalOrdinaryPlaces").getAsInt();
    int freeOrdinaryPlaces = totalElectricPlaces - freeElectricPlaces;
    String address = innerObj.get("Address").getAsString();
    StationsData station = new StationsData(id, freeElectricPlaces, freeOrdinaryPlaces, address);
    return station;
  }

  public void initSearchOnElectroPage(String text) {
    wd.findElement(By.id("search-input")).click();
    wd.findElement(By.id("search-input")).clear();
    wd.findElement(By.id("search-input")).sendKeys(text);
    wd.findElement(By.className("route-map__search__submit")).click();


  }

  public void initSearchOnMainPage (String text) {
    wd.findElement(By.id("search-input")).click();
    wd.findElement(By.id("search-input")).clear();
    wd.findElement(By.id("search-input")).sendKeys(text);
    wd.findElement(By.className("address-search__submit")).click();


  }

  public void clickOnStationIconInElectro() {
    wd.findElement(By.cssSelector("div[title]")).click();
  }

  public void clickOnStationIconOnMainPage() {
    wd.findElement(By.xpath("//*[@id=\"map\"]/div/div/div[1]/div[1]/div[1]")).click();
  }

  public StationsData CreateStationData(String stationNumber) {
    int id = Integer.parseInt("0" + wd.findElement(By.id(stationNumber)).getAttribute("id"));
    int freeElectricPlaces = Integer.parseInt(
            wd.findElement(By.cssSelector("div.map-popup__status-cols-wrap div.map-popup__status-col:nth-child(1) span.map-popup__number")).getAttribute("innerText"));
    int freeOrdinaryPlaces = Integer.parseInt(
            wd.findElement(By.cssSelector("div.map-popup__status-cols-wrap div.map-popup__status-col:nth-child(2) span.map-popup__number")).getText());
    String address = wd.findElement(By.cssSelector("address.map-popup__address")).getText();
    StationsData stationsData = new StationsData(id, freeElectricPlaces, freeOrdinaryPlaces, address);
    return stationsData;
  }
}
