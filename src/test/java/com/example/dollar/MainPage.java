package com.example.dollar;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class MainPage {
    public static void main(String[] args) {
        String val;
        double valorDollar=0;

        ChromeOptions options = new ChromeOptions();

        //Add chrome switch to disable notification - "**--disable-notifications**"
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com/search?q=dollaro+euro&oq=dollaro&aqs=chrome.0.0i131i433i512j69i57j0i131i433i512l4j0i433i512j0i512j0i131i433i512l2.999j1j7&sourceid=chrome&ie=UTF-8");

        driver.findElement(By.xpath("/html/body/div[3]/div[3]/span/div/div/div/div[3]/div[1]/button[2]/div")).click();

        val=driver.findElement(By.xpath("/html/body/div[8]/div/div[10]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[3]/div[1]/div[1]/div[2]/span[1]")).getText();
        driver.quit();
        try {
           val= val.replace(",", ".");

        }catch(Exception e){
            System.exit(1);
        }
        valorDollar=Double.parseDouble(val);


        if (valorDollar > 1.05) {
            System.out.println("Il valore corrente del dollaro è di "+valorDollar+" \nEd è maggiore di 1.05");
        }else {
            System.out.println("Il valore corrente del dollaro è di "+valorDollar+" \nNon è maggiore di 1.05");
        }


    }
}

