package basictest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class LoginTest {

    private String id = "4130162";
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
        // verificar si existe el control del logout
        chrome.findElement(By.className("AddProjectLiDiv")).click();
        Thread.sleep(1000);
        chrome.findElement(By.className("InputTextAddProj")).sendKeys("hola1234");
        Thread.sleep(1000);
        chrome.findElement(By.id("NewProjNameButton")).click();
        Thread.sleep(1000);
        chrome.findElement(By.id("ItemId_"+id)).click();
        Thread.sleep(1000);
        WebElement liElement =chrome.findElement(By.cssSelector("li.BaseProjectLi.acceptProject.acceptBoth[id='ItemId_"+id+"']"));
        WebElement tdElement = liElement.findElement(By.cssSelector("td.ItemIndicator"));
        tdElement.click();
        Thread.sleep(1000);
        WebElement contextMenu = chrome.findElement(By.id("projectContextMenu"));
        WebElement editOption = contextMenu.findElement(By.cssSelector("li.edit a"));
        Thread.sleep(1000);
        editOption.click();
        Thread.sleep(1000);
        WebElement editTextbox = chrome.findElement(By.id("ItemEditTextbox"));
        editTextbox.clear();
        editTextbox.sendKeys("Luciano");
        Thread.sleep(1000);
        WebElement saveButton = chrome.findElement(By.id("ItemEditSubmit"));
        saveButton.click();
        Thread.sleep(5000);


    }

    @AfterEach
    public void closeBrowser(){
        chrome.quit();
    }
}
/*package basicWeb;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    ChromeDriver chrome;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chrome/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.get("http://todo.ly/");
    }
//  .basic("upbapi@upbapi.com", "12345")
    @Test
    public void verifyLoginTest() throws InterruptedException {
        // click login button
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        // set email
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("upbapi@upbapi.com");
       // set password
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        // click login
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        Thread.sleep(5000);
        // verificar si existe el control del logout

        Assertions.assertTrue((chrome.findElements(By.xpath("//a[text()='Logout']")).size() == 1),
                "ERROR no se pudo ingresar a la sesion");

        Thread.sleep(5000);

    }

    @AfterEach
    public void closeBrowser(){
        chrome.quit();
    }

}*/

//<li id="ItemId_4130132" class="BaseProjectLi acceptProject acceptBoth" itemid="4130132">
//        <div class="LiDiv BaseProjectLiDiv LeftLiDiv ProjectSelected" onclick="ProjectSelected(this);" itemid="4130132" id="ItemId_4130132">
//            <div id="Arrow" class="ArrowExpanded" itemid="4130132"></div>
//            <table cellpadding="0" cellspacing="0" class="ProjItemTable">
//                <tbody><tr>
//                    <td class="ListCountTd"><img src="/Images/grippy.png" class="handle DragHandlerProj" style="user-select: none;"></td>
//                    <td class="ListCountTd"><div id="ListIcon" class="ListIcon" style="background: url(Images/icons/page2.png) no-repeat;"></div></td>
//                    <td class="ProjItemContent" title="" itemid="4130132">hola1234</td>
//                    <td class="ItemIndicator"><div id="ListCount" class="ListCount" itemid="4130132" style="display: none;">0</div><div class="ProjItemMenu" itemid="4130132" style="display: none;"><img src="/Images/dropdown.png" title="Options"></div></td>
//                </tr>
//              </tbody>
//            </table>
//        </div>
//    </li>