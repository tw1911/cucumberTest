package ru.tw1911.testforsber.pages;

import org.openqa.selenium.WebDriver;

public class AbstractPage {
    protected final WebDriver driver;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
    }
}
