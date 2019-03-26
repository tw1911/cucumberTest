package ru.tw1911.testforsber.application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.tw1911.testforsber.pages.AbstractPage;

public class Application {
    private WebDriver driver;
    public Application(WebDriver driver){
        this.driver=driver;
    }


    public  <TPage extends AbstractPage> TPage getInstance (Class<TPage> pageClass) {
        try {
            //Initialize the Page with its elements and return it.
            return PageFactory.initElements(driver,  pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
