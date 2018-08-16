package ru.usetech.pft.velobike.Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnterToSystemFromHederTest extends Testbase {

    @Test()
    public void TestEnterToSystemFromHeder () {
        app.getSessionHelper().loginInHeder("4001776", "3875");
        boolean a = app.isThereARightPage(By.tagName("h1"), "Личный кабинет", By.cssSelector("span.lk-intro__welcome-name"), "Тест!", "https://velobike.ru/account/");
        Assert.assertEquals(a, true);

    }

}
