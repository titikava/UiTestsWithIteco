package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;



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


    public void checkHeading() {
        try {
            openHomePage().headingHome().shouldBe(Condition.exactOwnText("XYZ Bank"));
            System.out.println("The title matches");
        } catch (Exception e) {
            System.out.println("The title doesn't match");
        }
    }
}
