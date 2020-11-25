package E2ETS;

import Com.PartRisk.Pages.Impacted_Parts_Page;
import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.PCN_Manager_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class N_2_Fun_Impacted_Parts extends Test_Base {
    Landing_Page LandObj;
    PCN_Manager_Page PCN_ManagerObj;
    Impacted_Parts_Page impacted_PartsPageObj;
    Actions act;

    @Test(priority = 14)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate To Check ability to view impacted parts in PCN")
    public void Impacted_Parts() throws InterruptedException {
        act = new Actions(driver);
        LandObj = new Landing_Page(driver);
        PCN_ManagerObj = new PCN_Manager_Page(driver);
        impacted_PartsPageObj = new Impacted_Parts_Page(driver);
        LandObj.Z2D_Open_PCN_Manager();
        WaitAllElement();
        boolean staleElement = true;
        while (staleElement) {
            try {
            PCN_ManagerObj.Z2D_Open_Impacted_Parts_Tab();
                staleElement = false;
            } catch (ElementClickInterceptedException e) {
                staleElement = true;
            }
        }
        Wait_for_Element_to_Disappear(LandObj.GeneralSpinner);
        impacted_PartsPageObj.Z2D_Select_Supplier();
        Assert.assertEquals(impacted_PartsPageObj.btnSearch.getText(), "Search");
    }
}