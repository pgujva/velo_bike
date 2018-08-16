package ru.usetech.pft.velobike.Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnterToSystemFromMenuTest extends Testbase {

    @Test()
    public void TestEnterToSystemFromMenu() {
        app.getSessionHelper().loginInsideMenu("4001776", "3875");
        boolean a = app.getHelperBase().isThereARightPage(By.tagName("h1"), "Личный кабинет",
                By.cssSelector("span.lk-intro__welcome-name"), "Тест!", "https://velobike.ru/account/");
        Assert.assertEquals(a, true);
    }

}
