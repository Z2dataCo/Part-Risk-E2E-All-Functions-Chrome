package Com.PartRisk.Pages;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Forecast_Page extends Page_Base {

    @FindBy(xpath = "//tbody/tr[1]/td[2]/a")
    public WebElement Active_Filter;
    @FindBy(xpath = "//tbody/tr[2]/td[5]/a")
    public WebElement EOL_Filter;
    @FindBy(xpath = "//tbody/tr[3]/td[4]/a")
    public WebElement Unknown_Filter;
    @FindBy(xpath = "//app-z2pagination/span/span[2]")
    public WebElement TotalValue;
    @FindBy(xpath = "//div[@style='border-color: silver silver silver rgb(51, 122, 183);']")
    public List <WebElement> Spinner;
    @FindBy(xpath = "//div[@class='z2tablemost']//table/tbody/tr[1]/td")
    public List<WebElement> Table_Columns;
    @FindBy(xpath = "//div[@class='z2tablemost']//table/tbody/tr")
    public List<WebElement> Table_Rows;
    @FindBy(xpath = "//a[contains(text(),'Forecast')]")
    public WebElement ForeCast_Tab;
    @FindBy(className ="jtoggler-control")
    WebElement Forecast_Switchers;
    //"//*[@id=\"RemainMainPage\"]/app-risk-manager/div[2]/div/div/div/div/label/div")

    public Forecast_Page(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver; }

    public void Z2D_Select_Switcher() { Click_Button(Forecast_Switchers); }
    public void Z2D_Click_on_Forecast_Tab() {
        Click_Button(ForeCast_Tab);
    }

    public void Z2D_Click_on_Active_Filter() {
        Scroll_To_Middle();
        Click_Button(Active_Filter); }

    public void Z2D_Click_on_EOL_Filter() {
        Click_Button(EOL_Filter);
    }
    public void Z2D_Click_on_Unknown_Filter() {
        Click_Button(Unknown_Filter);
    }
    public void Get_Table_Data(WebDriver driver, String Assertion ) {
        WebDriverWait Wait = new WebDriverWait(driver, 30);
        int Row_Size = Table_Rows.size();
        int Column_Size = Table_Columns.size();
        System.out.println("number of Rows are" + Row_Size);
        System.out.println("number of Columns are" + Column_Size);
        // String Life_Cycle_Column_Data = null;
        for (int i = 1; i <= Row_Size; i++) {
            String  Life_Cycle_Column_Data = driver.findElement(By.xpath("//div[@class='z2tablemost']//table/tbody/tr[" + i + "]/td[14]")).getText();
            Assert.assertEquals(Life_Cycle_Column_Data, Assertion);
        }
    }
}
