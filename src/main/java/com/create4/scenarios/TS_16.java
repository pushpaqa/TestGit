package com.create4.scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;
import com.sun.jna.platform.win32.WinGDI;
import jxl.Sheet;
import jxl.Workbook;

public class TS_16 {

	public TS_16() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	// --Add Project Document Type---//
	@FindBy(xpath = "html/body/div[4]/div[1]/div[1]/div[2]/h3")
	WebElement AddDocumentType_Title;
	// ---Add Documents Fields---//
	@FindBy(xpath = "//div[4]/div/form/div[1]/div/label")
	WebElement ProjectTypeTitle;
	@FindBy(xpath = "//div[4]/div/form/div[2]/div/label")
	WebElement reviewTypeTitle;
	@FindBy(xpath = "//div[4]/div/form/div[3]/div/label")
	WebElement SubmissionTypeTitle;
	@FindBy(xpath = "//div[4]/div/form/div[4]/div/label")
	WebElement DocumentTypeTitle;
	@FindBy(xpath = "//div[4]/div/form/div[5]/div/label")
	WebElement MandatoryTitle;

	// ---Add Documents Fields---//
	@FindBy(id = "add_annexure_project_type")
	WebElement ProjectType;
	@FindBy(id = "add_annexure_review_type")
	WebElement reviewType;
	@FindBy(id = "add_annexure_submission_type")
	WebElement SubmissionType;
	@FindBy(id = "add_annexure_document_type")
	WebElement DocumentType;
	@FindBy(xpath = "//div[1]/div[2]/div[4]/div/form/div[5]/div/div")
	WebElement Mandatory;
	// ---Submit bTN---//
	@FindBy(id = "add_edit_annexure_details")
	WebElement SubmitBTN;

	// --View--//
	@FindBy(css = ".fa.fa-eye")
	WebElement ViewLink;
	@FindBy(css = ".logout")
	WebElement LogOut;

	public void CRe4_959_960() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageDocumentType = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[6]/a");
		ManageDocumentType.click();
		WebElement AddDocumentType = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div/div[1]/div/li/div/ul/li[2]/div/a");
		AddDocumentType.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");
		String AddDocumentType_data = r1.getCell(2, 30).getContents();

		String ProjectTypeTitle_data = r1.getCell(3, 30).getContents();
		String reviewTypeTitle_data = r1.getCell(4, 30).getContents();
		String SubmissionTypeTitle_data = r1.getCell(5, 30).getContents();
		String DocumentTypeTitle_data = r1.getCell(6, 30).getContents();
		String MandatoryTitle_data = r1.getCell(7, 30).getContents();

		// ----AddDocumentType----//
		System.out.println(AddDocumentType_Title.getText());
		System.out.println(ProjectTypeTitle.getText());
		System.out.println(reviewTypeTitle.getText());
		System.out.println(SubmissionTypeTitle.getText());
		System.out.println(DocumentTypeTitle.getText());
		System.out.println(MandatoryTitle.getText());
		
		Assert.assertEquals(AddDocumentType_Title.getText(), AddDocumentType_data);
		
		// ----ProjectTypeTitle----//
		
		Assert.assertEquals(ProjectTypeTitle.getText(), ProjectTypeTitle_data);
		
		// ----reviewTypeTitle----//
		
		Assert.assertEquals(reviewTypeTitle.getText(), reviewTypeTitle_data);
		
		// ----SubmissionTypeTitle----//
		
		Assert.assertEquals(SubmissionTypeTitle.getText(), SubmissionTypeTitle_data);
		
		// ----DocumentTypeTitle----//
		
		Assert.assertEquals(DocumentTypeTitle.getText(), DocumentTypeTitle_data);
		
		// ----MandatoryTitle----//
		
		Assert.assertEquals(MandatoryTitle.getText(), MandatoryTitle_data);
		

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(61).createCell(4).setCellValue("Pass");
		sheet.getRow(61).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(61).createCell(4).setCellValue("Fail");
			sheet.getRow(61).getCell(4).setCellStyle(style);
			
			sheet.getRow(61).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(61).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	@FindBy(xpath = "//div[4]/div/form/div[1]/div/div/p")
	WebElement ProjectTypeAlert;
	@FindBy(xpath = "//div[4]/div/form/div[2]/div/div/p")
	WebElement reviewTypeAlert;
	@FindBy(xpath = "//div[4]/div/form/div[3]/div/div/p")
	WebElement SubmissionTypeAlert;
	@FindBy(xpath = "//div[4]/div/form/div[4]/div/div/p")
	WebElement DocumentTypeAlert;

