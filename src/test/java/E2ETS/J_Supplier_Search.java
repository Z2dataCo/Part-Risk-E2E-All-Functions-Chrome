package E2ETS;

import Com.PartRisk.Pages.DataManagement_Page;
import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.Suppliers_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class J_Supplier_Search extends Test_Base {
    Suppliers_Page SuppliersObj;
    Landing_Page LandObj;
    DataManagement_Page DManagamentOpj;

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate To Search For Supplier")
    public void Search_for_Supplier() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        SuppliersObj = new Suppliers_Page(driver);
        LandObj.Z2D_More_Menu();
        LandObj.Z2D_Select_Supplier();
        Thread.sleep(1000);
        SuppliersObj.Z2D_Enter_Supplier(Z2DataSupplier);
        Thread.sleep(1000);
        SuppliersObj.Z2D_Click_Search();
        Thread.sleep(2000);
        Assert.assertTrue(SuppliersObj.SuppName.getText().contains("Toshiba"));

    }
}