package Components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NavigationBarComponent {

    private SelenideElement navigationButtons;
    private SelenideElement navigationDropDownButtons;

    public NavigationBarComponent(ElementsCollection selenideElements) {
        this.navigationButtons = $x("//div/ul[@class='uk-navbar-nav']");
        this.navigationDropDownButtons = $x("//div//ul[@class='uk-nav uk-navbar-dropdown-nav']");

    }

    public String getNavigationBarComponents() {
        return navigationButtons
                .getText();
    }

    public String getDropDownName() {
        return this.navigationDropDownButtons.text();
    }

}

