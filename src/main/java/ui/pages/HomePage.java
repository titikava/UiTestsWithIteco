package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class HomePage extends Page {

    public HomePage() {
    }

    public HomePage openHomePage() {
        Selenide.open("#/login");
        return this;
    }

    public HomePage clickBankManager() {
        bankManagerLogin().click();
        return this;
    }

    public HomePage clickAddCustomer(){
        buttonAddCustomer().click();
        return this;
    }

    public HomePage clickCustomers(){
        buttonCustomers().click();
        return this;
    }

    public HomePage clickSubmitAddCustomer(){
        submitAddCustomer().click();
        return this;
    }

    public HomePage inputFirstName(){
        firstName().setValue("Jackson");
        return this;
    }

    public HomePage inputLastName(){
        lastName().setValue("Juarez");

        return this;
    }

    public HomePage inputPostCode(){
       postCode().setValue("11");
        return this;
    }


    public void dismissAlert(){
        WebDriver driver = getWebDriver();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void checkHeading() {
        try {
            openHomePage().headingHome().shouldBe(Condition.exactOwnText("XYZ Bank"));
            System.out.println("The title matches");
        } catch (Exception e) {
            System.out.println("The title doesn't match");
        }
    }

    public void checkPageManager() {
        try {
            buttonAddCustomer().shouldBe(Condition.exactOwnText("Add Customer"));
            System.out.println("Button text - Add Customer");
        } catch (Exception e) {
            System.out.println("The button text does not match");
        }
    }

    public void checkPageWithTableCustomers(){
        try {
            inputSearchCustomer().shouldBe(Condition.appear);
            System.out.println("Element is visible");
        } catch (Exception e){
            System.out.println("Element is not visible");
        }
    }

    public void checkFirstNameInTable(String firstName){
        try{
            jacksonCheck().shouldBe(Condition.text(firstName));
            System.out.println("We found " + firstName + "!!!");
        } catch (Exception e){
            System.out.println(firstName +  " not found");
        }
    }



}
