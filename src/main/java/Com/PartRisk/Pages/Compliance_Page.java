package Com.PartRisk.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Compliance_Page extends Page_Base {

    @FindBy(xpath = "//*[@id=\"z2parametric-all\"]/div/div[1]/div[2]/div[1]/label/span[2]")
    public WebElement First_Filter_Total;
    @FindBy(xpath = "//*[@id=\"z2parametric-all\"]/div/div[3]/div[2]/div[2]/label/span[2]")
    public WebElement Second_Filter_Total;
    @FindBy(xpath = "//*[@id=\"Information\"]/app-z2pagination/span/span[2]")
    public WebElement Total_Filter_Results;
    @FindBy(xpath = "//*[@id=\"z2parametric-all\"]/div/div[1]/div[2]/div[1]/label/span[1]")
    public WebElement First_Check_Box_Filter;
    @FindBy(xpath = "//*[@id=\"z2parametric-all\"]/div/div[3]/div[2]/div[2]/label/span[1]")
    public WebElement Second_Check_Box_Filter;

    public Compliance_Page(WebDriver driver) {
        super(driver);
    }

    public void Z2D_Click_on_First_Filter() {
        Click_Button(First_Check_Box_Filter);
    }

    public void Z2D_Click_on_Second_Filter() {
        Click_Button(Second_Check_Box_Filter);
    }
}