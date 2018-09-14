package com.create4.scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

//Check for during the configuration of institute, the email template needs to be system configures automatically
public class TS_65 {

	public TS_65() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(linkText = "My Projects")
	WebElement PI_project_menu;

	public void CRe4_65() throws Exception {

		File source = new File("C:\\Selenium_Files\\Create4_v2\\Writevalues.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb = new HSSFWorkbook(input);
		HSSFSheet sheet = wb.getSheetAt(1);
		
		GlobalMethods.Admin_Login_1();

		WebElement link = GWait.Wait_GetElementByLinkText("Email Templates");
		link.click();

		WebElement heading1 = GWait.Wait_GetElementByCSS("h3");
		String textheading = heading1.getText();
		Assert.assertEquals(textheading, "Email Templates");
		System.out.println(textheading);

		//Get rowscount & columncount of the table
		
				int rowscount = GlobalMethods.driver.findElements(By.xpath("//table/tbody/tr")).size();
				System.out.println("rowcount = " + rowscount);
				
				int columncount = GlobalMethods.driver.findElements(By.xpath("//table/tbody/tr[1]/*")).size();
				System.out.println("columnscount = " + columncount);
				
			 int pagination = GlobalMethods.driver.findElements(By.xpath("//html/body/div[4]/div[1]/div[2]/div[3]/div[3]/ul/li/a")).size();
			 System.out.println("pagination size " + pagination);
			 
			 File file1 = new File("C:\\Selenium_Files\\Create4_v2\\notepad.txt");
	       	 FileWriter fw1 = new FileWriter(file1, false);
			for(int k = 3; k<=pagination+1; k++)
			{
				for(int i=1; i<=rowscount; i++)
				{
					for(int j=2;j<=columncount; j++)
					{
						String lineSeparator = System.getProperty("line.separator");
						System.out.print(GlobalMethods.driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/*[" + j + "]")).getText());
						fw1.write(GlobalMethods.driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/*[" + j + "]")).getText());
						fw1.write(lineSeparator);
					}
					/*if(pagination>=columncount)
					 {*/
					System.out.println();
						
					
				}
				System.out.println("k "+ k);
				 GlobalMethods.driver.findElement(By.xpath("//div[3]/ul/li[" + k + "]/a")).click();
					
				}
			fw1.close();
		}
	
	
	}


