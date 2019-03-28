package ru.tw1911.testforsber.application;

import cucumber.api.java.ru.И;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.tw1911.testforsber.annotations.PageAction;
import ru.tw1911.testforsber.pages.MainPage;
import ru.tw1911.testforsber.util.Init;
import ru.tw1911.testforsber.pages.AbstractPage;
import ru.tw1911.testforsber.util.PageFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Application {
    private WebDriver driver;
    AbstractPage page = null;
    PageFactory pageFactory;

    public Application(Init init){
        this.driver = init.getDriver();
        this.pageFactory = new PageFactory(driver);
    }


    @И("^открывается страница \"([^\"]*)\"$")
    public void assignPage(String pageName){
        System.out.println(pageName);
        this.page = pageFactory.getInstance(MainPage.class);
        System.out.println(page.getClass().getCanonicalName());

    }

    @И("^он \\(([^\"]*)\\)$")
    public void invokePageAction(String actionName){
        System.out.println(actionName);
        invokeAction(actionName);
    }

    @И("^он открывает приложение в браузере$")
    public void openPage(){
        driver.get("https://yandex.ru");
    }

    @И("^нажимаем кнопку 'Войти в почту'")
    public void enterMail(){
        driver.findElement(By.xpath("//a[.//text()='Войти в почту']")).click();
    }

    private void invokeAction(String actionName){
        Method[] methods = page.getClass().getMethods();
        Method action;
        for (Method method:methods){
            if(method.isAnnotationPresent(PageAction.class)){
                if(method.getAnnotation(PageAction.class).value().equals(actionName)){
                    action = method;
                    try {
                        action.invoke(page);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        ;
    }

}
