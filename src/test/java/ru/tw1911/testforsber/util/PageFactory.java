package ru.tw1911.testforsber.util;

import org.openqa.selenium.WebDriver;
import org.picocontainer.MutablePicoContainer;
import org.reflections.Reflections;
import ru.tw1911.testforsber.annotations.PageTitle;
import ru.tw1911.testforsber.pages.AbstractPage;

import java.util.Optional;
import java.util.Set;

public class PageFactory {

    WebDriver driver;
    MutablePicoContainer container;

    public <TPage extends AbstractPage> TPage getInstance(Class<TPage> pageClass) {
        try {
            return org.openqa.selenium.support.PageFactory.initElements(driver, pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public PageFactory(MutablePicoContainer container) {
        this.container = container;
        this.driver = container.getComponent(WebDriver.class);
    }

    public AbstractPage getInstanceByTitle(String pageTitle) {
        Reflections reflections = new Reflections("ru.tw1911.testforsber.pages");
        Set<Class<?>> pages = reflections.getTypesAnnotatedWith(PageTitle.class);
        Optional<Class<?>> titledClass = pages.stream()
                .filter(page -> page.getAnnotation(PageTitle.class).value().equals(pageTitle))
                .findAny();
        Class pageClazz = titledClass.get();
        if (container.getComponent(pageClazz) == null) {
            container.addComponent(pageClazz);
            AbstractPage ap = (AbstractPage) container.getComponent(pageClazz);
            org.openqa.selenium.support.PageFactory.initElements(container.getComponent(CustomFieldDecorator.class), ap);
            return ap;
        } else return (AbstractPage) container.getComponent(pageClazz);
    }
}
