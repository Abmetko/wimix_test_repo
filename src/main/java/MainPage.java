import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    public MainPage() {
        super($("div.grid__header"));
    }

    public void clickMail() {
        clickElement(COMPONENT_CONTAINER
                .$$("a")
                .get(1));
    }
}