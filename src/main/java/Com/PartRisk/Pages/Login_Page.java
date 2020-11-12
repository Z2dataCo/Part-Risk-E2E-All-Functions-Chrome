package Com.PartRisk.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends Page_Base {
    @FindBy(xpath = "//*[@id=\"main_start_page\"]/div/h2")
    public WebElement verify_Redirect;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/form/button")
    public WebElement Verify_Open;
    @FindBy(id = "Username")
    WebElement Input_Text_Box;
    @FindBy(id = "Password")
    WebElement Input_Pass;
    @FindBy(name = "button")
    WebElement SignIn_btn;

    public Login_Page(WebDriver driver) {
        super(driver);
    }

    public void Z2D_Sign_IN(String Z2DataUsername, String Z2DataPassword) {
        Set_Text_Element_Text(Input_Text_Box, Z2DataUsername);
        Set_Text_Element_Text(Input_Pass, Z2DataPassword);
        Click_Button(SignIn_btn);
    }


}
