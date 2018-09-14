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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

//Check for during the configuration of institute, the document types need to be system configures automatically
public class TS_64 {
	
	public TS_64()
	{
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	 GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
		Actions action = new Actions(GlobalMethods.driver);

		@FindBy(linkText = "My Projects")
		WebElement PI_project_menu;
		
		


public void CRe4_64() throws Exception{
	
	FileInputStream fis = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
	Workbook wb = Workbook.getWorkbook(fis);
	Sheet r1 = wb.getSheet("Project Submissions");
	
	
	
	GlobalMethods.Admin_Login_1();

        //verifying default document type

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement ManageDocumentType = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[6]/a");
		ManageDocumentType.click();
		
		WebElement heading1 = GWait.Wait_GetElementByCSS("h3");
		String textheading = heading1.getText();
		Assert.assertEquals(textheading,"Manage Project Document Types");
		
		
		
		for(int i = 2; i<= 26; i++)
		{
		
			System.out.println(i);
			String Projecttype1 = r1.getCell(i,537).getContents();
			String Reviewtype1 = r1.getCell(i,538).getContents();
			String Submissiontype1 = r1.getCell(i,539).getContents();
			
		//Selecting project type value from boot strap field
		WebElement ProjType = GWait.Wait_GetElementByXpath(".//*[@id='manageannexures']/div[1]/div/div/div/button");
		ProjType.click();
		
		List<WebElement> projtypvalue = GlobalMethods.driver.findElements(By.xpath(".//*[@id='manageannexures']/div[1]/div/div/div/div/ul/li"));
		
		
		for(WebElement all: projtypvalue)
		{
			WebElement span = all.findElement(By.tagName("span"));
		    if(span.getText().equalsIgnoreCase(Projecttype1))
		    {
		    	System.out.println("Project type" + " " + span.getText());
		    	span.click();
		    	break;
		    }
		}
		
		//Selecting review type value from boot strap field
		WebElement RewType = GWait.Wait_GetElementByXpath(".//*[@id='manageannexures']/div[2]/div/div/div/button");
		RewType.click();
		
		List<WebElement> Rewvalues = GlobalMethods.driver.findElements(By.xpath(".//*[@id='manageannexures']/div[2]/div/div/div/div/ul/li"));
		for(WebElement elementlist1 : Rewvalues)
		{
			WebElement span = elementlist1.findElement(By.tagName("span"));
			if(span.getText().equalsIgnoreCase(Reviewtype1))
			{
				System.out.println("Review type" + " " + span.getText());
				span.click();
				break;
			}
		}
		
		//Selecting Submission type value from boot strap field
		
		WebElement submType = GWait.Wait_GetElementByXpath(".//*[@id='manageannexures']/div[3]/div/div/div/button");
		submType.click();
		
		List<WebElement> submvalues = GlobalMethods.driver.findElements(By.xpath(".//*[@id='manageannexures']/div[3]/div/div/div/div/ul/li"));
		for(WebElement elementlist2 : submvalues)
		{
			WebElement span = elementlist2.findElement(By.tagName("span"));
					if(span.getText().equalsIgnoreCase(Submissiontype1))
					{
						System.out.println("Submission type" + " " + span.getText());
						span.click();
						break;
					}
		}
		 WebElement seearchb = GWait.Wait_GetElementByXpath(".//*[@id='manageannexures']/div[4]/input");
	        seearchb.click();
	        
	        File source = new File("C:\\Selenium_Files\\Create4_v2\\Writevalues.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb1 = new HSSFWorkbook(input);
			
			HSSFSheet sheet = wb1.getSheetAt(0);
	        
	        HSSFRow rowing = sheet.createRow(i);
	        
	        WebElement table = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped"));
	        //WebElement table1 = GlobalMethods.driver.findElement(By.xpath("//table")).getSize()!=0;
	      String Xpath1 = "//table/tbody/tr/td[2]";
	        
	       // System.out.println(table.getText());
	        Boolean iselementpresent = GlobalMethods.driver.findElements(By.xpath(Xpath1)).size()!= 0;
	       
			   if (iselementpresent == true)
			   {
			    System.out.print("exists");
			   
			   
	        List<WebElement> rows = table.findElements(By.tagName("tr"));
	       System.out.println("Number of trs in a table = " + rows.size());
	       
	        
	        for(WebElement row : rows)
	        {
	                	
	        	List<WebElement> cells = row.findElements(By.xpath("//table/tbody/tr/td"));
	        	System.out.println("Number of tds in a table = " + cells.size());
	        	
	        	//prints first column value
	        	WebElement firstcol1 = GlobalMethods.driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
	        	String firstcol = firstcol1.getText();
	        	HSSFCell celling = rowing.createCell(1);
	        	celling.setCellValue(firstcol);
	        	System.out.println("firstcol" + " " + "+" + " " + firstcol);
	        	
	        	//prints second column value
	        	WebElement secondcol1 = GlobalMethods.driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]"));
	        	String secondcol = secondcol1.getText();
	        	//sheet.createRow(i).createCell(2).setCellValue(secondcol);
	        	HSSFCell celling1 = rowing.createCell(2);
	        	celling1.setCellValue(secondcol);
	        	System.out.println("secondcol" + " " + "+" + " " + secondcol);
	        	
	        	////prints third column value
	        	WebElement thirdcol1 = GlobalMethods.driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]"));
	        	String thirdcol = thirdcol1.getText();
	        	//sheet.createRow(i).createCell(3).setCellValue(thirdcol);
	        	HSSFCell celling11 = rowing.createCell(3);
	        	celling11.setCellValue(thirdcol);
	        	System.out.println("thirdcol" + " " + "+" + " " + thirdcol);
	        	
	        	//prints fourth column value
	        	WebElement fourthcol1 = GlobalMethods.driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]"));
	        	String fourthcol = fourthcol1.getText();
	        	//sheet.createRow(i).createCell(4).setCellValue(fourthcol);
	        	HSSFCell celling111 = rowing.createCell(4);
	        	celling111.setCellValue(fourthcol);
	        	System.out.println("fourthcol" + " " + "+" + " " + fourthcol);
	        		     
	        	//write to file
	        	FileOutputStream output = new FileOutputStream(source);
				wb1.write(output);
				wb1.close();
	        	
				
	        	 break;
	        }
	        
	      
	       
	        
			   }
				
		else
		
		   {
			
			System.out.println("No document types for " + Projecttype1 + " " + Reviewtype1 + " " + Submissiontype1);
		    System.out.print("No records found");
		    
			HSSFCell celling = rowing.createCell(5);
			celling.setCellValue("No document types for " + Projecttype1 + " " + Reviewtype1 + " " + Submissiontype1);
			 FileOutputStream output = new FileOutputStream(source);
			    wb1.write(output);
			    wb1.close();
		   
		   }
      
			  
		}

       
			

}
}

		

