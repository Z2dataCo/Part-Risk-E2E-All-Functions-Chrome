package E2ETS;

import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.Parts_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class P_2_Fun_MPN_View extends Test_Base {
    Landing_Page LandObj;
    Data_Management_Page DManagementObj;
    Parts_Page PartPageObj;

    @Test(priority = 16)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check selecting any status will affect on forecast graph ( MPN View )")
    public void MPN_View() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        PartPageObj = new Parts_Page(driver);
        Actions action = new Actions(driver);
        LandObj.Z2D_Open_Data_Management();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        DManagementObj.Z2D_Search(Z2DataFolderName);
        Thread.sleep(1000);
        action.moveToElement(DManagementObj.Test_Folder).click().perform();
        DManagementObj.Z2D_Open_BOM();
        Switch_Tabs();
        Wait_Element_Clickable(DManagementObj.Parts);
        DManagementObj.Z2D_Open_Parts();
        Thread.sleep(3000);
        //  PartPageObj.Chek_AVX();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        // PartPageObj.ChekFuses();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        Assert.assertEquals(PartPageObj.Uploaded_IPN.getText(), "Uploaded IPN");
        Assert.assertEquals(PartPageObj.Uploaded_MPN.getText(), "Uploaded MPN");
        Assert.assertEquals(PartPageObj.Uploaded_Supplier.getText(), "Uploaded Supplier");
        Assert.assertEquals(PartPageObj.IPN.getText(), "IPN");
        Assert.assertEquals(PartPageObj.Part_Number.getText(), "Part Number");
        Assert.assertEquals(PartPageObj.Supplier.getText(), "Supplier");
        Assert.assertEquals(PartPageObj.Product.getText(), "Product");
        Assert.assertEquals(PartPageObj.Description.getText(), "Description");
        Assert.assertEquals(PartPageObj.Package.getText(), "Package");
        Assert.assertEquals(PartPageObj.LifeCycle.getText(), "Lifecycle");
        Assert.assertEquals(PartPageObj.RoHos.getText(), "RoHS");
        Assert.assertEquals(PartPageObj.Crosses.getText(), "Crosses");
        Assert.assertEquals(PartPageObj.Inventory.getText(), "Inventory");
        Assert.assertEquals(PartPageObj.PCN.getText(), "PCN");
        Assert.assertEquals(PartPageObj.PartScore.getText(), "Part Score");
        Assert.assertEquals(PartPageObj.Tags.getText(), "Tags");
    }
}