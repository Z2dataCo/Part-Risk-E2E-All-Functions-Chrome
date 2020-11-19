package E2ETS;

import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Landing_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class V_2_Fun_Create_Folder_Data_Management extends Test_Base {

    Landing_Page LandObj;
    Data_Management_Page DManagementObj;

    @Test(priority = 22)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate To Create Folder In Data Management")
    public void Create_Folder_in_Data_Management() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        LandObj.Z2D_Open_Data_Management();
        Wait_Element_Clickable(DManagementObj.Create_Folder);
        DManagementObj.Z2D_Create_Folder();
        DManagementObj.Z2D_Folder_Name(Z2DataFakerFolder);
        DManagementObj.Z2D_Submit_Folder();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getPageSource().contains(Z2DataFakerFolder), Z2DataFakerFolder.contains(Z2DataFakerFolder));
        Wait_Element_Invisibility(DManagementObj.Toast_Container);
        String istRow = DManagementObj.istRow.getText();
        if (istRow.equals(Z2DataFakerFolder)) {
            DManagementObj.DeleteBom();
            DManagementObj.DeleteConfirmation();
            if (!driver.getPageSource().contains(Z2DataFakerFolder)) {
                Assert.assertNotEquals(istRow, Z2DataFakerFolder);
            }
        } else {
            System.out.println("Folder not Exist");
        }


    }
}