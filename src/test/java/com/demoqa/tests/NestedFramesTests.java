package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.windows.FramePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NestedFramesTests extends TestBase {

    FramePage frames;

    @BeforeEach
    public void precondition(){
        frames = new FramePage(driver);
        new HomePage(driver).selectJNestedFrames();


    }


//    @Test
//    @DisplayName("Verify number of iframes on the page")
//    public void iframeTest() {
//        frames.returnListOfIframes()
//                .switchToIframeByIndex(1)
//                .verifyIframeByTitle("This is a sample page");
//    }
}

