package academy.practiceproject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.MainclassObject;

public class MainPage extends Base {
	
	@BeforeTest
	
	public void beforeTest() throws IOException {
		WebDriver driver=intializeDriver();
		driver.get("https://courses.letskodeit.com/practice");


	}
	
	@Test
	public void pageTitleVerifyTest() {
		String pageTitle= driver.getTitle();
		Assert.assertEquals(pageTitle, "Practice Page");
	}
	
	@Test
	public void verifyUrl() {
		String url= driver.getCurrentUrl();
		Assert.assertEquals(url, "https://courses.letskodeit.com/practice");
	}
	
	@Test
	public void byDefaultSelectedRadioButton() {
	MainclassObject o= new MainclassObject(driver);
Assert.assertFalse(	o.getbmwradiobutton().isSelected());
Assert.assertFalse(	o.getbenzradiobutton().isSelected());
Assert.assertFalse(	o.gethondaradiobutton().isSelected());


	}
	@Test
	public void countRadioButtonNumber() {
		MainclassObject o= new MainclassObject(driver);
o.gethondaradiobutton().getSize();
Assert.assertEquals(o.getRadioButtonTotalCount().size(), 3);

	}
	
	@Test
	public void verifyRadioButtonLabels() {
		MainclassObject o= new MainclassObject(driver);

		Assert.assertEquals(o.getbenzradioButtonLabel().getText(), "Benz");
		Assert.assertEquals(o.getbmwradioButtonLabel().getText(), "BMW");
		Assert.assertEquals(o.gethondaradioButtonLabel().getText(), "Honda");


	}
	
	@Test
	public void selectBMWRadionButton() {
		MainclassObject o= new MainclassObject(driver);
		o.getbmwradiobutton().click();
		Assert.assertTrue(	o.getbmwradiobutton().isSelected());
		Assert.assertFalse(	o.getbenzradiobutton().isSelected());
		Assert.assertFalse(	o.gethondaradiobutton().isSelected());
}
	
	@Test
	public void selectBenzRadionButton() {
		MainclassObject o= new MainclassObject(driver);
		o.getbenzradiobutton().click();
		Assert.assertFalse(	o.getbmwradiobutton().isSelected());
		Assert.assertTrue(	o.getbenzradiobutton().isSelected());
		Assert.assertFalse(	o.gethondaradiobutton().isSelected());
	}
	@Test
	public void selectHondaRadionButton() {
		MainclassObject o= new MainclassObject(driver);
		o.gethondaradiobutton().click();
		Assert.assertFalse(	o.getbmwradiobutton().isSelected());
		Assert.assertFalse(	o.getbenzradiobutton().isSelected());
		Assert.assertTrue(	o.gethondaradiobutton().isSelected());
	}
	
	@Test
	public void dropdownText() {
		MainclassObject o= new MainclassObject(driver);
		Assert.assertEquals(o.dropdownOption().getFirstSelectedOption().getText(), "BMW");
		
	}
	
	@Test
	public void dropDownOptions() {
		MainclassObject o= new MainclassObject(driver);
		
		Assert.assertEquals(o.dropdownOption().getOptions().size(), 3);
		
	}
	@Test
	public void selectBenz() {
		MainclassObject o= new MainclassObject(driver);
		o.dropdownOption().selectByValue("benz");
	}
	
	@Test
	public void selectBmw() {
		MainclassObject o= new MainclassObject(driver);
		o.dropdownOption().selectByValue("bmw");
	}
	@Test
	public void selecthonda() {
		MainclassObject o= new MainclassObject(driver);
		o.dropdownOption().selectByValue("honda");
	}
	@Test
	public void  checkMultiSelectOption() {
		MainclassObject o= new MainclassObject(driver);
Assert.assertEquals(o.multipleSelectDropdown().getOptions().size(), 3);		
	}
	@Test
	public void selectEachOption()	{
		MainclassObject o= new MainclassObject(driver);
		o.multipleSelectDropdown().selectByValue("apple");
	System.out.println(	o.multipleSelectDropdown().getFirstSelectedOption().getText());
		Assert.assertTrue(o.multipleSelectDropdown().getFirstSelectedOption().isSelected());
		o.multipleSelectDropdown().selectByValue("Orange");
		System.out.println(	o.multipleSelectDropdown().getFirstSelectedOption().getText());
			Assert.assertTrue(o.multipleSelectDropdown().getFirstSelectedOption().isSelected());
			o.multipleSelectDropdown().selectByValue("Peach");
			System.out.println(	o.multipleSelectDropdown().getFirstSelectedOption().getText());
				Assert.assertTrue(o.multipleSelectDropdown().getFirstSelectedOption().isSelected());
	}
	@Test
	public void selectAllOption() {
		MainclassObject o= new MainclassObject(driver);
		o.multipleSelectDropdown().selectByValue("Apple");
		o.multipleSelectDropdown().selectByValue("Peach");
		o.multipleSelectDropdown().selectByValue("Orange");
		int selectedOption=o.multipleSelectDropdown().getAllSelectedOptions().size();
		Assert.assertEquals(selectedOption, 3);
		o.multipleSelectDropdown().deselectAll();
		Assert.assertEquals(o.multipleSelectDropdown().getAllSelectedOptions().size(), 0);

	}
	@Test
	public void getcheckboxCount()	{
		MainclassObject o= new MainclassObject(driver);
Assert.assertEquals(o.getcheckboxcount(), 3);
	}
	@Test
	public void checkallCheckbox() {
		MainclassObject o= new MainclassObject(driver);

		
	}
	
	@Test
	public void uncheckAllCheckbox() {
		
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
