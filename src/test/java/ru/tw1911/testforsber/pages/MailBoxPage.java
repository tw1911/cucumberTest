package ru.tw1911.testforsber.pages;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.picocontainer.annotations.Inject;
import ru.tw1911.testforsber.annotations.PageAction;
import ru.tw1911.testforsber.annotations.PageTitle;
import ru.tw1911.testforsber.entity.User;

@PageTitle("Входящие")
public class MailBoxPage extends AbstractPage {

    @Inject
    User user;

    public MailBoxPage(WebDriver driver) {
        super(driver);
    }

    @PageAction("проверяет свое имя на странице")
    public void checkLoginName() {
        String actualLogin = driver.findElement(By.className("mail-User-Name")).getText();
        Assert.assertEquals(actualLogin, user.getLogin());
    }

    @PageAction("нажимает выход")
    public void getOut() {
        driver.findElement(By.className("mail-User-Name")).click();
        driver.findElement(By.xpath("//a[text()='Выйти из сервисов Яндекса']")).click();
    }
}
