package E2ETS;

import Com.PartRisk.Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C_1_Existing_BOM_and_Switcher extends Test_Base {
    Landing_Page LandObj;
    Upload_BOM_Page UpBOMObj;
    Data_Management_Page DManagementObj;
    Mitigation_Page MitigationObj;
    Parts_Page PartsObj;
    Forecast_Page ForecastObj;

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate User Upload BOM")
    public void Existing_BOM_and_Switcher() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        UpBOMObj = new Upload_BOM_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        MitigationObj = new Mitigation_Page(driver);
        PartsObj = new Parts_Page(driver);
        ForecastObj = new Forecast_Page(driver);
        Actions action = new Actions(driver);

        LandObj.Z2D_Open_Data_Management();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        DManagementObj.Z2D_Search(Z2DataFolderName);
        Thread.sleep(1000);
        action.moveToElement(DManagementObj.Test_Folder).click().perform();
        DManagementObj.Z2D_Open_BOM();
        Switch_Tabs();

        Wait_Element_Visible(UpBOMObj.Dashboard_Tab);
        Assert.assertEquals(UpBOMObj.Dashboard_Tab.getText(), "Dashboard");
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);

        Wait_Element_Visible(UpBOMObj.Scrub_Tab);
        UpBOMObj.Z2D_Click_Scrub_Tab();
        Assert.assertEquals(UpBOMObj.Scrub_Tab.getText(), "Scrub");
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);

        Wait_Element_Visible(UpBOMObj.Parts_Tab);
        UpBOMObj.Z2D_Click_Parts_Tab();
        Assert.assertEquals(UpBOMObj.Parts_Tab.getText(), "Parts");
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        PartsObj.Z2D_Select_Switcher();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        PartsObj.Z2D_Select_Switcher();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);

        Wait_Element_Visible(UpBOMObj.Forecast_Tab);
        UpBOMObj.Z2D_Click_Forecast_Tab();
        Assert.assertEquals(UpBOMObj.Forecast_Tab.getText(), "Forecast");
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        ForecastObj.Z2D_Select_Switcher();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        ForecastObj.Z2D_Select_Switcher();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);

        Wait_Element_Visible(UpBOMObj.Compliance_Tab);
        UpBOMObj.Z2D_Click_Compliance_Tab();
        Assert.assertEquals(UpBOMObj.Compliance_Tab.getText(), "Compliance");
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);

        Wait_Element_Visible(UpBOMObj.Mitigation_Tab);
        UpBOMObj.Z2D_Click_Mitigation_Tab();
        Assert.assertEquals(UpBOMObj.Mitigation_Tab.getText(), "Mitigation");
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        MitigationObj.Z2D_Select_Switcher();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        MitigationObj.Z2D_Select_Switcher();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);

        Wait_Element_Visible(UpBOMObj.Reports_Tab);
        UpBOMObj.Z2D_Click_Reports_Tab();
        Assert.assertEquals(UpBOMObj.Reports_Tab.getText(), "Reports");
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
    }
}