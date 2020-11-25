package E2ETS;

import Com.PartRisk.Pages.Compare_Page;
import Com.PartRisk.Pages.Landing_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class I_1_Compare extends Test_Base {
    Compare_Page CompareObj;
    Landing_Page LandObj;
    Actions act;

    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate To Compare Between Item")
    public void Compare_Parts() throws InterruptedException {

        LandObj = new Landing_Page(driver);
        CompareObj = new Compare_Page(driver);
        act = new Actions(driver);
        LandObj.Z2D_Open_Compare_Page();
        WaitElement();
        Wait_Element_Visible(CompareObj.Compare1);
        CompareObj.Z2D_Input_Compare_1(Z2DataCompare_1);
        Wait_Element_Clickable(CompareObj.Value_Compare1);
        boolean staleElement = true;
        while (staleElement) {
            try {
                act.moveToElement(CompareObj.Value_Compare1).click().build().perform();;
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }
        Thread.sleep(3000);
        Wait_Element_Visible(CompareObj.Compare2);
        CompareObj.Z2D_Input_Compare_2(Z2DataCompare_2);
        Wait_Element_Clickable(CompareObj.Value_Compare2);
        boolean staleElement1 = true;
        while (staleElement1) {
            try {
                act.moveToElement(CompareObj.Value_Compare2).click().build().perform();;
                staleElement1 = false;
            } catch (StaleElementReferenceException e) {
                staleElement1 = true;
            }
        }

        Wait_Element_Visible(CompareObj.Differences);
        CompareObj.Z2D_Select_Differences();
        CompareObj.Z2D_Select_Similarities();
    }
}