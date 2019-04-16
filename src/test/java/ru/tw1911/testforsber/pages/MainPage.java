package ru.tw1911.testforsber.pages;

import org.openqa.selenium.support.FindBy;
import ru.tw1911.testforsber.annotations.PageAction;
import ru.tw1911.testforsber.annotations.PageTitle;
import ru.tw1911.testforsber.elements.MenuBar;


@PageTitle("Главная страница")
public class MainPage extends AbstractPage{

    @FindBy(id = "default-menu")
    private MenuBar menuBar;

    @PageAction("выбирает категорию")
    public void selectCategory(String category) {
        System.out.println("Категория" + category);
        menuBar.openСategory(category);
    }
}
