package ru.tw1911.testforsber.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Init {
    WebDriver driver;
    String login;
    String password;
    String browser;

    public Init(){
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/test/resources/application.properties");
            property.load(fis);

            login = property.getProperty("app.login");
            password = property.getProperty("app.password");
            browser = property.getProperty("test.browser");
            fis.close();
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }


}
