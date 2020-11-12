package E2ETS;

import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.Login_Page;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test_Base {
    public static WebDriver driver;
    public static String Z2DataUsername = "Z2D.PR1@z2data.com";
    public static String Z2DataPassword = "Z2D.PR1@z2data.com";
    public String Z2DataPartNumber = "bav99";
    public String Z2DataAdvCrosses = "bav";
    public String Z2DataIPN = "0.9902785216";
    public String Z2DataCompare_1 = "bav10";
    public String Z2DataCompare_2 = "bav20";
    public String Z2DataSupplier = "Toshiba";
    public String Z2DataFolderName = "TAP_BOM";
    public String Z2datafoldernamef = "fady";
    public String Z2dataSpinnerClassName ="spinner-circle full-screen";
    Faker faker = new Faker();
    public String Z2DataFakerFolder = faker.name().firstName();
    public String Z2DataFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\BOMs\\TABOM1.xlsx";
    public String Z2DataSwitcherStepFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\BOMs\\TABOM2.xlsx";
    public static Login_Page LogObj;
    public static Landing_Page page;

    @SuppressWarnings("unused")
    @BeforeMethod
    @Parameters("browser")
    public static void SetUp(String browser) throws Exception {

        //Check if parameter passed from TestNG is 'chrome'
        if (browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions opt = new ChromeOptions();
            opt.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            opt.setProxy(null);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(opt);
        }
        //Check if parameter passed as 'firefox'
        else if (browser.equalsIgnoreCase("Firefox")) {
            //set path to chromedriver.exe
            WebDriverManager.firefoxdriver().setup();
            //create chrome instance
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'Edge'
        else if (browser.equalsIgnoreCase("Edge")) {
            //set path to Edge.exe
            WebDriverManager.edgedriver().setup();
            //create Edge instance
            driver = new EdgeDriver();
        } else {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.navigate().to("https://test.z2data.com/");
        driver.navigate().to("https://parts.z2data.com/");
        login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void TearDown(ITestResult result) throws InterruptedException {
        String filename = new SimpleDateFormat("ddMMhhmm").format(new Date());
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "/Screenshots/" + result.getName() + filename + ".png"));
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
        ClickLogOut();
        driver.quit();
    }

    public static void Switch_Tabs() {
        ArrayList<String> tab2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab2.get(0));
        driver.close();
        driver.switchTo().window(tab2.get(1));
    }

    public void Implicitly() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void Wait_Element_Clickable(WebElement element) {
        WebDriverWait WebWait = new WebDriverWait(driver, 60);
        WebWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void Wait_Element_Visible(WebElement element) {
        WebDriverWait WebWait = new WebDriverWait(driver, 50);
        WebWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void Wait_Element_Invisibility(WebElement element) {
        WebDriverWait Wait = new WebDriverWait(driver, 50);
        Wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public void Wait_Element_Located_By_Invisibility(String ClassName) {
        WebDriverWait Wait = new WebDriverWait(driver, 50);
        Wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(ClassName)));
    }

    public void Wait_Element_Staleness(WebElement element) {
        WebDriverWait WebWait = new WebDriverWait(driver, 50);
        WebWait.until(ExpectedConditions.stalenessOf(element));
    }

    public static void Wait_for_Element_to_Disappear(List element) throws InterruptedException {
        int count = 0;
        while (element.size() != 0 && count < 30) {
            Thread.sleep(700);
            count++;
        }
    }

    public static void login() {
        LogObj = new Login_Page(driver);
        LogObj.Z2D_Sign_IN(Z2DataUsername, Z2DataPassword);
    }

    public void WaitAllElement() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public static void ClickLogOut() throws InterruptedException {
        page = new Landing_Page(driver);
        Thread.sleep(2000);
        page.ClickMyAccount();
        page.LogOut();
    }

    public static void Wait_for_Element_to_Disappear2(WebElement element) throws Exception {
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (element.isDisplayed()) break;
            } catch (Exception e) {
            }
            Thread.sleep(200);
        }

    }

    private static void fail(String timeout) {

    }


}