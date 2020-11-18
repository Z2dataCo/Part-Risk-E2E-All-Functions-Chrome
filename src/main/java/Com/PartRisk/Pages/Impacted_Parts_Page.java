package Com.PartRisk.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Impacted_Parts_Page extends Page_Base {
    @FindBy(xpath = "//body/div[@id='main_start_page']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/a[1]")
    public WebElement btnSearch;
    @FindBy(xpath = "//*[@id=\"DivAlertsFilterPCN\"]/div[1]/div[2]/div[1]/div/table/tbody/tr/td[4]/div/fieldset[1]/div/label/span/span")
    WebElement Supplier_CheckBox;


    public Impacted_Parts_Page(WebDriver driver) {
        super(driver);
    }

    public void Z2D_Select_Supplier() {
        Click_Button(Supplier_CheckBox);
    }
}