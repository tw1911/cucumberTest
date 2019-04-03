package ru.tw1911.testforsber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.tw1911.testforsber.annotations.PageAction;
import ru.tw1911.testforsber.annotations.PageTitle;

@PageTitle("Главная страница")
public class MainPage extends AbstractPage{

    @FindBy(xpath = "//a[.//text()='Войти в почту']")
    private WebElement loginButton;

    @PageAction("нажимает кнопку Войти в почту")
    public void clickLoginButton(){
        loginButton.click();
    }
}
