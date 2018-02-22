package by.htp.mailru;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.mailru.steps.Steps;

public class MailRuAutomationTest {

	private Steps steps;
	private static final String USERNAME = "tathtp";
	private static final String CORRECTUSERNAME = "tathtp@mail.ru";
	private static final String PASSWORD = "Klopik123";
	private static final String RECIPIENT = "tathtp@mail.ru";
	private static final String TEXTMESSAGE = "Hi from Alex";
	private static final String THREME = "Message Test";

	@BeforeMethod(description = "Open Browser")
	public void start() {
		steps = new Steps();
		steps.openBrowser();
	}

	@Test
	public void checkOutBoxMessage() {
		steps.loginMailRu(USERNAME, PASSWORD);
		steps.selectNewMessage();
		steps.writeNewMessage(RECIPIENT, TEXTMESSAGE, THREME);

	}

	@Test
	public void loginProfile() {
		steps.loginMailRu(USERNAME, PASSWORD);
		Assert.assertTrue(steps.checkCorrectDomain(CORRECTUSERNAME));
	}

	@AfterMethod(description = "Close Browser")
	public void close() {
		steps.closeBrowser();
	}

}
