package by.htp.mailru.steps;

import org.openqa.selenium.WebDriver;

import by.htp.mailru.driver.DriverSingleton;
import by.htp.mailru.pages.InboxMessagePage;
import by.htp.mailru.pages.LoginPage;
import by.htp.mailru.pages.NewMessagePage;

public class Steps {

	private WebDriver driver;

	public void openBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeBrowser() {
		DriverSingleton.closeDriver();
		System.out.println("The browser is closed");
	}

	public void loginMailRu(String login, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(login, password);
	}

	public void selectNewMessage() {
		InboxMessagePage inboxMessagePage = new InboxMessagePage(driver);
		inboxMessagePage.openPage();
		inboxMessagePage.chooseNewMessage();
	}

	public void writeNewMessage(String recipient, String text, String threme) {
		NewMessagePage newMassegePage = new NewMessagePage(driver);
		newMassegePage.writeNewMessage(recipient, text, threme);
	}

	public boolean checkCorrectDomain(String username) {
		LoginPage loginPage = new LoginPage(driver);
		InboxMessagePage inboxMessagePage = new InboxMessagePage(driver);
		inboxMessagePage.chooseMainPage();
		String correctDomain = loginPage.checkDomain();
		return correctDomain.equals(username);
	}

}
