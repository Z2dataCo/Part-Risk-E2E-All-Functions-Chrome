package E2ETS;

import Com.PartRisk.Pages.Advanced_Crosses_Page;
import Com.PartRisk.Pages.Landing_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class H_1_Advanced_Crosses extends Test_Base {
    Advanced_Crosses_Page AdvCrosObj;
    Landing_Page LandObj;

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate To Search By Advanced Crosses")
    public void Advanced_Crosses() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        AdvCrosObj = new Advanced_Crosses_Page(driver);

        Wait_Element_Visible(LandObj.DDL_Type_Of_Search);
        LandObj.Z2D_Open_DDL_Menu();
        LandObj.Z2D_Adv_Crosses();
        LandObj.Z2D_input_Search(Z2DataAdvCrosses);
        LandObj.Z2D_Adv_Product();
        Thread.sleep(3000);
        Assert.assertTrue(AdvCrosObj.Total.getText().contains("Total"));
        Assert.assertTrue(AdvCrosObj.Different_Inpout.getText().contains("Different Pinout"));
        Assert.assertTrue(AdvCrosObj.Drop_in.getText().contains("Drop-In"));
        Assert.assertTrue(AdvCrosObj.Drop_IN_SameSupplier.getText().contains("Drop-In Same Supplier"));
        Assert.assertTrue(AdvCrosObj.Similar_Different_Package.getText().contains("Similar / Different Package"));
    }
}