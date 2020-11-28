package E2ETS;

import Com.PartRisk.Pages.Landing_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A_1_Parametric_Search extends Test_Base {
    Landing_Page LandObj;

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate Parametric Search")
    public void Parametric_Search() {
        LandObj = new Landing_Page(driver);

        Wait_Element_Visible(LandObj.Parametric_Menu);
        LandObj.ParametricSearch();
        Assert.assertTrue(driver.getCurrentUrl().contains("/keysearch?ProductId=12292"));
    }
}

