package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MobilePage {

	@FindBy(linkText = "MOBILE")
	WebElement mobileMenu;

	@FindBy(xpath = "//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")
	WebElement sortBy;

	@FindBy(id = "product-price-1")
	WebElement product_price_1;

	@FindBy(linkText = "SONY XPERIA")
	WebElement sony_product;

	public MobilePage() {

		PageFactory.initElements(BaseClass.getWebDriver(), this);
	}

	public void clickMobileMenu() {

		mobileMenu.click();
	}

	public void sortMenuBySpecificElement(String element) {

		new Select(sortBy).selectByVisibleText(element);
	}

	// check Sony price after sorting products by name
	public Boolean checkListAndDetailsPriceProduct() {

		String price_list_page = product_price_1.getText();
		sony_product.click();
		String price_Details_page = product_price_1.getText();
		return price_list_page.equals(price_Details_page);
	}
}