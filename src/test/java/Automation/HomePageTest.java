package Automation;

import Components.InternetBlockComponent;
import PageObjects.HomePage;
import org.testng.annotations.Test;


import Components.NavigationBarComponent;

public class HomePageTest {
    @Test
    public void navBarTest() {
        NavigationBarComponent navigationBarComponent = new HomePage()
                .goTo()
                .getDropDown("");
        String categorySelectButtons = navigationBarComponent.getNavigationBarComponents();
        System.out.println(categorySelectButtons);

    }

    @Test
    public void testInternet(){
        InternetBlockComponent internetBlockComponent = new HomePage()
                .goTo()
                .getInternetBlock();
        String text = internetBlockComponent.getInternetBlock();
        System.out.println(text);
    }

}

