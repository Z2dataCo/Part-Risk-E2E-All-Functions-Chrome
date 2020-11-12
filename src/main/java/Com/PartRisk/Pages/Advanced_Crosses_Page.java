package Com.PartRisk.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Advanced_Crosses_Page extends Page_Base {
    @FindBy(xpath = "//*[@id=\"RemainMainPage\"]/adv-cross/div[1]/div/div[2]/div/div[1]/div")
    public WebElement Total;
    @FindBy(xpath = "//*[@id=\"RemainMainPage\"]/adv-cross/div[1]/div/div[2]/div/div[2]/div/div")
    public WebElement Drop_in;
    @FindBy(xpath = "//*[@id=\"RemainMainPage\"]/adv-cross/div[1]/div/div[2]/div/div[3]/div/div/div[1]")
    public WebElement Drop_IN_SameSupplier;
    @FindBy(xpath = "//*[@id=\"RemainMainPage\"]/adv-cross/div[1]/div/div[2]/div/div[4]/div/div")
    public WebElement Different_Inpout;
    @FindBy(xpath = "//*[@id=\"RemainMainPage\"]/adv-cross/div[1]/div/div[2]/div/div[5]/div/div")
    public WebElement Similar_Different_Package;

    public Advanced_Crosses_Page(WebDriver driver) {
        super(driver);
    }
}
