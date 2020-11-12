package Com.PartRisk.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Submit_Ticket_Page extends Page_Base {

    @FindBy(xpath = "//div[@id='dropbg']//div//div//div//div[@id='successdiv']//div//h3")
    public WebElement Verification_MSG;
    @FindBy(xpath = "//body/div[@id='dropbg']/div/div/div/div[@id='initdiv']/div/div/div/div[1]")
    WebElement Click_Data;
    @FindBy(id = "HeaderSubmitTicket")
    WebElement Submit_Issue_Btn;
    @FindBy(xpath = "//*[@id=\"initdiv\"]/div[1]/div[2]/div/div[2]")
    WebElement Tool;
    @FindBy(xpath = "//*[@id=\"initdiv\"]/div[1]/div[2]/div/div[3]")
    WebElement Suggestion;
    @FindBy(xpath = "//*[@id=\"initdiv\"]/div[1]/div[2]/div/div[4]")
    WebElement Other;
    @FindBy(xpath = "//div[@id='dropbg']//div//div//div//div[@id='initdiv']//div//div//input[@id='submit_txt_ticketSubject']")
    WebElement Subject_Area;
    @FindBy(xpath = "//div[@id='dropbg']//div//div//div//div[@id='initdiv']//div//div//textarea[@id='submit_txt_ticketBody']")
    WebElement Body;
    @FindBy(xpath = "//div[@id='dropbg']//button[@class='btn-submiticketsend inpanelaction'][contains(text(),'Send Support Ticket')]")
    WebElement Support_Btn;
    @FindBy(xpath = "//div[@id='dropbg']//div//div//div//div[@id='successdiv']//button")
    WebElement Close_Btn;

    public Submit_Ticket_Page(WebDriver driver) {
        super(driver);
    }

    public void Z2D_Type_Of_Issue() {
        Click_Button(Click_Data);
    }

    public void Z2D_Open_Submit_Ticket() {
        Click_Button(Submit_Issue_Btn);
    }

    public void Z2D_Enter_Issue_Data(String subject, String body) {
        Set_Text_Element_Text(Subject_Area, subject);
        Set_Text_Element_Text(Body, body);
        Click_Button(Support_Btn);
    }

    public void Z2D_Close_Ticket() {
        Click_Button(Close_Btn);
    }
}