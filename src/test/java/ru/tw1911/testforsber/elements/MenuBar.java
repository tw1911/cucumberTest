package ru.tw1911.testforsber.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuBar extends Element {
    @FindBy(xpath = "//li[@data-type='category']")
    private WebElement categories;

    public MenuBar(WebElement webElement) {
        super(webElement);
    }

    public void doSmth() {
        System.out.println("Do something cool!");
    }

    public void openСategory(String category) {
        categories.click();
    }
}
