package ru.tw1911.testforsber.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.injectors.MultiInjection;
import ru.tw1911.testforsber.entity.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Init {
    MutablePicoContainer container;
    Properties properties;

    public Init(){
        FileInputStream fis;
        properties = new Properties();
        try {
            fis = new FileInputStream("src/test/resources/application.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

        this.container = new DefaultPicoContainer(new MultiInjection());
        container.addComponent(createUser());
        container.addComponent(createDriver());
    }

    public MutablePicoContainer getContainer(){
        return container;
    }

    private User createUser(){
        return new User(properties.getProperty("app.login"),properties.getProperty("app.password"));
    }

    private WebDriver createDriver(){
        String browser = properties.getProperty("test.browser");
        WebDriver driver;
        switch (browser){
            case "chrome":{ driver = new ChromeDriver(); break;}
            case "firefox": { driver = new FirefoxDriver(); break;}
            case "ie": { driver = new InternetExplorerDriver(); break;}
            default: driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        return driver;
    }
}
