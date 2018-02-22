package by.htp.mailru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxMessagePage extends AbstractPage {

	private final String URL = "https://e.mail.ru/messages/inbox/?back=1";

	@FindBy(xpath = "//*[@id=\'b-toolbar__left\']/div/div/div[2]/div/a/span")
	private WebElement buttonNewMessage;

	@FindBy(xpath = "//*[@id=\'portal-menu\']/div[2]/div/div[1]/div[1]/div/div/a")
	private WebElement buttonBack;

	public InboxMessagePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void chooseNewMessage() {
		buttonNewMessage.click();
		System.out.println("Go to incoming messages");
	}

	public void chooseMainPage() {
		buttonBack.click();
	}

	@Override
	public void openPage() {
		driver.get(URL);
	}

}
