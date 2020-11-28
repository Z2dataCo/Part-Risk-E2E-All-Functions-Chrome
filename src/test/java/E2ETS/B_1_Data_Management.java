package E2ETS;

import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Landing_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class B_1_Data_Management extends Test_Base {
    Data_Management_Page DManagementObj;
    Landing_Page LandObj;

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate To Open Data Management Page")
    public void Data_Management() {
        DManagementObj = new Data_Management_Page(driver);
        LandObj = new Landing_Page(driver);
        Wait_Element_Visible(LandObj.Data_Management_Tab);
        LandObj.Z2D_Open_Data_Management();
        Wait_Element_Visible(DManagementObj.Table_Name);
        Wait_Element_Clickable(DManagementObj.Table_Name);
        Assert.assertEquals(DManagementObj.Table_Name.getText(), "Name");
        Assert.assertEquals(DManagementObj.Table_User.getText(), "User");
        Assert.assertEquals(DManagementObj.Table_Of_file.getText(), "# of Files");
        Assert.assertEquals(DManagementObj.of_Suppliers.getText(), "# of Suppliers");
        Assert.assertEquals(DManagementObj.Table_Data_Created.getText(), "Date Created");
        Assert.assertEquals(DManagementObj.Table_Action.getText(), "Actions");
    }
}