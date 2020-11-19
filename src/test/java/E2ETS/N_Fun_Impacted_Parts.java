package E2ETS;

import Com.PartRisk.Pages.Impacted_Parts_Page;
import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.PCN_Manager_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class N_Fun_Impacted_Parts extends Test_Base {
    Landing_Page LandObj;
    PCN_Manager_Page PCN_ManagerObj;
    Impacted_Parts_Page impacted_PartsPageObj;

    @Test(priority = 14)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate To Check ability to view impacted parts in PCN")
    public void Impacted_Parts() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        PCN_ManagerObj = new PCN_Manager_Page(driver);
        impacted_PartsPageObj = new Impacted_Parts_Page(driver);
        Implicitly();
        LandObj.Z2D_Open_PCN_Manager();
        Wait_Element_Clickable(PCN_ManagerObj.Impacted_Parts_Tab);
        PCN_ManagerObj.Z2D_Open_Impacted_Parts_Tab();
        Wait_for_Element_to_Disappear(LandObj.GeneralSpinner);
        impacted_PartsPageObj.Z2D_Select_Supplier();
        Assert.assertEquals(impacted_PartsPageObj.btnSearch.getText(), "Search");
    }
}