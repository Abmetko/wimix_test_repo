import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestMailRu {

    private MainPage mainPage;
    private SignInPage signInPage;

    @BeforeAll
    void setUp() {
        open("https://mail.ru/");
        mainPage = new MainPage();
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
        signInPage = new SignInPage();
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