	// ---Check for Add document type form with blank data---//
	public void CRe4_960_a_961() throws Exception {
		
		try{
		
		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String ProjectTypeAlert_data = r1.getCell(2, 32).getContents();
		String reviewTypeAlert_data = r1.getCell(3, 32).getContents();
		String SubmissionTypeAlert_data = r1.getCell(4, 32).getContents();
		String DocumentTypeAlert_data = r1.getCell(5, 32).getContents();

		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageDocumentType = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[6]/a");
		ManageDocumentType.click();
		WebElement AddDocumentType = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div/div[1]/div/li/div/ul/li[2]/div/a");
		AddDocumentType.click();

		WebElement SubmitBTN = GWait.Wait_GetElementById("add_edit_annexure_details");
		SubmitBTN.click();

		// ----MandatoryTitle----//
		System.out.println(ProjectTypeAlert.getText());
		System.out.println(reviewTypeAlert.getText());
		System.out.println(SubmissionTypeAlert.getText());
		System.out.println(DocumentTypeAlert.getText());
		
		Assert.assertEquals(ProjectTypeAlert.getText().trim(), ProjectTypeAlert_data);
		
		Assert.assertEquals(reviewTypeAlert.getText().trim(), reviewTypeAlert_data);
		
		Assert.assertEquals(SubmissionTypeAlert.getText().trim(), SubmissionTypeAlert_data);
		
		Assert.assertEquals(DocumentTypeAlert.getText().trim(), DocumentTypeAlert_data);
		
//		if (MandatoryTitle.getText().equalsIgnoreCase(MandatoryTitle_data)) {
//			System.out.println(MandatoryTitle.getText().equalsIgnoreCase(MandatoryTitle_data));
//		} else {
//			System.out.println("Test Fail MandatoryTitle");
//		}

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(62).createCell(4).setCellValue("Pass");
		sheet.getRow(62).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(62).createCell(4).setCellValue("Fail");
			sheet.getRow(62).getCell(4).setCellStyle(style);
			
			sheet.getRow(62).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(62).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	@FindBy(id = "importlink")
	WebElement Import;
	 @FindBy(id = "importdoclist")
	 WebElement ImportDocumentSelect;
	
	// ---Submit Form----//
	public void CRe4_961_a_962() throws Exception {
		
		try{
		
		
		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageDocumentType = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[6]/a");
		ManageDocumentType.click();
		
		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		
		System.out.println("Test001 "+r1.getColumns());
		for (int i = 2; i <= r1.getColumns()-1;) {
			
			
			WebElement AddDocumentType = GWait
					.Wait_GetElementByXpath("html/body/div[4]/div[1]/div/div[1]/div/li/div/ul/li[2]/div/a");
			AddDocumentType.click();
			
			String ProjectType_data = r1.getCell(i, 34).getContents();
			String reviewType_data = r1.getCell(i+1, 34).getContents();
			String SubmissionType_data = r1.getCell(i+2, 34).getContents();
			String DocumentType_Data = r1.getCell(i+3, 34).getContents();
			
			System.out.println(ProjectType.getText());
			WebElement ProjectType = GWait.Wait_GetElementById("add_annexure_project_type");
			Select PT = new Select(ProjectType);
			PT.selectByVisibleText(ProjectType_data);

			System.out.println(reviewType.getText());
			WebElement reviewType = GWait.Wait_GetElementById("add_annexure_review_type");
			Select RT = new Select(reviewType);
			RT.selectByVisibleText(reviewType_data);

			System.out.println(SubmissionType.getText());
			WebElement SubmissionType = GWait.Wait_GetElementById("add_annexure_submission_type");
			Select ST = new Select(SubmissionType);
			ST.selectByVisibleText(SubmissionType_data);
			
			DocumentType.sendKeys(DocumentType_Data);
			WebElement SubmitBTN = GWait.Wait_GetElementById("add_edit_annexure_details");
			SubmitBTN.click();
			WebElement Alertpopup = GWait.Wait_GetElementByCSS(".bg-success.text-success.col-sm-12.text-center");
			System.out.println(Alertpopup.getText());
			i=i+4;
			
			
			
		}

		/*WebElement Import = GWait.Wait_GetElementById("importlink");
		Import.click();

		List<WebElement> allCheckbox = GlobalMethods.driver.findElements(By.xpath("//input[@type='checkbox']"));

		for (WebElement ele : allCheckbox) {

			if (!ele.isSelected()) {

				ele.click();

			}
		}

		WebElement ImportDocumentSave = GWait.Wait_GetElementById("saveimportdocs");
		ImportDocumentSave.click();
		GlobalMethods.alertaccept();*/
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(63).createCell(4).setCellValue("Pass");
		sheet.getRow(63).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(63).createCell(4).setCellValue("Fail");
			sheet.getRow(63).getCell(4).setCellStyle(style);
			
			sheet.getRow(63).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(63).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}
	
	@FindBy(xpath = "html/body/div[5]/div[1]/div[3]/div[4]/div[1]/form/div/div[1]/div[1]/div/div/div/ul/li")
	public static List<WebElement> projtypvalue;
	@FindBy(xpath = "html/body/div[5]/div[1]/div[3]/div[4]/div[1]/form/div/div[2]/div[1]/div/div/div/ul/li")
	public static List<WebElement> revtypvalue;
	
	@FindBy(id = "projecttitle")
	WebElement Full_title;

	@FindBy(id = "projectshorttitle")
	WebElement short_title;

	@FindBy(id = "pi_name")
	WebElement PI_Name;

	@FindBy(id = "project_description")
	WebElement sponsor;

	@FindBy(xpath = "//*[@id='sumsave']")
	WebElement save_button1;
	
	@FindBy(xpath = "//span")
	WebElement Login_PI_Name;
	
	@FindBy(xpath = "//*[@id='document_type']/div/div/ul/li")
	public static List<WebElement> docvalue;
	
	public void CRe4_961_b() throws Exception {
		
		try{
			
		
		GlobalMethods.PI_Login();
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("ManageIEC");
		// Project summary data
		String Project_Type = r1.getCell(2, 36).getContents();
		String Review_Type = r1.getCell(3, 36).getContents();
		String Project_Full_Title = r1.getCell(4, 36).getContents();
		String Project_Short_Title = r1.getCell(5, 36).getContents();
		String Sponsor = r1.getCell(6, 36).getContents();

		WebElement SubmitNewProject = GWait.Wait_GetElementByLinkText("Submit New Project");
		SubmitNewProject.click();
		
		WebElement projtypdrop = GWait.Wait_GetElementByXpath(".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button");
		projtypdrop.click();
		
		List<WebElement> elementsList11 = projtypvalue;
		for (WebElement a11 : elementsList11) {
			WebElement span = a11.findElement(By.tagName("span"));
			if (span.getText().equalsIgnoreCase(Project_Type)) {
				span.click();
				break;
			}
		}

		WebElement revtypdrop = GWait.Wait_GetElementByXpath(".//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button");
		revtypdrop.click();

		List<WebElement> elementsList2 = revtypvalue;
		for (WebElement a111 : elementsList2) {
			WebElement span = a111.findElement(By.tagName("span"));
			// System.out.println(Review_Type);
			// System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(Review_Type)) {
				span.click();
				break;
			}
		}

		
		Full_title.sendKeys(Project_Full_Title);
		
		short_title.sendKeys(Project_Short_Title);

		// comparing PI name

		String PIname = Login_PI_Name.getText();
		String loggedpiname = PI_Name.getAttribute("value");

		PIname.equalsIgnoreCase(loggedpiname);

		sponsor.sendKeys(Sponsor);
		WebElement save_button1 = GWait.Wait_GetElementByXpath("//*[@id='sumsave']");
		save_button1.click();
		
//		 Verify Document Type.
		
		System.out.println("Test001 "+r1.getColumns());
		for (int i = 5; i <= r1.getColumns();) {
			
			
			String DocumentType_Data = r1.getCell(i, 34).getContents();
//			List<WebElement> docvalue = GWait.Wait_GetElementByXpathList("//*[@id='document_type']/div/div/ul/li");
			System.out.println(docvalue.size() - 1);
			for (int i1 = 1; i1 <= docvalue.size() - 1;) {
				Thread.sleep(6000);
				WebElement docdrop = GWait.Wait_GetElementByXpath("//div/div/div/div/div/div/button");
				docdrop.click();
				List<WebElement> elementsList3 = docvalue;
				for (WebElement a11 : elementsList3) {
					WebElement span = a11.findElement(By.tagName("span"));
					if (span.getText().equalsIgnoreCase(DocumentType_Data)) {
						System.out.println(span.getText());
						span.click();
						break;
					}
				}
				break;
			}
			
			i=i+4;
			
		}
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(64).createCell(4).setCellValue("Pass");
		sheet.getRow(64).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(64).createCell(4).setCellValue("Fail");
			sheet.getRow(64).getCell(4).setCellStyle(style);
			
			sheet.getRow(64).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(64).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}
}
