package E2ETS;

import Com.PartRisk.Pages.Compare_Page;
import Com.PartRisk.Pages.Landing_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class I_Compare extends Test_Base {
    Compare_Page CompareObj;
    Landing_Page LandObj;

    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate To Compare Between Item")
    public void Compare_Parts() throws InterruptedException {

        LandObj = new Landing_Page(driver);
        CompareObj = new Compare_Page(driver);
        LandObj.Z2D_Open_Compare_Page();
        Refresh();
        Wait_Element_Clickable(CompareObj.Compare1);
        CompareObj.Compare1.click();
        CompareObj.Z2D_Input_Compare_1(Z2DataCompare_1);
        Wait_Element_Clickable(CompareObj.Value_Compare1);
        CompareObj.SetValue1();
        Wait_Element_Clickable(CompareObj.Compare2);
        CompareObj.Compare2.click();
        CompareObj.Z2D_Input_Compare_2(Z2DataCompare_2);
        CompareObj.SetValue2();
        CompareObj.Z2D_Select_Differences();
        CompareObj.Z2D_Select_Similarities();
    }
}