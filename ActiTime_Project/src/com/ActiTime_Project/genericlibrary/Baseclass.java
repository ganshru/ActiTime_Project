package com.ActiTime_Project.genericlibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ActiTime_Project.pom.HomePage;
import com.ActiTime_Project.pom.LoginPage;

public class Baseclass {
	public static WebDriver driver;
	FileLibrary f=new FileLibrary();
	
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("Database connected", true);
	}
	
	@BeforeTest
	public void browserlaunch() throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    String link = f.readdatafromproperty("url");
	    driver.get(link);
		Reporter.log("Browser Launched", true);
	}
	
	@BeforeMethod
	public void login() throws IOException {
		LoginPage lp=new LoginPage(driver);
		String un = f.readdatafromproperty("username");
		lp.getUntbx().sendKeys(un);
		String pwd = f.readdatafromproperty("password");
		lp.getPwtbx().sendKeys(pwd);
		lp.getLgbtn().click();
		Reporter.log("Logged in Successfully", true);
	}
	
	@AfterMethod
	public void logout() {
		HomePage hp=new HomePage(driver);
		hp.getLogoutlink().click();
		Reporter.log("Logged out Successfully", true);
	}
	
	@AfterTest
	public void browserclosed() {
		driver.close();
		Reporter.log("Browser closed", true);
	}
	
	@AfterSuite
	public void databasedisconnect() {
		Reporter.log("Database Disconnected", true);
	}
	

}
