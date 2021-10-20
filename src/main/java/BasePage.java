import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.time.Duration;

@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BasePage {

    public SelenideElement COMPONENT_CONTAINER;

    public BasePage(SelenideElement component_container) {
        this.COMPONENT_CONTAINER = component_container;
    }

    public void waitPageOpen() {
        COMPONENT_CONTAINER
                .shouldBe(Condition.visible, Duration.ofSeconds(30));
    }

    public boolean waitIsPageOpen() {
        try {
            waitPageOpen();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
