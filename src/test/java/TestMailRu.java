import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestMailRu {

    private MainPage mainPage;
    private SignInPage signInPage;

    @BeforeAll
    void setUp() {
        open("https://mail.ru/");
        mainPage = new MainPage();
        signInPage = new SignInPage();
    }

    @Order(1)
    @Test
    public void openMainPage() {
        assertTrue(mainPage.waitIsPageOpen());
    }

    @Order(2)
    @Test
    public void openSignUpPage() {
        mainPage.clickMail();
        assertTrue(signInPage.waitIsPageOpen());
    }

    public void makeSignIn() {
        signInPage.inputAccountName();
        signInPage.clickEnterPasswordButton();
        signInPage.waitEnterYourPasswordDialog();
        InboxPage inboxPage = new InboxPage();
        assertTrue(inboxPage.waitIsPageOpen());
    }
}