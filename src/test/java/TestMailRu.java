import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMailRu {

    private MainPage mainPage;
    private SignInPage signInPage;
    private InboxPage inboxPage;

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

    @Order(3)
    @Test
    public void makeSignIn() {
        signInPage.inputAccountName();
        signInPage.clickEnterPasswordButton();
        signInPage.waitEnterYourPasswordDialog();
        signInPage.inputPassword();
        //click button
        inboxPage = new InboxPage();
        assertTrue(inboxPage.waitIsPageOpen());
    }
}