package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.widgets.SelectMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DropdownTests extends TestBase {

    SelectMenu menu;

    @BeforeEach
    public void precondition() {
        new HomePage(driver).selectDropdown();
        menu = new SelectMenu(driver);
    }

    @Test
    @DisplayName("Click Option1")
    public void dropdownListOption1Test() {
        menu.multiSelectList("Option 1")
                .verifyOption("Option 1");
    }

    @Test
    public void dropdownListOption2Test() {
        menu.multiSelectList("Option 2")
                .verifyOption("Option 2");
    }
}