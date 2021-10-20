public class MainPage extends BasePage {

    public MainPage() {
        super($("div.grid__header"));
    }

    public void clickMail() {
        COMPONENT_CONTAINER.$("почта").shouldBe(Condition.enabled).click();
    }
}