import java.time.Duration;

public class BasePage {

    public SelenideElement COMPONENT_CONTAINER;

    public BasePage(SelenideElement component_container){
        this.COMPONENT_CONTAINER = component_container;
    }

    public void waitPageOpen(){
        COMPONENT_CONTAINER
                .shoulBe(Condition.visible, Duration.ofSeconds(30));
    }

    public boolean waitIsPageOpen(){
        try{
            waitPageOpen();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
