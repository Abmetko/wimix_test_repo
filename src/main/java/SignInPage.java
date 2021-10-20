import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage extends BasePage {

    public SignInPage() {
        super($("div.wrapper-0-2-13")
                .shouldBe(Condition.visible, Duration.ofSeconds(30)));
    }

    public boolean waitIsPageOpen() {
        try {
            waitPageOpen();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void inputAccountName() {
        COMPONENT_CONTAINER
                .$("input[name='username']").setValue("test@mail.ru");
    }

    public void inputPassword() {
        COMPONENT_CONTAINER
                .$("input[name='password']").shouldBe(Condition.visible,Duration.ofSeconds(30))
                .setValue("ertertertertertertertet");
    }

    public void clickEnterPasswordButton() {
        COMPONENT_CONTAINER
                .$(byText("Enter password")).shouldBe(Condition.enabled)
                .click();
    }

    public void waitEnterYourPasswordDialog() {
        COMPONENT_CONTAINER.$("h2[data-test-id='header-text']")
                .shouldBe(Condition.visible)
                .click();
    }
}
