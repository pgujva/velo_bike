package ru.usetech.pft.velobike.Tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.*;
import ru.usetech.pft.velobike.appManager.ApplicationManager;

@Listeners(MyTestListener.class)

public class Testbase {

    protected static final ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp(ITestContext context) throws Exception {
        app.init();
        context.setAttribute("app",app);
    }

    @AfterClass( alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

}
