package Searchmodule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchData {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//input[@id='search_form_input_homepage']")
	private WebElement searchBox;

	@FindBy(xpath = "//input[@id='search_button_homepage']")
	private WebElement searchButton;

	@FindBy(xpath = "//a[normalize-space()='Videos']")
	private WebElement videosLink;

	@FindBy(xpath = "//div[@class='tile__media']")
	private List<WebElement> totalVideos;

	public SearchData(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 15);
		PageFactory.initElements(driver, this);
	}

	public void goTo() {
		this.driver.get("https://duckduckgo.com/");
	}

	public void doSearch(String keyword) {
		searchBox.sendKeys(keyword);
		searchButton.click();
	}

	public void goToVideosPage() {
		this.wait.until(ExpectedConditions.visibilityOf(videosLink));
		videosLink.click();
	}

	public void getTotalVideos() {
		By by = By.xpath("//div[@class='tile__media']");
		this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
		System.out.println("Total videos found " + totalVideos.size());
	}

}
