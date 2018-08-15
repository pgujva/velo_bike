package ru.usetech.pft.velobike;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.usetech.pft.velobike.appManager.ApplicationManager;

public class Testbase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
