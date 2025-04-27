package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.widgets.Hovers;
import com.demoqa.pages.windows.Alerts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContextMenuTests extends TestBase {

    Hovers hover;

    @BeforeEach
    public void precondition(){
        new HomePage(driver).selectContextMenu();
        hover =new Hovers(driver);
    }

    @Test
    public void rightClickContextMenuTest(){
        hover.clickBox();
        new Alerts(driver).verifyAlert();
    }
}
