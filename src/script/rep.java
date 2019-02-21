package script;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import generic.basetest;
import page.Accounts_page;
import page.Login_Page;
import page.dashbordPage;
import page.reportpage;

public class rep extends basetest{

		// TODO Auto-generated method stub
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
			int pos=0;
			int pos_to_perform=0;
			// TODO Auto-generated method stub
			WebDriver driver=null;
			try { driver= basetest.browser_launch();
			Login_Page p1= new Login_Page(driver);
			p1.entr_username(usernme);
			p1.entr_password(pwd);
			p1.login();
			if(element_present((p1.remindmelater())))
					{
						p1.remindmelater().get(0).click();
					}
		
			dashbordPage p2=new dashbordPage(driver);
			p2.click_repTab().click();
			driver.findElement(By.xpath("//input[@value='New Report...']")).click();
			driver.findElement(By.xpath("//input[@id='quickFindInput']")).sendKeys("Accounts with Assets");
			String actual_value = driver.findElement(By.xpath("//input[@id='quickFindInput']")).getText();
			reportpage rp = new reportpage(driver);
			List<WebElement> main_list = rp.main_l();
					//driver.findElements(By.xpath("//div[@id='reportTypeTree']//ul[@id='ext-gen10']/div/li"));
			List<WebElement> sub_list = rp.sub_l();
			//driver.findElements(By.xpath("//div[@id='reportTypeTree']//ul[@class='x-tree-node-ct']/li"));
			for(int i=0;i<main_list.size();i++)
			{
		System.out.println(main_list.get(i).findElement(By.xpath("/div[@class='x-tree-node-el x-unselectable folder x-tree-node-collapsed']//a//span")).getText());
			
			//	System.out.println(driver.findElement(By.xpath("//div[@id='reportTypeTree']//ul[@id='ext-gen10']/div/li/div[@class='x-tree-node-el x-unselectable folder x-tree-node-collapsed']//a//span")).getText());
		
			}
			
//			//driver.findElement(By.xpath("//input[@id='thePage:rtForm:createButton']")).click();
//		
//			
//			System.out.println(pos);
//			//code for deleting the prvious records
//		
//			driver.findElement(By.id("ext-gen129")).click();
//			driver.findElement(By.xpath("//button[@id='ext-gen608']")).click();
//			//driver.findElement(By.xpath("//button[@id='ext-gen129']")).click();
			}
			catch(Exception e) {
				driver.close();
				e.printStackTrace();
		}
		
}
}

