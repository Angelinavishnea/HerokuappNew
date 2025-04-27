package com.demoqa.pages;

import com.demoqa.core.BaseFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BaseFunctions {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /// //////////////////////////////////////////////////////////////
    @FindBy(xpath = "//a[contains(text(),'JavaScript Alerts')]")
    WebElement javaScriptAlert;

    public void selectJavaScriptAlerts() {  //for precondition
        clickWithJS(javaScriptAlert, 0, 300);
    }

    /// ///////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//a[contains(text(),'Nested Frames')]")
    WebElement nestedFrames;

    public void selectJNestedFrames() {  //for precondition
        clickWithJS(nestedFrames, 0, 300);
    }
    /// /////////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//a[contains(text(),'Dropdown')]")
    WebElement dropDown1;

    public void selectDropdown() {
        clickWithJS(dropDown1,0,200);
    }
    /// ////////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//a[contains(text(),'Hovers')]")
    WebElement hovers1;

    public void selectHovers() {
        clickWithJS(hovers1,0,200);
    }
    /// ///////////////////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//a[contains(text(),'Horizontal Slider')]")
    WebElement horizontalSlider;

    public void selectHorizontalSlider() {
        clickWithJS(horizontalSlider, 0, 400);
    }
    /// ///////////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//a[contains(text(),'Context Menu')]")
    WebElement contextMenu;

    public void selectContextMenu() {
        clickWithJS(contextMenu, 0, 400);
    }
}
