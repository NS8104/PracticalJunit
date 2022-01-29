package test;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

import org.junit.runners.MethodSorters;

import pages.BasePage;
import pages.FirstPage;
import util.BrowserFactory;
import util.ExcelReader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FirstPageTest {

	static WebDriver driver;
	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\TestData.xlsx");
	String categoryname = exlread.getCellData("CategoryName", "ItemName", 2);
	FirstPage firstpage;

	@Before
	public void init() {
		driver= BrowserFactory.init();
	}

	@Test
	public void whenToggleAllCheckBoxCheckedAllCheckBoxChecked() throws Throwable {
		
		firstpage = PageFactory.initElements(driver, FirstPage.class);
		firstpage.clickOnToggleAllCheckBoxandValidate(categoryname);

	}

	@Test
	public void singleListItemDeletion() throws Throwable {
		firstpage = PageFactory.initElements(driver, FirstPage.class);
		firstpage.verifyAndRemoveAddedItem();

	}

	@Test
	public void removeAllListWhenToggleAllSelected() throws Throwable {
		firstpage = PageFactory.initElements(driver, FirstPage.class);
		firstpage.removeAllList();

	}

	@After
	public void teardown() {
		driver = BrowserFactory.teardown();

	}
}
