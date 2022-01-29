package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;

public class FirstPage extends BasePage {

	WebDriver driver;

	public FirstPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.CSS, using = "input[name=\"allbox\"]")
	WebElement TOGGLEALL_CHECKBOX_ELEMENT;
	@FindBy(how = How.CSS, using = "input[type='checkbox']")
	WebElement TOTAL_NUMBERS_OF_CHECKBOX_ELEMENT;
	@FindBy(how = How.CSS, using = "li[style='font-size: 16px']")
	List<WebElement> All_LIST_ELEMENT;
	@FindBy(how = How.CSS, using = "input[name=\"data\"]")
	WebElement ADD_DATA_ELEMENT;
	@FindBy(how = How.CSS, using = "input[value=\"Add\"]")
	WebElement ADD_SUBMITBUTTON_ELEMENT;
	// @FindBy(how = How.CSS, using = "input[name=\"todo[0]\"]")
	// WebElement SINGLE_LIST_ITEM_ELEMENT;
	@FindBy(how = How.CSS, using = "input[value=\"Remove\"]")
	WebElement REMOVE_ELEMENT;

	String Enteredname;

	public void addItemInList(String Itemname) throws Throwable {
		Enteredname = Itemname + generateRandomNum(999);
		ADD_DATA_ELEMENT.sendKeys(Enteredname);
		ADD_SUBMITBUTTON_ELEMENT.click();

		Thread.sleep(3000);
	}

	@SuppressWarnings("deprecation")
	public void clickOnToggleAllCheckBoxandValidate(String Enteredname) throws Throwable {
		addItemInList(Enteredname);
		TOGGLEALL_CHECKBOX_ELEMENT.click();
		if (TOTAL_NUMBERS_OF_CHECKBOX_ELEMENT.isSelected()) {
			System.out.println("All Checkboxes are Selected");
		}
		 Assert.assertTrue("Checkbox not selected",TOTAL_NUMBERS_OF_CHECKBOX_ELEMENT.isSelected());
		Thread.sleep(3000);
	}

	public void verifyAndRemoveAddedItem() throws Throwable {
		addItemInList(Enteredname);
			List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
			int TotalCheckBoxes = checkbox.size();
			System.out.println("Total number of Checkboxes" + TotalCheckBoxes);
			for (int i = (TotalCheckBoxes - 2); i < TotalCheckBoxes; i++) {
				checkbox.get(i).click();
				Thread.sleep(3000);
				break;

			}
			REMOVE_ELEMENT.click();
			List<WebElement> checkbox1 = driver.findElements(By.xpath("//input[@type='checkbox']"));
			int TotalCheckBoxes1 = checkbox1.size();
			Assert.assertNotSame(TotalCheckBoxes, TotalCheckBoxes1);
		}
	
		


	public void removeAllList() throws Throwable {
		TOGGLEALL_CHECKBOX_ELEMENT.click();
		REMOVE_ELEMENT.click();
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		if (checkbox.size() <= 1) {
			System.out.println("All Items are deleted");
		}
		Assert.assertTrue(checkbox.size()<=1);
		Thread.sleep(3000);

	}
}
