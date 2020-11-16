package E2ETS;

import Com.PartRisk.Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C_Upload_BOM_and_Switcher extends Test_Base {
    Landing_Page LandObj;
    Upload_BOM_Page UpBOMObj;
    Data_Management_Page DManagementObj;
    Mitigation_Page MitigationObj;
    Parts_Page PartsObj;
    Forecast_Page ForecastObj;

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate User Upload BOM")
    public void User_Upload_BOM() throws Throwable {
        LandObj = new Landing_Page(driver);
        UpBOMObj = new Upload_BOM_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        MitigationObj = new Mitigation_Page(driver);
        PartsObj = new Parts_Page(driver);
        ForecastObj = new Forecast_Page(driver);

        LandObj.Z2D_Upload_BOM(Z2DataSwitcherStepFilePath);
        Wait_Element_Clickable(UpBOMObj.Next);
        UpBOMObj.Z2D_Click_Next();
        Thread.sleep(5000);
        Wait_for_Element_to_Disappear(LandObj.GeneralSpinner);
        UpBOMObj.Z2D_Select_Type();
        WaitAllElement();
        UpBOMObj.Z2D_Supplier_Selection();
        UpBOMObj.Z2D_Select_Type();
        UpBOMObj.Z2D_MPN_Select();
        UpBOMObj.Z2D_Open_Column();
        UpBOMObj.Z2D_Supplier_Selection();
        UpBOMObj.Z2D_Open_Column();
        Wait_Element_Clickable(UpBOMObj.Mapped_IPN);
        UpBOMObj.Z2D_Mapped_IPN();
        Wait_Element_Clickable(UpBOMObj.Next_Step);
        UpBOMObj.Z2D_Second_Step();
        UpBOMObj.Z2D_Select_Folder();
        UpBOMObj.Z2D_Selected_Folder();
        UpBOMObj.Z2D_Finish();
        Wait_for_Element_to_Disappear(LandObj.GeneralSpinner);

        Wait_Element_Visible(UpBOMObj.Dashboard_Tab);
        Assert.assertEquals(UpBOMObj.Dashboard_Tab.getText(), "Dashboard");
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);

        UpBOMObj.Z2D_Click_Scrub_Tab();
        Assert.assertEquals(UpBOMObj.Scrub_Tab.getText(), "Scrub");
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);

        UpBOMObj.Z2D_Click_Parts_Tab();
        Assert.assertEquals(UpBOMObj.Parts_Tab.getText(), "Parts");
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        PartsObj.Z2D_Select_Switcher();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        PartsObj.Z2D_Select_Switcher();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);

        UpBOMObj.Z2D_Click_Forecast_Tab();
        Assert.assertEquals(UpBOMObj.Forecast_Tab.getText(), "Forecast");
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        ForecastObj.Z2D_Select_Switcher();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        ForecastObj.Z2D_Select_Switcher();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);

        UpBOMObj.Z2D_Click_Compliance_Tab();
        Assert.assertEquals(UpBOMObj.Compliance_Tab.getText(), "Compliance");
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);

        UpBOMObj.Z2D_Click_Mitigation_Tab();
        Assert.assertEquals(UpBOMObj.Mitigation_Tab.getText(), "Mitigation");
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        MitigationObj.Z2D_Select_Switcher();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        MitigationObj.Z2D_Select_Switcher();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);

        UpBOMObj.Z2D_Click_Reports_Tab();
        Assert.assertEquals(UpBOMObj.Reports_Tab.getText(), "Reports");
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);

    }


}


