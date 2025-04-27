package com.demoqa.pages.windows;

import com.demoqa.core.BaseFunctions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Alerts extends BaseFunctions {
    public Alerts(WebDriver driver) {
        super(driver);
    }

    /// ///////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//button[contains(text(),'Click for JS Alert')]")
    WebElement clickJSAlert;

    public Alerts verifyAlert() {
        Assertions.assertTrue(isAlertPresent(2));
        return this;
    }
    /// ///////////////////////////////////////////////////////////////////
    public Alerts selectResult(String result) {
        if (result != null && result.equals("OK")){
            driver.switchTo().alert().accept();
        } else if (result != null && result.equals("Cancel")){
            driver.switchTo().alert().dismiss();
        }
        return this;
    }
    /// ///////////////////////////////////////////////////////////////////
    public Alerts startAlertAndClickResult(String result){
        clickWithJS(clickJSAlert,0,300);
        selectResult(result);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Click for JS Confirm')]")
    WebElement clickJSConfirm;

    public Alerts startAlertAndClickResult2(String result){
        clickWithJS(clickJSConfirm,0,300);
        selectResult(result);
        return this;
    }
    /// ///////////////////////////////////////////////////////////////////
    @FindBy(id = "result")
    WebElement confirmResult;

    public Alerts verifyResult(String text) {
        Assertions.assertTrue(isContainsText(text, confirmResult));
        return this;
    }
    /// ///////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//button[contains(text(),'Click for JS Prompt')]")
    WebElement clickJSPromt;

    public Alerts sendMessageToAlert(String message) {
        clickWithJS(clickJSPromt,0,300);

        if(message != null){
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }

}
