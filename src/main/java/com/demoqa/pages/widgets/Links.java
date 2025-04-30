package com.demoqa.pages.widgets;

import com.demoqa.core.BaseFunctions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class Links extends BaseFunctions {

    public static SoftAssertions softly;

    public Links(WebDriver driver) {
        super(driver);
        softly = new SoftAssertions();
    }


    @FindBy(id = "redirect")
    WebElement redirect;

    public Links clickHere() {
        click(redirect);
        return this;
    }

    /// ///////////////////////////////////////////////////////////////
    @FindBy(css = "a")
    List<WebElement> allElementsWithTagnameA;


    public Links verifyAlllinks() {
        for (int i = 0; i < allElementsWithTagnameA.size(); i++) {

            WebElement element = allElementsWithTagnameA.get(i);
            String url = element.getDomAttribute("href");
            System.out.println("before If");

            if (url.startsWith("http")) {
                System.out.println("if " + url);
                verifyLinks(url);

            } else {
                System.out.println("else " + "https://the-internet.herokuapp.com/ " + url);
                verifyLinks("https://the-internet.herokuapp.com/" + url);
            }
            softly.assertAll();
        }
        return this;
    }
}
