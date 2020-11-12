package E2ETS;

import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.Login_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;


public class M_Fun_Search_IPN extends Test_Base {
    Login_Page LogObj;
    Landing_Page LandObj;

    @Test(priority = 13)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate To Search By IPN")
    public void Search_by_IPN() throws InterruptedException {
        LogObj = new Login_Page(driver);
        LandObj = new Landing_Page(driver);
        LandObj.Z2D_Open_DDL_Menu();
        LandObj.Z2D_IPN_DDL();
        Thread.sleep(1000);
        LandObj.Z2D_input_Search(Z2DataIPN);
        Wait_Element_Clickable(LandObj.IPN_Value);
        LandObj.Z2D_IPN_Value();
        Assert.assertTrue(driver.getCurrentUrl().contains("IPN"));
    }
}