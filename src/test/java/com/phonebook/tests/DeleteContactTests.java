package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSighOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("akuna@ma.de").setPassword( "Africa2024!"));
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new Contact()
                .setName("Ma")
                .setLastName("Tata")
                .setPhone("1234567890")
                .setEmail("matata@aku.de")
                .setAddress("Hamburg")
                .setDescription("gamer"));
        app.getContact().clickOnSaveButton();
    }
    @Test
    public void deleteContactPositiveTest(){
        int sizeBefore = app.getContact().sizeOfContacts();
//        click(By.cssSelector(".contact-item_card__2SOIM"));
//        click(By.xpath("//button[.='Remove']"));
        app.getContact().removeContact();

        app.getContact().pause(1000);
        int sizeAfter= app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }

}
