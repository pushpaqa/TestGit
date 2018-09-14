package com.create4.scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.NoSuchElementException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
 * Check for change password feature functionality 
 */
public class TS_94 {

	public TS_94() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(linkText = "My Account")
	WebElement menu_myaccount;

	@FindBy(linkText = "Change Password")
	WebElement menu_changepassword;

	@FindBy(css = "h3.main-ouside")
	WebElement heading_changepassword;

	@FindBy(xpath = "//form[@id='changepassword']/div/label")
	WebElement field1_changepassword;

	@FindBy(xpath = "//form[@id='changepassword']/div[2]/label")
	WebElement field2_changepassword;

	@FindBy(xpath = "//form[@id='changepassword']/div[3]/label")
	WebElement field3_changepassword;

	@FindBy(css = "button.btn.btn-orange")
	WebElement field4_changepassword;

	@FindBy(id = "old_password")
	WebElement oldpwd;

	@FindBy(id = "password")
	WebElement pwd;

	@FindBy(id = "password_confirmation")
	WebElement pwdcnfrmtn;

	@FindBy(xpath = "//div[3]/div/p")
	WebElement alert1;

	@FindBy(xpath = "(//a[contains(text(),'Logout')])[2]")
	WebElement logoutt;

	@FindBy(css = "img")
	WebElement logo;

	@FindBy(id = "register_email")
	WebElement email;

	@FindBy(id = "register_password")
	WebElement password;

	@FindBy(id = "register_role")
	WebElement rol;

	@FindBy(id = "login_institute")
	WebElement login;

	@FindBy(id = "dept")
	WebElement deptg;

	@FindBy(id = "designation")
	WebElement desgig;

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

	// Check for change password form
	public void CRe4_728_729_730_733_734() throws Exception {

		// Creating PI

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("Institute_Logins");
		Sheet r1 = wb.getSheet("Projects");

		// PI Register data

		String PI_Reg_Institute = r.getCell(0, 2).getContents();
		//String PI_Reg_email = r1.getCell(8, 23).getContents();
		String PI_Reg_pwd = r1.getCell(25, 23).getContents();

		String PI_firstname = r1.getCell(2, 23).getContents();
		String PI_middlename = r1.getCell(3, 23).getContents();
		String PI_lastname = r1.getCell(4, 23).getContents();
		String PI_emdpid = r1.getCell(5, 23).getContents();
		String PI_dob = r1.getCell(6, 23).getContents();
		String PI_phnum = r1.getCell(7, 23).getContents();
		String PI_email = r1.getCell(8, 23).getContents();

		String PI_photo = r1.getCell(9, 23).getContents();
		String PI_dept1 = r1.getCell(10, 23).getContents();
		String PI_dept2 = r1.getCell(11, 23).getContents();
		String PI_desg = r1.getCell(12, 23).getContents();
		String PI_gcpdate = r1.getCell(13, 23).getContents();
		String PI_gcpdoc = r1.getCell(14, 23).getContents();
		String PI_cvdate = r1.getCell(15, 23).getContents();
		String PI_cvdoc = r1.getCell(16, 23).getContents();

		String formpageheading = r1.getCell(17, 23).getContents();
		String field1pageheading = r1.getCell(18, 23).getContents();
		String field2pageheading = r1.getCell(19, 23).getContents();
		String field3pageheading = r1.getCell(20, 23).getContents();
		String field4pageheading = r1.getCell(21, 23).getContents();
		String newpwdvalid = r1.getCell(22, 23).getContents();
		String cnfrmpwdvalid = r1.getCell(23, 23).getContents();
		String successalert = r1.getCell(24, 23).getContents();

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

		// register_designation.sendKeys(PI_desg);

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

		// Thread.sleep(2000);

		WebElement reason_approve = GWait.Wait_GetElementByLinkText("Approve");
		reason_approve.click();

		Thread.sleep(3000);

		WebElement reason_approve_yes = GWait
				.Wait_GetElementByXpath("//div[@id='approvalconfirmationmodal']/div[2]/div/div[2]/button");
		reason_approve_yes.click();

		// Thread.sleep(3000);
		WebElement reason_approve_ok = GWait
				.Wait_GetElementByXpath("//div[@id='registrationstatusapprovalorrejected']/div[2]/div/div[2]/button");
		reason_approve_ok.click();

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();

		WebElement logo1 = GWait.Wait_GetElementByCSS("img");
		logo1.click();

		GlobalMethods.PIMail4changepwd(
				"https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Ftab%3Dwm&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin",
				"qualeetee112@gmail.com", "qa@123456");
		
		WebElement logo2 = GWait.Wait_GetElementByCSS("img");
		logo2.click();

		Thread.sleep(2000);
		GlobalMethods.PILogin4changepwd();

		Thread.sleep(2000);
		WebElement menu_myaccount = GWait.Wait_GetElementByLinkText("My Account");
		menu_myaccount.click();

		WebElement menu_changepassword = GWait.Wait_GetElementByLinkText("Change Password");
		menu_changepassword.click();

		Thread.sleep(1000);
		Assert.assertEquals(heading_changepassword.getText(), formpageheading);
		Thread.sleep(1000);
		Assert.assertEquals(field1_changepassword.getText(), field1pageheading);
		Thread.sleep(1000);
		Assert.assertEquals(field2_changepassword.getText(), field2pageheading);
		Thread.sleep(1000);
		Assert.assertEquals(field3_changepassword.getText(), field3pageheading);
		Thread.sleep(1000);
		Assert.assertEquals(field4_changepassword.getText(), field4pageheading);

		System.out.println(PI_Reg_pwd);
		WebElement oldpwd = GWait.Wait_GetElementById("old_password");
		oldpwd.sendKeys(PI_Reg_pwd);

		System.out.println(newpwdvalid);
		WebElement pwd = GWait.Wait_GetElementById("password");
		pwd.sendKeys(newpwdvalid);

		System.out.println(cnfrmpwdvalid);
		WebElement pwdcnfrmtn = GWait.Wait_GetElementById("password_confirmation");
		pwdcnfrmtn.sendKeys(cnfrmpwdvalid);

		WebElement field4_changepassword = GWait.Wait_GetElementByCSS("button.btn.btn-orange");
		field4_changepassword.click();
        Thread.sleep(1000);
		Assert.assertEquals(alert1.getText(), successalert);

		WebElement logoutt1 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt1.click();
		
		File source = new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb1 = new HSSFWorkbook(input);

		HSSFSheet sheet = wb1.getSheetAt(0);
		sheet.getRow(14).createCell(2).setCellValue(newpwdvalid);

		FileOutputStream output = new FileOutputStream(source);
		wb1.write(output);
		wb1.close();

		
		Thread.sleep(2000);

	    WebElement email = GWait.Wait_GetElementById("register_email");
		email.sendKeys(PI_email);

		WebElement password = GWait.Wait_GetElementById("register_password");
		password.sendKeys(newpwdvalid);

		WebElement rol = GWait.Wait_GetElementById("register_role");
		Select dropdown = new Select(rol);
		dropdown.selectByValue("1");

		WebElement login = GWait.Wait_GetElementById("login_institute");
		login.click();

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();
		
		
		

	}

