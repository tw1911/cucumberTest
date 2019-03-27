package ru.tw1911.testforsber.util;

import org.openqa.selenium.WebDriver;
import ru.tw1911.testforsber.pages.AbstractPage;

public class PageFactory {
    WebDriver driver;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public  <TPage extends AbstractPage> TPage getInstance (Class<TPage> pageClass) {
        try {
            //Initialize the Page with its elements and return it.
            return org.openqa.selenium.support.PageFactory.initElements(driver,  pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
