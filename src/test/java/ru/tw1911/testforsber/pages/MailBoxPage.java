package ru.tw1911.testforsber.pages;

import org.openqa.selenium.WebDriver;
import ru.tw1911.testforsber.annotations.PageTitle;

@PageTitle("Входящие")
public class MailBoxPage extends AbstractPage{
    public MailBoxPage(WebDriver driver) {
        super(driver);
    }
}
