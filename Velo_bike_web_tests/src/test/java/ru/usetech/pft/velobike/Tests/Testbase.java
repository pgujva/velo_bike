package ru.usetech.pft.velobike.Tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.*;
import ru.usetech.pft.velobike.appManager.ApplicationManager;

@Listeners(MyTestListener.class)

public class Testbase {

 protected static final ApplicationManager app = new ApplicationManager();

    //@BeforeMethod(alwaysRun = true)
    //public void setUp(ITestContext context) throws Exception {
      //  app.init();
        //context.setAttribute("app",app);
    //}

    //@AfterMethod(alwaysRun = true)
    //public void tearDown() {
   //     app.stop();
    //}

}
