package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;

public class Page {
    public SelenideElement buttonHome(){
        return element(By.xpath("//button[@class='btn home']"));
    }

    public SelenideElement headingHome(){
        return element(By.xpath("//strong[@class='mainHeading']"));
    }

    public SelenideElement bankManagerLogin(){
        return element(By.xpath("//button[@ng-click='manager()']"));
    }

    public SelenideElement buttonAddCustomer(){
        return element(By.xpath("//button[@ng-class='btnClass1']"));
    }

    public void checkPageManager(){
        try {
            buttonAddCustomer().shouldBe(Condition.exactOwnText("Add Customer"));
            System.out.println("Button text - Add Customer");
        } catch (Exception e) {
            System.out.println("The button text does not match");
        }

    }




}
