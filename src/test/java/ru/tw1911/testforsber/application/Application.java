package ru.tw1911.testforsber.application;

import cucumber.api.java.ru.И;
import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.picocontainer.MutablePicoContainer;
import ru.tw1911.testforsber.annotations.PageAction;
import ru.tw1911.testforsber.pages.AbstractPage;
import ru.tw1911.testforsber.util.Init;
import ru.tw1911.testforsber.util.PageFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Log
public class Application {
    AbstractPage page = null;
    PageFactory pageFactory;
    MutablePicoContainer container;

    public Application(Init initt) {
        this.container = initt.getContainer();
        this.pageFactory = new PageFactory(container);
    }


    @И("^открывается страница \"([^\"]*)\"$")
    public void assignPage(String pageName) {
        this.page = pageFactory.getInstanceByTitle(pageName);
    }

    @И("^он \\((.*?)\\)$")
    public void invokePageAction(String actionName) {
        invokeAction(actionName);
    }

    @И("^он \\((.*?)\\) \"([^\"]*)\"$")
    public void invokePageActionWithOneParam(String actionName, String param1) {
        invokeAction(actionName, param1);
    }

    @И("^он открывает приложение в браузере$")
    public void openPage() {
        container.getComponent(WebDriver.class).get("https://demo.litecart.net/");
    }

    @И("^закрывает браузер$")
    public void closeBrowser() {
        container.getComponent(WebDriver.class).quit();
        container.removeComponent(WebDriver.class);
    }

    private void invokeAction(String actionName) {
        Method[] methods = page.getClass().getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PageAction.class) && method.getAnnotation(PageAction.class).value().equals(actionName)) {
                try {
                    method.invoke(page);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    log.info("Не удалось вызвать метод: " + actionName);
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    private void invokeAction(String actionName, String arg1) {
        Method[] methods = page.getClass().getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PageAction.class) && method.getAnnotation(PageAction.class).value().equals(actionName)) {
                try {
                    method.invoke(page, arg1);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    log.info("Не удалось вызвать метод: " + actionName + " c параметром: " + arg1);
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
