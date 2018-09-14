package com.create4.scenarios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.jetty.http.SSORealm;
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

//Check for document type names in project document list for all submisssions
public class Verifying_Documentypes {

	public Verifying_Documentypes() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	// PI submit new project page elements

	@FindBy(linkText = "Submit New Project")
	WebElement createproject;

	@FindBy(linkText = "My Projects")
	WebElement PI_project_menu;

	@FindBy(linkText = "Projects")
	WebElement MS_project_menu;

	@FindBy(linkText = "Archived Projects")
	WebElement PI_archived_menu;

	@FindBy(xpath = ".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button")
	public WebElement projtypdrop;

	@FindBy(xpath = "html/body/div[5]/div[1]/div[3]/div[4]/div[1]/form/div/div[1]/div[1]/div/div/div/ul/li")
	public static List<WebElement> projtypvalue;

	// review type selection element

	@FindBy(xpath = "//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button")
	public WebElement revtypdrop;
	@FindBy(xpath = "html/body/div[5]/div[1]/div[3]/div[4]/div[1]/form/div/div[2]/div[1]/div/div/div/ul/li")
	public static List<WebElement> revtypvalue;

	@FindBy(id = "projecttitle")
	WebElement Full_title;

	@FindBy(id = "projectshorttitle")
	WebElement short_title;

	@FindBy(id = "pi_name")
	WebElement PI_Name;

	@FindBy(id = "project_description")
	WebElement sponsor;

	@FindBy(xpath = "//*[@id='sumsave']")
	WebElement save_button1;

	@FindBy(id = "sumsave")
	WebElement save_button3;

	// document type selection element_initial

	@FindBy(xpath = "//*[@id='document_type']/div/button")
	public WebElement docdrop;
	@FindBy(xpath = "//*[@id='document_type']/div/div/ul/li")
	public static List<WebElement> docvalue;

	// document type selection element_continuing

	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button")
	public WebElement docdrop_c;
	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/div/ul/li")
	public static List<WebElement> docvalue_c;

	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/tbody/tr[2]/td")
	WebElement doctype_List;

	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/tbody/tr[2]/td[2]")
	WebElement doctype_title;

	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/tbody/tr[2]/td[3]")
	WebElement doctype_version;

	@FindBy(xpath = "//div[@id='list_documents']/div/div/table/tbody/tr[2]/td[4]")
	WebElement doctype_date;

	// sussequent doctype upload

	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/button")
	public WebElement docdrop1;
	@FindBy(xpath = "//*[@id='submitnewuploadproject']/div/div[1]/div[2]/div/div/div/ul/li")
	public static List<WebElement> docvalue1;

	@FindBy(xpath = "//*[@id='respondqueryupload']/div/div[1]/div[1]/div/div/button")
	public WebElement docdrop2;
	@FindBy(xpath = "//*[@id='respondqueryupload']/div/div[1]/div[1]/div/div/div/ul/li")
	public static List<WebElement> docvalue2;

	public static int querydoccount = 0;

