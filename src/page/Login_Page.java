package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page  {
@FindBy(id="username")
private WebElement un;

@FindBy(id="password")
private WebElement pwd;

@FindBy(id="Login")
private WebElement loginbuttoon;

//@FindBy(linkText="Remind Me Later")
//private WebElement remindmelater;
@FindAll({
	@FindBy(linkText="Remind Me Later")
	})
	private List<WebElement> remindmelater;

public Login_Page(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

public void entr_username(String uname)
{
	un.clear();
	un.sendKeys(uname);
}

public void entr_password(String password)
{
	pwd.clear();
	pwd.sendKeys(password);
}

public void login() {
	
	loginbuttoon.click();
}
public List<WebElement> remindmelater() {
	
	return remindmelater;
}

}