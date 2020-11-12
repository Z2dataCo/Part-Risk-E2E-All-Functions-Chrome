package E2ETS;

import Com.PartRisk.Pages.DataManagement_Page;
import Com.PartRisk.Pages.Delete_Bom_Page;
import Com.PartRisk.Pages.Landing_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;

public class X_Fun_Delete_BOMs extends Test_Base {

    DataManagement_Page DManagementObj;
    Landing_Page LandObj;
    Delete_Bom_Page DeleteOBJ;

    @Test(priority = 24)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deleting Created BOMs")
    public void Delete_BMS() throws InterruptedException {

        LandObj = new Landing_Page(driver);
        DManagementObj = new DataManagement_Page(driver);
        DeleteOBJ = new Delete_Bom_Page(driver);

        LandObj.Z2D_Open_Data_Management();
        Wait_Element_Clickable(DManagementObj.Search_Text_Input);
        DManagementObj.Z2D_Type_Folder_Name(Z2DataFolderName);
        boolean staleElement = true;
        while (staleElement) {
            try {
                DManagementObj.Z2D_Select_Folder();
                staleElement = false; }
            catch (StaleElementReferenceException e) {
                staleElement = true; }
        }
        DeleteOBJ.Click_on_Check_Box();
        int Rows_Size = DeleteOBJ.BOMs_Table.size();
        System.out.println(Rows_Size);
        DeleteOBJ.Deleting_Boms(driver);
    System.out.println("All testing BOMs have been deleted successfully except : (TAP_Bom_Proud_Test)");
    }
}

