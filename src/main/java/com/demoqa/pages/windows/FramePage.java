package com.demoqa.pages.windows;

import com.demoqa.core.BaseFunctions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramePage extends BaseFunctions {

    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "frame")
    List<WebElement> frames;

    public FramePage returnListOfFrames(){
        return this;
    }
    public FramePage returnListOfIframes() {
        System.out.println("The total number of iframes are " + frames.size());
        return this;
    }

    public FramePage switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }



    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public FramePage verifyIframeByTitle(String title) {
        Assertions.assertTrue(isContainsText(title,sampleHeading));
        return this;
    }
}

