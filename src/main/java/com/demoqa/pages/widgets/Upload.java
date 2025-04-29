package com.demoqa.pages.widgets;

import com.demoqa.core.BaseFunctions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Upload extends BaseFunctions {

    public Upload(WebDriver driver) {
        super(driver);
    }
/// ////////////////////////////////////////////////////////////////
    @FindBy(id = "file-upload")
    WebElement uploadFile;

    public Upload uploadFile(String path) {
        uploadFile.sendKeys(path);
        return this;
    }
/// ///////////////////////////////////////////////////////////////
    @FindBy(id = "file-submit")
    WebElement submitButton;

    public Upload clickSubmit() {
        click(submitButton);
        return this;
    }
/// //////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//h3[contains(text(),'File Uploaded!')]")
    WebElement successfulSubmit;

    public Upload verifyUpload(String text) {
        Assertions.assertTrue(isContainsText(text,successfulSubmit));
        return this;
    }
/// ///////////////////////////////////////////////////////////////
    @FindBy(xpath = "//div[@id='drag-drop-upload']")
    WebElement uploadSpace; //! не находит

    public Upload uploadFileDragAndDrop(String path){
        System.out.println("1");
        uploadSpace.sendKeys(path);
        System.out.println("2");
        return this;
    }
/// //////////////////////////////////////////////////////////////
    @FindBy(className = "dz-success-mark")
    WebElement successMark;

    public Upload verifyUploadDragAndDrop(String text) {
        Assertions.assertTrue(isContainsText(text,successMark));
        return this;
    }
}
