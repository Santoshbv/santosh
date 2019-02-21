package script;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import generic.basetest;
import page.Accounts_page;
import page.Login_Page;
import page.dashbordPage;
import page.opportunity_page;
import page.priya_oppurtunity;

public class Test_oppur_priya extends basetest{
		public static void call_logout(WebDriver driver) {
			Accounts_page acc= new Accounts_page(driver);
			WebElement logout = acc.logout();
			logout.click();
			driver.close();
			
		}
		private static boolean element_present(List<WebElement> list) {
			if(list.isEmpty())
			return false;
			else
			return true;
		}

		
		public static void main(String[] args) {
			int pos_to_perform=0;
			// TODO Auto-generated method stub
			WebDriver driver=null;
			try { 
				driver= basetest.browser_launch();
			}
			catch(Exception e) {
				driver.close();
				e.printStackTrace();
			}
			Login_Page p1= new Login_Page(driver);
			p1.entr_username(usernme);
			p1.entr_password(pwd);
			p1.login();
			if(element_present((p1.remindmelater())))
					{
						p1.remindmelater().get(0).click();
					}
		
			dashbordPage p2=new dashbordPage(driver);
			p2.click_opptab().click();
			p2.click_newtab().click();
			p2.click_contopp().click();
			
			opportunity_page p3 = new opportunity_page(driver);
			p3.opportunityName().click();
			p3.oppType().click();
			p3.icon1().click();
			
			
			
			
			
			
}
		
}
