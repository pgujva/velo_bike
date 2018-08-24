package ru.usetech.pft.velobike.Tests.PagesTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Model.PricePageData;
import ru.usetech.pft.velobike.Tests.Testbase;

import java.util.List;

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
       Assert.assertEquals(pricesUrl,"https://velobike.ru/prices/");

    }

    @Test
    public void Test2() {
        //проверка перехода по ссылке «вопросы и ответы»
        app.getNavigationHelper().goToQaPageFromgoElectroVelobikePage();
        String qaUrl = app.getHelperBase().getCurrentPageURL();
        Assert.assertEquals(qaUrl,"https://velobike.ru/qa/#electro");
        //проверка наличие элемента "Электропрокат"
        Assert.assertEquals(app.getHelperBase().isElementPresent(By.id("electro")),true);
    }
}
