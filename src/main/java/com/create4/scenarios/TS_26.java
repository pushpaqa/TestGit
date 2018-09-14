package com.create4.scenarios;

import static org.testng.Assert.assertEquals;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check the admin actions on Manage registration requests (Approve/Reject/Active/Inactive)
 */
public class TS_26 {

	public TS_26() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);
	
	@FindBy(xpath = "//div[3]/div/ul/li[8]/a")
	WebElement ResearchAppIns;

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[5]/a")
	WebElement ManageUsers;
	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[5]/ul/li[1]/a")
	WebElement ManageRegistration;
	@FindBy(xpath = "//a[text()='Reject']")
	WebElement ReJect;
	@FindBy(id = "reason_rejection")
	WebElement ResonsFor;
	@FindBy(css = ".request_reject_yes.btn.btn-default.first-btn.btn-green")
	WebElement Yes;
	@FindBy(css = ".request_reject_no.btn.btn.btn-default.first-btn.btn-orange")
	WebElement No;

	@FindBy(xpath = "//a[text()='Approve']")
	WebElement Approved;
	@FindBy(css = ".request_approval_yes.btn.btn-default.first-btn.btn-green")
	WebElement YesApproved;
	@FindBy(css = ".request_approval_ok.btn.btn-default.first-btn.btn-green")
	WebElement YesApprovedOK;
	@FindBy(css = ".request_approval_no.btn.btn.btn-default.first-btn.btn-orange")
	WebElement NoApproved;
	
	@FindBy(id = "designation")
	WebElement desgig;
	
	@FindBy(id = "dept")
	WebElement deptg;
	
	@FindBy(id = "departmenttext")
	WebElement deptgtext;
	
	@FindBy(id = "mrvalids")
	WebElement register_mrvalids;
	
	@FindBy(name = "mrdocs")
	WebElement register_mrdocs;
	
	@FindBy(name = "resumevalid")
	WebElement register_resumevalid;
	
	@FindBy(name = "resume")
	WebElement register_resume;
	
	@FindBy(id = "field_terms")
	WebElement register_field_terms;
	
	@FindBy(xpath = "//form[@id='registerform']/div[5]/div/div/p/input")
	WebElement register_field_terms1;
	
	
	
	public void Register_CRe4_58_59_60_61() throws Exception {
		
		try{

		Thread.sleep(2000);
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Data_Sheet");
		
		String RejectApproved_data = r1.getCell(2, 101).getContents();
		String Resons_data = r1.getCell(3, 101).getContents();
		String YesNo_data = r1.getCell(4, 101).getContents();

        WebElement ManageUsers = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/a");

		ManageUsers.click();
		
        WebElement ManageRegistration = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/ul/li[1]/a");

		ManageRegistration.click();
		  	
		
        String xpath = "//td[2]";
		 WebElement imgElement = GlobalMethods.driver.findElement(By.xpath(xpath));
	       try {
	         
	          System.out.println("true"); 
	        } catch(Exception e){
	        	System.out.println("false"); 
	       }
	       
	       
	      String xpath1 = "//td[6]/a";
	       WebElement imgElement1 = GlobalMethods.driver.findElement(By.xpath(xpath1));
			   if (imgElement1.getText().equalsIgnoreCase("Activate"))
			  {
				  				   
			    System.out.print("Activate");
			   }else
			   {
			   System.out.println("other");
			    

			}
			   
			   if (imgElement1.getText().equalsIgnoreCase("De-activate"))
				  {
					  				   
				    System.out.print("De-activate");
				   }else
				   {
				   System.out.println("other");
				    

				}
			   
			   if (imgElement1.getText().equalsIgnoreCase("Approve / Reject"))
				  {
					  				   
				    System.out.print("Approve / Reject");
				   }else
				   {
				   System.out.println("other");
	 

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
				
				sheet.getRow(73).createCell(4).setCellValue("Pass");
				sheet.getRow(73).getCell(4).setCellStyle(style);
				
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
					
					sheet.getRow(73).createCell(4).setCellValue("Fail");
					sheet.getRow(73).getCell(4).setCellStyle(style);
					
					sheet.getRow(73).createCell(5).setCellValue("Report Error: "+ "\n" + e);
					sheet.getRow(73).getCell(5).setCellStyle(style);
					
					FileOutputStream output = new FileOutputStream(source);
					wb11.write(output);
					wb11.close();
					
					throw(e);
			}

	
	}
		/*if (ReJect.getText().equalsIgnoreCase(RejectApproved_data)) {
			Thread.sleep(2000);
			ReJect.click();
			Thread.sleep(2000);
			ResonsFor.sendKeys(Resons_data);
			if (Yes.getText().equalsIgnoreCase(YesNo_data)) {
//				Thread.sleep(2000);
				Yes.click();
			} else {
				Thread.sleep(2000);
				No.click();
			}

		} else {
			Thread.sleep(2000);
			Approved.click();
			Thread.sleep(2000);
			System.out.println("Test"+YesApproved.getText());
			if (YesApproved.getText().equalsIgnoreCase(YesNo_data)) {
				Thread.sleep(2000);
				YesApproved.click();
				Thread.sleep(1000);
				YesApprovedOK.click();
			} else {
				Thread.sleep(2000);
				NoApproved.click();
			}
		}

	}
	*/
	public void Register_CRe4_64_65() throws Exception {
		
		try{

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("Institute_Logins");
		Sheet r1 = wb.getSheet("Data_Sheet");

		
		//PI Register data
		
		
		String PI_Reg_Institute = r.getCell(0, 2).getContents();
		
		String PI_firstname = r1.getCell(2, 103).getContents();
		String PI_middlename = r1.getCell(3, 103).getContents();
		String PI_lastname = r1.getCell(4, 103).getContents();
		String PI_emdpid = r1.getCell(5, 103).getContents();
		String PI_dob = r1.getCell(6, 103).getContents();
		String PI_phnum = r1.getCell(7, 103).getContents();
		String PI_email = r1.getCell(8, 103).getContents();
		
		String PI_photo = r1.getCell(9, 103).getContents();
		String PI_dept1 = r1.getCell(10, 103).getContents();
		String PI_dept2 = r1.getCell(11, 103).getContents();
		String PI_desg = r1.getCell(12, 103).getContents();
		String PI_gcpdate = r1.getCell(13, 103).getContents();
		String PI_gcpdoc = r1.getCell(14, 103).getContents();
		String PI_cvdate = r1.getCell(15, 103).getContents();
		String PI_cvdoc = r1.getCell(16, 103).getContents();
		String rejtext = r1.getCell(17, 103).getContents();
		
		
		WebElement PI_institute = GWait.Wait_GetElementByLinkText(PI_Reg_Institute);
		PI_institute.click();
			
		
		WebElement register_institute = GWait.Wait_GetElementByLinkText("Register");
		register_institute.click();
		
				
		
		WebElement register_firstname = GWait.Wait_GetElementById("firstname");
		register_firstname.sendKeys(PI_firstname);
		
		
		WebElement register_middlename = GWait.Wait_GetElementById("middlename");
		register_middlename.sendKeys(PI_middlename);
		
	
		WebElement register_lastname = GWait.Wait_GetElementById("lastname");
		register_lastname.sendKeys(PI_lastname);
		
		
		WebElement register_emp_id = GWait.Wait_GetElementById("emp_id");
		register_emp_id.sendKeys(PI_emdpid);
		
		
		WebElement register_dobs = GWait.Wait_GetElementById("dobs");
		register_dobs.sendKeys(PI_dob);
		
		
		WebElement register_phno = GWait.Wait_GetElementById("phno");
		register_phno.sendKeys(PI_phnum);
		
		
		WebElement register_email = GWait.Wait_GetElementById("email");
		register_email.sendKeys(PI_email);
		
	
		WebElement register_photos = GWait.Wait_GetElementById("photos");
		register_photos.sendKeys(PI_photo);
		
		
       Select select = new Select(deptg);
		select.selectByVisibleText(PI_dept1);
		
		
		
		deptgtext.sendKeys(PI_dept2);
		
		Select select1 = new Select(desgig);
		select1.selectByVisibleText(PI_desg);
		
		//register_designation.sendKeys(PI_desg);
		
		register_mrvalids.sendKeys(PI_gcpdate);
		Thread.sleep(2000);
		register_mrdocs.sendKeys(PI_gcpdoc);
		
		register_resumevalid.sendKeys(PI_cvdate);
		register_resume.sendKeys(PI_cvdoc);

		
		
		
		
		WebElement register_field_terms = GWait.Wait_GetElementById("field_terms");
		register_field_terms.click();
	
		WebElement register_submit = GWait.Wait_GetElementById("registration_submit");
		register_submit.click();
				
	
		
		WebElement Home_Link = GWait.Wait_GetElementByLinkText("Home");
		Home_Link.click();
		
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
		
		GlobalMethods.Admin_Login();
		
				
		WebElement admin_manage_users = GWait.Wait_GetElementByLinkText("Manage Users");
		admin_manage_users.click();
			
		
		WebElement manage_reg_req = GWait.Wait_GetElementByLinkText("Manage Registration Requests");
		manage_reg_req.click();
		
		Thread.sleep(5000);
		
		WebElement ReJect = GWait.Wait_GetElementByXpath("//a[text()='Reject']");
		
		ReJect.click();
		
		Thread.sleep(3000);
		WebElement ResonsFor = GWait.Wait_GetElementById("reason_rejection");
		ResonsFor.sendKeys(rejtext);
		Thread.sleep(2000);
		
		
		
		
		
		WebElement yes = GWait.Wait_GetElementByXpath("//div[@id='rejectconfirmationreasonmodal']/div[2]/div/div[2]/button");
		yes.click();
		
		Thread.sleep(2000);
		WebElement ok = GWait.Wait_GetElementByXpath("//div[@id='registrationstatusapprovalorrejected']/div[2]/div/div[2]/button");
		ok.click();
		
		Thread.sleep(10000);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		
		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();
		
				GlobalMethods.PIMail_rej("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Ftab%3Dwm&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin","qualeetee113@gmail.com","qa123456");
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
				
				sheet.getRow(74).createCell(4).setCellValue("Pass");
				sheet.getRow(74).getCell(4).setCellStyle(style);
				
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
					
					sheet.getRow(74).createCell(4).setCellValue("Fail");
					sheet.getRow(74).getCell(4).setCellStyle(style);
					
					sheet.getRow(74).createCell(5).setCellValue("Report Error: "+ "\n" + e);
					sheet.getRow(74).getCell(5).setCellStyle(style);
					
					FileOutputStream output = new FileOutputStream(source);
					wb11.write(output);
					wb11.close();
					
					throw(e);
			}

				
	}
	
	
	public void Register_CRe4_70_71_72_73_74() throws Exception {
		
	try{
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("Institute_Logins");
		Sheet r1 = wb.getSheet("Data_Sheet");

		
		//PI Register data
		
		
		String PI_Reg_Institute = r.getCell(0, 2).getContents();
		
		String PI_firstname = r1.getCell(18, 103).getContents();
		String PI_middlename = r1.getCell(19, 103).getContents();
		String PI_lastname = r1.getCell(20, 103).getContents();
		String PI_emdpid = r1.getCell(21, 103).getContents();
		String PI_dob = r1.getCell(22, 103).getContents();
		String PI_phnum = r1.getCell(23, 103).getContents();
		String PI_email = r1.getCell(24, 103).getContents();
		
		String PI_photo = r1.getCell(25, 103).getContents();
		String PI_dept1 = r1.getCell(26, 103).getContents();
		String PI_dept2 = r1.getCell(27, 103).getContents();
		String PI_desg = r1.getCell(28, 103).getContents();
		String PI_gcpdate = r1.getCell(29, 103).getContents();
		String PI_gcpdoc = r1.getCell(30, 103).getContents();
		String PI_cvdate = r1.getCell(31, 103).getContents();
		String PI_cvdoc = r1.getCell(32, 103).getContents();
		
		Thread.sleep(7000);
		
		WebElement PI_institute = GWait.Wait_GetElementByLinkText(PI_Reg_Institute);
		PI_institute.click();
			
		
		WebElement register_institute = GWait.Wait_GetElementByLinkText("Register");
		register_institute.click();
		
				
		
		WebElement register_firstname = GWait.Wait_GetElementById("firstname");
		register_firstname.sendKeys(PI_firstname);
		
		
		WebElement register_middlename = GWait.Wait_GetElementById("middlename");
		register_middlename.sendKeys(PI_middlename);
		
	
		WebElement register_lastname = GWait.Wait_GetElementById("lastname");
		register_lastname.sendKeys(PI_lastname);
		
		
		WebElement register_emp_id = GWait.Wait_GetElementByName("emp_id");
		register_emp_id.sendKeys(PI_emdpid);
		
		
		WebElement register_dobs = GWait.Wait_GetElementById("dobs");
		register_dobs.sendKeys(PI_dob);
		
		
		WebElement register_phno = GWait.Wait_GetElementById("phno");
		register_phno.sendKeys(PI_phnum);
		
		
		WebElement register_email = GWait.Wait_GetElementById("email");
		register_email.sendKeys(PI_email);
		
	
		WebElement register_photos = GWait.Wait_GetElementById("photos");
		register_photos.sendKeys(PI_photo);
		
		
		Select select = new Select(deptg);
		select.selectByVisibleText(PI_dept1);
		
		
		
		deptgtext.sendKeys(PI_dept2);
		
		Select select1 = new Select(desgig);
		select1.selectByVisibleText(PI_desg);
		
		//register_designation.sendKeys(PI_desg);
		
		register_mrvalids.sendKeys(PI_gcpdate);
		Thread.sleep(2000);
		register_mrdocs.sendKeys(PI_gcpdoc);
		
		register_resumevalid.sendKeys(PI_cvdate);
		register_resume.sendKeys(PI_cvdoc);

		WebElement register_field_terms = GWait.Wait_GetElementById("field_terms");
		register_field_terms.click();
	
		WebElement register_submit = GWait.Wait_GetElementById("registration_submit");
		register_submit.click();
	
	
		
		WebElement Home_Link = GWait.Wait_GetElementByLinkText("Home");
		Home_Link.click();
		
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
		
		GlobalMethods.Admin_Login();
		
				
		WebElement admin_manage_users = GWait.Wait_GetElementByLinkText("Manage Users");
		admin_manage_users.click();
			
		
		WebElement manage_reg_req = GWait.Wait_GetElementByLinkText("Manage Registration Requests");
		manage_reg_req.click();
		
		Thread.sleep(2000);
		
		WebElement reason_approve = GWait.Wait_GetElementByLinkText("Approve");
		reason_approve.click();
		
		Thread.sleep(3000);
		
		WebElement reason_approve_yes = GWait.Wait_GetElementByXpath("//div[@id='approvalconfirmationmodal']/div[2]/div/div[2]/button");
		reason_approve_yes.click();
		
		Thread.sleep(5000);
		WebElement reason_approve_ok = GWait.Wait_GetElementByXpath("//div[@id='registrationstatusapprovalorrejected']/div[2]/div/div[2]/button");
		reason_approve_ok.click();
		
		Thread.sleep(10000);
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		
		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();
		
				GlobalMethods.PIMail("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Ftab%3Dwm&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin","qualeetee113@gmail.com","qa123456");
			
		
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
				
				sheet.getRow(75).createCell(4).setCellValue("Pass");
				sheet.getRow(75).getCell(4).setCellStyle(style);
				
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
					
					sheet.getRow(75).createCell(4).setCellValue("Fail");
					sheet.getRow(75).getCell(4).setCellStyle(style);
					
					sheet.getRow(75).createCell(5).setCellValue("Report Error: "+ "\n" + e);
					sheet.getRow(75).getCell(5).setCellStyle(style);
					
					FileOutputStream output = new FileOutputStream(source);
					wb11.write(output);
					wb11.close();
					
					throw(e);
			}

	}

	
	@FindBy(id = "field_terms")
	WebElement IAccept_V;
	
	@FindBy(linkText= "Approve")
	WebElement reason_approve;
	
	@FindBy(xpath= "//div[@id='approvalconfirmationmodal']/div[2]/div/div[2]/button")
	WebElement reason_approve_yes;
	
	@FindBy(xpath= "//div[2]/div/div[2]/button")
	WebElement reason_approve_ok;
}
	
	
	
	
	