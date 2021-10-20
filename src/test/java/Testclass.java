public class Testclass {

    private MainPage mainPage;
    private SignInPage signInPage;

    void set() {
        open("url");
    }

    @Order(1)
    @Test
    public void openMainPage() {
        mainPage = new MainPage();
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

        //........
        InpoxPage inpoxPage = new InboxPage();
        assertTrue(inboxPage.waitIsPageOpen());
    }
}