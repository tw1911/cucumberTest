package ru.tw1911.testforsber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.picocontainer.annotations.Inject;
import ru.tw1911.testforsber.annotations.PageAction;
import ru.tw1911.testforsber.annotations.PageTitle;
import ru.tw1911.testforsber.annotations.ElementTitle;
import ru.tw1911.testforsber.elements.WebButton;
import ru.tw1911.testforsber.elements.WebInput;
import ru.tw1911.testforsber.entity.User;

@PageTitle("Войдите, чтобы перейти далее")
public class AnotherLoginPage extends AbstractPage{

    @Inject
    User user;

    @FindBy(id = "username")
    private WebInput loginInput;

    @FindBy(id = "password")
    private WebInput passwordInput;

    @FindBy(xpath = "//button//span[text()='Продолжить']")
    @ElementTitle("Продолжить")
    private WebButton continueButton;

    @FindBy(xpath = "//button[.//span/text()='Войти']")
    @ElementTitle("Войти")
    private WebButton loginButton;

    @PageAction("вводит логин и пароль из настроек")
    public void enterLoginAndPassword(){
        loginInput.clear();
        loginInput.sendKeys(user.getLogin());
        continueButton.click();
        passwordInput.sendKeys(user.getPassword());
    }
}
