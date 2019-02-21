package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import generic.basetest;
import page.Accounts_page;
import page.Login_Page;
import page.dashbordPage;

public class testLogin extends basetest{
public static void main(String[] args) {
	WebDriver driver=null;
	try {
	 driver= basetest.browser_launch();
	Login_Page p1= new Login_Page(driver);
	p1.entr_username(usernme);
	p1.entr_password(pwd);
	p1.login();
	p1.remindmelater();
	
	dashbordPage db= new dashbordPage(driver);
	db.click_accounttab();
	db.clcick_newaccount();
	
	Accounts_page acc = new Accounts_page(driver);
	acc.account_details("testqa", "2nd main road", "banga", "kar", "560012", "India");
	acc.organization(driver,8);
acc.new_save();

	if(driver.findElement(By.id("errorDiv_ep")).isDisplayed()) {
		
		acc.account_details("test2", "1st bsk", "mysore", "kar", "560013", "India");
		acc.organization(driver,5);
		acc.new_save();
		acc.close_pop();
		acc.logout().click();
	}
	else
	{
		driver.close();
	}

	}catch(Exception e) {
		driver.close();
		e.printStackTrace();
		
		
	}}
}
