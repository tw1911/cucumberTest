package ru.tw1911.testforsber.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import ru.tw1911.testforsber.annotations.ElementTitle;
import ru.tw1911.testforsber.annotations.PageAction;
import ru.tw1911.testforsber.annotations.PageTitle;
import ru.tw1911.testforsber.elements.WebButton;
import ru.tw1911.testforsber.elements.WebInput;

@PageTitle("Boards")
public class BoardsPage extends AbstractPage{
    @FindBy(xpath = "//span[text()='Create new board']")
    @ElementTitle("Create new board")
    private WebButton createNewBoardButton;

    @FindBy(xpath = "//input[@data-test-id='create-board-title-input']")
    @ElementTitle("Add board title")
    private WebInput boardTitleInput;

    @FindBy(xpath = "//button[.//span[text()='Create Board']]")
    @ElementTitle("Create Board")
    private WebButton createBoardButton;

    @PageAction("создает доску со случайным названием и запоминает его")
    public void createBoardWithRandomName(){
        String generatedString = RandomStringUtils.random(10, true, false);
        createNewBoardButton.click();
        boardTitleInput.sendKeys(generatedString);
        createBoardButton.click();
        saveValueToStash(generatedString);
    }

    private void saveValueToStash(String value){

    }
}
