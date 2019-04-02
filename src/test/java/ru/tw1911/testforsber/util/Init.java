package ru.tw1911.testforsber.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import ru.tw1911.testforsber.entity.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Init {
    WebDriver driver;
    String login;
    String password;
    String browser;

    MutablePicoContainer container;

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

        this.container = new DefaultPicoContainer();
        container.addComponent(new User(login,password));
    }

    public WebDriver getDriver() {
        return driver;
    }


}
