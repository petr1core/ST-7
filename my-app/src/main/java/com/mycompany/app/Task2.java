package com.mycompany.app;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2 {
    public static void getIPAddress() {
        WebDriver webDriver = App.getDriver();
        try {
            webDriver.get("https://api.ipify.org/?format=json");
            WebElement webElement = webDriver.findElement(By.tagName("pre"));
            String json = webElement.getText();
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(json);
            String ip = (String) obj.get("ip");
            System.out.println("Your IP: " + ip);
            Thread.sleep(1500);
        } catch (Exception e) {
            System.out.println("Error getting IP:");
            System.out.println(e);
        } finally {
            webDriver.quit();
        }
    }
}
