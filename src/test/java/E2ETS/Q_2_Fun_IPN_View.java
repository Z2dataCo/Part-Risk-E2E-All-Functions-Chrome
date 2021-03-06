package E2ETS;

import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.Parts_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Q_2_Fun_IPN_View extends Test_Base {
    Parts_Page PartPageObj;
    Data_Management_Page DManagementObj;
    Landing_Page LandObj;

    @Test(priority = 17)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that parts tab have data appear and count of uploaded IPN (IPN View)")
    public void IPN_View() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        PartPageObj = new Parts_Page(driver);

        LandObj.Z2D_Open_Data_Management();
        Wait_Element_Visible(DManagementObj.Search_Text_Input);
        DManagementObj.Z2D_Search(Z2DataFolderName);
        boolean staleElement = true;
        while (staleElement) {
            try {
                DManagementObj.SetFile();
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }
        DManagementObj.Z2D_Open_BOM();

        Switch_Tabs();
        Wait_Element_Clickable(DManagementObj.Parts);
        DManagementObj.Z2D_Open_Parts();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        PartPageObj.Z2D_Select_Switcher();
        Wait_Element_Visible(PartPageObj.IPN_Table_Header);
        //PartPageObj.ChekFuses();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        Assert.assertTrue(PartPageObj.IPN_Table_Header.getText().contains("IPN"));
        Assert.assertTrue(PartPageObj.Product_Table_Header.getText().contains("Product"));
        Assert.assertTrue(PartPageObj.Description_Table_Header.getText().contains("Description"));
        Assert.assertTrue(PartPageObj.ofMPNs_Table_Header.getText().contains("# of MPNs"));
        Assert.assertTrue(PartPageObj.OfSource_Table_Header.getText().contains("# of Sources"));
        Assert.assertTrue(PartPageObj.Multi_Sourcing_Table_Header.getText().contains("Multi-Sourcing"));
        Assert.assertTrue(PartPageObj.Package_Table_Header.getText().contains("Package"));
        Assert.assertTrue(PartPageObj.RoHS_Table_Header.getText().contains("RoHS"));
        Assert.assertTrue(PartPageObj.Lead_Finish_Table_Header.getText().contains("Lead-finish"));
        Assert.assertTrue(PartPageObj.Dimension_Table_Header.getText().contains("Dimension"));
        Assert.assertTrue(PartPageObj.Crosses_Table_Header.getText().contains("Crosses"));
        Assert.assertTrue(PartPageObj.IPN_Lifecycl_Forecast_Table_Header.getText().contains("IPN Lifecycle Forecast"));
        Assert.assertTrue(PartPageObj.IPN_Risk_Table_Header.getText().contains("IPN Risk"));
    }
}