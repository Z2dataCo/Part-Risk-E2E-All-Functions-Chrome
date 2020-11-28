package E2ETS;

import Com.PartRisk.Pages.Landing_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;


public class L_2_Fun_Search_Part_Number extends Test_Base {
    Landing_Page LandObj;

    @Test(priority = 12)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate To Search By Part Number")
    public void Search_with_Part_Number() {
        LandObj = new Landing_Page(driver);

        Wait_Element_Visible(LandObj.Search_Input);
        LandObj.Z2D_input_Search(Z2DataPartNumber);
        LandObj.Z2D_Click_Search();
        Wait_Element_Clickable(LandObj.Supp_ChkBox);
        LandObj.Z2D_Check_Supplier();
        Assert.assertEquals(LandObj.PartName.getText(), "bav99");
    }
}
