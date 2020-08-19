package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {


    @FindBy(xpath = "//input[@id='login_field']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='commit']")
    private WebElement SignInBtn;

    public LoginPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }


    public LoginPage fillLogin(String login) {
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage fillPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public MainPage clickSignInBtn() {
        SignInBtn.click();
        return new MainPage(webDriver);
    }
}
