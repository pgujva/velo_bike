package ru.usetech.pft.velobike.bdd;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import ru.usetech.pft.velobike.appManager.ApplicationManager;

public class SideMenuStepDefinitions {

    private ApplicationManager app;
    String pageUrl;
    String pageName;

    @Before
    public void init() {
        app = new ApplicationManager();
        app.init();
    }

    @After
    public void stop() {
        app.stop();
    }

    @Given("^a side menu and then go to PricePage$")
    public void a_side_menu_and_then_go_to_PricePage() {
        app.getNavigationHelper().goToSideMenu();
        app.getNavigationHelper().goPricePage();
        throw new cucumber.api.PendingException();
    }

    @When("^i get Current Page URL and get Page Name$")
    public void i_get_Current_Page_URL_and_get_Page_Name() {
        pageUrl = app.getHelperBase().getCurrentPageURL();
        pageName = app.getHelperBase().getPageName(By.tagName("h1"));
        throw new cucumber.api.PendingException();
    }

    @Then("^Current Page URL and Page Name equals really URL and page name$")
    public void current_Page_URL_and_Page_Name_equals_really_URL_and_page_name(){
        Assert.assertEquals(pageUrl, "https://velobike.ru/prices/", "неверный URL");
        Assert.assertEquals(pageName, "Сколько это стоит", "неверный заголовок страницы");
        throw new cucumber.api.PendingException();
    }


}
