package ru.usetech.pft.velobike.Tests.PagesTests;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import netscape.javascript.JSObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Model.PricePageData;
import ru.usetech.pft.velobike.Tests.Testbase;
import ru.usetech.pft.velobike.appManager.HttpSession;





import java.io.IOException;
import java.util.List;

public class ElectroVelobikePageTests extends Testbase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().goToPersonalAccountPage();
        app.getNavigationHelper().goToSideMenu();
        app.getNavigationHelper().goElectroVelobikePage();
    }


    @Test (enabled = false)
    public void Test1() {
        //проверка перехода по ссылке «стоимость доступа»
       app.getNavigationHelper().goToPriceFromgoElectroVelobikePage();
       String pricesUrl = app.getHelperBase().getCurrentPageURL();
       Assert.assertEquals(pricesUrl,"https://velobike.ru/prices/");

    }

    @Test (enabled = false)
    public void Test2() {
        //проверка перехода по ссылке «вопросы и ответы»
        app.getNavigationHelper().goToQaPageFromgoElectroVelobikePage();
        String qaUrl = app.getHelperBase().getCurrentPageURL();
        Assert.assertEquals(qaUrl,"https://velobike.ru/qa/#electro");
        //проверка наличие элемента "Электропрокат"
        Assert.assertEquals(app.getHelperBase().isElementPresent(By.id("electro")),true);
    }

    @Test
    public void Test3() throws IOException{
        HttpSession session = app.newSession();
       String respons = session.resp();
       // System.out.println(respons);
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(respons);
        JsonArray lang= (JsonArray) jsonObject.get("Items");
      //  JsonElement d = lang.get(234);
        JsonObject innerObj = (JsonObject) lang.get(234);
       // innerObj.get("Id");
        System.out.println(lang.get(234));
        System.out.println( innerObj.get("Id"));
        System.out.println( innerObj.get("FreeElectricPlaces"));
        System.out.println(innerObj.get("FreeOrdinaryPlaces"));

    }
}
