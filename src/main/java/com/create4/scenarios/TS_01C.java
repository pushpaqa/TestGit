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
 * Check for the Manage IEC Admins page after creating the admin in superadmin login with view/edit/delete
 */
public class TS_01C {

	public TS_01C() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);
	
	@FindBy(xpath = "//a[contains(text(),'Manage Items')]")
	WebElement Manage_Items; // s

	@FindBy(xpath = "//a[contains(text(),'Manage Institute Admins')]")
	WebElement Manage_Inst_admin; // s

	@FindBy(linkText = "Add IEC Admin")
	WebElement add_inst_admin;// s

	@FindBy(css = ".logout")
	WebElement logoutt;// s

	@FindBy(css = "img")
	WebElement logo; // s

	@FindBy(id = "add_iec_admin_details")
	WebElement Submit_button; // s

	// Form fields elements

	@FindBy(id = "add_iec_admin_first_name")
	WebElement iec_admin_first_name;// s

	@FindBy(id = "add_iec_admin_last_name")
	WebElement iec_admin_last_name;// s

	@FindBy(id = "add_iec_admin_date_of_birth")
	WebElement iec_admin_date_of_birth;// s

	@FindBy(id = "add_iec_admin_email")
	WebElement iec_admin_email;// s

	@FindBy(id = "add_iec_admin_contact_number")
	WebElement iec_admin_contact_number;// s

	@FindBy(id = "add_iec_admin_photo")
	WebElement iec_admin_photo;// s

	@FindBy(id = "add_iec_admin_department")
	WebElement iec_admin_department;// s

	@FindBy(id = "add_iec_admin_designation")
	WebElement iec_admin_designation;// s

	@FindBy(id = "add_iec_admin_qualifications")
	WebElement iec_admin_qualifications;// s

	@FindBy(id = "add_iec_admin_registration_number")
	WebElement iec_admin_registration_number;// s

	@FindBy(id = "add_iec_admin_appointment_letter")
	WebElement iec_admin_appointment_letter;// s

	@FindBy(id = "add_iec_admin_curriculum_vitae")
	WebElement iec_admin_curriculum_vitae;// s

	@FindBy(id = "add_iec_admin_institute")
	WebElement iec_admin_institute;// s

	@FindBy(xpath = "//form[@id='manageiecadmins']/div/p")
	WebElement Admin_Acknowledge;// s

	// Institution creation elements

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a")
	WebElement Insts; // s

	@FindBy(xpath = "//*[@id='accordion']/li[2]/div/a")
	WebElement createins; // s

	@FindBy(id = "inst_name")
	WebElement Inst_Title; // s

	@FindBy(id = "inst_address")
	WebElement Adds; // s

	@FindBy(id = "cgi_des")
	WebElement DCGI_Reg_Numr; // s

	@FindBy(id = "cgi_attach")
	WebElement DCGI_Reg_Letter_Upload_attachmnt; // s

	@FindBy(id = "accrediation_desc")
	WebElement Accredn; // s

	@FindBy(id = "acc_attach")
	WebElement Accredn_Attachmnt; // s

	@FindBy(id = "inst_logo")
	WebElement Ins_Logo; // s

	@FindBy(xpath = "//*[@id='createinstitute']/div[8]/div/input")
	WebElement Create_button; // s

	@FindBy(xpath = "//*[@id='createinstitute']/div[8]/div/button")
	WebElement Back_button; // s

	@FindBy(id = "Institutions")
	WebElement instheading;

	@FindBy(css = ".bgand-border>h3")
	WebElement Institute_form_heading;

	@FindBy(xpath = "//p")
	WebElement MSG; // s

	@FindBy(xpath = "//*[@id='createinstitute']/div[1]/label")
	WebElement Institute_Title;// s
	
	@FindBy(linkText = "Create Institute")
	WebElement crete;
	
	// --Search Email Address---//
		@FindBy(id = "iec_admin_email")
		WebElement Email_Search;
		@FindBy(css = "div.loaderGif")
		WebElement SearchBTN;

		// --View--//
		@FindBy(css = ".fa.fa-eye")
		WebElement ViewLink;
		
		@FindBy(css = ".fa.fa-eye")
		WebElement Backbutton;
		
		//Admin veiw elements
		
		@FindBy(css = "span.text-green")
		WebElement institutetitleview;
		
		@FindBy(xpath = "//div[2]/div[2]/span")
		WebElement rolenameview;
		
		@FindBy(css = "p")
		WebElement dateview;
		
		@FindBy(xpath = "//div[4]/div[2]/p")
		WebElement emailview;
		
		@FindBy(xpath = "//div[5]/div[2]/p")
		WebElement cntctview;
		
		@FindBy(id = "iec_admin_photo_name")
		WebElement photoview;
		
		@FindBy(xpath = "//div[4]/div/div/div[2]/p")
		WebElement deptview;
		
		@FindBy(xpath = "//div[2]/div[2]/p")
		WebElement desgview;
		
		@FindBy(xpath = "//div[4]/div/div[3]/div[2]/p")
		WebElement qualview;
		
		@FindBy(xpath = "//div[4]/div/div[4]/div[2]/p")
		WebElement mrcview;
		
		@FindBy(xpath = "//div[5]/div[2]/p/a")
		WebElement attach1view;
		
		@FindBy(xpath = "//div[4]/div/div[6]/div[2]/p/a")
		WebElement attach2view;
		
		@FindBy(css=".fa.fa-edit")
		WebElement EditLink;
		
		@FindBy(xpath="//td[6]")
		WebElement liststatus;
		
		@FindBy(css=".fa.fa-remove")
		WebElement Deactive;

		@FindBy(css="span.fa.fa-check")
		WebElement Activeicon;
		
		
		@FindBy(css=".bg-success.text-success.col-sm-12.text-center")
		WebElement Message;
		
		@FindBy(xpath="//h3")
		WebElement pageheading;
		
		//admin tabular list elements
		
		@FindBy(xpath="//th[2]/a/span[2]")
		WebElement tablefield1;
		
		@FindBy(xpath="//th[3]/a/span[2]")
		WebElement tablefield2;
		
		@FindBy(xpath="//th[4]/a/span[2]")
		WebElement tablefield3;
		
		@FindBy(xpath="//th[5]/a/span[2]")
		WebElement tablefield4;
		
		@FindBy(xpath="//th[6]/a/span[2]")
		WebElement tablefield5;
		
		@FindBy(xpath="//th[7]/span")
		WebElement tablefield6;
		
	
		
		
		/*
		 * Check for 'Manage Institute Admin' link functionality
		 * Check for 'Manage institute admin' list features
		 * Check for the tabular column details of Manage IEC admins' list
		 * Check for 'Actions' in manage iec admin list 
		 */
		
		public void CRe4_802_803_804_805() throws Exception {
			
			try{
			
			GlobalMethods.Super_Login();

			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);

			Sheet r1 = wb.getSheet("Data_Sheet");
			
			String adminpageheading = r1.getCell(2, 61).getContents();
			String adminaddheading = r1.getCell(3, 61).getContents();
			
			String field1 = r1.getCell(4, 61).getContents();
			String field2 = r1.getCell(5, 61).getContents();
			String field3 = r1.getCell(6, 61).getContents();
			String field4 = r1.getCell(7, 61).getContents();
			String field5 = r1.getCell(8, 61).getContents();
			String field6 = r1.getCell(9, 61).getContents();
			
			String viewactionpageheading = r1.getCell(10, 61).getContents();
			String editactionpageheading = r1.getCell(11, 61).getContents();
			
			String removemsg = r1.getCell(12, 61).getContents();
			String addmsg = r1.getCell(13, 61).getContents();

			WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
			Manage_Items.click();
			
			
			WebElement Manage_Items1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
			Manage_Items1.click();
			
			WebElement Manage_Inst_admin = GWait.Wait_GetElementByXpath("//a[contains(text(),'Manage Institute Admins')]");
			Manage_Inst_admin.click();
			Thread.sleep(1000);
			Assert.assertEquals(pageheading.getText().trim(), adminpageheading);
			
			Assert.assertEquals(add_inst_admin.getText().trim(), adminaddheading);
			
			Assert.assertEquals(tablefield1.getText().trim(), field1);
			Assert.assertEquals(tablefield2.getText().trim(), field2);
			Assert.assertEquals(tablefield3.getText().trim(), field3);
			Assert.assertEquals(tablefield4.getText().trim(), field4);
			Assert.assertEquals(tablefield5.getText().trim(), field5);
			Assert.assertEquals(tablefield6.getText().trim(), field6);
			
			WebElement viewaction = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
			viewaction.click();
			
			Assert.assertEquals(pageheading.getText().trim(), viewactionpageheading);
			
			WebElement managiecadminlink = GWait.Wait_GetElementByLinkText("Manage IEC Admins");
			managiecadminlink.click();
			
			WebElement editaction = GWait.Wait_GetElementByCSS("span.fa.fa-edit");
			editaction.click();
			
			Assert.assertEquals(pageheading.getText().trim(), editactionpageheading);
			
			WebElement managiecadminlink1 = GWait.Wait_GetElementByLinkText("Manage IEC Admins");
			managiecadminlink1.click();
			
			WebElement removeaction = GWait.Wait_GetElementByCSS("span.fa.fa-remove");
			removeaction.click();
			
			GlobalMethods.alertaccept1("Are you sure want to deactivate ?");
			
			Assert.assertEquals(Admin_Acknowledge.getText().trim(), removemsg);
			
			
			WebElement addaction = GWait.Wait_GetElementByCSS("span.fa.fa-check");
			addaction.click();
			
			GlobalMethods.alertaccept1("Are you sure want to activate ?");
			
			Assert.assertEquals(Admin_Acknowledge.getText().trim(), addmsg);
			
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
			
			sheet.getRow(37).createCell(4).setCellValue("Pass");
			sheet.getRow(37).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(37).createCell(4).setCellValue("Fail");
				sheet.getRow(37).getCell(4).setCellStyle(style);
				
				sheet.getRow(37).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(37).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}


		}



	public void CRe4_806_807_808_809_810_811_812() throws Exception {
		
		try{

		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);

		Sheet r1 = wb.getSheet("Data_Sheet");
		//Sheet r2 = wb.getSheet("Institute_Logins");

		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();
				
		WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
		Insts.click();
		
		WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
		createins.click();
		
		//String Admin_Role = r2.getCell(3, 13).getContents();

		String Inst_tite = r1.getCell(2, 63).getContents();
		String Inst_address = r1.getCell(3, 63).getContents();
		String Inst_number = r1.getCell(4, 63).getContents();
		String Inst_attachment = r1.getCell(5, 63).getContents();
		String Inst_accredtion = r1.getCell(6, 63).getContents();
		String Inst_accreattachment = r1.getCell(7, 63).getContents();
		String Inst_logo = r1.getCell(8, 63).getContents();
		
		
		String admin_first_name = r1.getCell(9, 63).getContents();
		String admin_last_name = r1.getCell(10, 63).getContents();
		String admin_dob = r1.getCell(11, 63).getContents();
		String admin_email = r1.getCell(12, 63).getContents();
		String admin_contact_number = r1.getCell(13, 63).getContents();
		String admin_department = r1.getCell(14, 63).getContents();
		String admin_designation = r1.getCell(15, 63).getContents();
		String admin_qualifications = r1.getCell(16, 63).getContents();
		String admin_registration_number = r1.getCell(17, 63).getContents();
		String admin_photo = r1.getCell(18, 63).getContents();
		String admin_appointment_letter = r1.getCell(19, 63).getContents();
		String admin_curriculum_vitae = r1.getCell(20, 63).getContents();
	
		WebElement Inst_Title = GWait.Wait_GetElementById("inst_name");
		Inst_Title.sendKeys(Inst_tite);
		Thread.sleep(2000);
		Adds.sendKeys(Inst_address);
		Thread.sleep(2000);
		DCGI_Reg_Numr.sendKeys(Inst_number);
		Thread.sleep(2000);

		DCGI_Reg_Letter_Upload_attachmnt.sendKeys(Inst_attachment);
		Thread.sleep(1000);

		Accredn.sendKeys(Inst_accredtion);
		Thread.sleep(1000);

		Thread.sleep(1000);
		Accredn_Attachmnt.sendKeys(Inst_accreattachment);
		Thread.sleep(1000);

		Ins_Logo.sendKeys(Inst_logo);
		Create_button.click();
		Thread.sleep(2000);
		String message = MSG.getText();
		String Instmsg = Institute_Title + " " + "Institution created Successfully";
		Instmsg.equalsIgnoreCase(message);

		System.out.println(message);
		
		WebElement Manage_Items1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items1.click();
		

		WebElement Manage_Inst_admin = GWait.Wait_GetElementByXpath("//a[contains(text(),'Manage Institute Admins')]");
		Manage_Inst_admin.click();
		
		WebElement add_inst_admin = GWait.Wait_GetElementByLinkText("Add IEC Admin");
		add_inst_admin.click();
		
		
		Thread.sleep(6000);

		

		
		WebElement iec_admin_institute =GWait.Wait_GetElementById("add_iec_admin_institute");
		Select select = new Select(iec_admin_institute);
		select.selectByVisibleText(Inst_tite);

		
		WebElement iec_admin_first_name =GWait.Wait_GetElementById("add_iec_admin_first_name");
		iec_admin_first_name.sendKeys(admin_first_name);
		Thread.sleep(1000);
		iec_admin_last_name.sendKeys(admin_last_name);
		Thread.sleep(1000);
		iec_admin_date_of_birth.sendKeys(admin_dob);
		Thread.sleep(1000);
		iec_admin_email.sendKeys(admin_email);
		Thread.sleep(1000);
		iec_admin_contact_number.sendKeys(admin_contact_number);
		Thread.sleep(1000);
		iec_admin_photo.sendKeys(admin_photo);
		Thread.sleep(1000);
		Select select1 = new Select(iec_admin_department);
		select1.selectByVisibleText(admin_department);
		Thread.sleep(1000);
		Select select_1 = new Select(iec_admin_designation);

		select_1.selectByVisibleText(admin_designation);
		Thread.sleep(1000);
		iec_admin_qualifications.sendKeys(admin_qualifications);
		Thread.sleep(1000);
		iec_admin_registration_number.sendKeys(admin_registration_number);
		Thread.sleep(1000);
		iec_admin_appointment_letter.sendKeys(admin_appointment_letter);
		Thread.sleep(1000);
		iec_admin_curriculum_vitae.sendKeys(admin_curriculum_vitae);
		
		WebElement Submit_button = GWait.Wait_GetElementById("add_iec_admin_details");
		Submit_button.click();
		Thread.sleep(3000);
		
		//Check for status in the list after create admin
		Assert.assertEquals(liststatus.getText(),"Activated");
		
		
		
		WebElement Deactive = GWait.Wait_GetElementByCSS(".fa.fa-remove");
		Deactive.click();
		Thread.sleep(1000);
		GlobalMethods.alertaccept();
		Thread.sleep(1000);
		Assert.assertEquals(liststatus.getText(),"Deactivated");
		Thread.sleep(1000);
		//Assert.assertEquals(Message.getText(), "Iec member is Deactivated.");
		System.out.println("Deactive Message: "+Message.getText());
		
		WebElement Activeicon = GWait.Wait_GetElementByCSS("span.fa.fa-check");
		Activeicon.click();
		Thread.sleep(1000);
		GlobalMethods.alertaccept();
		Thread.sleep(1000);
		Assert.assertEquals(liststatus.getText(),"Activated");
		System.out.println("Active Message: "+Message.getText());
		//Assert.assertEquals(Message.getText(),"Iec member is activated.");
		

		
		WebElement ViewLink = GWait.Wait_GetElementByCSS(".fa.fa-eye");
		ViewLink.click();
		Thread.sleep(3000);
		
		String Name = admin_first_name+" "+admin_last_name;
		System.out.println(Name);
		
		
		Assert.assertEquals(institutetitleview.getText(), Inst_tite); 
		System.out.println(Inst_tite);
		
		Assert.assertEquals(rolenameview.getText(), Name); 
		System.out.println(Name);
		
		Assert.assertEquals(dateview.getText(), admin_dob); 
		System.out.println(admin_dob);
		
		Assert.assertEquals(emailview.getText(), admin_email); 
		System.out.println(admin_email);
		
		Assert.assertEquals(cntctview.getText(), admin_contact_number); 
		System.out.println(admin_contact_number);
		
		String photo = photoview.getText(); 
		System.out.println(photo);
		
		Assert.assertEquals(deptview.getText(), admin_department); 
		System.out.println(admin_department);
		
		Assert.assertEquals(desgview.getText(), admin_designation); 
		System.out.println(admin_designation);
		
		Assert.assertEquals(qualview.getText(), admin_qualifications); 
		System.out.println(admin_qualifications);
		
		Assert.assertEquals(mrcview.getText(), admin_registration_number); 
		System.out.println(admin_registration_number);
		
		String appntletter = attach1view.getText(); 
		System.out.println(appntletter);
		
		String cirruculumcv = attach2view.getText(); 
		System.out.println(cirruculumcv);
				
		
		//Check for the details in the update iec admin page
		WebElement Manage_Inst_admin1 = GWait.Wait_GetElementByXpath("//a[contains(text(),'Manage IEC Admins')]");
		Manage_Inst_admin1.click();
		
		

		
		WebElement EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		EditLink.click();
		
		Thread.sleep(4500);
		List<WebElement> instfield=GlobalMethods.driver.findElements(By.id("add_iec_admin_institute"));
		for (WebElement selectboxDiv : instfield) {
			String selectboxValue = selectboxDiv.getText().trim();
			if (selectboxValue.equals(Inst_tite)) {
				Assert.assertEquals(selectboxValue, Inst_tite);
				System.out.println(selectboxValue);
			}
		}
		
		//Assert.assertEquals(iec_admin_institute.getAttribute("value"), Inst_tite);
		Thread.sleep(2000);
		WebElement iec_admin_first_name1 =GWait.Wait_GetElementById("add_iec_admin_first_name");
		Assert.assertEquals(iec_admin_first_name1.getAttribute("value"), admin_first_name);
		
		Assert.assertEquals(iec_admin_last_name.getAttribute("value"), admin_last_name);
		
		Assert.assertEquals(iec_admin_date_of_birth.getAttribute("value"), admin_dob);
		
		Assert.assertEquals(iec_admin_email.getAttribute("value"), admin_email);
		
		Assert.assertEquals(iec_admin_contact_number.getAttribute("value"), admin_contact_number);
		
		String photo1 =iec_admin_photo.getText();
		
		Thread.sleep(4500);
		List<WebElement> deptfield=GlobalMethods.driver.findElements(By.id("add_iec_admin_department"));
		for (WebElement selectboxDiv : deptfield) {
			String selectboxValue = selectboxDiv.getText().trim();
			if (selectboxValue.equals(admin_department)) {
				Assert.assertEquals(selectboxValue, admin_department);
				System.out.println(selectboxValue);
			}
		}
		
		
		
		List<WebElement> desgfield=GlobalMethods.driver.findElements(By.id("add_iec_admin_designation"));
		for (WebElement selectboxDiv : desgfield) {
			String selectboxValue = selectboxDiv.getText().trim();
			if (selectboxValue.equals(admin_designation)) {
				Assert.assertEquals(selectboxValue, admin_designation);
				System.out.println(selectboxValue);
			}
		}
		
		
		
		Assert.assertEquals(iec_admin_qualifications.getAttribute("value"), admin_qualifications);
		
		Assert.assertEquals(iec_admin_registration_number.getAttribute("value"), admin_registration_number);
		
		String appointment1 =iec_admin_appointment_letter.getText();
		
		String cirriculum1 =iec_admin_curriculum_vitae.getText();
		

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

		
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
		
		sheet.getRow(38).createCell(4).setCellValue("Pass");
		sheet.getRow(38).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(38).createCell(4).setCellValue("Fail");
			sheet.getRow(38).getCell(4).setCellStyle(style);
			
			sheet.getRow(38).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(38).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


		

	}

}
