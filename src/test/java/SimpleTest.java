import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.pages.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class SimpleTest {
    private HomePage homePage;

    @BeforeAll
    public static void setup(){
        Configuration.baseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/";
    }

    @BeforeEach
    public void createPage(){
        this.homePage = new HomePage();
    }

    //Проверка что при переходе по кнопке Bank Manager Login первая кнопка - Add Customer
    @Test
    public void openPage(){
        homePage.openHomePage()
                .clickBankManager()
                .checkPageManager();
    }

    //Проверка на совпадение заголовка
    @Test
    public void checkHeading(){
        homePage.checkHeading();
    }
}
