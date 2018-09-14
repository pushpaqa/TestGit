package com.create4.scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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

//Check for Investigator's Registration Requests section functionality in Admin dashboard
public class TS_112 {
	public TS_112() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);
	
	@FindBy(xpath = "//div[7]/div/div/table/thead/tr/th")
	WebElement investheading_name;
	
	@FindBy(xpath = "//div[7]/div/div/table/thead/tr/th[2]")
	WebElement investheading_email;
	
	@FindBy(xpath = "//div[7]/div/div/table/thead/tr/th[3]")
	WebElement investheading_date;
	
	@FindBy(xpath = "//div[7]/div/div/table/tbody/tr/td/a")
	WebElement invest_click;
	
	@FindBy(linkText = "Dashboard")
	WebElement dashboard_link;
	
	@FindBy(xpath = "(//a[contains(text(),'View all')])[2]")
	WebElement viewall_link;
		
	@FindBy(xpath = "//span/a")
	WebElement logoutt;

	@FindBy(css = "img")
	WebElement logo;
	
	// study team members

		@FindBy(xpath = "//div[7]/div/h3")
		WebElement investigator;
				
		
		@FindBy(css = "h3")
		WebElement investigatorheading;
		
		@FindBy(xpath = "//td[3]")
		WebElement emailinv;
		
		@FindBy(xpath = "//td[8]")
		WebElement status;
		
		@FindBy(xpath = "//div[7]/div/div/table/tbody/tr/td[2]")
		WebElement emailindash;
		
		//Check for Investigator's Registration Requests section
		public void CRe4_454_455_456_457_458_459_460() throws Exception{
			
			try{
			GlobalMethods.Admin_Login();
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r = wb.getSheet("Institute_Logins");
			Sheet r1 = wb.getSheet("Data_Sheet");
			Sheet r2 = wb.getSheet("Dashboard");

			
			//PI Register data
			
			
			String PI_Reg_Institute = r.getCell(0, 2).getContents();
			
			String PI_firstname = r1.getCell(2, 103).getContents();
			String PI_middlename = r1.getCell(3, 103).getContents();
			String PI_lastname = r1.getCell(4, 103).getContents();
			String PI_emdpid = r1.getCell(5, 103).getContents();
			String PI_dob = r1.getCell(6, 103).getContents();
			String PI_phnum = r1.getCell(7, 103).getContents();
			String PI_email = r1.getCell(24, 103).getContents();
			
			String PI_photo = r1.getCell(9, 103).getContents();
			String PI_dept1 = r1.getCell(10, 103).getContents();
			String PI_dept2 = r1.getCell(11, 103).getContents();
			String PI_desg = r1.getCell(12, 103).getContents();
			String PI_gcpdate = r1.getCell(13, 103).getContents();
			String PI_gcpdoc = r1.getCell(14, 103).getContents();
			String PI_cvdate = r1.getCell(15, 103).getContents();
			String PI_cvdoc = r1.getCell(16, 103).getContents();
			String rejtext = r1.getCell(17, 103).getContents();
			
			String invteamreg = r2.getCell(2, 15).getContents(); 
			String name = r2.getCell(3, 15).getContents(); 
			String email = r2.getCell(4, 15).getContents(); 
			String date = r2.getCell(5, 15).getContents(); 
			String inv_heading = r2.getCell(6, 15).getContents();
			
			Thread.sleep(3000);
			System.out.println(investigator.getText());
			Assert.assertEquals(investigator.getText().trim(), invteamreg);
			
			Thread.sleep(3000);
			System.out.println(investheading_name.getText());
			Assert.assertEquals(investheading_name.getText().trim(), name);
			
			Thread.sleep(3000);
			System.out.println(investheading_email.getText());
			Assert.assertEquals(investheading_email.getText().trim(), email);
			
			Thread.sleep(3000);
			System.out.println(investheading_date.getText());
			Assert.assertEquals(investheading_date.getText().trim(), date);
			
			Thread.sleep(3000);
			System.out.println(emailindash.getText());
			Assert.assertEquals(emailindash.getText().trim(), PI_email);
			
						
			WebElement viewall_link =GWait.Wait_GetElementByXpath("(//a[contains(text(),'View all')])[2]");
			viewall_link.click();
			
			Thread.sleep(3000);
			System.out.println(investigatorheading.getText());
			Assert.assertEquals(investigatorheading.getText().trim(), inv_heading);
			
			
			
			Thread.sleep(3000);
			System.out.println(emailinv.getText());
			Assert.assertEquals(emailinv.getText().trim(), PI_email);
			
			Thread.sleep(3000);
			System.out.println(status.getText());
			//Assert.assertEquals(status.getText().trim(), "Authroized /No PI Access");
			
			String XPath1 = "//td[8]";
			Boolean iselementpresent = GlobalMethods.driver.findElements(By.xpath(XPath1)).size()!= 0;
			   if (iselementpresent == true)
			   {
			    System.out.print("Approve / Reject");
			   }
			   else
			   {
			    System.out.print("Approved & account is active");
			   }
			   
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
						
					
					HSSFSheet sheet=wb11.getSheet("Executionfile1");
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
		
		
		
		

}
