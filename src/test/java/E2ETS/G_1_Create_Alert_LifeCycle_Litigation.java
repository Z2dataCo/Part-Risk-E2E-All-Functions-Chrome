package E2ETS;

import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Landing_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class G_1_Create_Alert_LifeCycle_Litigation extends Test_Base {

    Data_Management_Page DManagementObj;
    Landing_Page LandObj;

    @Test(priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate creating alert by selecting LifeCycle & Litigation")
    public void Create_Alert_LifeCycle_Litigation() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        DManagementObj = new Data_Management_Page(driver);

        DManagementObj.Z2D_Move_To_Prod_BOM(driver);
        Wait_Element_Clickable(DManagementObj.Followed_Text);
        if (DManagementObj.Followed_Text.getText().equals("Followed")) {
            DManagementObj.Z2D_Click_Followed_Btn();
            Wait_Element_Clickable(DManagementObj.Unfollow_Btn);
            DManagementObj.Z2D_Click_Unfollow_Btn();
            Wait_Element_Invisibility(DManagementObj.Toast_Container);
            DManagementObj.Z2D_Click_on_Create_Alert(driver);
        }
        else { DManagementObj.Z2D_Click_on_Create_Alert(driver);
        }
        Wait_Element_Clickable(DManagementObj.LifeCycle_Btn);
        DManagementObj.Z2D_Click_on_LifeCycle();
        DManagementObj.Z2D_Click_on_Litigation();
        DManagementObj.Z2D_Click_on_Submit_Btn();
        Wait_Text_Not_To_be(DManagementObj.Followed_Text,"Create Alert");
        String Status = DManagementObj.Followed_Text.getText();
        Assert.assertEquals(Status, "Followed");
        DManagementObj.Z2D_Click_Followed_Btn();
        Wait_Element_Clickable(DManagementObj.Unfollow_Btn);
        DManagementObj.Z2D_Click_Unfollow_Btn();
    }
}