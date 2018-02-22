package by.htp.mailru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewMessagePage extends AbstractPage {

	private final String URL = "https://e.mail.ru/compose/";

	@FindBy(xpath = "//*[contains(@id,'composeForm')]/div[1]/div/div[3]/div[1]/div/div/div[2]/div/div/div/textarea[2]")
	private WebElement inputRecipient;

	@FindBy(xpath = "//iframe[contains(@id,'composeEditor_ifr')]")
	private WebElement frame;

	@FindBy(id = "tinymce")
	private WebElement inputEMessageBody;

	@FindBy(xpath = "//*[contains(@id,'composeForm')]/div[1]/div/div[3]/div[4]/div/div/div[2]/div/input")
	private WebElement inputThreme;

	@FindBy(xpath = "//*[@id=\'b-toolbar__right\']/div[3]/div/div[2]/div[1]/div/span")
	private WebElement buttonSendMessage;

	public NewMessagePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void writeNewMessage(String recipient, String text, String threme) {
		inputRecipient.click();
		inputRecipient.sendKeys(recipient);
		driver.switchTo().frame(frame);
		inputEMessageBody.click();
		inputEMessageBody.sendKeys(text);
		driver.switchTo().defaultContent();
		inputThreme.click();
		inputThreme.sendKeys(threme);
		buttonSendMessage.click();
		System.out.println("The letter was sent");
	}

	@Override
	public void openPage() {
		driver.get(URL);
	}

}
