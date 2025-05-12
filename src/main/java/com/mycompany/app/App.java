package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome-WebDriver\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

        System.out.println("Testing Selenium...");
        randomWord();

        System.out.println("\nGetting IP-address...");
        Task2.getIPAddress();

        System.out.println("\nChecking weather forecast...");
        Task3.getWeatherForecast();
    }

    public static void randomWord() {
        WebDriver webDriver = getDriver();
        try {
            webDriver.get("https://calculator888.ru/random-generator/sluchaynoye-slovo");
            System.out.println("Got page:" + webDriver.getTitle());
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error:");
            System.out.println(e);
        } finally {
            webDriver.quit();
        }
    }

    public static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        return new ChromeDriver(options);
    }
}
