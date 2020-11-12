package E2ETS;

import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.PCN_Manager_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D_PCN_Manager extends Test_Base {
    PCN_Manager_Page PCN_ManagerObj;
    Landing_Page LandObj;

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate To Open PCN Tab")
    public void PCN_Tab() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        PCN_ManagerObj = new PCN_Manager_Page(driver);

        LandObj.Z2D_Open_PCN_Manager();
        Wait_for_Element_to_Disappear(LandObj.GeneralSpinner);
        PCN_ManagerObj.Z2D_Open_Dashboard_Tab();
        Wait_Element_Visible(PCN_ManagerObj.Dashboard_Tab_Total_PCNs);

        if (PCN_ManagerObj.Dashboard_Tab_Total_PCNs.isDisplayed()) {
            Assert.assertTrue((PCN_ManagerObj.Dashboard_Tab_Total_PCNs.isDisplayed()));
            Assert.assertTrue((PCN_ManagerObj.Dashboard_Tab_Requires_Action.isDisplayed()));
            Assert.assertTrue((PCN_ManagerObj.Dashboard_Tab_In_Progress.isDisplayed()));
            Assert.assertTrue((PCN_ManagerObj.Dashboard_Tab_Completed.isDisplayed()));
        } else {
            System.out.println("Assertion Dashboard Cards is Failed");
        }

        PCN_ManagerObj.Z2D_Open_Inbox_Tab();
        Wait_for_Element_to_Disappear(LandObj.GeneralSpinner);
        if (PCN_ManagerObj.Inbox_Tab_Filter_Table.isDisplayed()) {
            Assert.assertTrue((PCN_ManagerObj.Inbox_Tab_Filter_Table.isDisplayed()));
        } else {
            System.out.println("Assertion for Inbox Tab Filter Table is Failed");
        }

        PCN_ManagerObj.Z2D_Open_PCNs_Tab();
        Wait_for_Element_to_Disappear(LandObj.GeneralSpinner);
        if (PCN_ManagerObj.PCNs_Tab_Filter_Table.isDisplayed()) {
            Assert.assertTrue((PCN_ManagerObj.PCNs_Tab_Filter_Table.isDisplayed()));
        } else {
            System.out.println("Assertion for PCNs Tab Filter Table is Failed");
        }
        PCN_ManagerObj.Z2D_PCNs_First_PCN_Notification();

        if (PCN_ManagerObj.PCNs_First_PCN_Notification_PCN_ID.isDisplayed()) {
            Assert.assertEquals(PCN_ManagerObj.PCNs_First_PCN_Notification_PCN_ID.getText(), "Z2 PCN_ID");
        } else {
            System.out.println("Assertion for PCNs Tab First PCN Notification Z2 PCN_ID is Failed");
        }
        PCN_ManagerObj.Z2D_Back_from_PCN_Notification();

        PCN_ManagerObj.Z2D_Open_Impacted_Parts_Tab();
        Wait_for_Element_to_Disappear(LandObj.GeneralSpinner);
        if (PCN_ManagerObj.Impacted_Parts_Tab_Filter_Table.isDisplayed()) {
            Assert.assertTrue((PCN_ManagerObj.Impacted_Parts_Tab_Filter_Table.isDisplayed()));
        } else {
            System.out.println("Assertion for Impacted Parts Tab Filter Table is Failed");
        }

    }

}