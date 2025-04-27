package com.demoqa.pages.widgets;

import com.demoqa.core.BaseFunctions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.security.Signature;

public class SelectMenu extends BaseFunctions {


    public SelectMenu(WebDriver driver) {
        super(driver);
    }

    /// /////////////////////////////////////////////////////////////
    @FindBy(id="dropdown")
    WebElement dropdown2;

    @FindBy(css = "html")
    WebElement space;

    Select select = new Select(dropdown2);

    public SelectMenu multiSelectList(String option) {
        click(dropdown2);

        if (option == "Option 1"){
            select.selectByVisibleText(option);
        }else {
            select.selectByVisibleText(option);
        }
        click(space);
        return this;
    }

    public SelectMenu verifyOption(String option) {
        Assertions.assertTrue(isContainsText(option, dropdown2));
        return this;
    }
}
