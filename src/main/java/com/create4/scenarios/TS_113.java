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

/*
 * Check for Investigator's Registration Requests section functionality in Admin dashboard
 */
public class TS_113 {
	public TS_113() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);
	
	@FindBy(xpath = "//div[8]/div/div/table/thead/tr/th")
	WebElement investheading_name;
	
	@FindBy(xpath = "//div[8]/div/div/table/thead/tr/th[2]")
	WebElement investheading_email;
	
	@FindBy(xpath = "//div[8]/div/div/table/thead/tr/th[3]")
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
	
	@FindBy(xpath = "//td[4]")
	WebElement emailinv;
	
	@FindBy(xpath = "//td[8]")
	WebElement status;
	
	
	// study team members

		@FindBy(xpath = "//div[8]/div/h3")
		WebElement investigator;
		
		@FindBy(css = "h3")
		WebElement investigatorheading;
		
		
		//Check for Investigator's Registration Requests section
		public void CRe4_462_to_467() throws Exception{
			
			try{
			
			GlobalMethods.Admin_Login();
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("Data_Sheet");
			Sheet r2 = wb.getSheet("Dashboard");
			
			
			String studyteammem_name = r1.getCell(2, 119).getContents();
			String studyteammem_email = r1.getCell(3, 119).getContents();
			String studyteammem_role = r1.getCell(4, 119).getContents();
			
			
			String studyteamreg = r2.getCell(2, 13).getContents(); 
			String name = r2.getCell(3, 13).getContents(); 
			String email = r2.getCell(4, 13).getContents(); 
			String date = r2.getCell(5, 13).getContents(); 
			String study_heading = r2.getCell(6, 13).getContents(); 
			
			Thread.sleep(3000);
			System.out.println(investigator.getText());
			Assert.assertEquals(investigator.getText().trim(), studyteamreg);
			
			Thread.sleep(3000);
			System.out.println(investheading_name.getText());
			Assert.assertEquals(investheading_name.getText().trim(), name);
			
			Thread.sleep(3000);
			System.out.println(investheading_email.getText());
			Assert.assertEquals(investheading_email.getText().trim(), email);
			
			Thread.sleep(3000);
			System.out.println(investheading_date.getText());
			Assert.assertEquals(investheading_date.getText().trim(), date);
			
			
			
			
			/*WebElement invest_click =GWait.Wait_GetElementByXpath("//div[7]/div/div/table/tbody/tr/td/a");
			invest_click.click();
			
			
			WebElement dashboard_link =GWait.Wait_GetElementByLinkText("Dashboard");
			dashboard_link.click();*/
			
			
			WebElement viewall_link =GWait.Wait_GetElementByXpath("(//a[contains(text(),'View all')])[3]");
			viewall_link.click();
			
			Thread.sleep(3000);
			System.out.println(investigatorheading.getText());
			Assert.assertEquals(investigatorheading.getText().trim(), study_heading);
			
			Thread.sleep(3000);
			System.out.println(emailinv.getText());
			Assert.assertEquals(emailinv.getText().trim(), studyteammem_email);
			
			Thread.sleep(3000);
			System.out.println(status.getText());
			Assert.assertEquals(status.getText().trim(), "Authroized /No PI Access");
			
			
			WebElement logoutt2A = GWait.Wait_GetElementByXpath("//span/a");
			logoutt2A.click();

			WebElement logo1A = GWait.Wait_GetElementByCSS("img");
			logo1A.click();
			
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
			
			sheet.getRow(114).createCell(4).setCellValue("Pass");
			sheet.getRow(114).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(114).createCell(4).setCellValue("Fail");
				sheet.getRow(114).getCell(4).setCellStyle(style);
				
				sheet.getRow(114).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(114).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}

			
		}
		
		
		
		

}
