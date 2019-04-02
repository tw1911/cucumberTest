package ru.tw1911.testforsber;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.tw1911.testforsber.application.Application;
import ru.tw1911.testforsber.pages.MainPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginTests {
    static String login;
    static String password;
    static String browser;
    WebDriver driver;

    @BeforeClass
    public static void init(){
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

    @Before
    public void setUp(){
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest(){
//        driver.get("https://yandex.ru/");
//
//        Application app = new Application();
//        MainPage mainPage = app.getInstance(MainPage.class);
//        mainPage.open();
//
//        driver.findElement(By.xpath("//a[.//text()='Войти в почту']")).click();
//        driver.findElement(By.name("login")).sendKeys(login);
//        driver.findElement(By.xpath("//button[.//text()='Войти']")).click();
//        driver.findElement(By.id("passp-field-passwd")).sendKeys(password);
//        driver.findElement(By.xpath("//button[.//text()='Войти']")).click();

//        driver.findElement(By.className("mail-User-Name")).click();
//        driver.findElement(By.xpath("//a[text()='Выйти из сервисов Яндекса']")).click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
