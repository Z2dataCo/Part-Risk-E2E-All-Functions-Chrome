package E2ETS;

import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.Suppliers_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class J_1_Supplier_Search extends Test_Base {
    Suppliers_Page SuppliersObj;
    Landing_Page LandObj;
    Data_Management_Page DManagementObj;

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate To Search For Supplier")
    public void Search_for_Supplier() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        SuppliersObj = new Suppliers_Page(driver);
        DManagementObj = new Data_Management_Page(driver);

        LandObj.Z2D_More_Menu();
        LandObj.Z2D_Select_Supplier();
        boolean staleElement = true;
        while (staleElement) {
            try {
                SuppliersObj.Z2D_Enter_Supplier(Z2DataSupplier);
                staleElement = false;
            } catch (Exception e) {
                staleElement = true;
            }
        }
        SuppliersObj.Z2D_Click_Search();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        Wait_Element_Visible(SuppliersObj.SuppName);
        Assert.assertTrue(SuppliersObj.SuppName.getText().contains("Toshiba"));

    }
}