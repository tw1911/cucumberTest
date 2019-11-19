package ru.tw1911.testforsber.application;

import cucumber.api.java.ru.И;
import org.openqa.selenium.WebDriver;
import org.picocontainer.MutablePicoContainer;
import ru.tw1911.testforsber.annotations.PageAction;
import ru.tw1911.testforsber.entity.AppConfig;
import ru.tw1911.testforsber.pages.AbstractPage;
import ru.tw1911.testforsber.util.Init;
import ru.tw1911.testforsber.util.PageFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Application {
    private AbstractPage page = null;
    private PageFactory pageFactory;
    private MutablePicoContainer context;
    private AppConfig appConfig;
    private WebDriver driver;

    public Application(Init init) {
        this.context = init.getContainer();
        this.pageFactory = new PageFactory(context);
        appConfig= context.getComponent(AppConfig.class);
        driver= context.getComponent(WebDriver.class);
    }


    @И("открывается страница {string}")
    public void assignPage(String pageName) {
        this.page = pageFactory.getInstanceByTitle(pageName);
    }

    @И("он \\({})")
    public void invokePageAction(String actionName) {
        invokeAction(actionName);
    }

    @И("он \\({}) {string}")
    public void invokePageActionWithOneParam(String actionName, String param1) {
        invokeAction(actionName, param1);
    }

    @И("он \\({}) {string} {string}")
    public void invokePageActionWithTwoParams(String actionName, String param1, String param2) {
        invokeAction(actionName, param1, param2);
    }

    @И("он открывает приложение в браузере")
    public void openPage() {
        driver.get(appConfig.getUrl());
    }

    @И("закрывает браузер")
    public void closeBrowser() {
        context.getComponent(WebDriver.class).quit();
        context.removeComponent(WebDriver.class);
    }

//    private void invokeAction(String actionName) {
//        Method[] methods = page.getClass().getMethods();
//        for (Method method : methods) {
//            if (method.isAnnotationPresent(PageAction.class) && method.getAnnotation(PageAction.class).value().equals(actionName)) {
//                try {
//                    method.invoke(page);
//                } catch (InvocationTargetException | IllegalAccessException e) {
//                    //log.info("Не удалось вызвать метод: " + actionName);
//                    e.printStackTrace();
//                }
//                break;
//            }
//        }
//    }

    private void invokeAction(String actionName, String ... args) {
        Method[] methods = page.getClass().getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PageAction.class) && method.getAnnotation(PageAction.class).value().equals(actionName)) {
                try {
                    Object[] arr = args.clone();
                    method.invoke(page, arr);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    //log.info("Не удалось вызвать метод: " + actionName + " c параметром: " + arg1);
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
