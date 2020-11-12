package E2ETS;

import Com.PartRisk.Pages.DataManagement_Page;
import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.Login_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E_Create_Alert_LifeCycle extends Test_Base {
    DataManagement_Page DManagementObj;
    Landing_Page LandObj;

    @Test(priority = 5)
    @Severity(value = SeverityLevel.CRITICAL)
    @Description("Validate creating alert by selecting LifeCycle only")
    public void Create_Alert_LifeCycle() throws Exception {
        LandObj = new Landing_Page(driver);
        DManagementObj = new DataManagement_Page(driver);

        LandObj.Z2D_Open_Data_Management();
        Wait_Element_Clickable(DManagementObj.Search_Text_Input);
        DManagementObj.Z2D_Type_Folder_Name(Z2DataFolderName);
        DManagementObj.Z2D_Select_Folder();
        boolean staleElement = true;
        while (staleElement) {
            try {
                DManagementObj.Z2D_Click_on_BOM_File();
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                staleElement = true; }
        }
        Switch_Tabs();
        Wait_Element_Clickable(DManagementObj.Followed_Text);
        if (DManagementObj.Followed_Text.getText().equals("Followed")) {
            DManagementObj.Z2D_Click_Followed_Btn();
            Wait_Element_Clickable(DManagementObj.Unfollow_Btn);
            DManagementObj.Z2D_Click_Unfollow_Btn();
            Wait_Element_Invisibility(DManagementObj.ToastContainer);
            DManagementObj.Z2D_Click_on_Create_Alert(driver); }
        else {
            DManagementObj.Z2D_Click_on_Create_Alert(driver);
        }
        Wait_Element_Visible(DManagementObj.LifeCycle_Btn);
        Wait_Element_Clickable(DManagementObj.LifeCycle_Btn);
        DManagementObj.Z2D_Click_on_LifeCycle();
        DManagementObj.Z2D_Click_on_Submit_Btn();
        //Wait_for_Element_to_Disappear2(DManagementObj.ToastContainer);
        //Wait_for_Element_to_Disappear(DManagementObj.ToastContainer2);
        Wait_Element_Invisibility(DManagementObj.ToastContainer);
        //Wait_Element_Clickable(DManagementObj.Followed_Text);
        //Wait_Element_Visible(DManagementObj.ToastContainer);
        String Status = DManagementObj.Followed_Text.getText();
        Assert.assertEquals(Status, "Followed");
        DManagementObj.Z2D_Click_Followed_Btn();
        Wait_Element_Clickable(DManagementObj.Unfollow_Btn);
        DManagementObj.Z2D_Click_Unfollow_Btn();
    }
}