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

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

public class TS_17 {
	public TS_17() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[4]/a")
	WebElement ManageIECLink;
	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[4]/ul/li[6]/a")
	WebElement ManageDocumentType;

	// --View--//
	@FindBy(css = ".glyphicon.glyphicon-eye-open")
	WebElement ViewLink;

	// ---Add Documents Fields---//
	@FindBy(xpath = "//div[1]/form/div[1]/div/div/div/button")
	WebElement ProjectTypeClick;
	@FindBy(xpath = "//div[4]/div[1]/form/div[1]/div/div/div/div/ul/li")
	public static List<WebElement> ProjectType;
	@FindBy(xpath = "//div[1]/form/div[2]/div/div/div/button")
	WebElement reviewTypeClick;
	@FindBy(xpath = "//div[4]/div[1]/form/div[2]/div/div/div/div/ul/li")
	public static List<WebElement> reviewType;
	@FindBy(xpath = "//div[1]/form/div[3]/div/div/div/button")
	WebElement SubmissionTypeClick;
	@FindBy(xpath = "//div[4]/div[1]/form/div[3]/div/div/div/div/ul/li")
	public static List<WebElement> SubmissionType;
	@FindBy(xpath = "//div/div[2]/div[4]/div[1]/form/div[4]/input")
	WebElement Search;

	// ---Project Document Type Details---//
	@FindBy(xpath = "//div[2]/div[4]/div[1]/div[1]/div[2]")
	WebElement ProjectTypeDetails;
	@FindBy(xpath = "//div[2]/div[4]/div[1]/div[2]/div[2]")
	WebElement reviewTypeDetails;
	@FindBy(xpath = "//div[2]/div[4]/div[1]/div[3]/div[2]")
	WebElement SubmissionTypeDetails;
	@FindBy(css = ".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a")
	WebElement MPDT;

	public void CRe4_948_949() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageDocumentType = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[6]/a");
		ManageDocumentType.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");
		String ProjectType_data = r1.getCell(2, 38).getContents();
		String reviewType_data = r1.getCell(3, 38).getContents();
		String SubmissionType_data = r1.getCell(4, 38).getContents();

		WebElement ProjectTypeClick = GWait.Wait_GetElementByXpath("//div[1]/form/div[1]/div/div/div/button");
		ProjectTypeClick.click();
		List<WebElement> elementsList3 = ProjectType;

		for (WebElement a111 : elementsList3) {
			WebElement span = a111.findElement(By.tagName("span"));
			System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(ProjectType_data)) {

				span.click();
				break;
			}
		}

		WebElement reviewTypeClick = GWait.Wait_GetElementByXpath("//div[1]/form/div[2]/div/div/div/button");
		reviewTypeClick.click();
		List<WebElement> elementsList = reviewType;
		for (WebElement a : elementsList) {
			WebElement span = a.findElement(By.tagName("span"));
			System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(reviewType_data)) {
				span.click();
				break;
			}
		}
		WebElement SubmissionTypeClick = GWait.Wait_GetElementByXpath("//div[1]/form/div[3]/div/div/div/button");
		SubmissionTypeClick.click();
		List<WebElement> elementsList1 = SubmissionType;
		for (WebElement a : elementsList1) {
			WebElement span = a.findElement(By.tagName("span"));
			System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(SubmissionType_data)) {
				span.click();
				break;
			}
		}

		WebElement Search = GWait.Wait_GetElementByXpath("//div/div[2]/div[4]/div[1]/form/div[4]/input");
		Search.click();

		WebElement ViewLink = GWait.Wait_GetElementByCSS(".glyphicon.glyphicon-eye-open");
		ViewLink.click();

		// ----ProjectTypeDetails----//
