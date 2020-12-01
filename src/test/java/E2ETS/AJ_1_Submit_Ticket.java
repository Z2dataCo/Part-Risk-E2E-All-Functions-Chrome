package E2ETS;

import Com.PartRisk.Pages.Submit_Ticket_Page;
import org.testng.annotations.Test;

public class AJ_1_Submit_Ticket extends Test_Base {
    Submit_Ticket_Page SubmitObj;
     @Test(priority = 37)
    public void User_Submit_Ticket() {
        SubmitObj = new Submit_Ticket_Page(driver);
        SubmitObj.Z2D_Open_Submit_Ticket();
        SubmitObj.Z2D_Type_Of_Issue();
        SubmitObj.Z2D_Enter_Issue_Data(subject,area);
        SubmitObj.Z2D_Close_Ticket();
    }
}