	// Check for 'Project status' when initial submission gets MS decision as
	// 'Letter of Permission'
	public void CRe4_doctypename() throws Exception {

		// ******************Initial Project Submission********************//

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		// Project summary data
		String Project_Type = r1.getCell(2, 21).getContents();
		String Review_Type_fullboard = r1.getCell(3, 21).getContents();
		String Project_Full_Title = r1.getCell(4, 21).getContents();
		String Project_Short_Title = r1.getCell(5, 21).getContents();
		String Sponsor = r1.getCell(6, 21).getContents();

		// Document upload data
		String Document_Title_in_list = r1.getCell(7, 21).getContents();
		String Version_in_list = r1.getCell(8, 21).getContents();
		String Document_Date_in_list = r1.getCell(9, 21).getContents();
		String doc_upload = r1.getCell(10, 21).getContents();

		//Admin review data
		String pyrcnum = r1.getCell(11, 21).getContents();
		String inwnum = r1.getCell(12, 21).getContents();
		String prjnum = r1.getCell(13, 21).getContents();
		String insdate = r1.getCell(14, 21).getContents();
		String inwrddate = r1.getCell(15, 21).getContents();
		String ethic_com = r1.getCell(16, 21).getContents();
		String ethic_comnts = r1.getCell(17, 21).getContents();
		
		// MS data
		String Rev_one = r1.getCell(18, 21).getContents();
				
		GlobalMethods.PI_Login();

		WebElement myproj = GWait.Wait_GetElementByLinkText("My Projects");
		myproj.click();

		
	/*WebElement createproject =GWait.Wait_GetElementByLinkText("Submit New Project");
		 createproject.click();
		 
		  WebElement projtypdrop = GWait .Wait_GetElementByXpath( ".//*[@id='projectsummary']/div/div[1]/div[1]/div/div/button");
		 projtypdrop.click();
		 Thread.sleep(2000);
		  
		 List<WebElement> elementsList11 = projtypvalue;
			for (WebElement a11 : elementsList11) {
				WebElement span = a11.findElement(By.tagName("span"));
				if (span.getText().equalsIgnoreCase(Project_Type)) {
					span.click();
					break;
				}
			}
		 
		 WebElement revtypdrop = GWait .Wait_GetElementByXpath("//*[@id='projectsummary']/div/div[2]/div[1]/div/div/button");
		 revtypdrop.click();
		 Thread.sleep(2000);
		 
		 List<WebElement> elementsList2 = revtypvalue;
			for (WebElement a111 : elementsList2) {
				WebElement span = a111.findElement(By.tagName("span"));
				// System.out.println(Review_Type);
				System.out.println(span.getText());
				if (span.getText().equalsIgnoreCase(Review_Type_fullboard)) {

					String doc = span.getText();
					span.click();
					System.out.println(doc);
					break;
				}
			}

		  
		  WebElement Full_title = GWait.Wait_GetElementById("projecttitle");
		 Full_title.sendKeys(Project_Full_Title);
		  
		  WebElement short_title = GWait.Wait_GetElementById("projectshorttitle");
		  short_title.sendKeys(Project_Short_Title);
		 
		  WebElement sponsor = GWait.Wait_GetElementById("project_description");
		  sponsor.sendKeys(Sponsor);
		  
		  WebElement save_button1 =GWait.Wait_GetElementByXpath("//*[@id='sumsave']");
		  save_button1.click();
		  
		  Thread.sleep(2000);
			System.out.println(docvalue.size() - 1);
			

			for (int i = 1; i <= docvalue.size() - 1; i++) {
				querydoccount = docvalue.size();
			
				Thread.sleep(10000);
				WebElement docdrop = GWait.Wait_GetElementByXpath("html/body/div[5]/div[1]/div[3]/div[4]/div[2]/form/div/div[1]/div[1]/div/div/div/button");
				docdrop.click();
				String numberAsString = Integer.toString(i);
				Thread.sleep(5000);
				List<WebElement> elementsList3 = docvalue;
				int j = 0;
				for (WebElement a11 : elementsList3) {
					WebElement span = a11.findElement(By.tagName("span"));
					System.out.println(numberAsString);
					System.out.println(span.getAttribute("data-original-index"));
					if (i == j) {
						Thread.sleep(2000);
						String doc = span.getText();
						span.click();
						System.out.println(doc);

						break;
					}
					j++;
				}
				if (i == j) {
					WebElement doc_title = GWait.Wait_GetElementById("document_title");
					doc_title.sendKeys(Document_Title_in_list);

					WebElement doc_version = GWait.Wait_GetElementById("version");
					doc_version.sendKeys(Version_in_list);

					WebElement doc_date = GWait.Wait_GetElementById("document_date");
					doc_date.sendKeys(Document_Date_in_list);

					WebElement upload_doc = GWait.Wait_GetElementById("proj_document");
					upload_doc.sendKeys(doc_upload);

					WebElement save_button2 = GWait.Wait_GetElementById("savedoc");
					save_button2.click();

				}

			}
		  
		  Thread.sleep(2000); 
		  ((JavascriptExecutor)GlobalMethods.driver).executeScript("scroll(0,1000)");
		  Thread.sleep(10000);
		  
	  WebElement htmltable1 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped"));
		 
		 List<WebElement> Allrows = htmltable1.findElements(By.xpath("//table/tbody/tr"));
		 for(WebElement row : Allrows)
		 {
			 List<WebElement> cells = row.findElements(By.xpath("//td[1]"));
			 System.out.println("Number of tds in the total first column's in this table = " + cells.size());
			 
			 File source = new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			  FileInputStream input = new FileInputStream(source);
			  HSSFWorkbook wb1= new HSSFWorkbook(input);
			  
			  HSSFSheet sheet = wb1.getSheetAt(11);
			  HSSFRow rowing = sheet.createRow(0);
			 for(int k =0; k< cells.size(); k++)
			 {
				 System.out.println(cells.get(k).getText());
				 
				
				  
				 //sheet.createRow(k).createCell(0).setCellValue(cells.get(k).getText());
				  HSSFCell celling = rowing.createCell(0);
				  celling.setCellValue(cells.get(k).getText());
				  FileOutputStream output = new FileOutputStream(source);
				 wb1.write(output); 
				 wb1.close();
				 
			 }
			 break;
		 }
		  
		 
		 
		 WebElement next_button = GWait.Wait_GetElementById("nextid");
		 next_button.click();
		 
		  WebElement submit_to_IEC = GWait.Wait_GetElementById("submitid");
		 submit_to_IEC.click();
		 
		  Thread.sleep(2000); 
		  WebElement no = GWait.Wait_GetElementByXpath( "//*[@id='conflictsubmit']/div[1]/div[1]/div[1]/div/input[2]");
		 no.click();
		 
		  Thread.sleep(1000);
		  WebElement conflictsubmit1 =GWait.Wait_GetElementById("submit_for_iec_review_confirm");
		  conflictsubmit1.click();
		 
		  Thread.sleep(3000); 
		  GlobalMethods.alertaccept();
		  Thread.sleep(6000);*/
		 
		WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
		overview.click();

		WebElement projdoc = GWait.Wait_GetElementByLinkText("Project Documents");
		projdoc.click();

		WebElement selectvalues = GWait.Wait_GetElementByXpath("//html/body/div[5]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/form/div/div/select");
		Select dropdown = new Select(selectvalues);
		// Get all options
		List<WebElement> dd = dropdown.getOptions();

		// Get the length
		System.out.println(dd.size());

		String ele1 = "";
		// Loop to print one by one
		for (int j = 1; j < dd.size(); j++) {
			ele1 = dd.get(j).getText();
			break;
		}

		Select select = new Select(selectvalues);
		select.selectByVisibleText(ele1);

		WebElement searchbtn = GWait.Wait_GetElementByXpath("//form[@id='documentslist']/div/input[3]");
		searchbtn.click();
		
		
	
		
		File fis = new File("C:\\Selenium_Files\\Create4_v2\\Writevalues.xls");
		FileInputStream input1 = new FileInputStream(fis);
		HSSFWorkbook wb1 = new HSSFWorkbook(input1);
		HSSFSheet sheet = wb1.getSheetAt(2);
		
			int rowscount = GlobalMethods.driver.findElements(By.xpath("//table/tbody/tr")).size();		
			System.out.println("rowcount = " + rowscount);
			
			int columncount = GlobalMethods.driver.findElements(By.xpath("//table/tbody/tr[1]/*")).size();
			System.out.println("columnscount = " + columncount);
				
			List<WebElement> cells = GlobalMethods.driver.findElements(By.xpath("//table/tbody/tr[1]/*"));
			int pagination =GlobalMethods.driver.findElements(By.xpath("//div[2]/div[2]/ul/li/a")).size();
			
			
				
			
			File file = new File("C:\\Selenium_Files\\Create4_v2\\notepad_PI.txt");
       	 FileWriter fw = new FileWriter(file, false);
	                for(int i1=3; i1<= 4; i1++)
	                { 
	                	
	                	for(int j = 1; j<=rowscount; j++)
	                	     {
	                		
	                	        for(int i=4; i<=columncount; i++)
	    				             {
	                	        	
	                	        	 String lineSeparator = System.getProperty("line.separator");
	                	        	  
					                		System.out.println(columncount);
					                		System.out.println("Hello inner loop" + " " + i);
					    					
					                		
					    					
					    					System.out.println("PI document types " + i + GlobalMethods.driver.findElement(By.xpath("//table/tbody/tr[" + j + "]/*[" + i + "]")).getText());
					                	fw.write("PI document types " + " = " + "\n" + GlobalMethods.driver.findElement(By.xpath("//table/tbody/tr[" + j + "]/*[" + i + "]")).getText());
					                	fw.write(lineSeparator);
					    										 			
					                	
	    				                }
	                	         System.out.println();
	                	         
	                	      }
	                	System.out.println("end of looo i1 value "+ i1);
	                	Thread.sleep(3000);
	                	GlobalMethods.driver.findElement(By.xpath("//div[2]/div[2]/ul/li[" + i1 + "]/a")).click();
	                	Thread.sleep(3000);
	                	
	                }
	                
	                fw.close();
				
			
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();

		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
		
		
				GlobalMethods.Admin_Login();
				
				
				WebElement myproj1 = GWait.Wait_GetElementByLinkText("Projects");
				myproj1.click();

				 WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				 overview1.click();
				 
				 WebElement projdoc1 = GWait.Wait_GetElementByLinkText("Project Documents");
					projdoc1.click();

					WebElement selectvalues1 = GWait.Wait_GetElementByXpath("//html/body/div[4]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/form/div/div/select");
					Select dropdown1 = new Select(selectvalues1);
					// Get all options
					List<WebElement> dd1 = dropdown1.getOptions();

					// Get the length
					System.out.println(dd1.size());

					String ele11 = "";
					// Loop to print one by one
					for (int j = 1; j < dd1.size(); j++) {
						ele11 = dd1.get(j).getText();
						break;
					}

					Select select1 = new Select(selectvalues1);
					select1.selectByVisibleText(ele11);

					WebElement searchbtn1 = GWait.Wait_GetElementByXpath("//form[@id='documentslist']/div/input[3]");
					searchbtn1.click();
					
					File file1 = new File("C:\\Selenium_Files\\Create4_v2\\notepad_admin.txt");
			       	 FileWriter fw1 = new FileWriter(file1, false);
				                for(int i1=3; i1<= 4; i1++)
				                { 
				                	
				                	for(int j = 1; j<=rowscount; j++)
				                	     {
				                		
				                	        for(int i=4; i<=columncount; i++)
				    				             {
				                	        	
				                	        	 String lineSeparator = System.getProperty("line.separator");
				                	        	  
								                		System.out.println(columncount);
								                		System.out.println("Hello inner loop" + " " + i);
								    					
							
								                	fw1.write("Admin Document types " + " = " + "\n" + GlobalMethods.driver.findElement(By.xpath("//table/tbody/tr[" + j + "]/*[" + i + "]")).getText());
								                	fw1.write(lineSeparator);
								    										 			
								                	
				    				                }
				                	         System.out.println();
				                	         
				                	      }
				                	System.out.println("end of looo i1 value "+ i1);
				                	Thread.sleep(3000);
				                	GlobalMethods.driver.findElement(By.xpath("//div[2]/div[2]/ul/li[" + i1 + "]/a")).click();
				                	Thread.sleep(3000);
				                	
				                }
				                
				                fw1.close();
							
				                
				                WebElement Admin_Review = GWait.Wait_GetElementByLinkText("IEC Admin Review");
				        		Admin_Review.click();
				        		
				        		WebElement Processing_fee_yes2 = GWait.Wait_GetElementById("processing_fee_paid");
				        		Processing_fee_yes2.click();

				        		WebElement payment_receipt_yes2 = GWait.Wait_GetElementById("payment_receipt");
				        		payment_receipt_yes2.sendKeys(pyrcnum);

				        		WebElement hard_copy_yes2 = GWait.Wait_GetElementById("hard_copy_submitted");
				        		hard_copy_yes2.click();

				        		WebElement inward_no_yes2 = GWait.Wait_GetElementById("inward_no");
				        		inward_no_yes2.sendKeys(inwnum);

				        		WebElement projnum2 = GWait.Wait_GetElementById("project_number");
				        		projnum2.sendKeys(prjnum);

				        		WebElement insurdate2 = GWait.Wait_GetElementById("insurance_date");
				        		insurdate2.sendKeys(insdate);

				        		WebElement inwdate2 = GWait.Wait_GetElementById("inward_no_date");
				        		inwdate2.sendKeys(inwrddate);

				        		WebElement forward_button2 = GWait.Wait_GetElementById("forward_modal_btn");
				        		forward_button2.click();

				        		Thread.sleep(6000);
				        		WebElement ethic_selection2 = GWait.Wait_GetElementById("txn_ethic_committee_id");
				        		Select select22 = new Select(ethic_selection2);
				        		select22.selectByVisibleText(ethic_com);

				        		

				        		WebElement ethic_comments2 = GWait.Wait_GetElementByClassName("richText");
				        		ethic_comments2.sendKeys(ethic_comnts);

				        		WebElement ethic_frwd2 = GWait.Wait_GetElementById("forward_btn");
				        		ethic_frwd2.click();

				        		Thread.sleep(20000);
				        		GWait.LoadGif();
						
					WebElement logoutt1 = GWait.Wait_GetElementByXpath("//span/a");
					logoutt1.click();

					WebElement logo1 = GWait.Wait_GetElementByCSS("img");
					logo1.click();
					
					GlobalMethods.MS_Login();
					
					WebElement myproj11 = GWait.Wait_GetElementByLinkText("Projects");
					myproj11.click();

					 WebElement overview11 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
					 overview11.click();
					 
					 WebElement projdoc11 = GWait.Wait_GetElementByLinkText("Project Documents");
						projdoc11.click();

						WebElement selectvalues11 = GWait.Wait_GetElementByXpath("//html/body/div[4]/div[1]/div[1]/div[2]/div[6]/div[1]/div[1]/div[1]/form/div/div/select");
						Select dropdown11 = new Select(selectvalues11);
						// Get all options
						List<WebElement> dd11 = dropdown11.getOptions();

						// Get the length
						System.out.println(dd11.size());

						String ele111 = "";
						// Loop to print one by one
						for (int j = 1; j < dd11.size(); j++) {
							ele111 = dd11.get(j).getText();
							break;
						}

						Select select11 = new Select(selectvalues11);
						select11.selectByVisibleText(ele111);

						WebElement searchbtn11 = GWait.Wait_GetElementByXpath("//form[@id='documentslist']/div/input[3]");
						searchbtn11.click();
						
						File file11 = new File("C:\\Selenium_Files\\Create4_v2\\notepad_ms.txt");
				       	 FileWriter fw11 = new FileWriter(file11, false);
					                for(int i1=3; i1<= 4; i1++)
					                { 
					                	
					                	for(int j = 1; j<=rowscount; j++)
					                	     {
					                		
					                	        for(int i=4; i<=columncount; i++)
					    				             {
					                	        	
					                	        	 String lineSeparator = System.getProperty("line.separator");
					                	        	  
									                		System.out.println(columncount);
									                		System.out.println("Hello inner loop" + " " + i);
									    					
								
									                	fw11.write("MS Document types " + " = " + "\n" + GlobalMethods.driver.findElement(By.xpath("//table/tbody/tr[" + j + "]/*[" + i + "]")).getText());
									                	fw11.write(lineSeparator);
									    										 			
									                	
					    				                }
					                	         System.out.println();
					                	         
					                	      }
					                	System.out.println("end of looo i1 value "+ i1);
					                	Thread.sleep(3000);
					                	GlobalMethods.driver.findElement(By.xpath("//div[2]/div[2]/ul/li[" + i1 + "]/a")).click();
					                	Thread.sleep(3000);
					                	
					                }
					                
					                fw11.close();
					                
					               /* WebElement asignreviewers = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
					        		asignreviewers.click();

					        		WebElement primaryreview_one = GWait.Wait_GetElementById("primary_reviewer");
					        		Select select111 = new Select(primaryreview_one);
					        		select111.selectByVisibleText(Rev_one);
	        		
					        		

					        		WebElement assign_button = GWait.Wait_GetElementById("assign");
					        		assign_button.click();

					        		Thread.sleep(20000);
					        		GWait.LoadGif();
*/
					                
					                WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
					        		logoutt2.click();

					        		WebElement logo81 = GWait.Wait_GetElementByCSS("img");
					        		logo81.click();
			
	}

}

	

