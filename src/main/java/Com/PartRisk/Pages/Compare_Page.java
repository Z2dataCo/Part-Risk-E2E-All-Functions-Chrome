package Com.PartRisk.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Compare_Page extends Page_Base {
    @FindBy(id = "part_autocom_0")
    public WebElement Compare1;
    @FindBy(xpath = "//body[1]/div[5]/app-root[1]/div[3]/app-compare[1]/div[1]/div[1]/app-compareparts[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[2]/div[1]/app-part-autocomplete[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")
    public WebElement Value_Compare1;
    @FindBy(xpath = "//body[1]/div[5]/app-root[1]/div[3]/app-compare[1]/div[1]/div[1]/app-compareparts[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[3]/div[1]/app-part-autocomplete[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")
    public WebElement Value_Compare2;
    @FindBy(xpath = "//*[@id=\"box_one\"]/div/div/app-ipn-scorecard/div/div[1]/div/div[1]/div[1]/div[1]")
    public WebElement MSG;
    @FindBy(id = "part_autocom_1")
    public WebElement Compare2;
    @FindBy(xpath = "//*[@id=\"headerEl\"]/div/div/a[2]")
    WebElement Differences;
    @FindBy(xpath = "//*[@id=\"headerEl\"]/div/div/a[3]")
    WebElement Similarities;


    public Compare_Page(WebDriver driver) {
        super(driver);
    }

    public void Z2D_Input_Compare_1(String Z2DataCompare_1) {
        Set_Text_Element_Text(Compare1, Z2DataCompare_1);
    }

    public void Z2D_Input_Compare_2(String Z2DataCompare_2) {
        Set_Text_Element_Text(Compare2, Z2DataCompare_2);
    }

    public void Z2D_Select_Differences() {
        Click_Button(Differences);
    }

    public void Z2D_Select_Similarities() {
        Click_Button(Similarities);
    }

    public void SetValue1() {
        Click_Button(Value_Compare1);
    }


    public void SetValue2() {
        Click_Button(Value_Compare2);

    }
}
