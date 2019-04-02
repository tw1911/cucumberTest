package ru.tw1911.testforsber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.picocontainer.annotations.Inject;
import ru.tw1911.testforsber.annotations.PageAction;
import ru.tw1911.testforsber.annotations.PageTitle;
import ru.tw1911.testforsber.entity.User;

@PageTitle("Авторизация")
public class LoginPage extends AbstractPage{

    @Inject
    User user;

    @FindBy(name = "login")
    private WebElement loginInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[.//text()='Войти']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @PageAction("вводит логин и пароль из настроек")
    public void enterLoginAndPassword(){
        //loginInput.sendKeys(user.getLogin());
        loginInput.sendKeys("111111111111");

        loginButton.click();
        passwordInput.sendKeys(user.getPassword());
        passwordInput.sendKeys("1111111111");

        loginButton.click();
    }

    @PageAction("нажимает кнопку 'Войти'")
    public void clickLoginButton(){
        loginButton.click();
    }
}
