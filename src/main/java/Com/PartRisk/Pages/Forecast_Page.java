package Com.PartRisk.Pages;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Forecast_Page extends Page_Base {

    @FindBy(xpath = "//tbody/tr[1]/td[2]/a")
    public WebElement First_Filter;
    @FindBy(xpath = "//tbody/tr[2]/td[5]/a")
    public WebElement Second_Filter;
    @FindBy(xpath = "//tbody/tr[3]/td[4]/a")
    public WebElement Third_Filter;
    @FindBy(xpath = "//tbody/tr[5]/td[2]/a")
    public WebElement Fifth_Filter;
    @FindBy(xpath = "//div[@class='z2tablemost']//tbody/tr[1]/td[1]//span")
    public WebElement First_Table_Data;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[1]/div[1]/div[1]")
    public WebElement File_Name;

    @FindBy(xpath = "//app-z2pagination/span/span[2]")
    public WebElement TotalValue;
    @FindBy(xpath = "//div[@style='border-color: silver silver silver rgb(51, 122, 183);']")
    public List<WebElement> Spinner;
    @FindBy(xpath = "//div[@class='z2tablemost']//table/tbody/tr[1]/td")
    public List<WebElement> Table_Columns;
    @FindBy(xpath = "//div[@class='z2tablemost']//table/tbody/tr")
    public List<WebElement> Table_Rows;
    @FindBy(xpath = "//a[contains(text(),'Forecast')]")
    public WebElement ForeCast_Tab;
    @FindBy(className = "jtoggler-control")
    WebElement Forecast_Switchers;
    //"//*[@id=\"RemainMainPage\"]/app-risk-manager/div[2]/div/div/div/div/label/div")
    @FindBy(xpath = "//*[@id=\"dashboard_content\"]/div/div/div[1]/app-dashboard-risk/div/div[1]")
    public WebElement Graph2;

    public Forecast_Page(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
    }

    public void Z2D_Select_Switcher() {
        Click_Button(Forecast_Switchers);
    }
    public void Z2D_Click_on_Graph(){
        Click_Button(Graph2);
    }

    public void Z2D_Click_on_Forecast_Tab() {
        Click_Button(ForeCast_Tab);
    }

    public void Z2D_Click_on_First_Filter() {
        Scroll_To_Middle();
        Click_Button(First_Filter);
    }

    public void Z2D_Click_on_Second_Filter() {
        Click_Button(Second_Filter);
    }

    public void Z2D_Click_on_Third_Filter() {
        Click_Button(Third_Filter);
    }

    public void Z2D_Click_on_Fifth_Filter() {
        Click_Button(Fifth_Filter);
    }

    public void Z2D_Click_on_First_Result() {
        Click_Button(First_Table_Data);
    }

    public void Z2D_Get_Table_Data(WebDriver driver, String Assertion) {
        WebDriverWait Wait = new WebDriverWait(driver, 30);
        int Row_Size = Table_Rows.size();
        int Column_Size = Table_Columns.size();
        System.out.println("number of Rows are" + Row_Size);
        System.out.println("number of Columns are" + Column_Size);
        // String Life_Cycle_Column_Data = null;
        for (int i = 1; i <= Row_Size; i++) {
            String Life_Cycle_Column_Data = driver.findElement(By.xpath("//div[@class='z2tablemost']//table/tbody/tr[" + i + "]/td[14]")).getText();
            Assert.assertEquals(Life_Cycle_Column_Data, Assertion);
        }
    }
}
