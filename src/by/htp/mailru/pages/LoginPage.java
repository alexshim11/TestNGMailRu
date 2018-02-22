package by.htp.mailru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

	private final String URL = "https://mail.ru/";

	@FindBy(id = "mailbox:login")
	private WebElement inputLogin;

	@FindBy(id = "mailbox:password")
	private WebElement inputPassword;

	@FindBy(xpath = "//*[@id=\'mailbox:submit\']/input")
	private WebElement buttonEntry;

	@FindBy(xpath = "//*[@id=\"mailbox:activeEmail\"]")
	private WebElement domain;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void login(String login, String password) {

		inputLogin.sendKeys(login);
		inputPassword.sendKeys(password);
		buttonEntry.click();
		System.out.println("You are logged in");

	}

	public String checkDomain() {
		return domain.getText();
	}

	@Override
	public void openPage() {

		driver.get(URL);
		System.out.println("StartPage is Opened");

	}

}
