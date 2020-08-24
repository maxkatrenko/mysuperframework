package ui.tests;

import org.apache.commons.codec.binary.Base64;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.pages.LoginPage;
import ui.util.AbstractWebDriver;

public class LoginTest extends AbstractWebDriver {
    private LoginPage loginPage;

    @BeforeTest
    public void init() {
        loginPage = new LoginPage(webDriver, "https://github.com/login");
    }

    @Test
    public void testLogin() {
        loginPage.fillLogin("");
        loginPage.fillPassword("");
        loginPage.clickSignInBtn();

        Assert.assertTrue(loginPage.webDriver.getTitle().contains("GitHub"));
    }
}
