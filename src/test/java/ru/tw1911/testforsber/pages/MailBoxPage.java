package ru.tw1911.testforsber.pages;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.picocontainer.annotations.Inject;
import ru.tw1911.testforsber.annotations.PageAction;
import ru.tw1911.testforsber.annotations.PageTitle;
import ru.tw1911.testforsber.entity.User;

@PageTitle("Входящие")
public class MailBoxPage extends AbstractPage {

    @Inject
    User user;

    @FindBy(className = "mail-User-Name")
    private WebElement userNameLabel;

    @FindBy(xpath = "//a[text()='Выйти из сервисов Яндекса']")
    private WebElement signOutButton;

    @PageAction("проверяет свое имя на странице")
    public void checkLoginName() {
        String actualLogin = userNameLabel.getText();
        Assert.assertEquals(actualLogin, user.getLogin());
    }

    @PageAction("нажимает выход")
    public void getOut() {
        userNameLabel.click();
        signOutButton.click();
    }
}
