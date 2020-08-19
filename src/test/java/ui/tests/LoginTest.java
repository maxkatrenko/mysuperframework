package ui.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ui.pages.LoginPage;
import util.AbstractWebDriver;

public class LoginTest extends AbstractWebDriver {
    private LoginPage loginPage;

    @Before
    public void init() {
        loginPage = new LoginPage(webDriver, "https://github.com/login");
    }

    @Test
    public void testLogin() {
        loginPage.fillLogin("bestintheworldqq@gmail.com");
        loginPage.fillPassword("Csnorarcemax1");
        loginPage.clickSignInBtn();

        Assert.assertTrue(loginPage.webDriver.getTitle().contains("GitHub"));
    }
}
