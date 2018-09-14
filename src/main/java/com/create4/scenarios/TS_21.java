package com.create4.scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

public class TS_21 {

	public TS_21() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}
	
	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[4]/a")
	WebElement Manage_IEC1;

	@FindBy(xpath = "//li[4]/ul/li[7]/a")
	WebElement Manage_IECMembers1;

	@FindBy(xpath = "//div[1]/div/div[2]/div[4]/h3")
	WebElement IECMembers_Header;

	// ------Search Field-------//
	@FindBy(xpath = "//div[2]/div[4]/div[1]/form/div[1]/div/label")
	WebElement Name_Search;

	@FindBy(xpath = "//div[2]/div[4]/div[1]/form/div[2]/div/label")
	WebElement Email_Search;

	@FindBy(xpath = "//div[2]/div[4]/div[1]/form/div[3]/input")
	WebElement SearchField;

	// -------Search Data Field-----//
	@FindBy(id = "iec_member_name")
	WebElement Name;

	@FindBy(id = "iec_member_email")
	WebElement Email;

	@FindBy(xpath = "//div[2]/div[4]/div[1]/form/div[3]/input")
	WebElement SearchButton;

	@FindBy(css = ".logout")
	WebElement LogOutButton;

	// --------Log---------//
	@FindBy(xpath = "html/body/div[1]/div[1]/div[1]/a[1]/img")
	WebElement Logo;

	// --------Check for Search options---------//
	public void CRe4_970_971_972_973_977() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();
		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();
		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");
		String NameSearchField_data = r1.getCell(2, 140).getContents();
		String EmailSearchField_data = r1.getCell(3, 140).getContents();
		String SearchButton_data = r1.getCell(4, 140).getContents();
		
		

		System.out.println("Check for search with blank fields--TestCases no.== CRe4_970");
		// ---Name---//
		if (Name_Search.getText().equalsIgnoreCase(NameSearchField_data)) {
			System.out.println(Name_Search.getText().equalsIgnoreCase(NameSearchField_data));
		} else {
			System.out.println("Test Fail Name");
		}

		// ----Email Address----//
		if (Email_Search.getText().equalsIgnoreCase(EmailSearchField_data)) {
			System.out.println(Email_Search.getText().equalsIgnoreCase(EmailSearchField_data));
		} else {
			System.out.println("Test Fail Email Address");
		}

		// ----Submit Button----//
		System.out.println("Test " + SearchField.getAttribute("type"));
		if (SearchField.getAttribute("type").equalsIgnoreCase(SearchButton_data)) {
			System.out.println(SearchField.getAttribute("type").equalsIgnoreCase(SearchButton_data));
		} else {
			System.out.println("Test Fail Submit Field");
		}
		System.out.println("Check for search with blank fields--TestCases no.== CRe4_977");
		WebElement SearchButton = GWait.Wait_GetElementByXpath("//div[2]/div[4]/div[1]/form/div[3]/input");
		SearchButton.click();
		
		System.out.println("Check for search with non existing name--TestCases no.== CRe4_971");
		String NonExistName_data = r1.getCell(2, 142).getContents();
		Name.sendKeys(NonExistName_data);
		WebElement SearchButton1 = GWait.Wait_GetElementByXpath("//div[2]/div[4]/div[1]/form/div[3]/input");
		
		SearchButton1.click();

		// ----------Check for search with existing name and Full Name--------//
		System.out.println("Test cases == CRe4_972 & 973");
		String Name_data = r1.getCell(2, 144).getContents();
		Name.clear();
		Name.sendKeys(Name_data);
		WebElement SearchButton2 = GWait.Wait_GetElementByXpath("//div[2]/div[4]/div[1]/form/div[3]/input");
		SearchButton2.click();
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
		
		sheet.getRow(144).createCell(4).setCellValue("Pass");
		sheet.getRow(144).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(144).createCell(4).setCellValue("Fail");
			sheet.getRow(144).getCell(4).setCellStyle(style);
			
			sheet.getRow(144).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(144).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// ---------Check for search with partial name----//
	public void CRe4_974() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();
		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();
		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");
		String PartialName_data = r1.getCell(2, 146).getContents();
		System.out.println("Test cases == CRe4_974");
		Name.sendKeys(PartialName_data);
		WebElement SearchButton = GWait.Wait_GetElementByXpath("//div[2]/div[4]/div[1]/form/div[3]/input");
		SearchButton.click();
		WebElement LogOutButton = GWait.Wait_GetElementByCSS(".logout");
		LogOutButton.click();
		
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
		
		sheet.getRow(145).createCell(4).setCellValue("Pass");
		sheet.getRow(145).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(145).createCell(4).setCellValue("Fail");
			sheet.getRow(145).getCell(4).setCellStyle(style);
			
			sheet.getRow(145).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(145).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
		
	}
	
	// ---------Check for search with non existing Email address----//
		public void CRe4_975() throws Exception {
			
			try{

			// ----------IEC Admin Login------------//
			GlobalMethods.Admin_Login();
			WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
			Manage_IEC1.click();
			WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
			Manage_IECMembers1.click();

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			

			// String PartialName_data = r1.getCell(0, 13).getContents();
			String InvalidEmail_data = r1.getCell(2, 148).getContents();
			System.out.println("Test cases == CRe4_975");
			Email.sendKeys(InvalidEmail_data);
			WebElement SearchButton = GWait.Wait_GetElementByXpath("//div[2]/div[4]/div[1]/form/div[3]/input");
			SearchButton.click();
			WebElement LogOutButton = GWait.Wait_GetElementByCSS(".logout");
			LogOutButton.click();
			
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
			
			sheet.getRow(146).createCell(4).setCellValue("Pass");
			sheet.getRow(146).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(146).createCell(4).setCellValue("Fail");
				sheet.getRow(146).getCell(4).setCellStyle(style);
				
				sheet.getRow(146).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(146).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}

		}

	// ---------Check for search with non existing Email address----//
	public void CRe4_976() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();
		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();
		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");
		String NonExistEmail_data = r1.getCell(2, 150).getContents();
		System.out.println("Test cases == CRe4_976");
		Email.sendKeys(NonExistEmail_data);
		WebElement SearchButton = GWait.Wait_GetElementByXpath("//div[2]/div[4]/div[1]/form/div[3]/input");
		SearchButton.click();
		WebElement LogOutButton = GWait.Wait_GetElementByCSS(".logout");
		LogOutButton.click();
		
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
		
		sheet.getRow(147).createCell(4).setCellValue("Pass");
		sheet.getRow(147).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(147).createCell(4).setCellValue("Fail");
			sheet.getRow(147).getCell(4).setCellStyle(style);
			
			sheet.getRow(147).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(147).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	public void CRe4_978() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();
		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();
		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String Name_data = r1.getCell(2, 152).getContents();
		String Email_data = r1.getCell(3, 152).getContents();
		Name.sendKeys(Name_data);
//		Email.sendKeys(Email_data);
		WebElement SearchButton = GWait.Wait_GetElementByXpath("//div[2]/div[4]/div[1]/form/div[3]/input");
		SearchButton.click();
		
		System.out.println(Name.getAttribute("value"));
		Assert.assertEquals(Name.getAttribute("value"), Name_data);
//		Assert.assertEquals(Email.getText(), Email_data);
		
		WebElement LogOutButton = GWait.Wait_GetElementByCSS(".logout");
		LogOutButton.click();
		
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
		
		sheet.getRow(148).createCell(4).setCellValue("Pass");
		sheet.getRow(148).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(148).createCell(4).setCellValue("Fail");
			sheet.getRow(148).getCell(4).setCellStyle(style);
			
			sheet.getRow(148).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(148).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
		

	}
}
