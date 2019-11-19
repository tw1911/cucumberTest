package ru.tw1911.testforsber.pages;

import org.openqa.selenium.WebElement;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import ru.tw1911.testforsber.annotations.PageAction;
import ru.tw1911.testforsber.annotations.ElementTitle;
import ru.tw1911.testforsber.elements.WebButton;
import ru.tw1911.testforsber.elements.WebInput;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AbstractPage {

    @PageAction("нажимает кнопку")
    public void clickButton(final String buttonName) {
        Field buttonField = getFieldWithTypeAndTitle(buttonName,WebButton.class);
        buttonField.setAccessible(true);
        try {
            WebButton button = (WebButton) buttonField.get(this);
            button.click();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("Нажимает кнопку:" +  buttonName);
    }

    @PageAction("вводит значение в поле")
    public void enterValueInField(final String value, final String fieldName) {
        Field inputField = getFieldWithTypeAndTitle(fieldName, WebInput.class);
        inputField.setAccessible(true);
        try {
            WebInput input = (WebInput) inputField.get(this);
            input.sendKeys(value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("Воводит значение:" + value+" в поле: "+fieldName );
    }

    private Field getFieldWithTypeAndTitle(String title, Class clazz){
        Field[] fields = this.getClass().getDeclaredFields();
        List<Field> specificTypeFields = Stream.of(fields).filter(field -> field.getType().equals(clazz)).collect(Collectors.toList());
        return specificTypeFields.stream().filter(f -> f.getAnnotation(ElementTitle.class).value().equals(title)).findFirst().get();
    }
}
