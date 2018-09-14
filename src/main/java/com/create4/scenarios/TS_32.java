package com.create4.scenarios;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

//***Check for add Iec annexures list/view/download document***//
public class TS_32 {
	public TS_32() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

    GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[6]/a")
	WebElement IECSubmissionForms;

	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/h3")
	WebElement IECSubmissionFormsTXT;
	
	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/h3")
	WebElement IECSubmissionFormsAnnexures;

	// -----Check for 'IEC Submission Forms / Annexures'---//
	public void CRe4_1109() throws Exception {
		
		GlobalMethods.Admin_Login();
		
		WebElement IECSubmissionFrom = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[6]/a");
		IECSubmissionFrom.click();
			

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");

		String IECSubmissionFormsAnnexures_textData = r.getCell(2, 226).getContents();
		String AddAnnexure_Data = r.getCell(3, 226).getContents();

		// ----IECSubmissionFormsAnnexures----//
		Thread.sleep(1000);

		System.out.println(IECSubmissionFormsAnnexures.getText());
		if (IECSubmissionFormsAnnexures.getText().equalsIgnoreCase(IECSubmissionFormsAnnexures_textData)) {
			System.out.println(
					IECSubmissionFormsAnnexures.getText().equalsIgnoreCase(IECSubmissionFormsAnnexures_textData));
		} else {
			System.out.println("Test Fail IECSubmissionFormsAnnexures");
		}
		
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	// ---Check for tablular list fields---//
	public void CRe4_1123() throws Exception {
		
		GlobalMethods.Admin_Login();
		
		WebElement IECSubmissionForms = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[6]/a");
		IECSubmissionForms.click();

		// --Check for 'Table Header' field--//
		Thread.sleep(4500);
		WebElement table_element = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>thead"));
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//th"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
			}
		}
		
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}

	// ---Check for actions field features---//
	public void CRe4_1124() throws Exception {
		GlobalMethods.Admin_Login();
		WebElement IECSubmissionForms = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[6]/a");
		IECSubmissionForms.click();

		// --Check for 'Action' field--//
		Thread.sleep(4500);
		WebElement table_element = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[9]/a"));
			for (WebElement cell : cells) {
				System.out.println(cell.getAttribute("title"));
				System.out.println(cell.getText());
			}
			break;
		}
		
	
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
	}
	
	@FindBy(css=".logout")
	WebElement LogOut;
	// ---Check for download document---//
	public void CRe4_1125() throws Exception {
		
		
		GlobalMethods.Admin_Login();
		
		WebElement IECSubmissionForms = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[6]/a");
		IECSubmissionForms.click();
		
		

		// --Check for 'Action>>Download' field--//
		Thread.sleep(4500);
		WebElement table_element = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.cssSelector(".fa.fa-cloud-download"));
			for (WebElement cell : cells) {
				if (cell.getAttribute("title").equalsIgnoreCase("Download")) {
					cell.click();
					Thread.sleep(2000);
					GlobalMethods.AcceptDoenloadPopup();
					WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
					LogOut.click();
				}
				break;
			}
			break;
		}
		
	}


}
