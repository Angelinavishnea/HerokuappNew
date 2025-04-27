package com.demoqa.pages.widgets;

import com.demoqa.core.BaseFunctions;
import com.demoqa.pages.windows.Alerts;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.security.Signature;

import static org.openqa.selenium.devtools.v133.debugger.Debugger.pause;

public class Hovers extends BaseFunctions {

    public Hovers(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);
    Alerts alerts = new Alerts(driver);

    /// ////////////////////////////////////////////////////////////////////////
    public Hovers hoverContact(int nr) {
        pause();
        scrollWithJS(0, 200);
        WebElement contact = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[" + nr + "]"));
        actions.moveToElement(contact).perform();
        pause();
        return this;
    }

    public Hovers verifyHover(String text) {
        WebElement contact = driver.findElement(By.xpath("//h5[contains(text(),'name: " + text + "')]"));
        Assertions.assertTrue(isContainsText(text,contact));
        return this;
    }
    /// ///////////////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//input[@type='range']")
    WebElement source;

    public Hovers moveSliderInHorizontalDirectionToEnd() {
        pause();
        actions.dragAndDropBy(source, 400,0).perform();
        return this;
    }

    public Hovers verifyTarget(String text) {
        WebElement target = driver.findElement(By.xpath("//span[.='5']"));
        Assertions.assertTrue(isContainsText(text, target));
        return this;
    }

    @FindBy(id= "hot-spot")
    WebElement whiteBox;

    public Hovers clickBox() {
        actions.contextClick(whiteBox).perform();
        return this;
    }
}
