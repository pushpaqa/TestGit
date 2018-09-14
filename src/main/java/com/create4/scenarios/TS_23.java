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
import org.openqa.selenium.support.ui.Select;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

public class TS_23 {

	public TS_23() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}
	
	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[4]/a")
	WebElement ManageIECLink;

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[4]/ul/li[8]/a")
	WebElement ManageEthicsCommittee;

	public void CRe4_1056() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
	
		GlobalMethods.Admin_Login();
		
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageEthicsCommittee = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[8]/a");
		ManageEthicsCommittee.click();
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
		
		sheet.getRow(176).createCell(4).setCellValue("Pass");
		sheet.getRow(176).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(176).createCell(4).setCellValue("Fail");
			sheet.getRow(176).getCell(4).setCellStyle(style);
			
			sheet.getRow(176).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(176).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	@FindBy(xpath = "//div[1]/form/div[1]/div/label")
	WebElement NameTXT;
	@FindBy(xpath = "//div[1]/form/div[2]/div/label")
	WebElement TypeTXT;
	@FindBy(xpath = "//div[4]/div[1]/form/div[3]/input")
	WebElement Search;

	// --Check for Search options--//
	public void CRe4_1057() throws Exception {
		
		try{
		
		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageEthicsCommittee = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[8]/a");
		ManageEthicsCommittee.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");
		String NameTXT_data = r1.getCell(2, 168).getContents();
		String TypeTXT_data = r1.getCell(3, 168).getContents();
		String Search_data = r1.getCell(4, 168).getContents();

		// ----Name----//
		
		System.out.println(NameTXT.getText());
		if (NameTXT.getText().equalsIgnoreCase(NameTXT_data)) {
			System.out.println(NameTXT.getText().equalsIgnoreCase(NameTXT_data));
		} else {
			System.out.println("Test Fail Name");
		}
		// ----Type----//
		
		System.out.println(TypeTXT.getText());
		if (TypeTXT.getText().equalsIgnoreCase(TypeTXT_data)) {
			System.out.println(TypeTXT.getText().equalsIgnoreCase(TypeTXT_data));
		} else {
			System.out.println("Test Fail Type");
		}

		// ----Search----//
		
		System.out.println(Search.getAttribute("value"));
		if (Search.getAttribute("value").equalsIgnoreCase(Search_data)) {
			System.out.println(Search.getAttribute("value").equalsIgnoreCase(Search_data));
		} else {
			System.out.println("Test Fail Search");
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
		
		sheet.getRow(177).createCell(4).setCellValue("Pass");
		sheet.getRow(177).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(177).createCell(4).setCellValue("Fail");
			sheet.getRow(177).getCell(4).setCellStyle(style);
			
			sheet.getRow(177).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(177).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

	@FindBy(xpath = "//div[1]/form/div[1]/div/div/input")
	WebElement Name;
	@FindBy(xpath = "//div[1]/form/div[2]/div/div/select")
	WebElement Type;

	// --Check for search with existing name--//
	public void CRe4_1058_1060_1061() throws Exception {
		
		try{
		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageEthicsCommittee = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[8]/a");
		ManageEthicsCommittee.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");
		String Name_data = r1.getCell(2, 170).getContents();

		WebElement Name = GWait.Wait_GetElementByXpath("//div[1]/form/div[1]/div/div/input");
		Name.sendKeys(Name_data);
		WebElement Search = GWait.Wait_GetElementByXpath("//div[4]/div[1]/form/div[3]/input");
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
		
		sheet.getRow(178).createCell(4).setCellValue("Pass");
		sheet.getRow(178).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(178).createCell(4).setCellValue("Fail");
			sheet.getRow(178).getCell(4).setCellStyle(style);
			
			sheet.getRow(178).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(178).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

	// --Check for search with non existing name--//
	public void CRe4_1059() throws Exception {
		
		try{
		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageEthicsCommittee = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[8]/a");
		ManageEthicsCommittee.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");
		String Name_data = r1.getCell(2, 172).getContents();

		Name.clear();
		WebElement Name = GWait.Wait_GetElementByXpath("//div[1]/form/div[1]/div/div/input");
		Name.sendKeys(Name_data);
		WebElement Search = GWait.Wait_GetElementByXpath("//div[4]/div[1]/form/div[3]/input");
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
		
		sheet.getRow(179).createCell(4).setCellValue("Pass");
		sheet.getRow(179).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(179).createCell(4).setCellValue("Fail");
			sheet.getRow(179).getCell(4).setCellStyle(style);
			
			sheet.getRow(179).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(179).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

	@FindBy(css = ".logout")
	WebElement LogOut;

	// --Check for 'Committee type' drop down values--//
	public void CRe4_1062_1063() throws Exception {
		
		try{
		
		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageEthicsCommittee = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[8]/a");
		ManageEthicsCommittee.click();
		
		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");
		String Name_data = r1.getCell(2, 174).getContents();
		String Type_data = r1.getCell(3, 174).getContents();

		Name.clear();
		WebElement Name = GWait.Wait_GetElementByXpath("//div[1]/form/div[1]/div/div/input");
		Name.sendKeys(Name_data);
		System.out.println(Type.getText());
		Select MT = new Select(Type);
		MT.selectByVisibleText(Type_data);
		WebElement Search = GWait.Wait_GetElementByXpath("//div[4]/div[1]/form/div[3]/input");
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
		
		sheet.getRow(180).createCell(4).setCellValue("Pass");
		sheet.getRow(180).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(180).createCell(4).setCellValue("Fail");
			sheet.getRow(180).getCell(4).setCellStyle(style);
			
			sheet.getRow(180).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(180).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

}
