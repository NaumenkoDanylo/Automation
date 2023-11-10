package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hw2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Home\\IdeaProjects\\Automation\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://avator.ua/");
        String text = webDriver.findElement(By.xpath("//h1[@class='uk-h3']")).getText();
        boolean isDisplayed = webDriver.findElement(By.xpath("//div[@class='uk-visible@s uk-margin']")).isDisplayed();
        webDriver.findElement(By.xpath("//div//a [@class=\"uk-width-1-1 uk-button uk-button-default uk-button-large\"]")).click();
        webDriver.findElement(By.xpath(("//*[@id=\"name\"]"))).sendKeys("TestName");
        System.out.println(text);
        System.out.println(isDisplayed);


    }
}
