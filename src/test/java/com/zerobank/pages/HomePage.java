package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement> titlesOfAccountSummary_loc;

    @FindBy(xpath = "(//table[@class='table'])[3]//thead//tr//th")
    public List<WebElement> titlesOfCreditAccountTable_loc;


    @FindBy(xpath = "//select[@class='input-xlarge']")
    public WebElement selectAccount_loc;



    @FindBy(xpath = "//select[@id='sp_payee']")
    public WebElement selectPayeeMenu_loc;

    @FindBy(xpath = "//select[@id='sp_account']")
    public WebElement selectAccountMenu_loc;

    @FindBy (xpath = "//input[@id='sp_amount']")
    public WebElement inputAmount;

    @FindBy(xpath = "//input[@id='sp_date']")
    public WebElement inputDate;

    @FindBy(xpath = "//input[@id='pay_saved_payees']")
    public WebElement payButton;

    @FindBy(xpath = "//span[.='The payment was successfully submitted.']")
    public WebElement paymentMessage;



    /////////////////////////////////////////

    @FindBy(xpath = "//*[.='Add New Payee']")
    public WebElement addNewPayee;

    @FindBy(id = "sp_payee")
    public WebElement payeeInput_loc;

    @FindBy(id = "sp_account")
    public WebElement accountInput_loc;

    @FindBy(id = "sp_amount")
    public WebElement inputAmount_loc;

    @FindBy(id = "sp_date")
    public WebElement inputDate_loc;

    @FindBy(id = "sp_description")
    public WebElement inputDescription_loc;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton_loc;

    @FindBy(id = "alert_content")
    public WebElement paymentMessage_loc;

    @FindBy (id = "np_new_payee_name")
    public WebElement payeeName_loc;

    @FindBy(id="np_new_payee_address")
    public WebElement adress_loc;

    @FindBy(id = "np_new_payee_account")
    public WebElement account;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetails_loc;

    @FindBy(id="add_new_payee")
    public WebElement addNewPayeeBtn_loc;

    @FindBy(xpath = "//div[.='The new payee The Law Offices of Hyde, Price & Scharks was successfully created.']")
    public WebElement getMessage;

    public void addNewPayeeInfo(String payeeName, String payeeAdress, String payeeAccount, String payeeDetails){
        payeeName_loc.sendKeys(payeeName);
        adress_loc.sendKeys(payeeAdress);
        account.sendKeys(payeeAccount);
        payeeDetails_loc.sendKeys(payeeDetails);
        addNewPayeeBtn_loc.click();
    }


    /////////////////////////


    public List<String> titlesOfAccountSummary_mtd(){

        List<String> elementsText = BrowserUtils.getElementsText(titlesOfAccountSummary_loc);
        return elementsText;
    }
    public List<String> titlesOfCreditAccountTable_mtd(){

        List<String> elementsText = BrowserUtils.getElementsText(titlesOfCreditAccountTable_loc);
        return elementsText;
    }



    public List<String> getSelectMenu(){

        BrowserUtils.waitFor(3);
        Select select=new Select(selectAccount_loc);
        List<WebElement> options = select.getOptions();
        List<String> elementsText = BrowserUtils.getElementsText(options);


        return elementsText;



    }

    public void selectPayeeMenu_mtd(String typeOfPayee){

        BrowserUtils.waitFor(1);
        Select select=new Select(selectPayeeMenu_loc);
        select.selectByVisibleText(typeOfPayee);

    }

    public void setSelectAccountMenu_mtd(int valueNumber){

        BrowserUtils.waitFor(1);
        Select select=new Select(selectAccountMenu_loc);
        select.selectByIndex(valueNumber);
    }

    public void onlyDigits(String amount){

        int length=amount.length();

        for (int j = 0; j < length; j++) {

            if(!Character.isDigit(amount.charAt(j))){
                break;
            }else {


            }

        }
        inputAmount.sendKeys(amount);

    }

    public boolean isNumeric(String str)
    {


        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public boolean isAlphabeticAndSpecialChar(String str)
    {



        for (char c : str.toCharArray())

        {

            if (Character.isAlphabetic(c)) return false;
        }
        return true;



    }

}
