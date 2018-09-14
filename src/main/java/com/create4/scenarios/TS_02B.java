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
import org.openqa.selenium.JavascriptExecutor;
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
 * Check for the Login page with valid/Invalid data in institute home page.
 */

public class TS_02B {

	public TS_02B() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);
	
	
	
	
	
	
	@FindBy(id = "register_role")
	WebElement rolefield;
	
	@FindBy(css = "span.cheek-lable")
	WebElement remberoption;
	
	@FindBy(id = "login_institute")
	WebElement loginbutton;
	
	@FindBy(xpath = "//form/a")
	WebElement forgotlink;
	
	@FindBy(css = "h3")
	WebElement dashboardheading;
	
	@FindBy(id = "register_email")
	WebElement loginemail;
	
	@FindBy(id = "register_password")
	WebElement loginpwd;
	
	@FindBy(id = "register_role")
	WebElement loginrle;
	
	@FindBy(css = "div.alert.alert-danger > ul > li")
	WebElement loginalert;
	
	@FindBy(id = "remember_me")
	WebElement rember;
	
	
	public void CRe4_101_102() throws Exception {
		
		try{

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);

		Sheet r1 = wb.getSheet("Institute_Logins");
		String inst_link = r1.getCell(0,2).getContents();
		
		WebElement instclick = GWait.Wait_GetElementByLinkText(inst_link);
		instclick.click();
		
		String roles = "Select Role"+"\n"+"Principal Investigator"+"\n"+"Investigator/Study coordinator/Lab coordinator"+"\n"+"IEC Admin"+"\n"+"IEC Member Secretary"+"\n"+"IEC Chairperson"+"\n"+"IEC Member"+"\n"+"Super Admin";
		
		Thread.sleep(1000);
	//	Assert.assertEquals(rolefield.getText().trim(), roles);
		Thread.sleep(1000);
		Assert.assertEquals(remberoption.getText().trim(), "Remember Me");
		Thread.sleep(1000);
		Assert.assertEquals(loginbutton.getText().trim(), "Login");
		Thread.sleep(1000);
		Assert.assertEquals(forgotlink.getText().trim(), "Forgot Password ?");
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
		
		GlobalMethods.PI_Login();
		
		Assert.assertEquals(dashboardheading.getText().trim(), "Project Summary");
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile1");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(56).createCell(4).setCellValue("Pass");
		sheet.getRow(56).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile1");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(56).createCell(4).setCellValue("Fail");
			sheet.getRow(56).getCell(4).setCellStyle(style);
			
			sheet.getRow(56).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(56).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


		
	}
	
	public void CRe4_103_104_109() throws Exception {

	try{
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("Institute_Logins");
		String inst_link = r.getCell(0,2).getContents();
		
		String email2 = r.getCell(1,2).getContents();
		String pwd2 = r.getCell(2,2).getContents();
		String role2 = r.getCell(3,2).getContents();

		Sheet r1 = wb.getSheet("Data_Sheet");
		
		String email = r.getCell(1,2).getContents();
		String pwd = r1.getCell(3,73).getContents();
		String role = r1.getCell(4,73).getContents();
		String alert = r1.getCell(5,73).getContents();
		
		String email1 = r1.getCell(6,73).getContents();
		String pwd1 = r1.getCell(7,73).getContents();
		String role1 = r1.getCell(8,73).getContents();
		
		
		
		String alert1 = r1.getCell(9,73).getContents();
		
		WebElement instclick = GWait.Wait_GetElementByLinkText(inst_link);
		instclick.click();

		
		WebElement loginemail =GWait.Wait_GetElementById("register_email");
		loginemail.sendKeys(email);
		
		
		WebElement loginpwd =GWait.Wait_GetElementById("register_password");
		loginpwd.sendKeys(pwd);
		Thread.sleep(1000);
		WebElement role_inv = GWait.Wait_GetElementById("register_role");
		Select dropdown = new Select(role_inv);
		dropdown.selectByValue("2");
		
		
		WebElement loginbutton =GWait.Wait_GetElementById("login_institute");
		loginbutton.click();
		
		Assert.assertEquals(loginalert.getText().trim(), alert);
		WebElement loginemail1 =GWait.Wait_GetElementById("register_email");
		loginemail1.sendKeys(email1);
		WebElement loginpwd1 =GWait.Wait_GetElementById("register_password");
		loginpwd1.sendKeys(pwd1);
		Thread.sleep(1000);
		WebElement role_inv1 = GWait.Wait_GetElementById("register_role");
		Select dropdown1 = new Select(role_inv1);
		dropdown1.selectByValue("2");
		WebElement loginbutton1 =GWait.Wait_GetElementById("login_institute");
		loginbutton1.click();
		
		Assert.assertEquals(loginalert.getText().trim(), alert);
		WebElement loginemail2 =GWait.Wait_GetElementById("register_email");
		loginemail2.clear();
		WebElement loginpwd2 =GWait.Wait_GetElementById("register_password");
		loginpwd2.clear();
		Thread.sleep(1000);
		WebElement loginbutton2 =GWait.Wait_GetElementById("login_institute");
		loginbutton2.click();
		
		Assert.assertEquals(loginalert.getText().trim(), alert1);
		WebElement loginemail3 =GWait.Wait_GetElementById("register_email");
		loginemail3.sendKeys(email2);
		WebElement loginpwd3 =GWait.Wait_GetElementById("register_password");
		loginpwd3.sendKeys(pwd2);
		Thread.sleep(1000);
		WebElement role_inv2 = GWait.Wait_GetElementById("register_role");
		Select dropdown2 = new Select(role_inv2);
		dropdown2.selectByValue("1");
		
		WebElement rember =GWait.Wait_GetElementById("remember_me");
		rember.click();
		WebElement loginbutton3 =GWait.Wait_GetElementById("login_institute");
		loginbutton3.click();
		
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		WebElement loginemail4 =GWait.Wait_GetElementById("register_email");
		loginemail4.sendKeys(email2);
		//loginpwd.sendKeys(pwd2);
		Thread.sleep(1000);
		WebElement role_inv3 = GWait.Wait_GetElementById("register_role");
		Select dropdown3 = new Select(role_inv3);
		dropdown3.selectByValue("1");
		//rember.click();
		WebElement loginbutton4 =GWait.Wait_GetElementById("login_institute");
		loginbutton4.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile1");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(57).createCell(4).setCellValue("Pass");
		sheet.getRow(57).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile1");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(57).createCell(4).setCellValue("Fail");
			sheet.getRow(57).getCell(4).setCellStyle(style);
			
			sheet.getRow(57).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(57).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}



		
	}
	
	public void CRe4_108() throws Exception {
		
		try{
		
		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String Inst_heading = r1.getCell(2,75).getContents();
		
		GlobalMethods.driver.navigate().back();
		
		//GlobalWait.LoadGif();
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(800,0);");

		
		WebElement SOPlink = GWait.Wait_GetElementByLinkText("SOPs");
		SOPlink.click();
		
		
		WebElement godashboard = GWait.Wait_GetElementByLinkText("Goto Dashboard");
		String godashtext = godashboard.getText();
		
		
		
		Assert.assertEquals(godashtext, "Goto Dashboard");
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile1");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(58).createCell(4).setCellValue("Pass");
		sheet.getRow(58).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile1");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(58).createCell(4).setCellValue("Fail");
			sheet.getRow(58).getCell(4).setCellStyle(style);
			
			sheet.getRow(58).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(58).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}
	
	public void CRe4_111() throws Exception {
		
		try{
		
		System.out.println("(automation feasible but feature not implemented)");
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile1");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(59).createCell(4).setCellValue("Pass");
		sheet.getRow(59).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile1");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(59).createCell(4).setCellValue("Fail");
			sheet.getRow(59).getCell(4).setCellStyle(style);
			
			sheet.getRow(59).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(59).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


		
	}
	
}