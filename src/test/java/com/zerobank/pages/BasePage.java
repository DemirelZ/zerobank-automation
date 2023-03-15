package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){

        PageFactory.initElements(Driver.get(),this);

    }

    public void getTab(String tabName){

        Driver.get().findElement(By.xpath("//*[.='"+tabName+"']")).click();
    }
}
