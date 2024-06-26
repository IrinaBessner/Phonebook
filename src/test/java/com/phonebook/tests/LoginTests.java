package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSighOutButton();
        }
    }

    @Test
    public void loginPositiveTest (){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("akuna@ma.de").setPassword( "Africa2024!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }
    @Test
    public void loginNegativeTestWithoutEmail (){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setPassword("Africa2024!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());

    }

}
