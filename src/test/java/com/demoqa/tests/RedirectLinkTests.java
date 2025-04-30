package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.widgets.Links;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RedirectLinkTests extends TestBase {

    Links link;

    @BeforeEach
    public void precondition() {
        link = new Links(driver);
        new HomePage(driver).selectRedirectLink();
    }

    @Test
    public void clickAndCheckLinkTest(){
        link.clickHere()
                .verifyAlllinks();
    }
}
