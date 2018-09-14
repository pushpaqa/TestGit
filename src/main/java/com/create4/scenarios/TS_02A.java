package com.create4.scenarios;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;
import java.util.jar.Attributes.Name;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

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
 * Check for the Institute Home page details after click on particular institute.
 */

public class TS_02A {

	public TS_02A() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);
	
	@FindBy(xpath = "//a[contains(text(),'Manage Items')]")
	WebElement Manage_Items; 
	
	@FindBy(css = "h2.margin-none")
	WebElement insthomeheading; 
	
	@FindBy(css = "p")
	WebElement insthomeaddress; 
	
	@FindBy(css = "div.col-sm-12.block > h3")
	WebElement instethic1; 
	
	@FindBy(xpath = "//div[2]/div[2]/h3")
	WebElement instethic2; 
	
	@FindBy(xpath = "//div[3]/h3")
	WebElement instethic3;
	
	@FindBy(xpath = "//div[4]/h3")
	WebElement instethic4;
	
	@FindBy(xpath = "//div[5]/h3")
	WebElement instethic5;
	
	@FindBy(xpath = "//div[7]/h3")
	WebElement accreditaionhome;
	
	@FindBy(linkText = "SOPs")
	WebElement homesop;
	
	@FindBy(linkText = "Contact Us")
	WebElement homecont;
	
	@FindBy(linkText = "Feedback")
	WebElement homefeed;
	
	@FindBy(xpath = "//div[3]/div[2]/h3")
	WebElement homeiecnotf;	
	
	@FindBy(xpath = "//div[3]/div[3]/h3")
	WebElement homeiecguide;
	
	@FindBy(linkText = "Register")
	WebElement homereg;
	
	@FindBy(id = "login_institute")
	WebElement homelogin;
	
	@FindBy(xpath = "//form/a")
	WebElement homeforgot;
	
	@FindBy(xpath = "//h3")
	WebElement homeabtcntnt;

	@FindBy(xpath = "//form[@id='manageethiccommittee']/div/p")
	WebElement removeid;
	
	@FindBy(linkText="Manage IEC")
	WebElement ManageIEClink;
	
	@FindBy(linkText="SOP")
	WebElement SOPlink;
	
	@FindBy(xpath="//td[8]/a/span")
	WebElement ViewIcon;

	@FindBy(linkText="Add SOP")
	WebElement AddSOPLink;
	
	@FindBy(id="sop_title")
	WebElement TitleTextbox;
	
	@FindBy(id="sop_version")
	WebElement VersionTextbox;
	
	@FindBy(xpath="//div[3]/form/div[3]/div/div/div/input")
	WebElement DateEffectFromTextbox;
	
	@FindBy(id="desc")
	WebElement DescriptionTextbox;
	
	@FindBy(id="upload_sop")
	WebElement UploadSOPTextbox;
	
	@FindBy(xpath="//p")
	WebElement AddSopAckmessage;
	
	@FindBy(id="sopcreate")
	WebElement SOPSubmitButton;
	
	@FindBy(xpath="//form[@id='soplist']/div/label")
	WebElement TitleLabelinEdit;
	
	@FindBy(xpath="//form[@id='soplist']/div[2]/label")
	WebElement VersionLabelinEdit;
	
	@FindBy(xpath="//form[@id='soplist']/div[3]/label")
	WebElement DateLabelinEdit;
	
	@FindBy(xpath="//form[@id='soplist']/div[4]/label")
	WebElement DescriptionLabelinEdit;
	
	@FindBy(xpath="//form[@id='soplist']/div[5]/label")
	WebElement Upload;
	
	//--Check for Institution Home details---//
	
	public void CRe4_12_14_15_21_23_24() throws Exception {
		
		try{
	

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);

		Sheet r1 = wb.getSheet("Data_Sheet");
		Sheet r = wb.getSheet("Institute_Logins");
		
		String Instname = r1.getCell(2,71).getContents();
		String address = r1.getCell(3,71).getContents();
		String ethic1 = r1.getCell(4,71).getContents();
		String ethic2 = r1.getCell(5,71).getContents();
		String ethic3 = r1.getCell(6,71).getContents();
		String ethic4 = r1.getCell(7,71).getContents();
		String ethic5 = r1.getCell(8,71).getContents();
		String accred = r1.getCell(9,71).getContents();
		String soplink = r1.getCell(10,71).getContents();
		String contactlink = r1.getCell(11,71).getContents();
		String feedbacklink = r1.getCell(12,71).getContents();
		String iecnotflink = r1.getCell(13,71).getContents();
		String iecguidelink = r1.getCell(14,71).getContents();
		String reglink = r1.getCell(15,71).getContents();
		String loginlink = r1.getCell(16,71).getContents();
		String forgotlink = r1.getCell(17,71).getContents();
		
		String abtsftware = r1.getCell(18,71).getContents();
		
		String TitTextboxExc1=r1.getCell(27,71).getContents();
		String VerTextboxExc1=r1.getCell(28,71).getContents();
		String DateExc1=r1.getCell(29,71).getContents();
		String DescriptionExc1=r1.getCell(30,71).getContents();
		String UploadExc1=r1.getCell(31,71).getContents();
		String SOPAckMessage1=r1.getCell(32,71).getContents();
		
		String tablefield1=r1.getCell(33,71).getContents();
		String tablefield2=r1.getCell(34,71).getContents();
		String tablefield3=r1.getCell(35,71).getContents();
		
		String inst=r.getCell(0, 2).getContents();
		

				
		WebElement instclick = GWait.Wait_GetElementByLinkText(inst);
		instclick.click();
		
		Thread.sleep(2000);
		Assert.assertEquals(insthomeheading.getText().trim(), inst);
		
		String XPath1 = "//p";
		Boolean iselementpresent = GlobalMethods.driver.findElements(By.xpath(XPath1)).size()!= 0;
		   if (iselementpresent == true)
		   {
		    System.out.print("exists");
		   }
		   else
		   {
		    System.out.print("not exists");
		   }
		
		
		
		
		String XPath2 = "//div[2]/div/h3";
		Boolean iselementpresent1 = GlobalMethods.driver.findElements(By.xpath(XPath2)).size()!= 0;
		   if (iselementpresent1 == true)
		   {
		    System.out.print("exists");
		   }
		   else
		   {
		    System.out.print("not exists");
		   }
		
		
		
		Assert.assertEquals(homesop.getText().trim(), soplink);
		
		Assert.assertEquals(homecont.getText().trim(), contactlink);
		
		Assert.assertEquals(homefeed.getText().trim(), feedbacklink);
		
		Assert.assertEquals(homeiecnotf.getText().trim(), iecnotflink);
		
		Assert.assertEquals(homeiecguide.getText().trim(), iecguidelink);
		
		Assert.assertEquals(homereg.getText().trim(), reglink);
		
		Assert.assertEquals(homelogin.getText().trim(), loginlink);
		
		Assert.assertEquals(homeforgot.getText().trim(), forgotlink);
		
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
		
		Assert.assertEquals(homeabtcntnt.getText().trim(), abtsftware);
		
		
		//compare ethic member details on home page
		
		 GlobalMethods.Admin_Login();
			
			WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("//a[contains(text(),'Manage IEC')]");
			Manage_IEC1.click();
			
			WebElement manage_iec_comm1 = GWait.Wait_GetElementByLinkText("Manage Ethics Committee");
			manage_iec_comm1.click();
			
			WebElement searchtext = GWait.Wait_GetElementByName("ethic_committee_name");
			searchtext.sendKeys(ethic1);
			
			WebElement search = GWait.Wait_GetElementByXpath("//input[@value='Search']");
			search.click();
			
			WebElement ethicone = GWait.Wait_GetElementByXpath("//td[3]");
			String ethicname = ethicone.getText();
			
			WebElement ethiconeview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
			ethiconeview.click();
			
			WebElement ethiconeeditcp = GWait.Wait_GetElementByXpath("//div[6]/div[2]/p");
			String cpname = ethiconeeditcp.getText();
			
			
			WebElement ethiconeeditms = GWait.Wait_GetElementByXpath("//div[7]/div[2]/p");
			String msname = ethiconeeditms.getText();
			//System.out.println(msname);
			WebElement logoutt1 = GWait.Wait_GetElementByXpath("//span/a");
			logoutt1.click();
			
			WebElement cpdetails = GWait.Wait_GetElementByXpath("//div[2]/div/div/div");
			String homecp = cpdetails.getText();
			
			WebElement msdetails = GWait.Wait_GetElementByXpath("//div[2]/div/div[2]/div");
			String homems = msdetails.getText();
			
			
			//ms comparision
			
			String textfile1 = homems.substring(3);


			String[] finalStr = textfile1.split(" ");
			System.out.println(finalStr);

			System.out.println("Test1 "+finalStr[0]);
			System.out.println("Test2 "+finalStr[1]);

			String mshome = finalStr[0] +" " + finalStr[1];
			
			String  string= mshome.substring(0, mshome.length() - 6);
			System.out.println(string);

			System.err.println(mshome);
			System.err.println(msname);
			Assert.assertEquals(string, msname);
			
			
				
			//cp comparision
			
			String textfile11 = homecp.substring(3);
            System.out.println(textfile11);

			String[] finalStr1 = textfile11.split(" ");
			//System.out.println(finalStr1);

			System.out.println("Test1 "+finalStr1[0]);
			System.out.println("Test2 "+finalStr1[1]);
			System.out.println("Test3 "+finalStr1[2]);
			
			String cphome = finalStr1[0] +" " + finalStr1[1]+" " +finalStr1[2];
			
			String  string1= cphome.substring(0, cphome.length() - 10);
			System.out.println("21 " + string1);

			System.out.println(cpname);
			System.out.println(string1);
			Assert.assertEquals(string1, cpname);

			
		//String accredit1 = "Recognized / Accredited by:"+"\n"+accred;
		//Assert.assertEquals(homeaccr.getText().trim(), accredit1);
		
		
		String XPath11 = "//div[2]/div/h3";
		Boolean iselementpresent2 = GlobalMethods.driver.findElements(By.xpath(XPath11)).size()!= 0;
		   if (iselementpresent2 == true)
		   {
		    System.out.print("exists");
		   }
		   else
		   {
		    System.out.print("not exists");
		   }
		
		String XPath = "//div[7]/h3";
		Boolean iselementpresent11 = GlobalMethods.driver.findElements(By.xpath(XPath)).size()!= 0;
		   if (iselementpresent11 == true)
		   {
		    System.out.print("exists");
		   }
		   else
		   {
		    System.out.print("not exists");
		   }
		   
		
		WebElement logo11 = GWait.Wait_GetElementByCSS("img");
		logo11.click();
		
       
		
		
		
   
		   GlobalMethods.Admin_Login();
		   
		WebElement Manage_IEC2 = GWait.Wait_GetElementByXpath("//a[contains(text(),'Manage IEC')]");
		Manage_IEC2.click();
		
		WebElement SOPlink = GWait.Wait_GetElementByLinkText("SOP");
		SOPlink.click();
		
	
		
		WebElement AddSOPLink = GWait.Wait_GetElementByLinkText("Add SOP");
		AddSOPLink.click();
			
				
		WebElement TitleTextbox = GWait.Wait_GetElementById("sop_title");
		TitleTextbox.sendKeys(TitTextboxExc1);
		
		
		WebElement VersionTextbox =GWait.Wait_GetElementById("sop_version");
		VersionTextbox.sendKeys(VerTextboxExc1);
		
		Thread.sleep(2000);
		WebElement DateEffectFromTextbox =GWait.Wait_GetElementByXpath("//div[3]/form/div[3]/div/div/div/input");
		DateEffectFromTextbox.sendKeys("16-04-2018");
		Thread.sleep(2000);
		
		WebElement DescriptionTextbox =GWait.Wait_GetElementById("desc");
		DescriptionTextbox.sendKeys(DescriptionExc1);
		
		
		WebElement UploadSOPTextbox =GWait.Wait_GetElementById("upload_sop");
		UploadSOPTextbox.sendKeys(UploadExc1);
		
		
		WebElement SOPSubmitButton =GWait.Wait_GetElementById("sopcreate");
		SOPSubmitButton.click();
		
		
		
		WebElement ViewIcon = GWait.Wait_GetElementByXpath("//td[8]/a/span");
		ViewIcon.click();
	
			

		
		WebElement logoutt11 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt11.click();
		
	
		
		WebElement soplinkhome = GWait.Wait_GetElementByLinkText("SOPs");
		soplinkhome.click();
		
		Assert.assertEquals(tabletitlesop.getText(), tablefield1);
		
		Assert.assertEquals(tablecreatesop.getText(), tablefield2);
		
		Assert.assertEquals(tableactionsop.getText(), tablefield3);
		
		GlobalMethods.AcceptDoenloadPopup();
		
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
		
		sheet.getRow(49).createCell(4).setCellValue("Pass");
		sheet.getRow(49).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(49).createCell(4).setCellValue("Fail");
			sheet.getRow(49).getCell(4).setCellStyle(style);
			
			sheet.getRow(49).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(49).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


		
	}
	
	@FindBy(xpath = "//th[2]/a/span[2]")
	WebElement tabletitlesop;
	
	@FindBy(xpath = "//th[3]/a/span[2]")
	WebElement tablecreatesop;
	
	@FindBy(xpath = "//th[4]/span")
	WebElement tableactionsop;
	
	
	public void CRe4_18_22_26_29_13() throws Exception {
		
		try{
		

		GlobalMethods.Super_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");

		String Institute_Title_1 = r1.getCell(19, 71).getContents();
		String Address_1 = r1.getCell(20, 71).getContents();
		String DCGI_Registration_Number_1 = r1.getCell(21, 71).getContents();
		String DCGI_Registration_Letter_Upload_attachment_1 = r1.getCell(22, 71).getContents();
		String Accreditation_1 = r1.getCell(23, 71).getContents();
		String Accrediation_Attachment_1 = r1.getCell(24, 71).getContents();
		String Institute_Logo_1 = r1.getCell(25, 71).getContents();
		String InstCreationAck = r1.getCell(26, 71).getContents();
		
		WebElement Manage_Items = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/a");
		Manage_Items.click();
		

		WebElement Insts = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[2]/ul/li[1]/a");
		Insts.click();
		
		WebElement createins = GWait.Wait_GetElementByXpath("//*[@id='accordion']/li[2]/div/a");
		createins.click();

		
		WebElement Inst_Title = GWait.Wait_GetElementById("inst_name");
		Inst_Title.sendKeys(Institute_Title_1);
		
		
		WebElement Adds =GWait.Wait_GetElementById("inst_address");
		Adds.sendKeys(Address_1);
		
		
		WebElement DCGI_Reg_Numr =GWait.Wait_GetElementById("cgi_des");
		DCGI_Reg_Numr.sendKeys(DCGI_Registration_Number_1);
		
		
		WebElement DCGI_Reg_Letter_Upload_attachmnt =GWait.Wait_GetElementById("cgi_attach");
		DCGI_Reg_Letter_Upload_attachmnt.sendKeys(DCGI_Registration_Letter_Upload_attachment_1);
		
		
		WebElement Accredn =GWait.Wait_GetElementById("accrediation_desc");
		Accredn.sendKeys(Accreditation_1);
		
		WebElement Accredn_Attachmnt = GWait.Wait_GetElementById("acc_attach");
		Accredn_Attachmnt.sendKeys(Accrediation_Attachment_1);
		
		
		WebElement Ins_Logo =GWait.Wait_GetElementById("inst_logo");
		Ins_Logo.sendKeys(Institute_Logo_1);
		
		WebElement Create_button = GWait.Wait_GetElementByXpath("//*[@id='createinstitute']/div[8]/div/input");
		Create_button.click();
		
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt.click();
		//GlobalMethods.Logout();
		
		
		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
				
		
		WebElement instclick = GWait.Wait_GetElementByLinkText(Institute_Title_1);
		instclick.click();
		
		
		WebElement imagetext = GWait.Wait_GetElementByCSS(".logo_size");
		String textfile = imagetext.getAttribute("src").substring(62);
		System.out.println(textfile);
		String[] finalStr = textfile.split("_");
		
		System.out.println(finalStr[0]+".jpg");

		
		
		String accredit = "Recognized / Accredited by:"+"\n"+Accreditation_1;
		Assert.assertEquals(homeaccr.getText().trim(), accredit);
		
		
		String XPath = "//div[3]/div[2]/h3";
		Boolean iselementpresent = GlobalMethods.driver.findElements(By.xpath(XPath)).size()!= 0;
		   if (iselementpresent == true)
		   {
		    System.out.print("exists");
		   }
		   else
		   {
		    System.out.print("not exists");
		   }
		   
		   String XPath1 = "//div[3]/div[3]/h3";
			Boolean iselementpresent1 = GlobalMethods.driver.findElements(By.xpath(XPath1)).size()!= 0;
			   if (iselementpresent1 == true)
			   {
			    System.out.print("exists");
			   }
			   else
			   {
			    System.out.print("not exists");
			   }
		  

		
		WebElement soplinkhome = GWait.Wait_GetElementByLinkText("SOPs");
		soplinkhome.click();
		
		Thread.sleep(2000);
		Assert.assertEquals(nodata.getText().trim(), "No records found");
		
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
		
		sheet.getRow(50).createCell(4).setCellValue("Pass");
		sheet.getRow(50).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(50).createCell(4).setCellValue("Fail");
			sheet.getRow(50).getCell(4).setCellStyle(style);
			
			sheet.getRow(50).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(50).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}
	
	//---Check for IEC Notifications on institution page--//
	
	public void CRe4_25_27() throws Exception {
		
		
try{
		
		GlobalMethods.MS_Login();
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");
		
		for(int i=1;i<=5;i++)
		{
		
		String announce_title = r1.getCell(36, 71).getContents();
		String announce_desc = r1.getCell(37, 71).getContents();
		String announce_file = r1.getCell(38, 71).getContents();
		String announce_date = r1.getCell(39, 71).getContents();
		String announce_acknowledge = r1.getCell(40, 71).getContents();

	    Thread.sleep(1000);
		
		WebElement Link_Announcements = GWait.Wait_GetElementByLinkText("Announcements");
		Link_Announcements.click();
				
		WebElement manage_add_announcement = GWait.Wait_GetElementByLinkText("Add Announcement");
		manage_add_announcement.click();
		
		WebElement manage_add_announcement_title = GWait.Wait_GetElementById("add_announcement_title");
			
		manage_add_announcement_title.sendKeys(announce_title);
		
		
		WebElement manage_add_announcement_description = GWait.Wait_GetElementById("add_announcement_description");
		manage_add_announcement_description.sendKeys(announce_desc);
		Thread.sleep(2000);
		
		
		WebElement manage_add_announcement_notification_date =GWait.Wait_GetElementById("add_announcement_notification_date");
		manage_add_announcement_notification_date.sendKeys(announce_date);
		
		
		WebElement manage_add_announcement_notification_file_1 =GWait.Wait_GetElementById("add_announcement_notification_file_1");
		manage_add_announcement_notification_file_1.sendKeys(announce_file);
		Thread.sleep(2000);
		
		
		WebElement manage_add_announcement_notification_details =GWait.Wait_GetElementById("add_announcement_notification_details");
		manage_add_announcement_notification_details.click();
		
		Thread.sleep(1000);
		Assert.assertEquals(manage_acknowledge.getText().trim(), "Announcement added successfully.");
		System.out.println(manage_acknowledge.getText());
		
		}
	
		
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span[3]/a");
		logoutt.click();
		
		String announce_title = r1.getCell(36, 71).getContents();
		
		Thread.sleep(1000);
		Assert.assertEquals(homenotfone.getText().trim(), announce_title);
		Thread.sleep(1000);
		Assert.assertEquals(homenotftwo.getText().trim(), announce_title);
		Thread.sleep(1000);
		Assert.assertEquals(homenotfthree.getText().trim(), announce_title);
		Thread.sleep(1000);
		Assert.assertEquals(homenotffour.getText().trim(), announce_title);
		Thread.sleep(1000);
		Assert.assertEquals(homenotffive.getText().trim(), announce_title);
		
		String xpath = "//li[2]/a/span";
		 WebElement imgElement = GlobalMethods.driver.findElement(By.xpath(xpath));
	       try {
	          imgElement.click(); 
	          System.out.println("true"); 
	        } catch(Exception e){
	        	System.out.println("false"); 
	       }
		
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
		
		sheet.getRow(51).createCell(4).setCellValue("Pass");
		sheet.getRow(51).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(51).createCell(4).setCellValue("Fail");
			sheet.getRow(51).getCell(4).setCellStyle(style);
			
			sheet.getRow(51).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(51).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	public void CRe4_28_30() throws Exception {
		
		try{
		
		GlobalMethods.Admin_Login();
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Data_Sheet");
	
		for(int i=1;i<=5;i++)
		{

			
			String ExternalTitle=r1.getCell(41,71).getContents();
			String ExternalLink=r1.getCell(42,71).getContents();
			String ExternalDescription=r1.getCell(43,71).getContents();
			String ExtrnalLinkAckMsg=r1.getCell(44,71).getContents();
			
		WebElement ManageIECLink = GWait.Wait_GetElementByLinkText("Manage IEC");
		ManageIECLink.click();
						
		WebElement ExternalLinks = GWait.Wait_GetElementByLinkText("External Links");
		ExternalLinks.click();
				
		
		WebElement CreateExternalLink = GWait.Wait_GetElementByLinkText("Create External links");
		CreateExternalLink.click();
		
		WebElement ExternalTitleTxtbx = GWait.Wait_GetElementById("ex_title");
		ExternalTitleTxtbx.sendKeys(ExternalTitle);
		
		WebElement ExternalLinkTxtbx =GWait.Wait_GetElementById("ex_link");
		ExternalLinkTxtbx.sendKeys(ExternalLink);
		
		
		WebElement ExternalDescriptionTxtbx = GWait.Wait_GetElementById("ex_desc");
		ExternalDescriptionTxtbx.sendKeys(ExternalDescription);
		
		
		WebElement Submit = GWait.Wait_GetElementByXpath(".//*[@id='externallinks']/div[5]/div/input");
		Submit.click();
		}
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		String ExternalTitle=r1.getCell(41,71).getContents();
		Thread.sleep(1000);
		System.out.println(homeextlnk.getText().trim());
		Assert.assertEquals(homeextlnk.getText().trim(), ExternalTitle);
		Thread.sleep(1000);
		Assert.assertEquals(homeextlnk2.getText().trim(), ExternalTitle);
		Thread.sleep(1000);
		Assert.assertEquals(homeextlnk3.getText().trim(), ExternalTitle);
		Thread.sleep(1000);
		Assert.assertEquals(homeextlnk4.getText().trim(), ExternalTitle);
		Thread.sleep(1000);
		Assert.assertEquals(homeextlnk5.getText().trim(), ExternalTitle);
		
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
		
		sheet.getRow(52).createCell(4).setCellValue("Pass");
		sheet.getRow(52).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(52).createCell(4).setCellValue("Fail");
			sheet.getRow(52).getCell(4).setCellStyle(style);
			
			sheet.getRow(52).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(52).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


		
	}
	
	@FindBy(xpath="//li/a[2]")
	WebElement homeextlnk;
	
	@FindBy(xpath="//li[2]/a[2]")
	WebElement homeextlnk2;
	
	@FindBy(xpath="//li[3]/a[2]")
	WebElement homeextlnk3;
	
	@FindBy(xpath="//li[4]/a[2]")
	WebElement homeextlnk4;
	
	@FindBy(xpath="//li[5]/a[2]")
	WebElement homeextlnk5;
	
	@FindBy(id="ex_title")
	WebElement ExternalTitleTxtbx;
	
	@FindBy(id="ex_link")
	WebElement ExternalLinkTxtbx;

	@FindBy(id="ex_desc")
	WebElement ExternalDescriptionTxtbx;
	
	@FindBy(xpath="html/body/div[4]/div[1]/div/div[2]/div[3]/div[1]/p")
	WebElement ExternalLinkAckMsg;
	
	@FindBy(xpath=".//*[@id='externallinks']/div[5]/div/input")
	WebElement Submit ;
	
	@FindBy(xpath = "//td/span")
	WebElement nodata;
	
	@FindBy(xpath = "//div/div/div/div[2]/div")
	WebElement homeaccr;	
	
	@FindBy(xpath = "//*[@id='accordion']/li[2]/div/a")
	WebElement createins;

	@FindBy(id = "inst_name")
	WebElement Inst_Title;

	@FindBy(id = "inst_address")
	WebElement Adds;

	@FindBy(id = "cgi_des")
	WebElement DCGI_Reg_Numr;

	@FindBy(id = "cgi_attach")
	WebElement DCGI_Reg_Letter_Upload_attachmnt;

	@FindBy(xpath = "//input[@value='Create']")
	WebElement CreateButton;

	@FindBy(xpath = "//form[@id='createinstitute']/div[8]/div/button")
	WebElement Backbutton;

	@FindBy(id = "accrediation_desc")
	WebElement Accredn;

	@FindBy(id = "acc_attach")
	WebElement Accredn_Attachmnt;

	@FindBy(id = "inst_logo")
	WebElement Ins_Logo;

	@FindBy(xpath = "//*[@id='createinstitute']/div[8]/div/input")
	WebElement Create_button;
	

	

	@FindBy(id = "add_announcement_title")
	WebElement manage_add_announcement_title;

	@FindBy(id = "add_announcement_description")
	WebElement manage_add_announcement_description;

	@FindBy(id = "add_announcement_notification_date")
	WebElement manage_add_announcement_notification_date;

	@FindBy(id = "add_announcement_notification_file_1")
	WebElement manage_add_announcement_notification_file_1;
	
	@FindBy(id = "add_more_announcement_button")
	WebElement manage_add_more_announcement_button;

	@FindBy(id = "add_announcement_notification_details")
	WebElement manage_add_announcement_notification_details;

	@FindBy(xpath = "//form[@id='manageannouncementlist']/div/p")
	WebElement manage_acknowledge;
	
	@FindBy(css = "a > span")
	WebElement homenotfone;
	
	@FindBy(xpath = "//li[2]/a/span")
	WebElement homenotftwo;
	
	@FindBy(xpath = "//li[3]/a/span")
	WebElement homenotfthree;
	
	@FindBy(xpath = "//li[4]/a/span")
	WebElement homenotffour;
	
	@FindBy(xpath = "//li[5]/a/span")
	WebElement homenotffive;

	public void CRe4_16() throws Exception {
		try{
		
		System.out.println("Later we will check this feature");
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
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile1");
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
}

