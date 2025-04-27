package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.widgets.Hovers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HorizontalSliderTests extends TestBase {

    Hovers hover;

    @BeforeEach
    public void precondition(){
        new HomePage(driver).selectHorizontalSlider();
        hover = new Hovers(driver);
    }

    @Test
    public void horizontalSliderToEndTest(){
        hover.moveSliderInHorizontalDirectionToEnd()
                .verifyTarget("5");
    }
}


