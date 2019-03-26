package ru.tw1911.testforsber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage{

    @FindBy(xpath = "//a[.//text()='Войти в почту']")
    private WebElement loginButton;

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get("https://yandex.ru");
    }
}
