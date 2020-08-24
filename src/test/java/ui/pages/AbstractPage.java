package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {
    public final WebDriver webDriver;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public AbstractPage(WebDriver webDriver, String url) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        PageFactory.initElements(webDriver, this);
        webDriver.get(url);
        webDriver.navigate().refresh();
    }
}
