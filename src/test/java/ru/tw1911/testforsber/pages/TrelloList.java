package ru.tw1911.testforsber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.tw1911.testforsber.elements.Element;

public class TrelloList extends Element {
    public TrelloList(WebElement webElement) {
        super(webElement);
    }

    public String getName(){
        return super.webElement.findElement(By.xpath(".//h2[contains(@class,'list-header-name')]")).getText();
    }
}
