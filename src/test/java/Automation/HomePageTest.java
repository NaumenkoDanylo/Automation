package Automation;

import Components.CoverageMapComponent;
import PageObjects.ConnectionPage;
import PageObjects.HomePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest {
    @Test(description = "Getting text from internet block")
    @Description("Getting the text from the aboutInternet method")
    public void gettingTextFromInternetSection() {
        // Creating a SoftAssert instance to collect multiple assertions
        SoftAssert softAssert = new SoftAssert();

        // Getting the text from the aboutInternet method
        String internetText = new HomePage()
                .goTo()
                .aboutInternet();

        // Expected text
        String expectedText = "- Найнижчі ціни - від 0 грн!\n" +
                "- Швидкість до 1000 Мбіт/с!";

        softAssert.assertEquals(internetText, expectedText, "Text from internet section is not as expected");
        softAssert.assertAll();
    }

    @Test(description = "Checking the display of the company logo")
    public void checkCompanyLogoDisplay() {
        // Creating a SoftAssert instance to collect multiple assertions
        SoftAssert softAssert = new SoftAssert();

        // Creating a HomePage instance and navigating to the page
        HomePage homePage = new HomePage()
                .goTo();

        // Checking the display of the company logo
        boolean isLogoDisplayed = homePage
                .headerComponent
                .logoAvator();

        softAssert.assertTrue(isLogoDisplayed, "Company logo is not displayed");

        softAssert.assertAll();
    }

    @Test(description = "Input in the connection form")
    @Description("Filling out the connection form")
    public void connectionFormSubmitting() throws InterruptedException {
        // Creating a SoftAssert instance to collect multiple assertions
        SoftAssert softAssert = new SoftAssert();

        // Navigating to the connection form on the homepage and filling out the form
        ConnectionPage formSubmitting = new HomePage()
                .goTo()
                .clickConnectButton()
                .inputUserName("Test Name")
                .inputPhoneNumber(123456789)
                .inputMassage("Test Data");

        softAssert.assertEquals(formSubmitting.getUserName(), "Test Name", "User name is not as expected");
        softAssert.assertEquals(formSubmitting.getPhoneNumber(), "123456789", "Phone number is not as expected");
        softAssert.assertEquals(formSubmitting.getMassage(), "Test Data", "Massage is not as expected");

        softAssert.assertAll();
    }

    @Test(description = "Test City Selection")
    @Description("Selection chosen city on map")
    public void testCitySelection() throws InterruptedException {
        // Creating a SoftAssert instance to collect multiple assertions
        SoftAssert softAssert = new SoftAssert();

        // Navigating to the specified region, district, and city on the homepage
        CoverageMapComponent cityTitle = new HomePage()
                .goTo()
                .getCoverageMapElement()
                .regionSelector("Полтавська")
                .districtSelector("Великобагачанський")
                .citySelector("Білоцерківка");

        // Getting the actual city title from the page
        String actualCity = cityTitle.getCityTitle();

        // Expected city title
        String expectedCity = "Білоцерківка";

        softAssert.assertEquals(actualCity, expectedCity, "City is not as expected. Actual city: " + actualCity);

        softAssert.assertAll();
    }


    @Test(description = "Verify name field length")
    @Description("Verify name field length")
    public void testNameLength() {
        SoftAssert softAssert = new SoftAssert();
        ConnectionPage connectionPage = new ConnectionPage().goTo();

        // Set the value to the name input field
        connectionPage.inputUserName("User Name");

        // Get the actual length of the input field value
        int actualLength = connectionPage.getUserName().length();

        // Expected length
        int expectedLength = 9;

        softAssert.assertEquals(actualLength, expectedLength, "Name field length is not as expected");

        softAssert.assertAll();
    }
}
