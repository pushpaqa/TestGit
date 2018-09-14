package com.create4.scenarios;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
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

/*
 * Check for Iec annexures submission forms update functionality
 */
public class TS_33 {

	public TS_33() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

    GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[6]/a")
	WebElement IECSubmissionForms;

	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/h3")
	WebElement IECSubmissionFormsTXT;

	// -----Check for 'Edit' annexures from list---//
	public void CRe4_1132() throws Exception {
		// ----------PI Login------------//
        GlobalMethods.Admin_Login();
		
		
		WebElement IECSubmissionForms = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[6]/a");
		IECSubmissionForms.click();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");

		String IECSubFormTXT_data = r.getCell(2, 228).getContents();

		// ----IECSubmissionFormsTXT----//
		Thread.sleep(1000);
		System.out.println(IECSubmissionFormsTXT.getText());
		if (IECSubmissionFormsTXT.getText().equalsIgnoreCase(IECSubFormTXT_data)) {
			System.out.println(IECSubmissionFormsTXT.getText().equalsIgnoreCase(IECSubFormTXT_data));
		} else {
			System.out.println("Test Fail IECSubmissionFormsTXT");
		}

		// ---Check for Edit document---//

		// --Check for 'Action>>Edit' field--//
		Thread.sleep(4500);
		WebElement table_element = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows = (ArrayList<WebElement>) table_element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.cssSelector(".fa.fa-edit"));
			for (WebElement cell : cells) {
				cell.click();
				WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
				logoutt.click();
				break;
			}
			break;
		}
		

	}

	@FindBy(xpath = "//button[@type='button']")
	WebElement ProjectType;
	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/div[4]/div/form/div[1]/div/div/div/div/ul/li")
	List<WebElement> ProjectTypeList;

	@FindBy(xpath = "//html/body/div[5]/div[1]/div[3]/div[4]/div[1]/form/div/div[2]/div[1]/div/div/button")
	WebElement ReviewType;
	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/div[4]/div/form/div[2]/div/div/div/div/ul/li")
	List<WebElement> ReviewTypeList;

	@FindBy(xpath = "//div[1]/div/div[2]/div[4]/div/form/div[3]/div/div/div/button")
	WebElement SubmissionType;
	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/div[4]/div/form/div[3]/div/div/div/div/ul/li")
	List<WebElement> SubmissionTypeList;

	@FindBy(xpath = "//div[1]/div/div[2]/div[4]/div/form/div[4]/div/div/div/button")
	WebElement DocumentType;
	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/div[4]/div/form/div[4]/div/div/div/div/ul/li")
	List<WebElement> DocumentTypeList;

	@FindBy(id = "add_annexure_document_upload")
	WebElement DocumentUpload;
	@FindBy(id = "add_edit_annexure_details")
	WebElement Update;

	@FindBy(css=".logout")
	WebElement LogOut;
	
	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/div[4]/div/form/div[1]/div/div/div/div/ul/li")
	public static List<WebElement> projtypvalue;
	
	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/div[4]/div/form/div[2]/div/div/div/div/ul/li")
	public static List<WebElement> revtypvalue;
	
	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/div[4]/div/form/div[3]/div/div/div/div/ul/li")
	public static List<WebElement> subtypvalue;
	// ---Check for 'Edit' annexures with blank data--//
	public void CRe4_1133() throws Exception {
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");

		String ProjectType_alert = r.getCell(2, 230).getContents();
		String ReviewType_alert = r.getCell(3, 230).getContents();
		String SubmissionType_alert = r.getCell(4, 230).getContents();
		String DocumentType_alert = r.getCell(5, 230).getContents();
		String UploadDoc_alert = r.getCell(6, 230).getContents();
		
		
		GlobalMethods.Admin_Login();
		
		
		WebElement IECSubmissionForms = GWait.Wait_GetElementByXpath("//html/body/div[3]/div/div[2]/ul/li[6]/a");
		IECSubmissionForms.click();
		
		
		Thread.sleep(2000);
		WebElement edit = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		edit.click();
		Thread.sleep(2000);
		
		WebElement projtypdrop = GWait.Wait_GetElementByXpath("//html/body/div[4]/div[1]/div/div[2]/div[4]/div/form/div[1]/div/div/div/button");
		projtypdrop.click();
		Thread.sleep(2000);

		List<WebElement> elementsList11 = projtypvalue;
		for (WebElement a11 : elementsList11) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase("Select Project Type")) {
				span.click();
				break;
			}
		}
		
		WebElement Update1 = GWait.Wait_GetElementById("add_edit_annexure_details");
		Update1.click();
		
		System.out.println(alert_proj.getText());
		Assert.assertEquals(alert_proj.getText().trim(), ProjectType_alert);
		
		
		WebElement projtypdrop1 = GWait.Wait_GetElementByXpath("//html/body/div[4]/div[1]/div/div[2]/div[4]/div/form/div[1]/div/div/div/button");
		projtypdrop1.click();
		Thread.sleep(2000);

		List<WebElement> elementsList111 = projtypvalue;
		for (WebElement a11 : elementsList111) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase("Pharma/Industry")) {
				span.click();
				break;
			}
		}
		
		WebElement revtypdrop = GWait.Wait_GetElementByXpath("//html/body/div[4]/div[1]/div/div[2]/div[4]/div/form/div[2]/div/div/div/button");
		revtypdrop.click();
		Thread.sleep(2000);

		List<WebElement> elementsList2 = revtypvalue;
		for (WebElement a11 : elementsList2) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase("Select Review Type")) {
				span.click();
				break;
			}
		}
		
		WebElement Update2 = GWait.Wait_GetElementById("add_edit_annexure_details");
		Update2.click();
		Thread.sleep(2000);
		Assert.assertEquals(alert_rew.getText().trim(), ReviewType_alert);
		
		WebElement revtypdrop1 = GWait.Wait_GetElementByXpath("//html/body/div[4]/div[1]/div/div[2]/div[4]/div/form/div[2]/div/div/div/button");
		revtypdrop1.click();
		Thread.sleep(2000);

		List<WebElement> elementsList3 = revtypvalue;
		for (WebElement a11 : elementsList3) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase("Full Board Review")) {
				span.click();
				break;
			}
		}
		
		
		WebElement subtypdrop = GWait.Wait_GetElementByXpath("//html/body/div[4]/div[1]/div/div[2]/div[4]/div/form/div[3]/div/div/div/button");
		subtypdrop.click();
		Thread.sleep(2000);

		List<WebElement> elementsList1111 = subtypvalue;
		for (WebElement a11 : elementsList1111) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase("Select Submission Type")) {
				span.click();
				break;
			}
		}
		
		WebElement Update3 = GWait.Wait_GetElementById("add_edit_annexure_details");
		Update3.click();
		
		Thread.sleep(2000);
		Assert.assertEquals(alert_sub.getText().trim(), SubmissionType_alert);
		
		WebElement subtypdrop1 = GWait.Wait_GetElementByXpath("//html/body/div[4]/div[1]/div/div[2]/div[4]/div/form/div[3]/div/div/div/button");
		subtypdrop1.click();
		Thread.sleep(2000);

		List<WebElement> elementsList4 = subtypvalue;
		for (WebElement a11 : elementsList4) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase("Project Initial Submission")) {
				span.click();
				break;
			}
		}
		
		WebElement doc = GWait.Wait_GetElementById("add_annexure_document_type");
		Select select = new Select(doc);
		select.selectByVisibleText("Select Document Type");
		
		WebElement Update4 = GWait.Wait_GetElementById("add_edit_annexure_details");
		Update4.click();
		Thread.sleep(2000);
		Assert.assertEquals(alert_doc.getText().trim(), DocumentType_alert);
		
		/*WebElement uploadclear = GWait.Wait_GetElementById("add_annexure_document_upload");
		uploadclear.clear();
		Thread.sleep(2000);
		Assert.assertEquals(alert_upload.getText().trim(), UploadDoc_alert);*/
		
			
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
				
	}
			
		
	@FindBy(xpath = "//form[@id='addannexures']/div/div/div/small")
	WebElement alert_proj;
	
	@FindBy(xpath = "//form[@id='addannexures']/div[2]/div/div/small")
	WebElement alert_rew;
	
	@FindBy(xpath = "//form[@id='addannexures']/div[3]/div/div/small")
	WebElement alert_sub;
	
	@FindBy(xpath = "//form[@id='addannexures']/div[4]/div/div/small")
	WebElement alert_doc;
	
	@FindBy(xpath = "//form[@id='addannexures']/div[5]/div/div/small[2]")
	WebElement alert_upload;
	
	
		
	
	
      public void CRe4_1134_1135() throws Exception {

		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");
		
		String UploadDocument_jpg = r.getCell(2, 232).getContents();
		String UploadDocument_png = r.getCell(3, 232).getContents();
		String UploadDocument_gif = r.getCell(4, 232).getContents();
		String UploadDocument_bmp = r.getCell(5, 232).getContents();
		String upload_acknowledge = r.getCell(6, 232).getContents();
		
		String UploadDocument_doc = r.getCell(7, 232).getContents();
		String UploadDocument_docx = r.getCell(8, 232).getContents();
		String UploadDocument_pdf = r.getCell(9, 232).getContents();
		
		Thread.sleep(6000);
		GlobalMethods.Admin_Login();
		
		WebElement IECSubmissionFrom = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[6]/a");
		IECSubmissionFrom.click();
		Thread.sleep(2000);
		WebElement editlink = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
		editlink.click();
		
		try 
		{ 
			if(docinedit.isDisplayed())
			{
			System.out.println(docinedit.getText());
		    System.out.println("File present");
			}
			else
			{
			    System.out.println("File not present");
			}  
		}  
		catch (NoAlertPresentException e) 
		{ 
		e.getMessage();
		}
		
		WebElement DocumentUpload = GWait.Wait_GetElementById("add_annexure_document_upload"); 
		DocumentUpload.sendKeys(UploadDocument_jpg);
		
		WebElement Update = GWait.Wait_GetElementById("add_edit_annexure_details");
		Update.click();
					
		Assert.assertEquals(uploadalert.getText(), upload_acknowledge);
		System.out.println(uploadalert.getText());
		
		WebElement DocumentUpload1 = GWait.Wait_GetElementById("add_annexure_document_upload"); 
		DocumentUpload1.sendKeys(UploadDocument_png);
		
		WebElement Update1 = GWait.Wait_GetElementById("add_edit_annexure_details");
		Update1.click();
		
		Assert.assertEquals(uploadalert.getText(), upload_acknowledge);
		System.out.println(uploadalert.getText());
		
		WebElement DocumentUpload2 = GWait.Wait_GetElementById("add_annexure_document_upload"); 
		DocumentUpload2.sendKeys(UploadDocument_gif);
				
		WebElement Update2 = GWait.Wait_GetElementById("add_edit_annexure_details");
		Update2.click();
		
		Assert.assertEquals(uploadalert.getText(), upload_acknowledge);
		System.out.println(uploadalert.getText());
		
		WebElement DocumentUpload3 = GWait.Wait_GetElementById("add_annexure_document_upload"); 
		DocumentUpload3.sendKeys(UploadDocument_bmp);
		
		WebElement Update3 = GWait.Wait_GetElementById("add_edit_annexure_details");
		Update3.click();
		
		Assert.assertEquals(uploadalert.getText(), upload_acknowledge);
		System.out.println(uploadalert.getText());
		
		WebElement DocumentUpload4 = GWait.Wait_GetElementById("add_annexure_document_upload"); 
		DocumentUpload4.sendKeys(UploadDocument_doc);
		
		WebElement DocumentUpload5 = GWait.Wait_GetElementById("add_annexure_document_upload"); 
		DocumentUpload5.sendKeys(UploadDocument_docx);
		
		WebElement DocumentUpload6 = GWait.Wait_GetElementById("add_annexure_document_upload"); 
		DocumentUpload6.sendKeys(UploadDocument_pdf);
		
		
		
		
		WebElement Update4 = GWait.Wait_GetElementById("add_edit_annexure_details");
		Update4.click();
		
							
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
	}

      @FindBy(xpath = "//form[@id='addannexures']/div[5]/div/div/div/a")
  	WebElement docinedit;
      
      @FindBy(xpath = "//form[@id='addannexures']/div[5]/div/div/small")
  	WebElement uploadalert;

}
