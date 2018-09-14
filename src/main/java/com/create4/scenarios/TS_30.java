package com.create4.scenarios;

import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

//***Check for add IEC annexures with valid/invalid data***//
public class TS_30 {

	public TS_30() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}
   GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
   Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[6]/a")
	WebElement IECSubmissionFrom;
	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/h3")
	WebElement IECSubmissionFormsAnnexures;

	@FindBy(xpath = "//div[1]/div/div[1]/div/li/div/ul/li[2]/div/a")
	WebElement AddIECSubmissionFrom;
	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/h3")
	WebElement AddAnnexure;
	@FindBy(css=".logout")
	WebElement LogOut;

	// ----Check for 'IEC Submission Forms / Annexures '----//
	public void AddIECSubmission_CRe4_1109() throws Exception {
		// ----------IEC Admin Login------------//
		
		GlobalMethods.Admin_Login();
		WebElement IECSubmissionFrom = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[6]/a");
		IECSubmissionFrom.click();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");

		String IECSubmissionFormsAnnexures_textData = r.getCell(2,178).getContents();
		
		// ----IECSubmissionFormsAnnexures----//
		WebElement IECSubmissionFormsAnnexures = GWait.Wait_GetElementByXpath("//h3");

		System.out.println(IECSubmissionFormsAnnexures.getText());
		
		Assert.assertEquals(IECSubmissionFormsAnnexures.getText(), IECSubmissionFormsAnnexures_textData);
		
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();

	}

	// ---Text verification---//
	@FindBy(xpath = "//div[2]/div[4]/div/form/div[1]/div/label")
	WebElement ProjectTypeTXT;
	@FindBy(xpath = "//div[2]/div[4]/div/form/div[2]/div/label")
	WebElement ReviewTypeTXT;
	@FindBy(xpath = "//div[2]/div[4]/div/form/div[3]/div/label")
	WebElement SubmissionTypeTXT;
	@FindBy(xpath = "//div[2]/div[4]/div/form/div[4]/div/label")
	WebElement DocumentTypeTXT;
	@FindBy(xpath = "//div[2]/div[4]/div/form/div[5]/div/div/span")
	WebElement UploadDocumentTXT;

	// ---Value---//
	@FindBy(xpath = "//div[4]/div/form/div[1]/div/div/div/button")
	WebElement ProjectType;
	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/div[4]/div/form/div[1]/div/div/div/div/ul/li")
	List<WebElement> ProjectTypeList;

	@FindBy(xpath = "//div[4]/div/form/div[2]/div/div/div/button")
	WebElement ReviewType;
	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/div[4]/div/form/div[2]/div/div/div/div/ul/li")
	List<WebElement> ReviewTypeList;

	@FindBy(xpath = "//div[4]/div/form/div[3]/div/div/div/button")
	WebElement SubmissionType;
	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/div[4]/div/form/div[3]/div/div/div/div/ul/li")
	List<WebElement> SubmissionTypeList;

	@FindBy(id = "add_annexure_document_type")
	WebElement DocumentType;
	@FindBy(xpath = "//div[4]/div/form/div[4]/div/div/div/div/ul/li")
	List<WebElement> DocumentTypeList;

	@FindBy(id = "add_annexure_document_upload")
	WebElement UploadDocument;
	@FindBy(id = "add_edit_annexure_details")
	WebElement Submit;

	// ---Check for Add IEC submission form / annexure---//
	public void AddIECSubmission_CRe4_1111() throws Exception {
		GlobalMethods.Admin_Login();
		WebElement IECSubmissionFrom1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[6]/a");
		IECSubmissionFrom1.click();
		WebElement AddIECSubmissionFrom1 = GWait.Wait_GetElementByXpath("//div[1]/div/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECSubmissionFrom1.click();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");

		
		String ProjectTypeTXT_Data = r.getCell(2,180).getContents();
		String ReviewTypeTXT_Data = r.getCell(3,180).getContents();
		String SubmissionTypeTXT_Data = r.getCell(4,180).getContents();
		String DocumentTypeTXT_Data = r.getCell(5,180).getContents();
		String UploadDocumentTXT_Data = r.getCell(6,180).getContents();
		String Submit_Data = r.getCell(7,180).getContents();
		String AddAnnexure_Data = r.getCell(8,180).getContents();
		
		// ----AddAnnexure----//
		WebElement AddAnnexure = GWait.Wait_GetElementByXpath("html/body/div[4]/div[1]/div/div[2]/h3");

		System.out.println(AddAnnexure.getText());
		
		Assert.assertEquals(AddAnnexure.getText(), AddAnnexure_Data);
		
		// ----ProjectTypeTXT----//
		Assert.assertEquals(ProjectTypeTXT.getText(), ProjectTypeTXT_Data);

		System.out.println(ProjectTypeTXT.getText());
		
		Assert.assertEquals(ReviewTypeTXT.getText(), ReviewTypeTXT_Data);
		System.out.println(ReviewTypeTXT.getText());
		
		Assert.assertEquals(SubmissionTypeTXT.getText(), SubmissionTypeTXT_Data);
		System.out.println(SubmissionTypeTXT.getText());
		
		Assert.assertEquals(DocumentTypeTXT.getText(), DocumentTypeTXT_Data);
		System.out.println(DocumentTypeTXT.getText());
		
		Assert.assertEquals(UploadDocumentTXT.getText(), UploadDocumentTXT_Data);
		System.out.println(UploadDocumentTXT.getText());
		
		Assert.assertEquals(Submit.getAttribute("value"),Submit_Data);
		
		WebElement LogOut1 = GWait.Wait_GetElementByCSS(".logout");
		LogOut1.click();

	}

	// -----Alert-------//
	@FindBy(xpath = "//div[2]/div[4]/div/form/div[1]/div/div/small[1]")
	WebElement ProjectTypeAlert;
	@FindBy(xpath = "//div[2]/div[4]/div/form/div[2]/div/div/small[1]")
	WebElement ReviewTypeAlert;
	@FindBy(xpath = "//div[2]/div[4]/div/form/div[3]/div/div/small[1]")
	WebElement SubmissionTypeAlert;
	@FindBy(xpath = "//div[2]/div[4]/div/form/div[4]/div/div/small[1]")
	WebElement DocumentTypeAlert;
	@FindBy(xpath = "//div[5]/div/div/small[2]")
	WebElement UploadDocumentAlert;

	// ---Check for add annexure with blank data---//
	public void AddIECSubmission_CRe4_1121() throws Exception {
		GlobalMethods.Admin_Login();
		WebElement IECSubmissionFrom2 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[6]/a");
		IECSubmissionFrom2.click();
		WebElement AddIECSubmissionFrom2 = GWait.Wait_GetElementByXpath("//div[1]/div/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECSubmissionFrom2.click();
		
		WebElement Submit = GWait.Wait_GetElementById("add_edit_annexure_details");
		Submit.click();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");

		String ProjectTypeAlert_Data = r.getCell(2,184).getContents();
		String ReviewTypeAlert_Data = r.getCell(3,184).getContents();
		String SubmissionTypeAlert_Data = r.getCell(4,184).getContents();
		String DocumentTypeAlert_Data = r.getCell(5,184).getContents();
		String UploadDocumentAlert_Data = r.getCell(6,184).getContents();

		// ----ProjectTypeAlert----//
		WebElement ProjectTypeAlert2 = GWait.Wait_GetElementByXpath("//div[2]/div[4]/div/form/div[1]/div/div/small[1]");

		System.out.println(ProjectTypeAlert2.getText());
		
		Assert.assertEquals(ProjectTypeAlert.getText(), ProjectTypeAlert_Data);
		
		System.out.println(ReviewTypeAlert.getText());
		
		Assert.assertEquals(ReviewTypeAlert.getText(), ReviewTypeAlert_Data);
		
		System.out.println(SubmissionTypeAlert.getText());
		
		Assert.assertEquals(SubmissionTypeAlert.getText(), SubmissionTypeAlert_Data);
	
		System.out.println(DocumentTypeAlert.getText());
		
		Assert.assertEquals(DocumentTypeAlert.getText(), DocumentTypeAlert_Data);
		
		System.out.println(UploadDocumentAlert.getText());
		
		Assert.assertEquals(UploadDocumentAlert.getText(), UploadDocumentAlert_Data);
		

		WebElement LogOut2 = GWait.Wait_GetElementByCSS(".logout");
		LogOut2.click();
	}

	// ---Check for all type drop down field values---//
	public void AddIECSubmission_CRe4_1113__1116_1122() throws Exception {
		
		GlobalMethods.Admin_Login();
		WebElement IECSubmissionFrom3 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[6]/a");
		IECSubmissionFrom3.click();
		WebElement AddIECSubmissionFrom3 = GWait.Wait_GetElementByXpath("//div[1]/div/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECSubmissionFrom3.click();
		

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");

		String ProjectType_Data = r.getCell(2,182).getContents();
		String ReviewType_Data = r.getCell(3,182).getContents();
		String SubmissionType_Data = r.getCell(4,182).getContents();
		String DocumentType_Data = r.getCell(5,182).getContents();
		String UploadDocument_Data = r.getCell(6,182).getContents();

		WebElement ProjectType3 = GWait.Wait_GetElementByXpath("//div[4]/div/form/div[1]/div/div/div/button");
		ProjectType3.click();
		
		List<WebElement> elementsList = ProjectTypeList;
		for (WebElement a : elementsList) {
			WebElement span = a.findElement(By.tagName("span"));
			System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(ProjectType_Data)) {
				
				span.click();
				break;
			}

		}
		WebElement ReviewType3 = GWait.Wait_GetElementByXpath("//div[4]/div/form/div[2]/div/div/div/button");
		ReviewType3.click();
		List<WebElement> elementsList1 = ReviewTypeList;
		for (WebElement a1 : elementsList1) {
			WebElement span = a1.findElement(By.tagName("span"));
			System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(ReviewType_Data)) {
				
				span.click();
				break;
			}

		}
		WebElement SubmissionType3 = GWait.Wait_GetElementByXpath("//div[4]/div/form/div[3]/div/div/div/button");
		SubmissionType3.click();
		List<WebElement> elementsList2 = SubmissionTypeList;
		for (WebElement a2 : elementsList2) {
			WebElement span = a2.findElement(By.tagName("span"));
			System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(SubmissionType_Data)) {
				
				span.click();
				break;
			}

		}
		
		Select Document = new Select(DocumentType);
		Document.selectByVisibleText("Final Completion Report");
		
		WebElement UploadDocument3 = GWait.Wait_GetElementById("add_annexure_document_upload");
		UploadDocument3.sendKeys(UploadDocument_Data);
		WebElement Submit3 = GWait.Wait_GetElementById("add_edit_annexure_details");
		Submit3.click();
		
		WebElement LogOut3 = GWait.Wait_GetElementByCSS(".logout");
		LogOut3.click();
	}

}
