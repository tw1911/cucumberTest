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

    @FindBy(name = "passwd")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[.//text()='Войти']")
    private WebElement loginButton;

    @PageAction("вводит логин и пароль из настроек")
    public void enterLoginAndPassword(){
        loginInput.sendKeys(user.getLogin());

        loginButton.click();
        passwordInput.sendKeys(user.getPassword());

        loginButton.click();
    }

    @PageAction("нажимает кнопку 'Войти'")
    public void clickLoginButton(){
        loginButton.click();
    }
}
