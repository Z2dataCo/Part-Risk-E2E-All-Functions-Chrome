package Com.PartRisk.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Grant_Page extends Page_Base {

    @FindBy(xpath = "/html/body/div[6]/div[1]/div/div/div/a")
    WebElement PartRisk_Grant;

    public Grant_Page(WebDriver driver) {
        super(driver);

    }

    public void Z2D_PartRisk_Grant() {
        Click_Button(PartRisk_Grant);
    }
}