package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.widgets.Hovers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HoversTests extends TestBase {

    Hovers hovers;

    @BeforeEach
    public void precondition() {
        new HomePage(driver).selectHovers();
        hovers = new Hovers(driver);
    }

    @Test
    public void hoverContact1Test(){
        hovers.hoverContact(1)
                .verifyHover("user1");
    }

    @Test
    public void hoverContact2Test(){
        hovers.hoverContact(2)
                .verifyHover("user2");
    }

    @Test
    public void hoverContact3Test(){
        hovers.hoverContact(3)
                .verifyHover("user3");
    }
}
