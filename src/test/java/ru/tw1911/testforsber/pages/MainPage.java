package ru.tw1911.testforsber.pages;

import org.openqa.selenium.support.FindBy;
import ru.tw1911.testforsber.annotations.PageAction;
import ru.tw1911.testforsber.annotations.PageTitle;
import ru.tw1911.testforsber.annotations.ElementTitle;
import ru.tw1911.testforsber.elements.WebButton;


@PageTitle("Главная страница")
public class MainPage extends AbstractPage{
    @ElementTitle("Войти")
    @FindBy(xpath = "//a[text()='Войти']")
    private WebButton loginButton;
}
