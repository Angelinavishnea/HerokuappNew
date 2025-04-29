package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.widgets.Hovers;
import com.demoqa.pages.widgets.Upload;
import com.demoqa.pages.windows.Alerts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileUploaderTests extends TestBase {

    Upload upload;
    Hovers hover;

    @BeforeEach
    public void precondition(){
        upload = new Upload(driver);
        hover = new Hovers(driver);
        new HomePage(driver).selectFileUpload();
    }

    @Test
    public void FileUploadTest(){
        upload.uploadFile("C:/Tools/gretsiya-001.jpg")
                .clickSubmit()
                .verifyUpload("Uploaded!");
    }

    @Test
    public void FileUploadDragANdDropTest(){
        upload.uploadFileDragAndDrop("C:/Tools/gretsiya-001.jpg")
                .verifyUploadDragAndDrop("✔");
        //! не находит локатор

    }
}
