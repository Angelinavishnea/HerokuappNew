package com.demoqa.core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseFunctions {

    public WebDriver driver;
    public static JavascriptExecutor js;
    //относится к Selenium, управляет браузером через JavaScript

    public BaseFunctions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        //функция из  Selenium, дает возможность пользоваться @FindBy
        js = (JavascriptExecutor) driver;
        //активирует Javascript функционал
    }

    public void scrollWithJS(int x, int y){
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void click(WebElement element){
        element.click();
    }

    public void clickWithJS(WebElement element, int x, int y){
        scrollWithJS(x, y);
        click(element);
    }

    public void type(WebElement element, String text){
        if (text != null){
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean isAlertPresent(int time){ //for control
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.alertIsPresent());
        if(alert == null){
            return false;
        }

        return true;

    }

    public boolean isContainsText(String text, WebElement element) {

        return element.getText().contains(text);}
}
