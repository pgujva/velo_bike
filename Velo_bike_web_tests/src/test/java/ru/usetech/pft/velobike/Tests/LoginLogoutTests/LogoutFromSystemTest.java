package ru.usetech.pft.velobike.Tests.LoginLogoutTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.usetech.pft.velobike.Tests.Testbase;

public class LogoutFromSystemTest extends Testbase {

    @Test()
    public void TestLogoutFromSystem () {
        app.getSessionHelper().loginInHeder("4001776","3875");
        app.getSessionHelper().logoutFromSystem();

        Assert.assertEquals(app.getHelperBase().isThereARightPage(By.xpath("//a[contains(text(),'Войти')]"),"ВОЙТИ",
                By.xpath("//a[contains(text(),'Регистрация')]"),"РЕГИСТРАЦИЯ",
                "https://velobike.ru/"), true);
    }
}
