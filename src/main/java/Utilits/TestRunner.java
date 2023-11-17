package Utilits;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestRunner {
    public TestRunner() {
    }

    @BeforeClass
    protected void setBrowser() {
        Configuration.browser = PropertyHelper.getBrowserProperty();
        Configuration.browserSize = PropertyHelper.getBrowserSizeProperty();
        Configuration.timeout = PropertyHelper.getTimeoutProperty();
        Configuration.pageLoadTimeout = PropertyHelper.getPageLoadTimeout();
    }

    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
