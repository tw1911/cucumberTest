package ru.tw1911.testforsber.util;

        import org.openqa.selenium.WebDriver;
        import org.reflections.Reflections;
        import ru.tw1911.testforsber.annotations.PageTitle;
        import ru.tw1911.testforsber.pages.AbstractPage;

        import java.lang.reflect.InvocationTargetException;
        import java.util.Optional;
        import java.util.Set;

public class PageFactory {
    WebDriver driver;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public  <TPage extends AbstractPage> TPage getInstance (Class<TPage> pageClass) {
        try {
            //Initialize the Page with its elements and return it.
            return org.openqa.selenium.support.PageFactory.initElements(driver,  pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public AbstractPage getInstanceByTitle(String pageTitle){
        Reflections reflections = new Reflections("ru.tw1911.testforsber.pages");
        Set<Class<?>> pages = reflections.getTypesAnnotatedWith(PageTitle.class);
        Optional<Class<?>> titledClass = pages.stream()
                .filter(page -> page.getAnnotation(PageTitle.class).value().equals(pageTitle))
                .findAny();
        Class pageClazz = titledClass.get();
        //System.out.println(pageClazz.getCanonicalName());
//        AbstractPage page;
//        try {
//            Object obj = pageClazz.getDeclaredConstructor(WebDriver.class).newInstance(driver);
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
        return (AbstractPage) org.openqa.selenium.support.PageFactory.initElements(driver, pageClazz);
    }
}
