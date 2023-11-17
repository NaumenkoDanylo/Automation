package Components;

import com.codeborne.selenide.SelenideElement;

public class CoverageMapComponent {

    private SelenideElement regionSelectorPoint;

    private SelenideElement districtSelectorPoint;

    private SelenideElement citiesSelectorPoint;

    private SelenideElement mapScaleSelection;

    private SelenideElement increaseMapScale;

    private SelenideElement decreaseMapScale;


    public CoverageMapComponent(SelenideElement element) {
        this.citiesSelectorPoint = element.$("//*[@id=\"cities\"]");
        this.districtSelectorPoint = element.$("//*[@id=\"districts\"]");
        this.regionSelectorPoint = element.$(("//*[@id=\"regions\"]"));
        this.mapScaleSelection = element.$("//div[@class='leaflet-control-zoom leaflet-bar leaflet-control']");
        this.increaseMapScale = element.$("//*[@class='leaflet-control-zoom-in']");
        this.decreaseMapScale = element.$("//*[@class='leaflet-control-zoom-out']");

    }
}