//		WebElement ProjectTypeDetails = GWait.Wait_GetElementByCSS("//div[2]/div[4]/div[1]/div[1]/div[2]/span");
		System.out.println(ProjectTypeDetails.getText());
		if (ProjectTypeDetails.getText().equalsIgnoreCase(ProjectType_data)) {
			System.out.println(ProjectTypeDetails.getText().equalsIgnoreCase(ProjectType_data));
		} else {
			System.out.println("Test Fail ProjectTypeTitle");
		}
		// ----reviewTypeDetails----//
		System.out.println(reviewTypeDetails.getText());
		if (reviewTypeDetails.getText().equalsIgnoreCase(reviewType_data)) {
			System.out.println(reviewTypeDetails.getText().equalsIgnoreCase(reviewType_data));
		} else {
			System.out.println("Test Fail reviewTypeTitle");
		}
		// ----SubmissionTypeDetails----//
		System.out.println(SubmissionTypeDetails.getText());
		if (SubmissionTypeDetails.getText().equalsIgnoreCase(SubmissionType_data)) {
			System.out.println(SubmissionTypeDetails.getText().equalsIgnoreCase(SubmissionType_data));
		} else {
			System.out.println("Test Fail SubmissionTypeTitle");
		}

		WebElement MPDT = GWait.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		MPDT.click();
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
		
		sheet.getRow(67).createCell(4).setCellValue("Pass");
		sheet.getRow(67).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(67).createCell(4).setCellValue("Fail");
			sheet.getRow(67).getCell(4).setCellStyle(style);
			
			sheet.getRow(67).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(67).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	@FindBy(css = ".fa.fa-edit")
	WebElement EditLink;

	// ---Add Documents Fields---//
	@FindBy(id = "add_annexure_project_type")
	WebElement ProjectType1;
	@FindBy(id = "add_annexure_review_type")
	WebElement reviewType1;
	@FindBy(id = "add_annexure_submission_type")
	WebElement SubmissionType1;
	@FindBy(id = "add_annexure_document_type")
	WebElement DocumentType;
	@FindBy(xpath = "//div[1]/div[2]/div[4]/div/form/div[5]/div/div")
	WebElement Mandatory;
	// ---Submit bTN---//
	@FindBy(id = "add_edit_annexure_details")
	WebElement SubmitBTN;

	// --Check for Edit link--//
	public void CRe4_950_951() throws Exception {
		
		try{

		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageDocumentType = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[6]/a");
		ManageDocumentType.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String ProjectType_data = r1.getCell(2, 40).getContents();
		String reviewType_data = r1.getCell(3, 40).getContents();
		String SubmissionType_data = r1.getCell(4, 40).getContents();
		
		WebElement ProjectTypeClick = GWait.Wait_GetElementByXpath("//div[1]/form/div[1]/div/div/div/button");
		ProjectTypeClick.click();
		List<WebElement> elementsList3 = ProjectType;

		for (WebElement a111 : elementsList3) {
			WebElement span = a111.findElement(By.tagName("span"));
			System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(ProjectType_data)) {

				span.click();
				break;
			}
		}

		WebElement reviewTypeClick = GWait.Wait_GetElementByXpath("//div[1]/form/div[2]/div/div/div/button");
		reviewTypeClick.click();
		List<WebElement> elementsList = reviewType;
		for (WebElement a : elementsList) {
			WebElement span = a.findElement(By.tagName("span"));
			System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(reviewType_data)) {
				span.click();
				break;
			}
		}
		WebElement SubmissionTypeClick = GWait.Wait_GetElementByXpath("//div[1]/form/div[3]/div/div/div/button");
		SubmissionTypeClick.click();
		List<WebElement> elementsList1 = SubmissionType;
		for (WebElement a : elementsList1) {
			WebElement span = a.findElement(By.tagName("span"));
			System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(SubmissionType_data)) {
				span.click();
				break;
			}
		}

		WebElement Search = GWait.Wait_GetElementByXpath("//div/div[2]/div[4]/div[1]/form/div[4]/input");
		Search.click();
		
		WebElement EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		EditLink.click();

		WebElement ProjectType1 = GWait.Wait_GetElementById("add_annexure_project_type");
		System.out.println(ProjectType1.getText());
		Select PT = new Select(ProjectType1);
		PT.selectByVisibleText(ProjectType_data);
		WebElement reviewType1 = GWait.Wait_GetElementById("add_annexure_review_type");
		System.out.println(reviewType1.getText());
		Select RT = new Select(reviewType1);
		RT.selectByVisibleText(reviewType_data);
		WebElement SubmissionType1 = GWait.Wait_GetElementById("add_annexure_submission_type");
		System.out.println(SubmissionType1.getText());
		Select ST = new Select(SubmissionType1);
		ST.selectByVisibleText(SubmissionType_data);

		List<WebElement> elements = GlobalMethods.driver
				.findElements(By.xpath("//input[@id='add_project_document_type_isMandatory']"));
		for (WebElement element : elements) {
			if (!element.isSelected()) {
				element.click();
			}
			break;
		}

		WebElement SubmitBTN = GWait.Wait_GetElementById("add_edit_annexure_details");
		SubmitBTN.click();
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
		
		sheet.getRow(68).createCell(4).setCellValue("Pass");
		sheet.getRow(68).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(68).createCell(4).setCellValue("Fail");
			sheet.getRow(68).getCell(4).setCellStyle(style);
			
			sheet.getRow(68).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(68).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// ---Check for update document type as non mandatory
	public void CRe4_952() throws Exception {
		
		try{

		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageDocumentType = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[6]/a");
		ManageDocumentType.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String ProjectType_data = r1.getCell(2, 42).getContents();
		String reviewType_data = r1.getCell(3, 42).getContents();
		String SubmissionType_data = r1.getCell(4, 42).getContents();
		
		WebElement ProjectTypeClick = GWait.Wait_GetElementByXpath("//div[1]/form/div[1]/div/div/div/button");
		ProjectTypeClick.click();
		List<WebElement> elementsList3 = ProjectType;

		for (WebElement a111 : elementsList3) {
			WebElement span = a111.findElement(By.tagName("span"));
			System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(ProjectType_data)) {

				span.click();
				break;
			}
		}

		WebElement reviewTypeClick = GWait.Wait_GetElementByXpath("//div[1]/form/div[2]/div/div/div/button");
		reviewTypeClick.click();
		List<WebElement> elementsList = reviewType;
		for (WebElement a : elementsList) {
			WebElement span = a.findElement(By.tagName("span"));
			System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(reviewType_data)) {
				span.click();
				break;
			}
		}
		WebElement SubmissionTypeClick = GWait.Wait_GetElementByXpath("//div[1]/form/div[3]/div/div/div/button");
		SubmissionTypeClick.click();
		List<WebElement> elementsList1 = SubmissionType;
		for (WebElement a : elementsList1) {
			WebElement span = a.findElement(By.tagName("span"));
			System.out.println(span.getText());
			if (span.getText().equalsIgnoreCase(SubmissionType_data)) {
				span.click();
				break;
			}
		}

		WebElement Search = GWait.Wait_GetElementByXpath("//div/div[2]/div[4]/div[1]/form/div[4]/input");
		Search.click();
		
		WebElement EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		EditLink.click();

		WebElement ProjectType1 = GWait.Wait_GetElementById("add_annexure_project_type");
		System.out.println(ProjectType1.getText());
		Select PT = new Select(ProjectType1);
		PT.selectByVisibleText(ProjectType_data);
		WebElement reviewType1 = GWait.Wait_GetElementById("add_annexure_review_type");
		System.out.println(reviewType1.getText());
		Select RT = new Select(reviewType1);
		RT.selectByVisibleText(reviewType_data);
		WebElement SubmissionType1 = GWait.Wait_GetElementById("add_annexure_submission_type");
		System.out.println(SubmissionType1.getText());
		Select ST = new Select(SubmissionType1);
		ST.selectByVisibleText(SubmissionType_data);

		List<WebElement> elements = GlobalMethods.driver
				.findElements(By.xpath("//input[@id='add_project_document_type_isMandatory']"));
		for (WebElement element : elements) {
			if (element.getAttribute("value").equalsIgnoreCase("0")) {
				element.click();
			}
			break;
		}

		WebElement SubmitBTN = GWait.Wait_GetElementById("add_edit_annexure_details");
		SubmitBTN.click();
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
		
		sheet.getRow(69).createCell(4).setCellValue("Pass");
		sheet.getRow(69).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(69).createCell(4).setCellValue("Fail");
			sheet.getRow(69).getCell(4).setCellStyle(style);
			
			sheet.getRow(69).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(69).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// ---Check for update document type by changing project type
	public void CRe4_953() throws Exception {
		
		try{

		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageDocumentType = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[6]/a");
		ManageDocumentType.click();

		WebElement EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		EditLink.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String ProjectType_data = r1.getCell(2, 44).getContents();

		WebElement ProjectType1 = GWait.Wait_GetElementById("add_annexure_project_type");
		System.out.println(ProjectType1.getText());
		Select PT = new Select(ProjectType1);
		PT.selectByVisibleText(ProjectType_data);

		WebElement SubmitBTN = GWait.Wait_GetElementById("add_edit_annexure_details");
		SubmitBTN.click();
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
		
		sheet.getRow(70).createCell(4).setCellValue("Pass");
		sheet.getRow(70).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(70).createCell(4).setCellValue("Fail");
			sheet.getRow(70).getCell(4).setCellStyle(style);
			
			sheet.getRow(70).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(70).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// ---Check for update document type by changing review type
	public void CRe4_954() throws Exception {
		
		try{

		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageDocumentType = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[6]/a");
		ManageDocumentType.click();

		WebElement EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		EditLink.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String reviewType_data = r1.getCell(2, 46).getContents();

		WebElement reviewType1 = GWait.Wait_GetElementById("add_annexure_review_type");
		System.out.println(reviewType1.getText());
		Select RT = new Select(reviewType1);
		RT.selectByVisibleText(reviewType_data);

		WebElement SubmitBTN = GWait.Wait_GetElementById("add_edit_annexure_details");
		SubmitBTN.click();
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
		
		sheet.getRow(71).createCell(4).setCellValue("Pass");
		sheet.getRow(71).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(71).createCell(4).setCellValue("Fail");
			sheet.getRow(71).getCell(4).setCellStyle(style);
			
			sheet.getRow(71).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(71).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// ---Check for update document type by changing submission type
	public void CRe4_955() throws Exception {
		
		try{

		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageDocumentType = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[6]/a");
		ManageDocumentType.click();

		WebElement EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		EditLink.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String SubmissionType_data = r1.getCell(2, 48).getContents();

		WebElement SubmissionType1 = GWait.Wait_GetElementById("add_annexure_submission_type");
		System.out.println(SubmissionType1.getText());
		Select ST = new Select(SubmissionType1);
		ST.selectByVisibleText(SubmissionType_data);

		WebElement SubmitBTN = GWait.Wait_GetElementById("add_edit_annexure_details");
		SubmitBTN.click();
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
		
		sheet.getRow(72).createCell(4).setCellValue("Pass");
		sheet.getRow(72).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(72).createCell(4).setCellValue("Fail");
			sheet.getRow(72).getCell(4).setCellStyle(style);
			
			sheet.getRow(72).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(72).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// ---Check for update by changing document type
	public void CRe4_956() throws Exception {
		
		try{

		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageDocumentType = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[6]/a");
		ManageDocumentType.click();

		WebElement EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		EditLink.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String documentType_data = r1.getCell(2, 50).getContents();

		DocumentType.clear();
		WebElement documentType = GWait.Wait_GetElementById("add_annexure_document_type");
		System.out.println(documentType.getAttribute("value"));
		documentType.sendKeys(documentType_data);

		WebElement SubmitBTN = GWait.Wait_GetElementById("add_edit_annexure_details");
		SubmitBTN.click();
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
		
		sheet.getRow(73).createCell(4).setCellValue("Pass");
		sheet.getRow(73).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(73).createCell(4).setCellValue("Fail");
			sheet.getRow(73).getCell(4).setCellStyle(style);
			
			sheet.getRow(73).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(73).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	//--Check for update by changing project/review/submission/document type field values
	public void CRe4_957() throws Exception {
		
		try{

		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageDocumentType = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[6]/a");
		ManageDocumentType.click();

		WebElement EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		EditLink.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String ProjectType_data = r1.getCell(2, 52).getContents();
		String reviewType_data = r1.getCell(3, 52).getContents();
		String SubmissionType_data = r1.getCell(4, 52).getContents();
		String DocumentType_data = r1.getCell(5, 52).getContents();

		WebElement ProjectType1 = GWait.Wait_GetElementById("add_annexure_project_type");
		System.out.println(ProjectType1.getText());
		Select PT = new Select(ProjectType1);
		PT.selectByVisibleText(ProjectType_data);
		WebElement reviewType1 = GWait.Wait_GetElementById("add_annexure_review_type");
		System.out.println(reviewType1.getText());
		Select RT = new Select(reviewType1);
		RT.selectByVisibleText(reviewType_data);
		WebElement SubmissionType1 = GWait.Wait_GetElementById("add_annexure_submission_type");
		System.out.println(SubmissionType1.getText());
		Select ST = new Select(SubmissionType1);
		ST.selectByVisibleText(SubmissionType_data);
		DocumentType.clear();
		WebElement DocumentType = GWait.Wait_GetElementById("add_annexure_document_type");
		DocumentType.sendKeys(DocumentType_data);

		List<WebElement> elements = GlobalMethods.driver
				.findElements(By.xpath("//input[@id='add_project_document_type_isMandatory']"));
		for (WebElement element : elements) {
			if (!element.isSelected()) {
				element.click();
			}
			break;
		}

		WebElement SubmitBTN = GWait.Wait_GetElementById("add_edit_annexure_details");
		SubmitBTN.click();
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
		
		sheet.getRow(74).createCell(4).setCellValue("Pass");
		sheet.getRow(74).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(74).createCell(4).setCellValue("Fail");
			sheet.getRow(74).getCell(4).setCellStyle(style);
			
			sheet.getRow(74).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(74).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	@FindBy(css = ".logout")
	WebElement LogOut;

	// --Check for update by blank fields--//
	public void CRe4_958() throws Exception {
		
		try{

		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageDocumentType = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[6]/a");
		ManageDocumentType.click();

		WebElement EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		EditLink.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String ProjectType_data = r1.getCell(2, 54).getContents();
		String reviewType_data = r1.getCell(3, 54).getContents();
		String SubmissionType_data = r1.getCell(4, 54).getContents();

		WebElement ProjectType1 = GWait.Wait_GetElementById("add_annexure_project_type");
		System.out.println(ProjectType1.getText());
		Select PT = new Select(ProjectType1);
		PT.selectByVisibleText(ProjectType_data);
		WebElement reviewType1 = GWait.Wait_GetElementById("add_annexure_review_type");
		System.out.println(reviewType1.getText());
		Select RT = new Select(reviewType1);
		RT.selectByVisibleText(reviewType_data);
		WebElement SubmissionType1 = GWait.Wait_GetElementById("add_annexure_submission_type");
		System.out.println(SubmissionType1.getText());
		Select ST = new Select(SubmissionType1);
		ST.selectByVisibleText(SubmissionType_data);
		WebElement DocumentType = GWait.Wait_GetElementById("add_annexure_document_type");
		DocumentType.clear();

		List<WebElement> elements = GlobalMethods.driver
				.findElements(By.xpath("//input[@id='add_project_document_type_isMandatory']"));
		for (WebElement element : elements) {
			if (!element.isSelected()) {
				element.click();
			}
			break;
		}

		WebElement SubmitBTN = GWait.Wait_GetElementById("add_edit_annexure_details");
		SubmitBTN.click();
		WebElement MPDT = GWait.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		MPDT.click();
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
		
		sheet.getRow(75).createCell(4).setCellValue("Pass");
		sheet.getRow(75).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(75).createCell(4).setCellValue("Fail");
			sheet.getRow(75).getCell(4).setCellStyle(style);
			
			sheet.getRow(75).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(75).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

}
