package com.demoqa.pages.widgets;

import com.demoqa.core.BaseFunctions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Options extends BaseFunctions {

    public Options(WebDriver driver) {
        super(driver);
    }

    public Options checkboxNrClick(int number) {
         click(driver.findElement(By.xpath("(//input[@type='checkbox'])[ "+ number +"]")));
        return this;
    }

//    public Options deleteCheckbox(int nr) {
//        boolean result = isElementPresent(By.xpath("//input [@checked])"));
//        // если есть галочка
//        if (result) {
//            checkboxNrClick(nr);
//        }
//        return this;
//    }

    public Options verifyCheckboxEmpty() {
        Assertions.assertFalse(isElementPresent(By.xpath("//input[@type = 'checkbox' and @checked]")));
        return this;
    }
}
