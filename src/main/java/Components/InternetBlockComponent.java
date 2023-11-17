package Components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InternetBlockComponent {

    private SelenideElement internetBlock;

    public InternetBlockComponent() {
        this.internetBlock = $x("/html/body/div/div/div[4]/div/div[2]");
    }

    public String getInternetBlock() {
        return internetBlock
                .getText();
    }

}
