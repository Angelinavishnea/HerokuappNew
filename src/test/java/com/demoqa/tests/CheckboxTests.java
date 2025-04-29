package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.widgets.Options;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckboxTests extends TestBase {

    @BeforeEach
    public void precondition(){
        new HomePage(driver).selectCheckbos();
    }

    @Test
    public void deleteCheckboxTest(){
        new Options(driver).checkboxNrClick(2)
                .verifyCheckboxEmpty();
    }
}