	// Check for change password form submission with Invalid confirm new
	// password
	public void CRe4_731_732() throws Exception {
		
		

		GlobalMethods.PILogin4changepwd();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Projects");
		Sheet r2 = wb.getSheet("Institute_Logins");

		String oldpwdvalid = r2.getCell(2, 14).getContents();
		String newpwdvalid = r1.getCell(2, 25).getContents();
		String cnfrmpwdvalid = r1.getCell(3, 25).getContents();

		String cnfrmpwdvalidalert = r1.getCell(4, 25).getContents();

		String newpwdvalidalert = r1.getCell(5, 25).getContents();

		Thread.sleep(1000);
		WebElement menu_myaccount = GWait.Wait_GetElementByLinkText("My Account");
		menu_myaccount.click();

		WebElement menu_changepassword = GWait.Wait_GetElementByLinkText("Change Password");
		menu_changepassword.click();

		WebElement oldpwd = GWait.Wait_GetElementById("old_password");
		oldpwd.sendKeys(oldpwdvalid);

		WebElement pwd = GWait.Wait_GetElementById("password");
		pwd.sendKeys(newpwdvalid);

		WebElement pwdcnfrmtn = GWait.Wait_GetElementById("password_confirmation");
		pwdcnfrmtn.sendKeys(cnfrmpwdvalid);

		WebElement field4_changepassword = GWait.Wait_GetElementByCSS("button.btn.btn-orange");
		field4_changepassword.click();

		Assert.assertEquals(alert1.getText(), newpwdvalidalert);

		WebElement oldpwd1 = GWait.Wait_GetElementById("old_password");
		oldpwd1.sendKeys(cnfrmpwdvalid);

		WebElement pwd1 = GWait.Wait_GetElementById("password");
		pwd1.sendKeys(newpwdvalid);

		WebElement pwdcnfrmtn1 = GWait.Wait_GetElementById("password_confirmation");
		pwdcnfrmtn1.sendKeys(oldpwdvalid);

		WebElement field4_changepassword1 = GWait.Wait_GetElementByCSS("button.btn.btn-orange");
		field4_changepassword1.click();
        Thread.sleep(1000);
		Assert.assertEquals(alert1.getText(), cnfrmpwdvalidalert);

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();
		
		 

	}

}
