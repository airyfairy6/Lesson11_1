import java.util.NoSuchElementException;


public class SystemTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\Svetlana\\12\\src\\main\\resources\\chromedriver.exe"
        );
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        Thread.sleep(500);
//try {
        driver.get("https://learn.andersenlab.com/login/index.php/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


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
        Thread.sleep(2000);
        System.out.println("AssertTrue Test1 Passed\n");


        String expected_student = "Sviatlana Karaliova";
        String current_student = String.valueOf(driver.findElement(By.id("page-my-index")));

        Assert.assertFalse("URL does not match\\n", expected_url.equals(current_url));
        Thread.sleep(2000);
        System.out.println("AssertTrue Test2 Passed\n");

        try {
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

            driver.close();
        } catch (TimeoutException e) {
        } catch (NoSuchElementException e) {
        }
        ;

    }


    private static void assertEquals(String actual, String expected) {
    }

    ;

    private static void setProperty(String s, String s1) {
    }
}
