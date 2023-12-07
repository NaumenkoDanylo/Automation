package Components;

import PageObjects.HomePage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

public class CoverageMapComponent {
    private List<SelenideElement> regionSelectorPoint = Selenide.$$x("//*[@id=\"regions\"]/*");
    private List<SelenideElement> districtSelectorPoint = Selenide.$$x("//*[@id=\"districts\"]/option[@value]");
    private List<SelenideElement> citiesSelectorPoint = Selenide.$$x("//*[@id=\"cities\"]/option[@value]");
    private SelenideElement mapScaleSelection = Selenide.$x("//*[@class='leaflet-control-zoom leaflet-bar leaflet-control']");
    private SelenideElement increaseMapScale = Selenide.$x("//*[@class='leaflet-control-zoom-in']");
    private SelenideElement decreaseMapScale = Selenide.$x("//*[@class='leaflet-control-zoom-out']");

    public CoverageMapComponent() {
    }

    @Step("Selecting region on the coverage map")
    public CoverageMapComponent regionSelector(String regionName) {
        SelenideElement regionSelector = this.regionSelectorPoint
                .stream()
                .filter((region) -> region.getText().equals(regionName))
                .findFirst()
                .get();
        regionSelector.click();
        return new CoverageMapComponent();
    }

    @Step("Selecting district on the coverage map")
    public CoverageMapComponent districtSelector(String districtName) throws InterruptedException {
        Thread.sleep(3000L);
        SelenideElement districtSelector = this.districtSelectorPoint
                .stream()
                .filter((districts) -> districts.getText().equals(districtName))
                .findFirst()
                .get();
        districtSelector.click();
        return new CoverageMapComponent();
    }

    @Step("Selecting city on the coverage map")
    public CoverageMapComponent citySelector(String cityName) throws InterruptedException {
        Thread.sleep(3000L);
        SelenideElement citySelector = (SelenideElement)
                this.citiesSelectorPoint
                        .stream()
                        .filter((city) -> city.getText().equals(cityName))
                        .findFirst()
                        .get();
        citySelector.click();
        return new CoverageMapComponent();
    }

    @Step("Verification map visibility")
    public boolean mapScaleVisible() {
        this.mapScaleSelection.isDisplayed();
        return this.mapScaleSelection.isDisplayed();
    }

    @Step("Increases map scaling")
    public HomePage mapZoomIn() {
        this.increaseMapScale.click();
        return null;
    }

    @Step("Decreases map scaling")
    public HomePage mapZoomOut() {
        this.decreaseMapScale.click();
        return null;
    }

    public String getCityTitle() {
        return this.citiesSelectorPoint
                .stream()
                .findFirst()
                .get()
                .getText();

    }
}
