import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage extends BasePage {

    public SignInPage() {
        super($("div.wrapper-0-2-13"));
    }

    public boolean waitIsPageOpen(){
        try{
            waitPageOpen();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void inputAccountName() {
        COMPONENT_CONTAINER.$("account name");
    }

    public void clickEnterPasswordButton(){
        COMPONENT_CONTAINER.$("...").shouldBe(Condition.enabled).click();
    }

    public void waitEnterYourPasswordDialog(){
        COMPONENT_CONTAINER.$("password").shouldBe(Condition.visible).click();
    }
}
