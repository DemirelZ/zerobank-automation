package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement getSignInButton;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement inputUserName;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[contains(text(),'Login and/or password are wrong.')]")
    public WebElement wrongMessage;

    @FindBy(xpath = "//span[@id='account_activity_link']")
    public WebElement accountActivityLink;


    public void loginZeroBank_mtd(String userName, String password) {
        getSignInButton.click();
        inputUserName.sendKeys(userName);
        inputPassword.sendKeys(password);
        signInButton.click();

        Driver.get().navigate().back();
        accountActivityLink.click();
        BrowserUtils.waitFor(1);

    }

}
