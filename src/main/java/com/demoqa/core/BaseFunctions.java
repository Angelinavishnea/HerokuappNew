package com.demoqa.core;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public class BaseFunctions {

    public WebDriver driver;
    public static JavascriptExecutor js;
    //относится к Selenium, управляет браузером через JavaScript
    public static SoftAssertions softly;

    public BaseFunctions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        //функция из  Selenium, дает возможность пользоваться @FindBy
        js = (JavascriptExecutor) driver;
        //активирует Javascript функционал
        softly = new SoftAssertions();
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

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void verifyLinks(String url) {

        try {
            URL linkUrl = new URL(url);

            //create URL connection and get response code
            HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();

            if (connection.getResponseCode() >= 400) {
                //   System.out.println(url + " - " + connection.getResponseMessage() + "is a broken link");
                System.out.println("bad");
                softly.fail(url + " - " + connection.getResponseMessage() + "is a broken link");
            } else {
                //  System.out.println(url + " - " + connection.getResponseMessage());
                System.out.println("good");
                softly.assertThat(connection.getResponseCode()).isLessThan(400);
            }
        } catch (Exception e) {
            System.out.println(url + " - " + e.getMessage() + " ERROR occurred");
        }
        //softly.assertAll();
    }

}
