package Com.PartRisk.Pages;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Delete_BOM_Page extends Page_Base {
    Actions Action;
    int i = 2;


    @FindBy(xpath = "/html/body/modal-container/div/div/div/button[1]")
    public WebElement Yes_Button;
    //@FindBy(className = "btn btn-primary")
    //public WebElement No_Button;
    @FindBy(xpath = "//table[@class='table table-bordered table-striped bg-white mt-05 mb-0']/tbody/tr")
    public List<WebElement> BOMs_Table;
    @FindBy(xpath = "//div[@class='actionbar-right mr-1']//span[2]")
    public WebElement Showing_of_Status;
    //@FindBy(xpath = "//table[@class='table table-bordered table-striped bg-white mt-05 mb-0']/tbody/tr[2]/td[2]/a[1]")
    // public WebElement BOM_Name;
    @FindBy(xpath = "//div[@class='actionbar-right mr-1']//span[2]")
    public WebElement Total_Results_Shown;
    @FindBy(xpath = "//span[contains(text(),'Create Sub Folder')]")
    public WebElement Creat_Sub_Folder_Button;


    public Delete_BOM_Page(WebDriver driver) {
        super(driver);
    }

    public void Z2D_Click_on_Check_Box() {
        Click_Button(Showing_of_Status);
    }

    //public void Z2D_Click_on_Yes(){Click_Button(Yes_Button);}
    public void Z2D_Deleting_BOMs(WebDriver driver) throws InterruptedException {

        while (!(driver.findElement(By.xpath("//div[@class='actionbar-right mr-1']//span[2]")).getText()).equals("1")) {
            System.out.println("Looping Here1");
            System.out.println((Total_Results_Shown.getText()));
            while (!driver.findElement(By.xpath("//table[@class='table table-bordered table-striped bg-white mt-05 mb-0']/tbody/tr[" + i + "]/td[2]/a[1]")).getText().equals("TAP_BOM_Proud_Test")) {
                if (Creat_Sub_Folder_Button.isDisplayed()) {
                    ;
                    String Button_Label = Creat_Sub_Folder_Button.getText();
                    Assert.assertEquals("Create Sub Folder", Button_Label);
                    System.out.println("Looping Here2");
                    System.out.println((driver.findElement(By.xpath("//table[@class='table table-bordered table-striped bg-white mt-05 mb-0']/tbody/tr[" + i + "]/td[2]/a[1]")).getText()));
                    boolean staleElement2 = true;
                    while (staleElement2) {
                        System.out.println("Looping Here2-1");
                        try {
                            driver.findElement(By.xpath("//tbody//tr[" + i + "]//a[contains(text(),'Delete')]")).click();
                            staleElement2 = false;
                        } catch (StaleElementReferenceException e) {
                            staleElement2 = true;
                        }
                    }
                    Thread.sleep(2000);
                    Action = new Actions(driver);
                    Action.moveToElement(Yes_Button).click().build().perform();
                    Thread.sleep(4000);
                } else {
                    System.out.println("Page has been Reloaded and redirected to Folder Page");
                }
            }
            System.out.println("Looping Here3");
            Thread.sleep(2000);
            i++;
        }

    }

}
