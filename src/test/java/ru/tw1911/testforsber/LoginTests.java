package ru.tw1911.testforsber;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTests {

    @Test
    public void loginTest(){
        String login = "all.ivanofff";
        String password = "qwerty!@#123";
        WebDriver driver = new ChromeDriver();
        driver.get("https://yandex.ru/");
        driver.findElement(By.xpath("//a[.//text()='Войти в почту']")).click();
        driver.findElement(By.name("login")).sendKeys(login);
        driver.findElement(By.xpath("//button[.//text()='Войти']")).click();
        driver.findElement(By.id("passp-field-passwd")).sendKeys(password);
        driver.findElement(By.xpath("//button[.//text()='Войти']")).click();

    }
}
