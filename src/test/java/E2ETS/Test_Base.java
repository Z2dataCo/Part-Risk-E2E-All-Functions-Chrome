package E2ETS;

import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.Login_Page;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

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
    public static Login_Page LogObj;
    public static Landing_Page page;
    public String Z2DataPartNumber = "bav99";
    public String Z2DataAdvCrosses = "bav";
    public String Z2DataIPN = "0.9902785216";
    public String Z2DataCompare_1 = "bav10";
    public String Z2DataCompare_2 = "bav20";
    public String Z2DataSupplier = "Toshiba";
    public String Z2DataFolderName = "TAP_BOM";
    //public String Z2DataFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\BOMs\\TABOM1.xlsx";
    public String Z2DataSwitcherStepFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\BOMs\\TABOM2.xlsx";
    Faker faker = new Faker();
    public String Z2DataFakerFolder = faker.name().firstName() + "1";
    public String Z2DataPCNID = "PD22748X";
    public String Z2DataMPNID = "FSP012-FHEN2";

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    @SuppressWarnings("unused")
    @BeforeSuite
    public static void SetUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setProxy(null);
       // options.addArguments("--headless");
        //options.addArguments("--disable-gpu");
     //   options.addArguments("--window-size=1400,800");
        options.addArguments("--disable-remote-fonts");
        options.addArguments("--enable-precache");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-modal-animations");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        //driver.navigate().to("https://test.z2data.com/");
        driver.get("https://parts.z2data.com");
        login();
        DeleteCookies();
        WaitAllElement();
        //JavascriptExecutor js = (JavascriptExecutor) driver;
    }

    public static void Switch_Tabs() {
        ArrayList<String> tab2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab2.get(0));
        driver.close();
        driver.switchTo().window(tab2.get(1));
    }

    public static void Wait_for_Element_to_Disappear(List element) throws InterruptedException {
        int count = 0;
        while (element.size() != 0 && count < 40) {
            Thread.sleep(700);
            count++;
        }
    }

    public static void login() {
        LogObj = new Login_Page(driver);
        LogObj.Z2D_SignIn(Z2DataUsername, Z2DataPassword);
    }

    public static void WaitAllElement() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public static void ClickLogOut() throws InterruptedException {
        page = new Landing_Page(driver);
        Thread.sleep(2000);
        page.Z2D_Click_My_Account();
        page.Z2D_Logout();
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

    @AfterMethod
    public void Back_To_Landing(ITestResult result) throws InterruptedException {
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
        WaitAllElement();
        driver.get("https://parts.z2data.com/");

        if (ITestResult.SUCCESS == result.getStatus()) {
            System.out.println("[SCENARIO PASSED]:" + result.getMethod().getMethodName());
        } else if (ITestResult.FAILURE == result.getStatus()) {
            System.out.println("[SCENARIO FAIL]:" + result.getMethod().getMethodName());
        } else {
            System.out.println("SCENARIO SKIPPED]:" + result.getMethod().getMethodName());
        }
    }


    @AfterSuite
    public void TearDown() {
        driver.quit();
    }

    public void Implicitly() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void Wait_Element_Clickable(WebElement element) {
        WebDriverWait WebWait = new WebDriverWait(driver, 60);
        WebWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void Wait_Element_Visible(WebElement element) {
        WebDriverWait WebWait = new WebDriverWait(driver, 60);
        WebWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void Wait_Element_Invisibility(WebElement element) {
        WebDriverWait Wait = new WebDriverWait(driver, 60);
        Wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void Wait_Text_To_Be(WebElement element, String Text) {
        WebDriverWait Wait = new WebDriverWait(driver, 60);
        Wait.until(ExpectedConditions.textToBePresentInElement(element, Text));

    }

    public void Wait_Text_Not_To_be(WebElement element, String Text) {
        WebDriverWait Wait = new WebDriverWait(driver, 50);
        Wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, Text)));
    }

    @BeforeMethod
    public void WaitElement() {
        Refresh();
        WaitAllElement();

    }

    public static void DeleteCookies() {
        driver.manage().deleteAllCookies();
    }

    public static void Refresh() {
        driver.navigate().refresh();
    }
}