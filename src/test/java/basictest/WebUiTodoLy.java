package basictest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class WebUiTodoLy {

    private String id = "4150412";
    ChromeDriver chrome;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chrome/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        chrome.get("http://todo.ly/");
    }

    @Test
    public void verifySomeThing() throws InterruptedException {
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        // set email
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("lutyvr02@gmail.com");
        // set password
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("hola1234");
        // click login
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        chrome.findElement(By.xpath("//a[text()='Settings']")).click();
        Thread.sleep(2000);

        WebElement ty = chrome.findElement(By.id("settingsDialog"));
        Thread.sleep(2000);
        WebElement ty1 = ty.findElement(By.id("FullNameInput"));
        ty1.clear();
        ty1.sendKeys("Cowpoker02");
        Thread.sleep(2000);

        WebElement ty2 = chrome.findElement(By.className("ui-dialog-buttonset"));
        ty2.findElement(By.className("ui-button-text")).click();


    }
    @AfterEach
    public void closeBrowser(){
        chrome.quit();
    }
}