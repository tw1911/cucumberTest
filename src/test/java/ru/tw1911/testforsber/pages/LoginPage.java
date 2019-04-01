package ru.tw1911.testforsber.pages;

import org.openqa.selenium.WebDriver;
import ru.tw1911.testforsber.annotations.PageTitle;

@PageTitle("Авторизация")
public class LoginPage extends AbstractPage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
