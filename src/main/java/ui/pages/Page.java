package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;

public class Page {
    public SelenideElement buttonHome() {
        return element(By.xpath("//button[@class='btn home']"));
    }

    public SelenideElement headingHome() {
        return element(By.xpath("//strong[@class='mainHeading']"));
    }

    public SelenideElement bankManagerLogin() {
        return element(By.xpath("//button[@ng-click='manager()']"));
    }

    public SelenideElement buttonAddCustomer() {
        return element(By.xpath("//button[@ng-class='btnClass1']"));
    }

    public SelenideElement jacksonCheck(){
        return element(By.xpath("//*[contains(text(),'Jackson')]"));
    }

    public SelenideElement buttonCustomers() {
        return element(By.xpath("//button[@ng-class='btnClass3']"));
    }

    public SelenideElement firstName(){
        return element(By.xpath("//input[@placeholder='First Name']"));
    }

    public SelenideElement lastName(){
        return element(By.xpath("//input[@placeholder='Last Name']"));
    }

    public SelenideElement postCode(){
        return element(By.xpath("//input[@placeholder='Post Code']"));
    }

    public SelenideElement submitAddCustomer(){
        return element(By.xpath("//button[@type='submit']"));
    }

    public SelenideElement inputSearchCustomer(){
        return element(By.xpath("//input[@ng-model='searchCustomer']"));
    }

}





