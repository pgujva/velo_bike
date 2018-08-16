package ru.usetech.pft.velobike.Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnterTo extends Testbase {

    @Test()
    public void TestsEnte() {

        boolean a = app.isThereARightPage(By.tagName("h1"), "Личный кабинет", By.cssSelector("span.lk-intro__welcome-name"), "Тест!", "https://velobike.ru/account/");
        Assert.assertEquals(a, true);
    }
}

