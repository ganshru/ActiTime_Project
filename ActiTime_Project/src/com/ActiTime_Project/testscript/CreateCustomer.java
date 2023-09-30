package com.ActiTime_Project.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ActiTime_Project.genericlibrary.Baseclass;
import com.ActiTime_Project.genericlibrary.FileLibrary;
import com.ActiTime_Project.genericlibrary.ListenerImplimentation;
import com.ActiTime_Project.pom.HomePage;
import com.ActiTime_Project.pom.TaskPage;
@Listeners(ListenerImplimentation.class)
public class CreateCustomer extends  Baseclass{
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getTaskstab().click();
		
		TaskPage tp=new TaskPage(driver);
		tp.getAddcust().click();
		tp.getNewcust().click();
		
		FileLibrary f=new FileLibrary();
		String name = f.readdatafromexcelfile("Sheet1", 3, 1);
		tp.getCustname().sendKeys(name);
		String desc = f.readdatafromexcelfile("Sheet1", 3, 2);
		tp.getCustdesc().sendKeys(desc);
		tp.getCreatecust().click();
		
		String expectedresult = name;
		String actualresult = driver.findElement(By.xpath("(//div[.='"+name+"'])[2]")).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(expectedresult, actualresult);
		s.assertAll();
		Reporter.log("Customer Created Successfully", true);
	}

}
