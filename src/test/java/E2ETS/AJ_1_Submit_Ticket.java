package E2ETS;

import Com.PartRisk.Pages.Submit_Ticket_Page;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class AJ_1_Submit_Ticket extends Test_Base {
    Submit_Ticket_Page Submit;
     @Test(priority = 35)
    public void User_Submit_Ticket() {
        Submit = new Submit_Ticket_Page(driver);
        Submit.Z2D_Open_Submit_Ticket();
        Submit.Z2D_Type_Of_Issue();
        Submit.Z2D_Enter_Issue_Data(subject,area);
        Submit.Z2D_Close_Ticket();
    }
}
