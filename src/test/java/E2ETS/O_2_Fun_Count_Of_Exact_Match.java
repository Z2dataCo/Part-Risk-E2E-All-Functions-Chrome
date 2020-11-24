package E2ETS;

import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.Scrub_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class O_2_Fun_Count_Of_Exact_Match extends Test_Base {
    Landing_Page LandObj;
    Data_Management_Page DManagementObj;
    Scrub_Page ScrubPageObj;

    @Test(priority = 15)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate To Count Exact Match in Scrub Page ")
    public void Count_Exact_Match_in_Scrub() throws InterruptedException {
        DManagementObj = new Data_Management_Page(driver);
        LandObj = new Landing_Page(driver);
        ScrubPageObj = new Scrub_Page(driver);
        LandObj.Z2D_Open_Data_Management();
      Wait_for_Element_to_Disappear(LandObj.GeneralSpinner);
        DManagementObj.Z2D_Search(Z2DataFolderName);
        DManagementObj.SetFile(); // hna
        Thread.sleep(1000);
        DManagementObj.Z2D_Open_BOM();
        Thread.sleep(2000);
        Switch_Tabs();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        DManagementObj.Z2D_Open_Scrub();
        Thread.sleep(10000);
        int FixedNum = Integer.parseInt(ScrubPageObj.FixedNumber.getText());
        if (ScrubPageObj.Last.isEnabled()) {
            int tableRows = DManagementObj.Table_Rows.size();
            Thread.sleep(3000);
            ScrubPageObj.Z2D_Last_Pagination();
            Thread.sleep(3000);
            int PaginationSize = Integer.parseInt(ScrubPageObj.LastPage.getText());
            int Pagination = PaginationSize - 1;
            int SupTotal = Pagination * tableRows;
            int lastPageSize = FixedNum - SupTotal;
            int AllTableRows = lastPageSize + SupTotal;
            Assert.assertEquals(AllTableRows, FixedNum);
            System.out.println(AllTableRows);
            System.out.println(FixedNum);
        } else {
            int tableRows = DManagementObj.Table_Rows.size();
            int PaginationSize = Integer.parseInt(ScrubPageObj.LastPage.getText());
            int Pagination = PaginationSize;
            int SupTotal = Pagination * tableRows;
            int lastPageSize = FixedNum - SupTotal;
            int AllTableRows = lastPageSize + SupTotal;
            Assert.assertEquals(AllTableRows, FixedNum);
            //System.out.println("Expected Result Is: "+AllTableRows);
            //System.out.println("Actual Result Is: "+FixedNum);

        }

    }
}
