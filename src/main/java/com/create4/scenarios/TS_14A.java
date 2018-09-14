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


//***Check for Add Qualification with valid/Invalid data(After creation should display in the List/Registration forms/Member forms)***//
public class TS_14A {
	public TS_14A() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);
	
	@FindBy(xpath = "//a[contains(text(),'Manage IEC')]")
	WebElement Manage_IEC;

	@FindBy(xpath = "//li[4]/ul/li[5]/a")
	WebElement Manage_Qualifications;

	@FindBy(css = ".col-sm-10.col-xs-12.main-right>h3")
	WebElement Verify_Qualifications;

	@FindBy(xpath = "//div[4]/div[1]/div/div[1]/div/li/div/ul/li[2]/div/a")
	WebElement Add_Qualification;

	@FindBy(css = ".col-sm-10.col-xs-12.main-right>h3")
	WebElement Verify_AddQualificationstxt;

	@FindBy(id = "addQualificationButton")
	WebElement Submit_Qualifi;

	@FindBy(css = ".help-block")
	WebElement BlankAlertQ;

	@FindBy(css = ".help-block")
	WebElement BlankAlertMD;

	@FindBy(id = "add_qualification_name")
	WebElement QualifiTextBox;

	@FindBy(xpath = "//form/div[2]/div/div/span/input[1]")
	WebElement MedicalDegree;

	@FindBy(css = ".bg-success.text-success.col-sm-12.text-center")
	WebElement AddDepartmentPopuptext;

	@FindBy(xpath = "//td[contains(text(),'TestQualification')]")
	WebElement QulifiValue;

	public void AddQualification_CRe4_928_CRe4_921_CRe4_929() throws Exception {
	
		
		try{
			// ----------IEC Admin Login------------//
			GlobalMethods.Admin_Login();

			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r = wb.getSheet("ManageIEC");
			String ManageQualifi_text = r.getCell(2, 19).getContents();
			String AddQualifi_text = r.getCell(3, 19).getContents();
			String Qualification_Data = r.getCell(4, 19).getContents();

			WebElement Manage_IECA1=GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
			Manage_IECA1.click();
			WebElement Manage_Qualifications1=GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
			Manage_Qualifications1.click();
			
		    WebElement Verify1=GWait.Wait_GetElementByCSS(".col-sm-10.col-xs-12.main-right>h3");
			System.out.println("Test cases == CRe4_921");
			System.out.println(Verify1.getText());
			System.out.println(ManageQualifi_text);
			System.out.println(Verify1.getText().equalsIgnoreCase(ManageQualifi_text));

			// --------Test cases == CRe4_928, Check for add qualification-----//
			WebElement Add_Qualification1=GWait.Wait_GetElementByXpath("//div[4]/div[1]/div/div[1]/div/li/div/ul/li[2]/div/a");
			Add_Qualification1.click();
			WebElement Verify_AddQualificationstxt1=GWait.Wait_GetElementByCSS(".col-sm-10.col-xs-12.main-right>h3");
			System.out.println(Verify_AddQualificationstxt1.getText());
			System.out.println(AddQualifi_text);
			System.out.println(Verify_AddQualificationstxt1.getText().equalsIgnoreCase(AddQualifi_text));

			// ------Test cases == CRe4_929, Check for add qualification with blank
			// data-----//
			
			System.out.println("Test cases == CRe4_929");
			// ---Click Submit Button---//
			WebElement Submit_Qualifi1=GWait.Wait_GetElementById("addQualificationButton");
			Submit_Qualifi1.click();
			WebElement BlankAlertQ1=GWait.Wait_GetElementByCSS(".help-block");
			Assert.assertEquals(BlankAlertQ1.getText(), "The Qualification field is required!");
			System.out.println(BlankAlertQ1.getText());
			
			WebElement Alert=GWait.Wait_GetElementByXpath("//form[@id='add_qualification_form']/div[2]/div/div/span/small");
            Assert.assertEquals(Alert.getText(), "The Medical Degree field is required!");
			// ------Test cases == CRe4_930, Check for add qualification with valid
			// data-----//
			
			System.out.println("Test cases == CRe4_930");

			WebElement QualifiTextBox1=GWait.Wait_GetElementById("add_qualification_name");
			QualifiTextBox1.sendKeys(Qualification_Data);
			WebElement MedicalDegree1=GWait.Wait_GetElementByXpath("//form/div[2]/div/div/span/input[1]");
			MedicalDegree1.click();
			// ---Click Submit Button---//
			WebElement Submit_Qualifi11=GWait.Wait_GetElementById("addQualificationButton");
			Submit_Qualifi11.click();

			WebElement AddDepartmentPopuptext1=GWait.Wait_GetElementByCSS(".bg-success.text-success.col-sm-12.text-center");
			System.out.println(AddDepartmentPopuptext1.getText());
			WebElement QulifiValue1=GWait.Wait_GetElementByXpath("//td[contains(text(),'TestQualification')]");
			System.out.println(QulifiValue1.getText().equalsIgnoreCase(Qualification_Data));

			WebElement LogOutA1=GWait.Wait_GetElementByLinkText("Logout");
			LogOutA1.click();
		
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
			
			sheet.getRow(53).createCell(4).setCellValue("Pass");
			sheet.getRow(53).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(53).createCell(4).setCellValue("Fail");
				sheet.getRow(53).getCell(4).setCellStyle(style);
				
				sheet.getRow(53).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(53).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}


	}

	// -------Test Cases -- CRe4_931 -------//

	@FindBy(linkText = "html/body/div[1]/div[1]/div[1]/a[1]/img")
	WebElement Logo;

	@FindBy(linkText = "Research approval institute")
	WebElement InstiLink;

	@FindBy(css = ".btn.btn-primary.col-sm-12.register-class")
	WebElement Registration;

	@FindBy(xpath = "html/body/div[5]/div/div/div/div/form/div[2]/div[3]/div/div")
	WebElement QulificationCheckbox;

	@FindBy(linkText="Logout")
	WebElement LogOut;

	public void AddQualification_CRe4_930() throws Exception {
		
		try{
		
			// ----------Click to 'Research approval institute'------------//
			
		WebElement InstiLink=GWait.Wait_GetElementByLinkText("Research approval institute");
			InstiLink.click();

			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r = wb.getSheet("ManageIEC");
			String ManageQualifi_text = r.getCell(2,23).getContents();

			// ------Test cases == CRe4_931, Check for add qualification in
			// registration forms-----//
			WebElement Registration=GWait.Wait_GetElementByCSS(".btn.btn-primary.col-sm-12.register-class");
			Registration.click();
			WebElement QulificationCheckbox=GWait.Wait_GetElementByXpath("html/body/div[5]/div/div/div/div/form/div[2]/div[3]/div/div");
			QulificationCheckbox.click();
			System.out.println(QulificationCheckbox.getText());
		
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
			
			sheet.getRow(54).createCell(4).setCellValue("Pass");
			sheet.getRow(54).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(54).createCell(4).setCellValue("Fail");
				sheet.getRow(54).getCell(4).setCellStyle(style);
				
				sheet.getRow(54).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(54).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}

	}

}
