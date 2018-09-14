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
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

public class TS_18 {
	public TS_18() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[4]/a")
	WebElement ManageIECLink;
	@FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/h3")
	WebElement ManageDocumentTypeHeader;

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
	@FindBy(xpath = "//div[2]/div[4]/div[1]/form/div[1]/div/label")
	WebElement ProjectType_Search;
	@FindBy(xpath = "//div[2]/div[4]/div[1]/form/div[2]/div/label")
	WebElement reviewType_Search;
	@FindBy(xpath = "//div[2]/div[4]/div[1]/form/div[3]/div/label")
	WebElement SubmissionType_Search;

	@FindBy(css = ".logout")
	WebElement LogOut;
	@FindBy(xpath = "html/body/div[1]/div[1]/div[1]/a[1]/img")
	WebElement Logo;

	@FindBy(xpath = "//div/div[2]/div[4]/div[1]/form/div[4]/input")
	WebElement Search;

	public void CRe4_932_933_934_935_936() throws Exception {
		
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

		String ManageDocumentTypeHeader_Data = r1.getCell(2, 56).getContents();
		String ProjectType_Search_Data = r1.getCell(3, 56).getContents();
		String reviewType_Search_Data = r1.getCell(4, 56).getContents();
		String SubmissionType_Search_Data = r1.getCell(5, 56).getContents();

		System.out.println(ManageDocumentTypeHeader.getText());
		Assert.assertEquals(ManageDocumentTypeHeader.getText(), ManageDocumentTypeHeader_Data);
		System.out.println(ProjectType_Search.getText());
		Assert.assertEquals(ProjectType_Search.getText(), ProjectType_Search_Data);
		System.out.println(reviewType_Search.getText());
		Assert.assertEquals(reviewType_Search.getText(), reviewType_Search_Data);
		System.out.println(SubmissionType_Search.getText());
		Assert.assertEquals(SubmissionType_Search.getText(), SubmissionType_Search_Data);

		// ---Check for 'Project type' drop down values
		WebElement ProjectTypeClick = GWait.Wait_GetElementByXpath("//div[1]/form/div[1]/div/div/div/button");
		ProjectTypeClick.click();
		List<WebElement> elementsList3 = ProjectType;
		for (WebElement a111 : elementsList3) {
			WebElement span = a111.findElement(By.tagName("span"));
			System.out.println("Project Type: "+span.getText());
		}
		// ---Check for 'Review type' drop down values
		WebElement reviewTypeClick = GWait.Wait_GetElementByXpath("//div[1]/form/div[2]/div/div/div/button");
		reviewTypeClick.click();
		List<WebElement> elementsList = reviewType;
		for (WebElement a : elementsList) {
			WebElement span = a.findElement(By.tagName("span"));
			System.out.println("Review Type: "+span.getText());
		}
		// ---Check for 'Submission type' drop down values
		WebElement SubmissionTypeClick = GWait.Wait_GetElementByXpath("//div[1]/form/div[3]/div/div/div/button");
		SubmissionTypeClick.click();
		List<WebElement> elementsList1 = SubmissionType;
		for (WebElement a : elementsList1) {
			WebElement span = a.findElement(By.tagName("span"));
			System.out.println("Submission Type: "+span.getText());
		}

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
		
		sheet.getRow(78).createCell(4).setCellValue("Pass");
		sheet.getRow(78).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(78).createCell(4).setCellValue("Fail");
			sheet.getRow(78).getCell(4).setCellStyle(style);
			
			sheet.getRow(78).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(78).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// ---Check for search with review type
	public void CRe4_937() throws Exception {
		
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
		String reviewType_data = r1.getCell(2, 58).getContents();

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

		WebElement Search = GWait.Wait_GetElementByXpath("//div/div[2]/div[4]/div[1]/form/div[4]/input");
		Search.click();
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
		
		sheet.getRow(79).createCell(4).setCellValue("Pass");
		sheet.getRow(79).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(79).createCell(4).setCellValue("Fail");
			sheet.getRow(79).getCell(4).setCellStyle(style);
			
			sheet.getRow(79).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(79).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	// ---Check for search with project status
	public void CRe4_938() throws Exception {
		
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
		String ProjectType_data = r1.getCell(2, 60).getContents();

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

		WebElement Search = GWait.Wait_GetElementByXpath("//div/div[2]/div[4]/div[1]/form/div[4]/input");
		Search.click();
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
		
		sheet.getRow(80).createCell(4).setCellValue("Pass");
		sheet.getRow(80).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(80).createCell(4).setCellValue("Fail");
			sheet.getRow(80).getCell(4).setCellStyle(style);
			
			sheet.getRow(80).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(80).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	// ---Check for search with Submission type
	public void CRe4_939() throws Exception {
		
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
		String SubmissionType_data = r1.getCell(2, 62).getContents();

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
		
		sheet.getRow(81).createCell(4).setCellValue("Pass");
		sheet.getRow(81).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(81).createCell(4).setCellValue("Fail");
			sheet.getRow(81).getCell(4).setCellStyle(style);
			
			sheet.getRow(81).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(81).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	// ---Check for search wtih no field value selected
	public void CRe4_940() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageDocumentType = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[6]/a");
		ManageDocumentType.click();

		WebElement Search = GWait.Wait_GetElementByXpath("//div/div[2]/div[4]/div[1]/form/div[4]/input");
		Search.click();
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
		
		sheet.getRow(82).createCell(4).setCellValue("Pass");
		sheet.getRow(82).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(82).createCell(4).setCellValue("Fail");
			sheet.getRow(82).getCell(4).setCellStyle(style);
			
			sheet.getRow(82).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(82).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	// ---Check for search three fields
	public void CRe4_941() throws Exception {
		
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
		String ProjectType_data = r1.getCell(2, 64).getContents();
		String reviewType_data = r1.getCell(3, 64).getContents();
		String SubmissionType_data = r1.getCell(4, 64).getContents();

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
		
		sheet.getRow(83).createCell(4).setCellValue("Pass");
		sheet.getRow(83).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(83).createCell(4).setCellValue("Fail");
			sheet.getRow(83).getCell(4).setCellStyle(style);
			
			sheet.getRow(83).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(83).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// ---Check for search with only project type/submission type
	public void CRe4_942() throws Exception {
		
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
		String ProjectType_data = r1.getCell(2, 66).getContents();
		String SubmissionType_data = r1.getCell(3, 66).getContents();

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
		
		sheet.getRow(84).createCell(4).setCellValue("Pass");
		sheet.getRow(84).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(84).createCell(4).setCellValue("Fail");
			sheet.getRow(84).getCell(4).setCellStyle(style);
			
			sheet.getRow(84).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(84).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// ---Check for search with only project type/review type
	public void CRe4_943() throws Exception {
		
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
		String ProjectType_data = r1.getCell(2, 68).getContents();
		String reviewType_data = r1.getCell(3, 68).getContents();

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

		WebElement Search = GWait.Wait_GetElementByXpath("//div/div[2]/div[4]/div[1]/form/div[4]/input");
		Search.click();
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
		
		sheet.getRow(85).createCell(4).setCellValue("Pass");
		sheet.getRow(85).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(85).createCell(4).setCellValue("Fail");
			sheet.getRow(85).getCell(4).setCellStyle(style);
			
			sheet.getRow(85).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(85).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// ---Check for search with only submission type/review type
	public void CRe4_944() throws Exception {
		
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
		String reviewType_data = r1.getCell(2, 70).getContents();
		String SubmissionType_data = r1.getCell(3, 70).getContents();

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
		
		sheet.getRow(86).createCell(4).setCellValue("Pass");
		sheet.getRow(86).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(86).createCell(4).setCellValue("Fail");
			sheet.getRow(86).getCell(4).setCellStyle(style);
			
			sheet.getRow(86).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(86).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// ---Check for search with value has no data
	public void CRe4_945() throws Exception {
		
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
		String ProjectType_data = r1.getCell(2, 72).getContents();
		String reviewType_data = r1.getCell(3, 72).getContents();
		String SubmissionType_data = r1.getCell(4, 72).getContents();
		String NoRecordFound_data = r1.getCell(5, 72).getContents();

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
		WebElement NoRecordFound = GWait.Wait_GetElementByXpath("html/body/div[4]/div[1]/div/div[2]/div[4]/table/tbody/tr/td/span");
		System.out.println(NoRecordFound.getText());
		Assert.assertEquals(NoRecordFound.getText(), NoRecordFound_data);
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
		
		sheet.getRow(87).createCell(4).setCellValue("Pass");
		sheet.getRow(87).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(87).createCell(4).setCellValue("Fail");
			sheet.getRow(87).getCell(4).setCellStyle(style);
			
			sheet.getRow(87).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(87).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

}
