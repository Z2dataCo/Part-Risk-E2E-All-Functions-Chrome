package Com.PartRisk.Pages;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Obsolescence_Page extends Page_Base {
    public Obsolescence_Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[1]")
    public WebElement High_LifeCycle_Risk;

    @FindBy(xpath = "/html[1]/body[1]/div[9]/div[1]/div[1]/div[2]/div[1]/div[2]")
    public WebElement NRND_Parts;

    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[3]")
    public WebElement Obsolete_Parts;

    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[4]")
    public WebElement Last_Buy_Parts;

    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div[2]/div[2]/app-z2pagination/div/div/div/div/pagination/ul/li[9]/a")

    public WebElement Last;

    @FindBy(xpath = "//div[@id='dropbg']//li[@class='pagination-next page-item disabled']/preceding-sibling::li[position()<2]")
    public WebElement Next_Page;

    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div[2]/div[2]/app-z2pagination/span/span[2]")
    public WebElement Fixed_Number;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> Table_Size;


    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div/div[1]/div[2]/app-z2pagination/div/div/div/div/pagination/ul/li[9]/a")
    public WebElement LastPage_3Y;

    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[2]/app-z2pagination/div/div/div/div/pagination/ul/li[9]/a")
    public WebElement LastPage_5Y;


    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div/div[1]/div[2]/app-z2pagination/span/span[2]")
    public WebElement Fixed_Number_For_3Y;

    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[1]/div[2]/i")
    public WebElement Close_Slide;


    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[2]/app-z2pagination/span/span[2]")
    public WebElement Fixed_Number_For_5Y;

    @FindBy(linkText = "All Obsolescence PCNs")
    public WebElement All_Obsolescence;

    @FindBy(xpath = "//*[@id=\"z2-2cols-leftpanel\"]/ul/li[6]/a/div[2]")
    public WebElement Product_Change_Notices;

    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div/div[2]/app-z2pagination/div/div/div/div/pagination/ul/li[9] ")
    public WebElement Last_Page_All_Obs;


    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div/div[2]/app-z2pagination/span/span[2]")
    public WebElement Fixed_Number_for_All_Obs;


    @FindBy(xpath = "c")
    public List<WebElement> New_Data;

    public void Z2D_Open_High_LifeCycle() {
        Click_Button(High_LifeCycle_Risk);
    }

    public void Z2D_NRND_Parts() {
        Click_Button(NRND_Parts);
    }

    public void Z2D_Obsolete_Parts() {
        Click_Button(Obsolete_Parts);
    }

    public void Z2D_Last_by_Parts() {
        Click_Button(Last_Buy_Parts);
    }

    public void Z2D_Get_Last_Page() {
        Click_Button(Last);
    }

    public void Z2D_Get_Last_Page_For_3Y() {
        Click_Button(LastPage_3Y);
    }

    public void Z2D_Close_Slide() {
        Click_Button(Close_Slide);
    }

    public void Z2D_Get_Last_Page_For_5Y() {
        Click_Button(LastPage_5Y);
    }

    public void Z2D_All_Obsolescence() {
        Click_Button(All_Obsolescence);
    }

    public void Z2D_Product_Change() {
        Click_Button(Product_Change_Notices);
    }

    public void Z2D_Get_Last_Page_for_All_Obs() {
        Click_Button(Last_Page_All_Obs);
    }

    public void Z2D_Table_of_Data(WebDriver driver) {
        for (int i = 1; i <= New_Data.size(); i++) {
            System.out.println(New_Data);
            String Data = driver.findElement(By.xpath("//table[@class='z2tableM table hoverrows table-bordered table-middle bigtitle text-left']/tbody/tr[" + i + "]/td[3]")).getText();
            Assert.assertTrue(Data.contains("Obsolescence"));
        }
    }
}