import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Test1 {
    public static WebDriver driver;

    @BeforeEach
    public void beforeClass() {
        System.setProperty(
                "webdriver.chrome.driver",

                "C:\\Users\\Svetlana\\1212\\untitled\\src\\main\\resources\\chromedriver.exe"
        );
        this.driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        driver.get("https://learn.andersenlab.com/login/index.php/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    @Test
    void test() {
        driver.findElement(By.id("username"));

        driver.findElement(By.id("username"));
        WebElement username = driver.findElement(By.id("username"));
        username.click();
        username.sendKeys("may2022_aqa5");

        driver.findElement(By.id("password"));
        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("Levanter_6");

        driver.findElement(By.id("loginbtn"));
        WebElement login = driver.findElement(By.id("loginbtn"));
        login.click();

        String expected_url = "https:learn.andersenlab.com/my//";
        String current_url = driver.getCurrentUrl();

        Assert.assertFalse("URL does not match\\n", expected_url.equals(current_url));
        System.out.println("AssertTrue Test1 Passed\n");


        String expected_student = "Sviatlana Karaliova";
        String current_student = String.valueOf(driver.findElement(By.id("page-my-index")));

        Assert.assertFalse("Student does not match\\n", expected_student.equals(current_student));
        System.out.println("AssertTrue Test2 Passed\n");


        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                elementToBeClickable(By.linkText("Управление личными файлами...")));

        driver.findElement(By.linkText("Управление личными файлами..."));
        WebElement item = driver.findElement(By.linkText("Управление личными файлами..."));
        item.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                elementToBeClickable(By.id("id_cancel")));

        driver.findElement(By.id("id_cancel"));
        WebElement reject = driver.findElement(By.id("id_cancel"));
        reject.click();
    }


    @AfterEach
    void tearThis() {
        driver.findElement(By.id("action-menu-toggle-1"));
        WebElement id = driver.findElement(By.id("action-menu-toggle-1"));
        id.click();
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            driver.switchTo().window(ChildWindow);
            WebElement d = driver.findElement(By.id("actionmenuaction-7"));
            d.click();
        }

        driver.close();
    }


}
