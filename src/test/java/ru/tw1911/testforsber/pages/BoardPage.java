package ru.tw1911.testforsber.pages;

import org.openqa.selenium.support.FindBy;
import ru.tw1911.testforsber.annotations.ElementTitle;
import ru.tw1911.testforsber.annotations.PageAction;
import ru.tw1911.testforsber.annotations.PageTitle;
import ru.tw1911.testforsber.elements.TrelloList;
import ru.tw1911.testforsber.elements.WebButton;
import ru.tw1911.testforsber.elements.WebInput;

import java.util.List;

@PageTitle("Board")
public class BoardPage extends AbstractPage {

    @FindBy(xpath = "//input[@name='name']")
    @ElementTitle("Enter list title")
    private WebInput listTitleInput;

    @FindBy(xpath = "//input[@value='Add List']")
    @ElementTitle("Add List")
    private WebButton addListButton;

    @FindBy(xpath = "//div[contains(@class,'list-content')]")
    @ElementTitle("List")
    private List<TrelloList> trelloLists;

    @PageAction("проверяет, что существует список с именем")
    public void checkListWithNameExists(String listName){
        System.out.println(trelloLists.get(0).getName());
    }
}