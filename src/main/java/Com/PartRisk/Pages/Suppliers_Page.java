package Com.PartRisk.Pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Suppliers_Page extends Page_Base {
    @FindBy(xpath = "//*[@id=\"RemainMainPage\"]/app-browsesuppliers/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[1]/a")
    public WebElement Verify_MSG;
    @FindBy(xpath = "//*[@id=\"RemainMainPage\"]/app-browsesuppliers/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[1]/a")
    public WebElement SuppName;
    @FindBy(xpath = "//*[@id=\"RemainMainPage\"]/app-browsesuppliers/div/div[1]/div/div/div[1]/div/span/a")
    public WebElement Search_Btn;
    @FindBy(xpath = "//*[@id=\"supplier_autocom_\"]")
    public WebElement Search_Input;

    public Suppliers_Page(WebDriver driver) {
        super(driver);
    }

    public void Z2D_Enter_Supplier(String supplier) {
        Set_Text_Element_Text(Search_Input, supplier);
    }

    public void Z2D_Click_Search() {
        boolean Intercepted = true;
        while (Intercepted) {
            try {
                Click_Button(Search_Btn);
                Intercepted = false;
            } catch (ElementClickInterceptedException e) {
                Intercepted = true;
            }
        }
    }
}
