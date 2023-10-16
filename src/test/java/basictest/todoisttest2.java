package basictest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class todoisttest2 {
        ChromeDriver chrome;
        @BeforeEach
        public void openBrowser(){
            System.setProperty("webdriver.chrome.driver","src/test/resources/chrome/chromedriver.exe");
            chrome = new ChromeDriver();
            chrome.manage().window().maximize();
            chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
            chrome.get("https://todoist.com/app/");
        }

        @Test
        public void verifySomeThing() throws InterruptedException {
        Thread.sleep(5000);
        chrome.findElement(By.xpath("//input[@type='email']")).sendKeys("lutyvr02@gmail.com");
        Thread.sleep(2000);
        chrome.findElement(By.xpath("//input[@type='password']")).sendKeys("Cowboyvr02");
        Thread.sleep(2000);
        chrome.findElement(By.cssSelector("button[data-gtm-id='start-email-login']")).click();
        Thread.sleep(10000);
        }


        @AfterEach
        public void closeBrowser(){
            chrome.quit();
        }
    }