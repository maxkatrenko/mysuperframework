package ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;

public class LoginTestSelenoid {

    @Test
    public void loginTest() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("84.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        RemoteWebDriver webDriver = new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub").toURL(),
                capabilities
        );

        webDriver.get("https://github.com/login");
        webDriver.findElement(By.xpath("//input[@id='login_field']")).sendKeys("");
        webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys("");
        webDriver.findElement(By.xpath("//input[@name='commit']")).click();

        Assert.assertTrue(webDriver.getTitle().contains("GitHub"));
    }
}
